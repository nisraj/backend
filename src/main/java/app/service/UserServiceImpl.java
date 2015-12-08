package app.service;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.User;
import app.repository.UserRepository;

/**
 * The Class UserServiceImpl.
 */
@Service
public class UserServiceImpl implements UserService {

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;

	/* (non-Javadoc)
	 * @see app.service.UserService#findAll()
	 */
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see app.service.UserService#saveUser(app.model.User)
	 */
	@Override
	public void saveUser(User user) {
		user.setCreatedDate(new Date());
		user.setId(new ObjectId().toString());
		userRepository.save(user);
	}

}
