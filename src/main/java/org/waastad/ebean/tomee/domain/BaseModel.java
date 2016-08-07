/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebean.tomee.domain;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author helge
 */
@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class BaseModel extends Model {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Version
    @Column(name = "version")
    private Long version;
    @CreatedTimestamp
    @Column(name = "created")
    private Timestamp whenCreated;
    @UpdatedTimestamp
    @Column(name = "updated")
    private Timestamp whenUpdated;
    
}
