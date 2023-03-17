package com.example.currencycompare;

import com.example.currencycompare.schedule.ScheduleService;
import com.example.currencycompare.schedule.impl.ScheduleServiceImpl;
import com.example.currencycompare.telegram.TelegramBotService;
import org.quartz.SchedulerException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication(excludeName = "CurrencyCompare")
public class CurrencyCompareApplication {


	@RestController
	class CurrencyCompareController{
		@GetMapping("/")
		public void compareCurrencies() {

			ScheduleService scheduleService = new ScheduleServiceImpl();
			try {

				scheduleService.init();
			} catch (SchedulerException e) {
				throw new RuntimeException(e);
			}
		}
	}




	public static void main(String[] args) {
		SpringApplication.run(CurrencyCompareApplication.class, args);
		TelegramBotService botService = new TelegramBotService();
		ScheduleService scheduleService = new ScheduleServiceImpl();
		try {

			scheduleService.init();
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	}

}
