/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebean.tomee.business;

import com.avaje.ebean.EbeanServer;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.waastad.ebean.tomee.domain.Customer;

/**
 *
 * @author helge
 */
@Stateless
public class BusinessBean {
    
    @Inject private EbeanServer es;
    
    public void dostuff() {
        Customer c = new Customer();
        c.setName("fdgdfsg");
        es.save(c);
    }
    
}
