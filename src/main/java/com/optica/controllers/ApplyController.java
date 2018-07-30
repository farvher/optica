package com.optica.controllers;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.optica.domain.Apply;
import com.optica.domain.Curriculum;
import com.optica.entity.User;
import com.optica.services.ApplyService;
import com.optica.services.login.SecurityService;

@Controller
public class ApplyController {

	@Autowired
	private ApplyService applyService;

	@Autowired
	private SecurityService securityService;

	@PostMapping("/apply/{jobOfferId}")
	@ResponseBody
	public String applyForJobOffer(Model model, Long jobOfferId) {

		Apply apply = new Apply();
		User user = securityService.getCurrentUser();

		if (user.getCurriculum() != null) {
			apply.setActive(true);
			apply.setApplyDate(LocalDate.now());
			apply.setCurriculumId(user.getCurriculum().getId());
			apply.setJobOfferId(jobOfferId);
			applyService.applyForJobOffer(apply);
		}

		return "success";
	}

}
