
package com.hibernatehomework.lectureupddatabase.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Алена
 */
@Entity
@Table(name = "duties", schema = "databasehib")
public class Duties {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idD", nullable = false) 
    private Integer id;
    
    @Column(name = "rule", nullable = false)
    private String rule;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "duties", cascade = CascadeType.ALL)
    private Set<Users> setUsers = new HashSet<Users>();
    
    public Duties() {
        
    }
       
    public Duties(String s) { 
      rule = s;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId (Integer id) {
        this.id = id;
    }
    
    public String getRule() {
        return rule;
    }
    
    public void setRule(String rule) {
        this.rule = rule;
    }
    
    public Set<Users> getUsers() {
        return setUsers;
    }
    
    public void setUsers(Set<Users> setUsers) {
        this.setUsers = setUsers;
    }
    
    @Override
    public String toString() {
        return ("|id: "+ id + "; rule: " + rule + "|");
    }
    
}
