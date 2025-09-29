package com.arquiteturaspring.arquiteturaspring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class ArquiteturaSpringApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ArquiteturaSpringApplication.class, args);

		//Outra maneira de startar a aplicação
		SpringApplicationBuilder builder = new SpringApplicationBuilder(ArquiteturaSpringApplication.class);
		//desliga o banner
		builder.bannerMode(Banner.Mode.OFF);
		builder.profiles("producao", "homologacao"		);
		builder.lazyInitialization(true);
		builder.run(args);

		//pega o contexto da aplicação já iniciada
		ConfigurableApplicationContext context = builder.context();
		//var produtoRepository = context.getBean("produtoRepository");

		ConfigurableEnvironment environment = context.getEnvironment();
		String applicatioName = environment.getProperty("spring.application.name");
		System.out.println(applicatioName);

	}

}
