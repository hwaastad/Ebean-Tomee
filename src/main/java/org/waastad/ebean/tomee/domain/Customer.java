/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebean.tomee.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author helge
 */
@Entity
@Table(name = "t_customer")
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Customer extends BaseModel {
    
    @Column(length = 50,name = "name")
    private String name;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Contact> contacts;
    
}
