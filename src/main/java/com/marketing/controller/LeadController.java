package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadData;
import com.marketing.entities.Lead;
import com.marketing.services.LeadService;

@Controller
public class LeadController {
	@Autowired
	public LeadService leadservice;
	
	
	@RequestMapping("/createLead")
	public String viewCreateLeadPage() {
		
		return "create_lead";
	}
      @RequestMapping("/savelead")
	public String saveOneLead(@ModelAttribute("lead")Lead lead,ModelMap model) {
//	
    	   leadservice.saveLead(lead);
    	   model.addAttribute("msg", "Lead is saved");
//		
		return "create_lead";
	}
	@RequestMapping("/listAll")
      public String listAllLeads(ModelMap model) {
    	  
    	  List<Lead> leads = leadservice.listLeads();
model.addAttribute("leads", leads);    	  
    return "lead_search_result";  
	
	}
	
      @RequestMapping("/delete")
      public String  deleteOneLead(@RequestParam("id")long id,ModelMap model) {
    	  
    	  leadservice.deleteLeadById(id);
    	      List<Lead> leads = leadservice.listLeads();
    	      model.addAttribute("leads", leads);    
    	      return "lead_search_result"; 
      }
      
      @RequestMapping("/update")
      public String updateOneLead(@RequestParam("id")long id,ModelMap model) {
    	  Lead lead = leadservice.getOneLeadId(id);
    	  model.addAttribute("lead", lead);
    	  return "update_lead";
      }
      
    	  @RequestMapping("/updatelead")
    	  public String updateOneLeadData(LeadData data) {
    			Lead lead = new Lead();
    			lead.setId(data.getId());
    			lead.setFirstName(data.getFirstName());
    			lead.setLastName(data.getLastName());
    			lead.setEmail(data.getEmail());
    			lead.setMobile(data.getMobile());
    			leadservice.saveLead(lead);
    		 
    		  return "lead_search_result";
    	  }
    	  
      
      
      
      
	
//    @RequestMapping("/savelead")
//	public String saveOneLead(@RequestParam("finame") String fname,@RequestParam("laName") String lname, @RequestParam("emailId") String email,@RequestParam("mobileNo") long mobile ,ModelMap model) {
//	Lead lead = new Lead();
//    	lead.setFirstName(fname);
//    	lead.setLastName(lname);
//    	lead.setEmail(email);
//    	lead.setMobile(mobile);
//    	 leadservice.saveLead(lead);
//      
//		return "create_lead";
//	}
	
//	 @RequestMapping("/savelead")
//		public String saveOneLead(LeadData data,  ModelMap model) {
//		 Lead lead = new Lead();
//		 lead.setFirstName(data.getFiname());
//		 lead .setLastName(data.getLaName());
//		 lead.setEmail(data.getEmailId());
//		 lead.setMobile(data.getMobileNo());
//	      leadservice.saveLead(lead);
//			return "create_lead";
//		}
	
      
      
}
