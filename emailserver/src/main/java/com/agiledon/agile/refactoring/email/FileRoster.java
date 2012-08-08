package com.agiledon.agile.refactoring.email;

import javax.mail.Address;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Created by IntelliJ IDEA.
 * User: twer
 * Date: 2/19/12
 * Time: 1:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileRoster implements Roster {
    private Address[] addresses;

    public FileRoster(String fileName) {
        try {
            addresses = new Address[]{
                    new InternetAddress("abc@qq.com"),
                    new InternetAddress("xyz@qq.com"),
            };
        } catch (AddressException e) {
            e.printStackTrace();
        }
    }

    public boolean constainsOneOf(Address[] from) {
        for (int i = 0; i < addresses.length; i++) {
            Address address = addresses[i];
            for (int j = 0; j < from.length; j++) {
                Address fromAddress = from[j];
                if (address.equals(fromAddress)) {
                    return true;
                }
            }
        }

        return false;
    }

    public Address[] getAddresses() {
        return addresses;
    }
}
