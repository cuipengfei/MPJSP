package Collector.Test;

import Collector.PersonalInfo;
import junit.framework.TestCase;
import org.junit.Before;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/18/12
 * Time: 8:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonalInfoTest extends TestCase {

    PersonalInfo info;

    @Override
    public void setUp() throws Exception {
        info = new PersonalInfo();
    }

    public void testSetHobby() throws Exception {
        info.setHobby("eat");
        assertEquals("eat",info.getHobby());
    }

    public void testSetId() throws Exception {
        info.setId(123);
        Integer expectedValue=123;
        assertEquals(expectedValue,info.getId());
    }

    public void testSetName() throws Exception {
        info.setName("cui");
        assertEquals("cui",info.getName());
    }
}
