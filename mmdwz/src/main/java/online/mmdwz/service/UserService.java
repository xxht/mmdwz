package online.mmdwz.service;

import java.util.List;
import online.mmdwz.entity.User;

public interface UserService {
	User load(int id);

	User get(int id);

	List<User> findAll();

	void persist(User entity);

	Integer save(User entity);

	void saveOrUpdate(User entity);

	void delete(int id);

	void flush();
}
