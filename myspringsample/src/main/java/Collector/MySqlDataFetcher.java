package Collector;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.sql.*;

import static java.lang.Class.*;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/13/12
 * Time: 1:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class MySqlDataFetcher extends HibernateDaoSupport {

    public PersonalInfo[] all(){
        return (PersonalInfo[])getHibernateTemplate().find("from Collector.PersonalInfo").toArray(new PersonalInfo[0]);
    }

    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory)
    {
        super.setSessionFactory(sessionFactory);
    }

    public void save(PersonalInfo info){
        getHibernateTemplate().save(info);
    }
}