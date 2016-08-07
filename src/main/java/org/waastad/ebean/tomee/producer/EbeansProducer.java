/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebean.tomee.producer;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.HsqldbPlatform;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author helge
 */
@Slf4j
public class EbeansProducer {

    @Resource(name = "TestDS")
    private DataSource datasource;

    private EbeanServer server;

    @Produces
    @ApplicationScoped
    public EbeanServer getEbeansServer() {
        if (this.server == null) {
            initEserver();
        }
        return this.server;
    }

    public void closeEbeansServer(@Disposes EbeanServer ebeanServer) {
        ebeanServer.shutdown(true, true);
    }

    private void initEserver() {

        ServerConfig config = new ServerConfig();
        config.setName("TestDsServer");
        config.setDataSource(datasource);
        config.loadFromProperties();
        config.setDefaultServer(true);
        config.setRegister(true);

        config.setDatabasePlatform(new HsqldbPlatform());
        this.server = EbeanServerFactory.create(config);
    }
}
