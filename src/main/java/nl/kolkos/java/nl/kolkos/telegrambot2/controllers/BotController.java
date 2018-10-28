package nl.kolkos.java.nl.kolkos.telegrambot2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.ArchivedEntry;
import nl.kolkos.java.nl.kolkos.telegrambot2.objects.QueueEntry;
import nl.kolkos.java.nl.kolkos.telegrambot2.objects.Setting;
import nl.kolkos.java.nl.kolkos.telegrambot2.scheduledTasks.ScheduledTasks;
import nl.kolkos.java.nl.kolkos.telegrambot2.services.ArchivedEntryService;
import nl.kolkos.java.nl.kolkos.telegrambot2.services.BotService;
import nl.kolkos.java.nl.kolkos.telegrambot2.services.QueueEntryService;
import nl.kolkos.java.nl.kolkos.telegrambot2.services.SettingService;

@Controller
@RequestMapping("/bot")
public class BotController {
	
	Logger logger = LoggerFactory.getLogger(BotController.class);
	
	@Autowired
	private QueueEntryService queueEntryService;
	
	@Autowired
	private SettingService settingService;
	
	@Autowired
	private ArchivedEntryService archivedEntryService;
	
	@Autowired
	private BotService botService;
	
	@ResponseBody
	@RequestMapping(value={"/action/stop"}, method = RequestMethod.GET)
	private String handleStopBot(Authentication loggedInUser) {
		return botService.stopBot(loggedInUser.getName());
	}
	
	@ResponseBody
	@RequestMapping(value={"/action/start"}, method = RequestMethod.GET)
	private String handleStartBot(Authentication loggedInUser) {
		return botService.startBot(loggedInUser.getName());
	}
	
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
		
		List<QueueEntry> queueEntries = queueEntryService.findUnhandledEntriesNewToOld();
		modelAndView.addObject("queueEntries", queueEntries);
		
		modelAndView.setViewName("queue_results");
		return modelAndView;
	}
	
	
	@RequestMapping(value={"/archive"}, method = RequestMethod.GET)
	public ModelAndView archive(@PageableDefault(size = 25, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
		ModelAndView modelAndView = new ModelAndView();
		
		
		
		Page<ArchivedEntry> pages = archivedEntryService.getArchivedEntries(pageable);
		
		
		
		modelAndView.addObject("title", "Archive");
		modelAndView.addObject("number", pages.getNumber());
		modelAndView.addObject("totalPages", pages.getTotalPages());
		
		modelAndView.addObject("totalElements", pages.getTotalElements());
		modelAndView.addObject("size", pages.getSize());
		modelAndView.addObject("archivedEntries", pages.getContent());
		
		modelAndView.addObject("maxNrOfPagesInNav", 15);
		
		// to determine which fields needs to be sorted in which direction
		Sort sort = pages.getSort();
		String sortString = sort.toString();
		
		modelAndView.addObject("sortString", sortString);
		
		String column = sortString.split(": ")[0];
		String direction = sortString.split(": ")[1];
		
		modelAndView.addObject("column", column);
		modelAndView.addObject("direction", direction);
		
		
		
		
		modelAndView.setViewName("archive");
		return modelAndView;
	}
	
}
