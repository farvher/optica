package com.optica.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.optica.entity.Role;
import com.optica.entity.User;
import com.optica.services.login.RoleService;
import com.optica.services.login.SecurityService;
import com.optica.services.login.UserService;
import com.optica.util.UserValidator;

@Controller
public class UsuarioController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model, User user) {
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("user") User userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}
		userForm.setRoles(roleService.findRoleByName("USER"));
		userService.save(userForm);
		
		securityService.autologin(userForm.getUserName(), userForm.getPasswordConfirm());
		return "redirect:/";
	}


	@GetMapping("/login")
	public String login(Model model) {

		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("users", userService.findAll());
		
		return "login";
	}
	@GetMapping("/user")
	@ResponseBody
	public String welcomePage() {
		return "welcome";
		
	}

}
