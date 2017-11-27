
package com.hibernatehomework.lectureupddatabase.dao;

import com.hibernatehomework.lectureupddatabase.entity.Duties;
import com.hibernatehomework.lectureupddatabase.entity.Password;
import com.hibernatehomework.lectureupddatabase.entity.Users;
import java.util.List;

/**
 *
 * @author Алена
 */
public class RunTest {

    
    public static void main(String[] args) {
        //заполнение таблиц 
        DutiesDao dd = new DutiesDao();
        UserPasswordDutiesDao upd = new UserPasswordDutiesDao();
        UsersDao ud = new UsersDao();
        
        /*Duties d1 = new Duties("admin");
        Duties d2 = new Duties("moderator");
        Duties d3 = new Duties("user");
        
        Users u1 = new Users("alena", 20);
        Users u2 = new Users("veronica", 18);
        Users u3 = new Users("diana", 19);
        Users u4 = new Users("katya", 9);
                        
        Password p1 = new Password("050505");
        Password p2 = new Password("202020");
        Password p3 = new Password("222222");
        Password p4 = new Password("292929");
        
        upd.save(u1, p1, d1);
        upd.save(u2, p2, d2);
        upd.save(u3, p3, d3);
        upd.save(u4, p4, 3);*/
        
        
        //показать список пользователей
        List<Users> list = ud.findALl();
        for (Users u: list) {
            System.out.println(("Row -->") + u);
        }
        
        //удалить пользователя
       // upd.delete(3);
          
        //проверить пароль
        System.out.println(upd.checkPass("alena", "050507"));
        System.out.println(upd.checkPass("alena", "050505"));
        
    }
 
}
