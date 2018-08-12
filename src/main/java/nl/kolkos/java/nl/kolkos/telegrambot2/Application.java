package nl.kolkos.java.nl.kolkos.telegrambot2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.Role;
import nl.kolkos.java.nl.kolkos.telegrambot2.services.RoleService;

@SpringBootApplication
public class Application {
	@Autowired
	private RoleService roleService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
            this.createRoles();
        };
        
        
    }
	
	
	public void createRoles() {
		List<String> neededRoles = new ArrayList<>();
		neededRoles.add("ADMIN");
		neededRoles.add("USER");
		
		// loop to required roles
		for(String role : neededRoles) {
			// check if already registered
			Role foundRole = roleService.findByRole(role);
			if(foundRole == null) {
				Role newRole = new Role();
				newRole.setRole(role);
				roleService.saveRole(newRole);
			}
			
		}
		
	}
}
