package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.constants.AppConstants;
import com.nt.model.Contact;
import com.nt.service.ContactService;

/**
 * This is for handling the requests coming from Contact.jsp
 * @author Subhashree
 *
 */

@Controller
public class ContactInfoController {

	@Autowired
	private ContactService service;
	
	/**
	 * For displaying contact page
	 * @param model
	 * @return
	 */

	@RequestMapping("/")
	public String displayContactForm(Model model) {
		Contact c = new Contact();
		model.addAttribute(AppConstants.CONTACT, c);
		return "contact";
	}
	
	/**
	 * For handling submit button
	 * @param c
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/handleSubmitBtn", method = RequestMethod.POST)
	public String handleSubmitBtn(@ModelAttribute("contact") Contact c, Model model) {
		boolean flag = service.saveContact(c);
		if (flag) {
			model.addAttribute(AppConstants.SUCCESS_MSG, "Contact Saved");
		} else {
			model.addAttribute(AppConstants.ERROR_MSG, "Failed to save contact");
		}
		return "contact";
	}
	
	/**
	 * Handling view all contact hyperlink
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value="/viewContacts")
	public String viewContacts(Model model) {
		List<Contact> allContacts = service.getAllContacts();
		model.addAttribute("contact",allContacts);
		return "viewContacts";
	}

}
