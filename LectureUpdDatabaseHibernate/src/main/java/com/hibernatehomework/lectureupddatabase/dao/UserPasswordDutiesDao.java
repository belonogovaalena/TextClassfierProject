/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernatehomework.lectureupddatabase.dao;

import com.hibernatehomework.lectureupddatabase.entity.Duties;
import com.hibernatehomework.lectureupddatabase.entity.Password;
import com.hibernatehomework.lectureupddatabase.entity.Users;
import com.hibernatehomework.lectureupddatabase.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Алена
 */
public class UserPasswordDutiesDao {
    
    public void save(Users u, Password p, Duties d) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(d);
        u.setDuties(d);
        d.getUsers().add(u);
        session.persist(u);
        p.setId(u.getId());
        u.setPassword(p);
        session.save(u);
        session.getTransaction().commit();
        session.close();
    }
    
    public void save(Users u, Password p, Integer id) {
        Session session = HibernateUtil.getSession();
        DutiesDao dd = new DutiesDao();
        session.beginTransaction();
        Duties d = dd.findId(id);
        u.setDuties(d);
        d.getUsers().add(u);
        session.persist(u);
        p.setId(u.getId());
        u.setPassword(p);
        session.save(u);
        session.getTransaction().commit();
        session.close();
    } 

    public void delete(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Users users = (Users) session.get(Users.class, id);
        Duties d = users.getDuties();
        d.getUsers().remove(users);
        session.delete(users);
        session.getTransaction().commit();
        session.close();
    }
    
    public boolean checkPass(String login, String pass) {
        UsersDao ud = new UsersDao();
        Users user = ud.findLogin(login);
        if (user.getLogin().equals(null))
            return false;
        else {
            if (user.getPassword().getPass().equals(pass))
                return true;
            else
                return false;
        }
    }
}
