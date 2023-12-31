package dev.baluapp.twitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // для аудита изменений в моделях
public class TwitterApplication {

    public static void main(String[] args) {

        SpringApplication.run(TwitterApplication.class, args);

    }

}
