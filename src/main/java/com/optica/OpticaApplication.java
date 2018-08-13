package com.optica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class OpticaApplication {

	/**
	 *
	 * el usuario se registra e importa contactos de su cel
     * enviara un mensaje de texto a n contactos
     * enviara un mensaje de texto personalizado basado  en columnas
     * enviara mensaje a travez de un web service
     * limita la cantidad de mensajes por membresia
     * informacion de membresia comprada
	 * el usuario se registra pero no se activara de inmediato solo enviara 3 msj
	 * el administrador habilita al usuario
	 *
	 *
     *
	 * */
	public static void main(String[] args) {
		SpringApplication.run(OpticaApplication.class, args);
	}


}
