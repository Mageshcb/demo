package com.stack.rs;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.stack.util.HibernateUtil;

public class UserDao {

	public Users getUser(String name) {
		Session ses = HibernateUtil.currentSession();
		try {
			Criteria crit = ses.createCriteria(Users.class);
			crit.add(Restrictions.idEq(name));
			Users u = (Users) crit.uniqueResult();
			return u;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public List<Users> getUsers() {
		Session ses = HibernateUtil.currentSession();
		try {
			return ses.createCriteria(Users.class).list();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void createUser(Users u) {

		Session ses = HibernateUtil.currentSession();
		try {
			Transaction tx = ses.beginTransaction();
			ses.save(u);
			tx.commit();
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public void updateUser(Users u) {
		Session ses = HibernateUtil.currentSession();
		try {
			Transaction tx = ses.beginTransaction();
			ses.update(u);
			tx.commit();
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public void deleteUser(String us) {
		Session ses = HibernateUtil.currentSession();
		try {
			Transaction tx = ses.beginTransaction();
			Users u = (Users) ses.load(Users.class, us);
			ses.delete(u);
			tx.commit();
		} finally {
			HibernateUtil.closeSession();
		}

	}
}
