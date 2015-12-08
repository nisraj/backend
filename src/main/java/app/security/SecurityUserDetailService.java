package app.security;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * The Class SecurityUserDetailService.
 */
@Service
public class SecurityUserDetailService implements UserDetailsService {

	/** The request. */
	@Autowired
	private HttpServletRequest request;

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (validationAPIKey(request.getHeader(SecurityConstant.HEADER_API_KEY))) {
			User user = getAllUser().get(username);
			if (user == null) {
				throw new UsernameNotFoundException("in valid user name and paasword.");
			} else {
				return user;
			}
		}
		throw new APIKeyException("API key is invalid");
	}

	/**
	 * Gets the granted authorities.
	 *
	 * @param username the username
	 * @return the granted authorities
	 */
	private Collection<? extends GrantedAuthority> getGrantedAuthorities(String username) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		setAuths.add(new SimpleGrantedAuthority("USER"));
		return setAuths;
	}

	/**
	 * Gets the all user.
	 *
	 * @return the all user
	 */
	private Map<String, User> getAllUser() {
		Map<String, User> map = new HashMap<String, User>();
		map.put("aadit", new User("aadit", "aadit", getGrantedAuthorities("aadit")));
		map.put("david", new User("david", "david", getGrantedAuthorities("david")));
		return map;
	}

	/**
	 * Validation api key.
	 *
	 * @param key the key
	 * @return true, if successful
	 */
	private boolean validationAPIKey(final String key) {
		return SecurityConstant.API_KEY.equals(key);
	}
}
