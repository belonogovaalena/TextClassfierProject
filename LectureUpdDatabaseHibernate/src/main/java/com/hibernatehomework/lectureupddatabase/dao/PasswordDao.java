
package com.hibernatehomework.lectureupddatabase.dao;

import com.hibernatehomework.lectureupddatabase.entity.Password;
import com.hibernatehomework.lectureupddatabase.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Алена
 */
public class PasswordDao {
    public Password findId(Integer id) {
        Session session = HibernateUtil.getSession();
        Password pass = (Password) session.get(Password.class, id);
        session.close();
        return pass;
    }

    public List<Password> findALl() {
        Session session = HibernateUtil.getSession();
        List<Password> listPassword = (List<Password>)session.createQuery("from Password ").list();
        session.close();
        return listPassword;
    }  
}
