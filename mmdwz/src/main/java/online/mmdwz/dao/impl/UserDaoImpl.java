package online.mmdwz.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.mmdwz.dao.UserDao;
import online.mmdwz.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public User load(Integer id) {
		// TODO Auto-generated method stub
		return (User) this.getCurrentSession().load(User.class, id);
	}

	public User get(Integer id) {
		// TODO Auto-generated method stub
		return (User) this.getCurrentSession().get(User.class, id);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> users = this.getCurrentSession().createQuery("from User").list();
		return users;
	}

	public void persist(User entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().persist(entity);
	}

	public Integer save(User entity) {
		// TODO Auto-generated method stub
		return (Integer) this.getCurrentSession().save(entity);
	}

	public void saveOrUpdate(User entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		User entity = this.load(id);
		this.getCurrentSession().delete(entity);
	}

	public void flush() {
		// TODO Auto-generated method stub
		this.getCurrentSession().flush();
	}

}
