package dev.baluapp.twitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwitterApplication {

	public static void main(String[] args) {

		System.out.println("TWITTER_DB_USERNAME: " + System.getenv("TWITTER_DB_USERNAME"));
		System.out.println("TWITTER_DB_PASSWORD: " + System.getenv("TWITTER_DB_PASSWORD"));
		System.out.println("TWITTER_DB_HOST: " + System.getenv("TWITTER_DB_HOST"));
		System.out.println("TWITTER_DB_PORT: " + System.getenv("TWITTER_DB_PORT"));
		System.out.println("TWITTER_DB_NAME: " + System.getenv("TWITTER_DB_NAME"));
		// Повторите для всех переменных

		SpringApplication.run(TwitterApplication.class, args);

	}

}
