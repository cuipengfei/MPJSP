package Collector.Test;

import Collector.PersonalInfo;
import Collector.PersonalInfoCreater;
import org.junit.Assert;
import org.junit.Test;

public class PersonalInfoCreaterTest {

    @Test
    public void testCreatePersonalInfo() throws Exception {
        PersonalInfoCreater creater = new PersonalInfoCreater();
        PersonalInfo info = creater.createPersonalInfo();
        Assert.assertNotNull(info);
    }
}
