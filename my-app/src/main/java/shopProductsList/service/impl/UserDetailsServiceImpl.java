package shopProductsList.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import shopProductsList.entity.FamilyUser;
import shopProductsList.repository.FamilyUserRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private FamilyUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Collection<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
		String password;
		
		FamilyUser potentialUser = userRepository.findByEmail(email);
		
		if(potentialUser != null) {
			
			authority.add(new SimpleGrantedAuthority("user"));
			password = potentialUser.getPassword();
		}
		else {
			throw new UsernameNotFoundException("User doesn't exist");
		}
		return new User(email, password, authority);
	}

}
