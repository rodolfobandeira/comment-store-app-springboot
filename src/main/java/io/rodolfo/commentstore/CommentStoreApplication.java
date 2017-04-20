package io.rodolfo.commentstore;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EntityScan(basePackages= {"io.rodolfo.commentstore"})
public class CommentStoreApplication {

	public static void main(String[] args) {
        SpringApplication.run(CommentStoreApplication.class, args);
	}

    @RequestMapping("/")
    String home() {
        return "Microservice with SpringBoot. You must authenticate using basic auth and use the methods: /create (post), /list/{id} (get), /listall (get)";
    }
    
    @RequestMapping("/test")
    String test() {
        return "test!!!!!!";
    }
}

