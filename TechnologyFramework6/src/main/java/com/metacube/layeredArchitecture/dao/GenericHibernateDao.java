package main.java.com.metacube.layeredArchitecture.dao;

import java.util.List;
import main.java.com.metacube.layeredArchitecture.model.BaseModel;
import main.java.com.metacube.layeredArchitecture.model.Product;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericHibernateDao <T extends BaseModel> implements BaseDao<T> {
	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> modelClass;
	
	public GenericHibernateDao() { }
	
	public GenericHibernateDao(Class<T> modelClass) {
		this.modelClass = modelClass;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Class<T> getModelClass() {
		return modelClass;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(getModelClass());
		if(criteria.list().size() == 0) {
			System.out.println("empty");
		}
		return criteria.list();	
	}
	
	@SuppressWarnings("unchecked")
	public T getById(int primaryKey) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(getModelClass());
		return (T) criteria.add(Restrictions.eq("id", primaryKey)).uniqueResult();
	}

	public void delete(T t) { 
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(t);
	}

	public int deleteById(int primaryKey) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(getModelClass());
		session.delete(criteria.add(Restrictions.eq("id", primaryKey)).uniqueResult());
		return 1;
	}
	
	public void update(Product t, int id) {
		Session session = getSessionFactory().getCurrentSession();
		session.update(t);
	}

	public int create(T t) {
		Session session = getSessionFactory().getCurrentSession();
		session.save(t);
		return ((Product) t).getId();
	}
}