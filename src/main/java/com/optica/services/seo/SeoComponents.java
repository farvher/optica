package com.optica.services.seo;

import java.util.Map;

import org.springframework.ui.Model;

public interface SeoComponents {
	
	void generateSeoComponents(Model model, Map<String, String> filters);

}
