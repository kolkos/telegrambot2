package nl.kolkos.java.nl.kolkos.telegrambot2.services;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
	public String findLoggedInUsername();
}
