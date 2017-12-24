package com.hibernatehomework.lectureupddatabase.dao;

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
public class UsersDao {
    
    public Users findId(Integer id) {
        Session session = HibernateUtil.getSession();
        Users users = (Users) session.get(Users.class, id);
        session.close();
        return users;
    }

    public List<Users> findALl() {
        Session session = HibernateUtil.getSession();
        List<Users> listUsers = (List<Users>)session.createQuery("from Users ").list();
        session.close();
        return listUsers;
    }
    
    public Users findLogin (String login) {
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.eq("login", login));
        Users users = (Users) criteria.uniqueResult();
        session.close();
        return users;
    }
}