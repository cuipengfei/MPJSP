package com.agiledon.agile.refactoring.email;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class Forwarder {
    public static final String SUBJECT_MARKER = "[list]";
    public static final String LOOP_HEADER = "X-LOOP";

    public static void main(String[] args) {
        if (parametersInvalid(args)) return;

        HostInformation host = new HostInformation(args);
        String listAddress = args[6];
        int interval = new Integer(args[7]).intValue();
        Roster roster = null;
        try {
            roster = new FileRoster("roster.txt");
        } catch (Exception e) {

        }

        try {
            do {
                try {
                    Properties properties = System.getProperties();
                    Session session = Session.getDefaultInstance(properties, null);
                    Store store = session.getStore("pop3");
                    store.connect(host.getPop3Host(), -1, host.getPop3User(), host.getPop3Password());
                    Folder defaultFolder = store.getDefaultFolder();
                    if (defaultFolder == null) {
                        return;
                    }
                    Folder inboxFolder = defaultFolder.getFolder("INBOX");
                    if (inboxFolder == null) {
                        return;
                    }
                    inboxFolder.open(FOLDER.READ_WRITE);
                    try {
                        if (inboxFolder.getMessageCount() != 0) {
                            Message[] messages = inboxFolder.getMessages();
                            FetchProfile fp = new FetchProfile();
                            fp.add(FetchProfile.Item.ENVELOPE);
                            fp.add(FetchProfile.Item.FLAGS);
                            fp.add("X-Mailer");
                            inboxFolder.fetch(messages, fp);
                            for (int i = 0; i < messages.length; i++) {
                                Message message = messages[i];
                                if (message.getFlags().contains(Flags.Flag.DELETED)) continue;
                                System.out.println("message received: " + message.getSubject());
                                if (!roster.constainsOneOf(message.getFrom())) continue;
                                MimeMessage forward = new MimeMessage(session);
                                Address[] fromAddress = message.getFrom();
                                InternetAddress from = null;
                                if (fromAddress != null && fromAddress.length > 0) {
                                    from = new InternetAddress(fromAddress[0].toString());
                                }
                                forward.setFrom(from);
                                forward.setReplyTo(new Address[]{
                                        new InternetAddress(listAddress)
                                });

                                forward.addRecipients(Message.RecipientType.BCC, roster.getAddresses());
                                String subject = message.getSubject();
                                if (-1 == message.getSubject().indexOf(SUBJECT_MARKER)) {
                                    subject = SUBJECT_MARKER + " " + message.getSubject();
                                }
                                forward.setSubject(subject);
                                forward.setSentDate(message.getSentDate());
                                forward.addHeader(LOOP_HEADER, listAddress);
                                Object content = message.getContent();
                                if (content instanceof Multipart) {
                                    forward.setContent((Multipart) content);
                                } else {
                                    forward.setText((String) content);
                                }

                                Properties props = new Properties();
                                props.put("mail.smtp.host", host.getSmtpHost());

                                Session smtpSession = Session.getDefaultInstance(props, null);
                                Transport transport = smtpSession.getTransport("smtp");
                                transport.connect(host.getSmtpHost(), host.getSmtpUser(), host.getSmtpPassword());
                                transport.sendMessage(forward, roster.getAddresses());
                                message.setFlag(Flags.Flag.DELETED, true);
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("message handling error");
                        e.printStackTrace(System.err);
                    } finally {
                        inboxFolder.close(true);
                        store.close();
                    }
                } catch (Exception e) {
                    System.err.println(e);
                    System.err.println("(Retrying mail check");
                }
                System.err.print(".");
                try {
                    Thread.sleep(interval * 1000);
                } catch (InterruptedException e) {

                }
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean parametersInvalid(String[] args) {
        if (args.length != 8) {
            System.err.println("Usage: java MailingList <popHost> " +
                    "<smtpHost> <pop3user> <pop3password> <smtpuser> <smtppassword> <listname> " +
                    "<relayinterval");
            return true;
        }
        return false;
    }

}
