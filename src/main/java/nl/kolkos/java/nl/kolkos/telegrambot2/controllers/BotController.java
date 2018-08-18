package nl.kolkos.java.nl.kolkos.telegrambot2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.QueueEntry;
import nl.kolkos.java.nl.kolkos.telegrambot2.services.QueueEntryService;
import nl.kolkos.java.nl.kolkos.telegrambot2.services.SettingService;

@Controller
@RequestMapping("/bot")
public class BotController {
	
	@Autowired
	private QueueEntryService queueEntryService;
	
	@Autowired
	private SettingService settingService;
	
	@RequestMapping(value={"/queue"}, method = RequestMethod.GET)
	public ModelAndView queue(){
		ModelAndView modelAndView = new ModelAndView();
		
		// get the bot_stopped status
		String botStopped = settingService.findBySettingKey("BOT_STOPPED").getSettingValue();
		modelAndView.addObject("botStopped", botStopped);
		
		modelAndView.addObject("title", "Queue");
		modelAndView.setViewName("queue");
		return modelAndView;
	}
	
	@RequestMapping(value={"/queue/results"}, method = RequestMethod.GET)
	public ModelAndView queueContent(){
		
		ModelAndView modelAndView = new ModelAndView();
		
		List<QueueEntry> queueEntries = queueEntryService.findUnhandledEntries();
		modelAndView.addObject("queueEntries", queueEntries);
		
		modelAndView.setViewName("queue_results");
		return modelAndView;
	}
	
	
	@RequestMapping(value={"/archive"}, method = RequestMethod.GET)
	public ModelAndView archive(){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "Queue");
		modelAndView.setViewName("queue");
		return modelAndView;
	}
	
}
