package nl.kolkos.java.nl.kolkos.telegrambot2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.Role;
import nl.kolkos.java.nl.kolkos.telegrambot2.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
    private RoleRepository roleRepository;
	
	@Override
	public List<Role> findAllRoles(){
		return roleRepository.findAllByOrderByRoleAsc();
	}
	
	@Override
	public void saveRole(Role role) {
		roleRepository.save(role);
	}
	
	@Override
	public Role findByRole(String role) {
		return roleRepository.findByRole(role);
	}
}
