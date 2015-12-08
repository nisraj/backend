package app.service;

import java.util.List;

import app.model.User;

/**
 * The Interface UserService.
 */
public interface UserService {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<User> findAll();

	/**
	 * Save user.
	 *
	 * @param user the user
	 */
	public void saveUser(final User user);

}
