package jjw34g.ire.dto;

import jjw34g.ire.entity.LakasokEntity;
import jjw34g.ire.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;

public class LakasokDTO {

    private static Transaction transaction;
    private static Session session = HibernateUtil.getSessionFactory().openSession();
    private ArrayList<LakasokEntity> list = new ArrayList();

    public void createNewLakas(LakasokEntity entity) {
        try {
            transaction = session.beginTransaction();
            System.out.println("\n Uj Lakas Hozzaadasa : \n" + entity.toString());
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("\nUj Lakas Hozzaadasa exception: \n " + e.getMessage());
        }
    }

    public ArrayList<LakasokEntity> getAllLakas() {
        if (!list.isEmpty()) {
            list.clear();
        }

        try {
            Query query = session.createQuery("Select u from LakasokEntity u");
            list = (ArrayList<LakasokEntity>) query.getResultList();
        } catch (Exception e) {
            System.out.println("\n getAllLakas exception: \n " + e.getMessage());
        }
        return list;
    }

    public LakasokEntity getLakasById(int id) {
        if (!list.isEmpty()) {
            list.clear();
        }
        try {
            Query query = session.createQuery("Select u from LakasokEntity u where u.id =: id");
            query.setParameter("id", id);
            list = (ArrayList<LakasokEntity>) query.getResultList();
        } catch (Exception e) {
            System.out.println("\n getLakasById exception: \n " + e.getMessage());
        }
        return list.get(0);
    }

    public void updateLakas(LakasokEntity entity) {
        try {
            transaction = session.beginTransaction();
            System.out.println("\n Lakas update : \n" + entity.toString());
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("\nLakas Update exception: \n " + e.getMessage());
        }
    }

    public void deleteLakas(LakasokEntity entity) {
        System.out.println("Lakas torlese : " + entity.getId() + " " + entity.getFull_name());
        LakasokEntity updateEntity = entity;
        updateEntity.setDeleted_Lakas(true);
        updateLakas(updateEntity);
    }
}

