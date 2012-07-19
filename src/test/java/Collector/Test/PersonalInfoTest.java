package Collector.Test;

import Collector.PersonalInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/18/12
 * Time: 8:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonalInfoTest {

    PersonalInfo info;

    @Before
    public void setUp() throws Exception {
        info = new PersonalInfo();
    }

    @Test
    public void testSetHobby() throws Exception {
        info.setHobby("eat");
        Assert.assertEquals("eat", info.getHobby());
    }

    @Test
    public void testSetId() throws Exception {
        info.setId(123);
        Integer expectedValue = 123;
        Assert.assertEquals(expectedValue, info.getId());
    }

    @Test
    public void testSetName() throws Exception {
        info.setName("cui");
        Assert.assertEquals("cui", info.getName());
    }
}
