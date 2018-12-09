/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Pojos.User;
import Util.NewHibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author Acer
 */
public class UserHelper {

    public UserHelper() {

    }
    public User Login(String email, String password) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String q = "From User a where a.email=:email AND a.password =:password";
        Query query = session.createQuery(q);
        query.setParameter("email", email);
        query.setParameter("password", password);

        return (User) query.uniqueResult();
    }

}
