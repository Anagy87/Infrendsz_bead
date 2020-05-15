package jjw34g.ire.dto;

import jjw34g.ire.entity.LakokEntity;
import jjw34g.ire.entity.LakokStatusEntity;
import jjw34g.ire.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;

public class LakokDTO {

    private static Transaction transaction;
    private static Session session = HibernateUtil.getSessionFactory().openSession();
    private ArrayList<LakokEntity> list = new ArrayList();

    public void createNewLako(LakokEntity entity) {
        try {
            transaction = session.beginTransaction();
            System.out.println("\n Uj Lako letrehozasa : \n" + entity.toString());
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("\nUj Lako letrehozasa exception: \n " + e.getMessage());
        }
    }

    public LakokEntity getLakoById(int id) {
        if (!list.isEmpty()) {
            list.clear();
        }

        try {
            Query query = session.createQuery("Select l from LakokEntity l where l.id =: id");
            query.setParameter("id", id);
            list = (ArrayList<LakokEntity>) query.getResultList();
        } catch (Exception e) {
            System.out.println("getLakokById exception : " + e.getMessage());
        }
        return list.get(0);
    }

    public ArrayList<LakokEntity> getAllLakok() {
        if (!list.isEmpty()) {
            list.clear();
        }
        try {
            Query query = session.createQuery("Select l from LakokEntity l");
            list = (ArrayList<LakokEntity>) query.getResultList();
        } catch (Exception e) {
            System.out.println("getAllLakok exception : " + e.getMessage());
        }
        return list;
    }

    public void updateLakok(LakokEntity entity) {
        try {
            transaction = session.beginTransaction();
            System.out.println("\n Lako felulirasa : \n" + entity.toString());
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("\nLako felulirasa exception: \n " + e.getMessage());
        }
    }

    public void deleteLakok(LakokEntity entity) {
        System.out.println("Lako torlese : " + entity.getId() + " " + entity.getTitle());
        LakokEntity updateEntity = entity;
        updateEntity.setStatus(LakokStatusEntity.scrapped);
        updateLakok(updateEntity);
    }
}
