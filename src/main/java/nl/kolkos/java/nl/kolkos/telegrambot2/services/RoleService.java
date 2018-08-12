package nl.kolkos.java.nl.kolkos.telegrambot2.services;

import java.util.List;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.Role;

public interface RoleService {
	public List<Role> findAllRoles();
	public Role findByRole(String role);
	public void saveRole(Role role);
}
