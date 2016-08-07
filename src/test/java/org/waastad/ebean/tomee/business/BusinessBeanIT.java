/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebean.tomee.business;

import java.util.Properties;
import javax.inject.Inject;
import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.Configuration;
import org.apache.openejb.testing.Module;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.waastad.ebean.tomee.producer.EbeansProducer;

/**
 *
 * @author helge
 */
@RunWith(ApplicationComposer.class)
public class BusinessBeanIT {

    @Module
    @Classes(value = {BusinessBean.class, EbeansProducer.class}, cdi = true)
    public EjbJar jar() {
        return new EjbJar();
    }

    @Configuration
    public Properties properties() {
        Properties p = new Properties();
        p.put("TestDS", "new://Resource?type=DataSource");
        p.put("TestDS.JdbcDriver", "org.hsqldb.jdbcDriver");
        p.put("TestDS.JdbcUrl", "jdbc:hsqldb:mem:Test");
        p.put("TestDS.logSql", "true");
        p.put("TestDS.jtaManaged", "false");
        //p.put("TestDS.defaultAutoCommit","false");
        return p;
    }

    @Inject
    private BusinessBean businessBean;

    @Test
    public void testSomeMethod() {
        businessBean.dostuff();
    }

}
