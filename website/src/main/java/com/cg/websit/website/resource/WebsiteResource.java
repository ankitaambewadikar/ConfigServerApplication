package com.cg.websit.website.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
@EnableDiscoveryClient
@Controller
public class WebsiteResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/hello")
	public String hello(){
		return "helloWorld";
		
	}
	
	@RequestMapping("/output")
	public String home(Model model) {
		
		  String output = restTemplate .exchange("http://hello-client", HttpMethod.GET,
		  null, new ParameterizedTypeReference<String>() { }).getBody();
		 
		//String output = restTemplate.getForObject("http://hello-client", String.class);
		model.addAttribute("output", output);
		return "hello";

	}
	

}
