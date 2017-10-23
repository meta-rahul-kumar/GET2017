package main.java.com.metacube.layeredArchitecture.dao.user;

import main.java.com.metacube.layeredArchitecture.dao.GenericHibernateDao;
import main.java.com.metacube.layeredArchitecture.model.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("hibernateUserDao")
public class HibernateUserDao extends GenericHibernateDao<User> implements UserDao {
	public HibernateUserDao() {
		super(User.class);
	}

	@Override
	public void update(User t, int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User checkAuth(String name, String password) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("email", name));
		return (User) criteria.add(Restrictions.eq("password", password)).uniqueResult();
	}

}