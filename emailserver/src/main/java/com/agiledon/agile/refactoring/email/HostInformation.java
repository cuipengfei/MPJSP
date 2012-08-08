package com.agiledon.agile.refactoring.email;

/**
 * Created by IntelliJ IDEA.
 * User: twer
 * Date: 2/19/12
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class HostInformation {
    private String pop3Host;
    private String pop3User;
    private String pop3Password;
    private String smtpHost;
    private String smtpUser;
    private String smtpPassword;

    public HostInformation(String[] inputParas){
        setPop3Host(inputParas[0]);
        setSmtpHost(inputParas[1]);
        setPop3User(inputParas[2]);
        setPop3Password(inputParas[3]);
        setSmtpUser(inputParas[4]);
        setSmtpPassword(inputParas[5]);
    }

    public String getPop3Host() {
        return pop3Host;
    }

    public void setPop3Host(String pop3Host) {
        this.pop3Host = pop3Host;
    }

    public String getPop3User() {
        return pop3User;
    }

    public void setPop3User(String pop3User) {
        this.pop3User = pop3User;
    }

    public String getPop3Password() {
        return pop3Password;
    }

    public void setPop3Password(String pop3Password) {
        this.pop3Password = pop3Password;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public String getSmtpUser() {
        return smtpUser;
    }

    public void setSmtpUser(String smtpUser) {
        this.smtpUser = smtpUser;
    }

    public String getSmtpPassword() {
        return smtpPassword;
    }

    public void setSmtpPassword(String smtpPassword) {
        this.smtpPassword = smtpPassword;
    }
}
