
package com.hibernatehomework.lectureupddatabase.dao;
import com.hibernatehomework.lectureupddatabase.entity.Duties;
import com.hibernatehomework.lectureupddatabase.util.HibernateUtil;
import org.hibernate.Session;
/**
 *
 * @author Алена
 */
public class DutiesDao {
    
     public void save(Duties d) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(d);
        session.save(d);
        session.getTransaction().commit();
        session.close();
    }
     
      public Duties findId(Integer id) {
        Session session = HibernateUtil.getSession();
        Duties duty = (Duties) session.get(Duties.class, id);
        session.close();
        return duty;
    }
      
      public void delete(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Duties users = (Duties) session.get(Duties.class, id);
        session.delete(users);
        session.getTransaction().commit();
        session.close();
    }
}
