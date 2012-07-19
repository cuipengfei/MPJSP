package Collector.Test;

import Collector.PersonalInfo;
import Collector.PersonalInfoCreater;
import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/18/12
 * Time: 8:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonalInfoCreaterTest extends TestCase {

    public void testCreatePersonalInfo() throws Exception {
        PersonalInfoCreater creater = new PersonalInfoCreater();
        PersonalInfo info = creater.createPersonalInfo();
        assertNotNull(info);
    }
}
