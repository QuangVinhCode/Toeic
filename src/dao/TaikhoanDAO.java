package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import model.Taikhoan;
import uti.HibernateUti;

public class TaikhoanDAO implements DAO<Taikhoan> {

	@Override
	public List<Taikhoan> findALL() {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUti.getSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		try {
			List<Taikhoan> list = sess.createCriteria(Taikhoan.class).list();
			tx.commit();
			return list;

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		}
		return null;
	}

	@Override
	public Taikhoan findByid(Serializable id) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUti.getSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		try {
			Taikhoan c = (Taikhoan) sess.get(Taikhoan.class, id);
			tx.commit();
			return c;

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		}
		return null;

	}

	@Override
	public boolean delete(Serializable id) {
		SessionFactory sf = HibernateUti.getSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		try {
			Taikhoan c = (Taikhoan) sess.get(Taikhoan.class, id);
			sess.delete(c);
			tx.commit();
			return true;

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		}
		return false;
	}

	@Override
	public boolean add(Taikhoan t) {
		SessionFactory sf = HibernateUti.getSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		try {
			sess.save(t);
			tx.commit();
			return true;

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		}
		return false;
	}

	@Override
	public boolean update(Taikhoan t) {
		SessionFactory sf = HibernateUti.getSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		try {
			sess.saveOrUpdate(t);
			tx.commit();
			return true;

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		}
		return false;
	}
	
	public Taikhoan findTaiKhoanByTenAndMatKhau(String tenTaiKhoan, String matKhauTaiKhoan) {
		SessionFactory sf = HibernateUti.getSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		try {
			Criteria criteria = sess.createCriteria(Taikhoan.class);
			criteria.add(Restrictions.eq("TenTK", tenTaiKhoan));
			criteria.add(Restrictions.eq("MatKhauTK", matKhauTaiKhoan));
			Taikhoan taiKhoan = (Taikhoan) criteria.uniqueResult();
			tx.commit();
			return taiKhoan;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		}
		return null;
	}

}
