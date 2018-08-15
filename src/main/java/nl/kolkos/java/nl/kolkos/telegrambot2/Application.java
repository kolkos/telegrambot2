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
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import nl.kolkos.java.nl.kolkos.telegrambot2.bots.TestBot;
import nl.kolkos.java.nl.kolkos.telegrambot2.objects.Role;
import nl.kolkos.java.nl.kolkos.telegrambot2.objects.Setting;
import nl.kolkos.java.nl.kolkos.telegrambot2.services.RoleService;
import nl.kolkos.java.nl.kolkos.telegrambot2.services.SettingService;

@SpringBootApplication
@EnableScheduling
public class Application {
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private SettingService settingService;
	
	public static void main(String[] args) {
		ApiContextInitializer.init();
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
            this.createSettingKeys();
            
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
	
	public void createSettingKeys() {
		// TODO: Remove the settings here, use a setup for first run or whatever
		
		List<Setting> settings = new ArrayList<>();
		settings.add(new Setting("BOT_TOKEN", "348807800:AAGEcj83xpwlAhC69GC8mPj3byha3BwJ8-Y"));
		settings.add(new Setting("BOT_USERNAME", "kolkos_ProbeerselBot"));
		
		settingService.saveSettings(settings);
	}
	
	

}
