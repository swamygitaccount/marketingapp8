package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entities.Lead;
import com.marketing.services.LeadService;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
@Autowired
	private LeadService leadservice;
	
	@GetMapping
	public List <Lead> getAllLeads(){
		
		List<Lead> leads = leadservice.listLeads();
		
		return leads;
	}
	
	@PostMapping
	public void saveOneLead(@RequestBody Lead lead) {
		
		leadservice.saveLead(lead);
		
	}
	@DeleteMapping("/delete/{id}")
	public void deleteOneLead(@PathVariable("id") long id) {
		
		leadservice.deleteLeadById(id);
	}
	@PutMapping
	public void updateOneLead(@RequestBody Lead lead) {
		leadservice.saveLead(lead);
	}
	
	@RequestMapping("/leadinfo/{id}")
	public Lead getoneLead(@PathVariable("id") long id) {
		
		Lead lead = leadservice.getOneLeadId(id);
		
	         return lead;
	
	}
	
	
}
