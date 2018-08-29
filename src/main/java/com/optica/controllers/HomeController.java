package com.optica.controllers;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.optica.domain.JobOffer;
import com.optica.repository.JobOfferDao;
import com.optica.services.search.SearchJobOfferService;
import com.optica.services.search.SearchService;

/**
 * @author farsan
 */
@Controller
public class HomeController {

	@Autowired
	private SearchService searchService;
	
	@Autowired
	private JobOfferDao offerDao ;
	
	@Autowired
	private SearchJobOfferService searchJobService;

    @GetMapping(Routes.INDEX_PATH)
    public String index(HttpServletRequest request, Model model) {
   
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
    	model.addAttribute("jobs", searchJobService.findJobOffersByKeyword("*"));
    	

        return "index";
    }

    @GetMapping(Routes.ABOUT_PATH)
    public String about(Model model) {
        return "about";
    }

    @GetMapping(Routes.CONTACT_PATH)
    public String contact() {
        return "contact";
    }

    @GetMapping(Routes.TEAM_PATH)
    public String team() {
        return "team";
    }

    @PostMapping(Routes.CONTACT_PATH)
    @ResponseBody
    public String contant(Model model) {

        return "success";
    }

}
