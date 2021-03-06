package com.optica.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.optica.dto.CustomerDto;
/**
 * Clase dummy para probar validacion de errores de formulario por modelo
 * 
 * @author fsanmiguel
 * */
@Controller
public class CustomerController {

	private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	private static final String VIEW_CUSTOMER = "customer";

	private static final String CUSTOMER = "customer";

	@GetMapping("/customer")
	public String index(CustomerDto customerDto, Model model) {
		return VIEW_CUSTOMER;
	}

	@PostMapping("/customer/add")
	public String addCustomer(@Valid CustomerDto customerDto, BindingResult errors, Model model) {

		if (errors.hasErrors()) {
			logger.error(errors.getAllErrors().toString());

		}
		return VIEW_CUSTOMER;
	}

	@GetMapping("/customer/find/{document}")
	public String findCustomer(@PathVariable String document, Model model) {

		return VIEW_CUSTOMER;
	}
}
