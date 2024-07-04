package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.Principal.AppPrincipal;

import com.aluracursos.screenmatch.repositorio.AutorRepository;
import com.aluracursos.screenmatch.repositorio.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApp implements CommandLineRunner {
	@Autowired
	private AutorRepository repository;
	@Autowired
	private LibroRepository libroRepository;
	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		AppPrincipal principal = new AppPrincipal(repository,libroRepository);
		principal.muestraElMenu();

	}
}
