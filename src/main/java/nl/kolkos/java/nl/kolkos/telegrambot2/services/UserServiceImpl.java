package nl.kolkos.java.nl.kolkos.telegrambot2.services;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.Role;
import nl.kolkos.java.nl.kolkos.telegrambot2.objects.User;
import nl.kolkos.java.nl.kolkos.telegrambot2.repositories.RoleRepository;
import nl.kolkos.java.nl.kolkos.telegrambot2.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private RoleRepository roleRepository;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
	
	@Override
	public String findLoggedInUsername() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	// if user is logged in return the username
    	if (!(authentication instanceof AnonymousAuthenticationToken)) {
    	    String currentUserName = authentication.getName();
    	    return currentUserName;
    	}
    	
    	// else return null
    	return null;
	}
}
