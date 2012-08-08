package com.agiledon.agile.refactoring.email;

import junit.framework.Assert;
import org.junit.Test;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 8/8/12
 * Time: 10:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileRosterTest {
    @Test
    public void testConstainsOneOf() throws Exception {
        FileRoster roster = new FileRoster("none");
        boolean containsAbc = roster.constainsOneOf(new Address[]{new InternetAddress("abc@qq.com")});
        boolean containsXyz = roster.constainsOneOf(new Address[]{new InternetAddress("xyz@qq.com")});
        Assert.assertTrue(containsAbc);
        Assert.assertTrue(containsXyz);
    }

    @Test
    public void testGetAddresses() throws Exception {
        FileRoster roster = new FileRoster("none");
        Address[] addresses = roster.getAddresses();
        Assert.assertNotNull(addresses);
        Assert.assertTrue(addresses.length > 0);
    }
}
