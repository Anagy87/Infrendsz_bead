package jjw34g.ire.dto;

import jjw34g.ire.entity.BefizetesekEntity;
import jjw34g.ire.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;

import static jjw34g.ire.entity.LakokStatusEntity.fizetetlen;

import java.util.ArrayList;

public class BefizetesekDTO {

    private static Transaction transaction;
    private static Session session = HibernateUtil.getSessionFactory().openSession();
    private ArrayList<BefizetesekEntity> list = new ArrayList();

    public void createNewBefizetes(BefizetesekEntity entity) {
        try {
            transaction = session.beginTransaction();
            System.out.println("\n Uj befizetes teljesitese : \n" + entity.toString());
            session.update(entity.getWho_paid());
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("\nUj befizetes exception: \n " + e.getMessage());
        }
    }

    public BefizetesekEntity getBefizetesbyId(int id) {
        if (!list.isEmpty()) {
            list.clear();
        }

        try {
            System.out.println("Befizetes atonosito : " + id);
            Query query = session.createQuery("Select l from BefizetesekEntity l where l.id = :id");
            query.setParameter("id", id);
            list = (ArrayList<BefizetesekEntity>) query.getResultList();

        } catch (Exception e) {
            System.out.println("\n getBefizetesById exception: \n " + e.getMessage());
        }
        return list.get(0);
    }

    public void deleteBefizetes(BefizetesekEntity entity) {
        try {
            transaction = session.beginTransaction();
            System.out.println("\n Fizetes torolve : \n" + entity.toString());
            entity.getWho_paid().setStatus(fizetetlen);
            session.update(entity.getWho_paid()); 
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("\nBefizetes torlese exception: \n " + e.getMessage());
        }

    }

    public ArrayList<BefizetesekEntity> getAllBefizetesek() {
        if (!list.isEmpty()) {
            list.clear();
        }

        try {
            Query query = session.createQuery("Select l from BefizetesekEntity l");
            list = (ArrayList<BefizetesekEntity>) query.getResultList();
        } catch (Exception e) {
            System.out.println("\ngetAllBefizetesek exception: \n " + e.getMessage());
        }

        return list;
    }

    public int getBefizetesekSzama(int id) {
        int count = -1;
        try {
            Query query = session.createQuery("Select COUNT(who_paid)from BefizetesekEntity l where l.id =: id");
            query.setParameter("id", id);
            count = query.getFirstResult();
        } catch (Exception e) {
            System.out.println("\ngetBefizetesekSzama exception: \n " + e.getMessage());
        }
        return count;
    }
}

