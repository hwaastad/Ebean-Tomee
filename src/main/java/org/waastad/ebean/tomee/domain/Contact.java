/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebean.tomee.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author helge
 */
@Entity
@Table(name = "t_contact")
@NoArgsConstructor
@Data
public class Contact extends BaseModel {
    
    @Column(length = 50,name = "name")
    private String name;
    
    @ManyToOne(optional = false)
    @Column(nullable = true)
    private Customer customer;
    
}
