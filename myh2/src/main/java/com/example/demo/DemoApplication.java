package com.example.demo;

//import com.myh2.demo.model.Book;
//import com.myh2.demo.repository.BookRepository;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		Object dataSource = context.getBean("dataSource");

		System.out.println("======================");
		System.out.println(dataSource);
		System.out.println("======================");
	}

	@Bean
	CommandLineRunner commandLineRunner(BookRepository repository) {
		return args -> {
			repository.save(new Book(null, "Spring boot in Action", 471, "Craig Walls"));
		};
	}

}
