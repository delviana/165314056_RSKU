/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Pojos.Klinik;
import Util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Acer
 */
public class KlinikHelper {

    public KlinikHelper() {

    }

    public List<Klinik> bacaSemuaKlinik() {
        List<Klinik> list = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Klinik k");
        list = q.list();
        tx.commit();
        session.close();
        return list;

    }

    public static String toJson() {
        KlinikHelper helper = new KlinikHelper();
        List<Klinik> list = helper.bacaSemuaKlinik();
        String result = "[";
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) {
                result = result + list.get(i).toJson() + ",\n";
            } else {
                result = result + list.get(i).toJson() + "\n";
            }
        }
        result = result + "]";
        return result;
    }

    public void addNewKlinik(String idKlinik, String nama, String spesialis) {

        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Klinik klinik = new Klinik(idKlinik, nama, spesialis);
        session.saveOrUpdate(klinik);
        transaction.commit();
        session.close();
    }

}
