package org.james.service;

import java.util.List;

import org.james.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public UserDetails loadUserByUsername(String userName);
	public void creat(User user);
	public User findUserByEmail(String email);
	public User findUserByName(String name);

	public List<User> findAllUsers();
}
