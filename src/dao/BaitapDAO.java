package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Baitap;
import uti.HibernateUti;

public class BaitapDAO implements DAO<Baitap> {

	@Override
	public List<Baitap> findALL() {
		// TODO Auto-generated method stub
		SessionFactory sf=HibernateUti.getSessionFactory();
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		try {
			List<Baitap> list=sess.createCriteria(Baitap.class).list();
			tx.commit();
			return list;
			
		} catch (Exception e) {
			if (tx!=null)
				tx.rollback();
		}
		return null;
	}

	@Override
	public Baitap findByid(Serializable id) {
		// TODO Auto-generated method stub
				SessionFactory sf=HibernateUti.getSessionFactory();
				Session sess=sf.openSession();
				Transaction tx=sess.beginTransaction();
				try {
					Baitap c=(Baitap) sess.get(Baitap.class,id);
					tx.commit();
					return c;
					
				} catch (Exception e) {
					if (tx!=null)
						tx.rollback();
				}
				return null;
		
	}

	@Override
	public boolean delete(Serializable id) {
		SessionFactory sf=HibernateUti.getSessionFactory();
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		try {
			Baitap c=(Baitap) sess.get(Baitap.class,id);
			sess.delete(c);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			if (tx!=null)
				tx.rollback();
		}
		return false;
	}

	@Override
	public boolean add(Baitap t) {
		SessionFactory sf=HibernateUti.getSessionFactory();
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		try {
			sess.save(t);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			if (tx!=null)
				tx.rollback();
		}
		return false;
	}

	@Override
	public boolean update(Baitap t) {
		SessionFactory sf=HibernateUti.getSessionFactory();
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		try {
			sess.saveOrUpdate(t);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			if (tx!=null)
				tx.rollback();
		}
		return false;
	}

}
