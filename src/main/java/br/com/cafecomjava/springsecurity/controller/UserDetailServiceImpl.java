package br.com.cafecomjava.springsecurity.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import br.com.cafecomjava.springsecurity.dto.UserDetailsImpl;

public class UserDetailServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		if (username.equalsIgnoreCase("iuri")) {
			UserDetailsImpl user = new UserDetailsImpl();
			user.setUserName(username);
			user.setPassword("iuri");
			user.addAuthority("ROLE_USER");
			return user;
		}
		throw new UsernameNotFoundException("Usuario não encontrado");
	}

}
