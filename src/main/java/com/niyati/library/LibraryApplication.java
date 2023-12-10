package com.niyati.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.WebApplicationType;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
    SpringApplicationBuilder app = new SpringApplicationBuilder(LibraryApplication.class);
    if (args.length == 0) {
      app.web(WebApplicationType.SERVLET);
    } else {
      app.web(WebApplicationType.NONE);
    }
    app.run(args);
	}

}
