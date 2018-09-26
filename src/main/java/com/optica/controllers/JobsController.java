package com.optica.controllers;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.optica.domain.JobOffer;
import com.optica.dto.JobOfferDto;

/**
 * 
 * Clase controladora para los jobs<br>
 * listar<br>
 * aplicar<br>
 * reportar<br>
 * guardar<br>
 * seleccionar<br>
 * 
 * @author fsanmiguel
 */
@Controller
public class JobsController {

	private final Logger logger = LoggerFactory.getLogger(JobsController.class);

	private final String JOBS = "jobs";

	@GetMapping(Routes.JOB_SEARCH_PATH)
	public String findJobs(String keyword, String city, HttpServletRequest request, Model model) {
		return JOBS;
	}

	@GetMapping(Routes.JOB_OFFER_NEW)
	public String createJob(Model model) {
		return JOBS;
	}
	@PostMapping(Routes.JOB_OFFER_NEW)
	public String createJob(@Valid JobOfferDto jobOffer ,BindingResult errors, Model model,HttpServletRequest request, RedirectAttributes redirect) {
		
		JobOffer j = new JobOffer();
    	j.setActive(true);
    	j.setAvailabilityToRelocate(false);
    	j.setAvailabilityToTravel(true);
    	j.setCityId(1L);
    	j.setConfidential(false);
    	j.setContactsId(2L);
    	j.setDescription("Oferta laboral descripcion se requiere");
    	j.setExperienceYears(4);
    	j.setHighLight(false);
    	j.setLatitude(123456789L);
    	j.setLength(12345678L);
    	j.setMaxSalary(50000000L);
    	j.setMinSalary(3000000L);
    	j.setMinimunAge(30);
    	j.setPublishDate(LocalDate.now());
    	j.setSalary(6000000L);
    	j.setScheduleId(2L);
    	j.setTitle("INGENIERO DE DESARROLLO");
    	j.setTrainingId(5L);
    	j.setUnpublishDate(LocalDate.now());
    	j.setUpdateDate(LocalDate.now());
    	j.setVacancies(10);
    	//offerDao.save(j);
    	//searchService.indexSampleArticles(j);
		
		redirect.addFlashAttribute("","");
		
		return "redirect:/";
	}

}
