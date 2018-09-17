package com.optica.controllers;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.optica.domain.app.TokenLogin;
import com.optica.entity.User;
import com.optica.services.login.RoleService;
import com.optica.services.login.SecurityService;
import com.optica.services.login.UserService;
import com.optica.util.UserValidator;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = Routes.REGISTRATION_PATH, method = RequestMethod.GET)
	public String registration(Model model, User user) {
		return "registration";
	}

	@RequestMapping(value = Routes.REGISTRATION_PATH, method = RequestMethod.POST)
	public String registration(@ModelAttribute("user") User userForm, BindingResult bindingResult, Model model,
			HttpServletRequest request) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "redirect:/registration";
		}
		String passConfirm = userForm.getPassword();
		userForm.setRoles(roleService.findRoleByName("USER"));
		userService.save(userForm);
		securityService.autologin(userForm.getUsername(), passConfirm, request);


		return "redirect:/";
	}

	@GetMapping(Routes.LOGIN_PATH)
	public String login(Model model) {

		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("users", userService.findAll());

		return "login";
	}

}
