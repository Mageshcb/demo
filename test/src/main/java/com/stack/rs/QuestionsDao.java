package com.stack.rs;

import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stack.util.HibernateUtil;

public class QuestionsDao {

	public void create(Questions question) {
		Session session = HibernateUtil.currentSession();

		Transaction tx = session.beginTransaction();
		// question.setTimevalue(new java.util.Date());
		session.save(question);
		tx.commit();
		session.close();
	}

	public Questions read(int questionId) throws QuestionNotFoundException {
		Session session = HibernateUtil.currentSession();
		Questions question = (Questions) session.get(Questions.class,
				questionId);
		session.close();
		if (question == null)
			throw new QuestionNotFoundException();
		return question;
	}

	public Questions readQuestion(int questionId)
			throws QuestionNotFoundException {
		Session session = HibernateUtil.currentSession();
		Questions question = (Questions) session.get(Questions.class,
				questionId);
		session.close();
		if (question == null)
			throw new QuestionNotFoundException();
		return question;
	}

	@SuppressWarnings("unchecked")
	public List<Questions> readAll() throws ParseException {
		Session session = HibernateUtil.currentSession();
		List<Questions> results = session.createQuery(
				"from Questions f order by f.id desc").list();

		// results.
		Date date = null;
		Iterator<Questions> test = results.iterator();
		while (test.hasNext()) {
			Questions val = test.next();
			Date timestamp = val.getTimeval();
			// System.out.println("timeval value" + timestamp);
			//
			// System.out.println("Harshitha" + timestamp.toString());
			//
			// SimpleDateFormat formatter = new SimpleDateFormat(
			// "yyyy-MM-dd HH:mm:ss.S");
			// Date convertedDate = formatter.parse(timestamp.toString());
			//
			// System.out.println("Value 1" + convertedDate);
			val.setTimeval(timestamp);
			session.update(val);

		}

		session.close();
		return results;
	}

	public boolean isPresent(int questionId) {
		Session session = HibernateUtil.currentSession();
		Questions question = (Questions) session.get(Questions.class,
				questionId);
		session.close();
		if (question == null)
			return false;
		return true;
	}

	public List<Questions> readUserAll(String loginId) {
		Session session = HibernateUtil.currentSession();
		@SuppressWarnings("unchecked")
		List<Questions> results = session
				.createQuery("from Questions where username = :loginId")
				.setString("loginId", loginId).list();
		session.close();
		return results;
	}
}
