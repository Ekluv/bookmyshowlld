package com.personal.bookmyshow;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookmyshowApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookmyshowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 0. Create a movie
		// 1. Create a city
		// 2. Create a theatre
		// 3. Add auditorium to a theatre (create a theatre)
		// 4. Create 3 seat types: vip, gold, platinum
		// 5. Create 50 seats in the above auditorium
		// 6. Create a show
		//   showController.createShow(Long movieId, Date startTime, Date endTime, Theatre thetreId)



	}
}
