package com.hibernatehomework.lectureupddatabase.entity;

/**
 *
 * @author Alena
 */
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "password", schema = "databasehib")
public class Password {
    
    @Id
    @Column(name = "idP")
    private Integer id;
         
    @Column(name = "pass")    
    private String pass; 
    
    public Password() {
        
    }
    
    public Password(String pass) {
        this.pass = pass;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    @Override
    public String toString() {
        return ("|id: "+ id + "; password: " + pass + "|");
    }
}