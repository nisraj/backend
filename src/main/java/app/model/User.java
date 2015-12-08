package app.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * The Class User.
 */
public class User {

	/**
	 * Instantiates a new user.
	 */
	public User(){}
	/**
	 * Instantiates a new user.
	 *
	 * @param name the name
	 * @param email the email
	 */
	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	/** The id. */
	@Id
	private String id;

	/** The name. */
	@NotEmpty
	@Indexed
	private String name;

	/** The email. */
	@NotEmpty
	private String email;

	/** The created date. */
	private Date createdDate;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
