package online.mmdwz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.mmdwz.dao.UserDao;
import online.mmdwz.entity.User;
import online.mmdwz.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public User load(int id) {
		// TODO Auto-generated method stub
		return userDao.load(id);
	}

	public User get(int id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	public void persist(User entity) {
		// TODO Auto-generated method stub
		userDao.persist(entity);
	}

	public Integer save(User entity) {
		// TODO Auto-generated method stub
		return userDao.save(entity);
	}

	public void saveOrUpdate(User entity) {
		// TODO Auto-generated method stub
		userDao.saveOrUpdate(entity);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}

	public void flush() {
		// TODO Auto-generated method stub
		userDao.flush();
	}

}
