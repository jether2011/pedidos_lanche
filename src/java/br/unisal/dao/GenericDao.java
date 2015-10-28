/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal.dao;

import br.unisal.hibernateutil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author carlos.oliveira
 */
public class GenericDao {

    public Long save(Object entity) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            Long save = (Long) session.save(entity);
            tx.commit();
            return save;
        } catch (HibernateException e) {
            tx.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    public <T> T update(T s) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            T save = (T) session.merge(s);
            tx.commit();
            return save;
        } catch (HibernateException e) {
            tx.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    public <T> List<T> getAll(Class<T> type) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<T> entities = new ArrayList<>();
        try {
            tx.begin();
            Criteria criteria = session.createCriteria(type);
            entities = criteria.list();
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
        return entities;
    }

    public <T> T getById(Class<T> type, Long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        T entity = null;
        try {
            tx.begin();
            entity = (T) session.get(type, id);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
        return entity;
    }

    public void remove(Object entity) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.delete(entity);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }
    
    public void deleteAll(Class klass) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.createQuery("DELETE FROM " + klass.getSimpleName()).executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

}
