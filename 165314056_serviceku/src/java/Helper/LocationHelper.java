/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Pojos.Location;
import Util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Acer
 */
public class LocationHelper {

    public LocationHelper() {

    }

    public List<Location> getLocation(){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String query = "from Location";
        Query q = session.createQuery(query);
        List<Location> list = q.list();
        return list;
    }
    
    public void addNewLocation(double lat, double lng, String name) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Location location = new Location(lat, lng, name);
        session.saveOrUpdate(location);
        transaction.commit();
        session.close();
    }

}