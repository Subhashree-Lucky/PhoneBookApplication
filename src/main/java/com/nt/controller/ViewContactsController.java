package com.nt.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.model.Contact;
import com.nt.service.ContactService;

/**
 * This is use for handling all request coming from viewContacts.jsp
 * 
 * @author Subhashree
 *
 */

@Controller
public class ViewContactsController {

	@Autowired
	public ContactService service;
	
	/**
	 * Used for edit contact hyperlink
	 * @param req
	 * @param model
	 * @return
	 */

	@RequestMapping("/editContact")
	public String editContact(HttpServletRequest req, Model model) {
		int id = Integer.parseInt(req.getParameter("cid"));
		// call service method
				Contact contact = service.getContactById(id);
				model.addAttribute("contact", contact);	
		return "contact";
	}
	
	/**
	 * For delete contact hyperlink
	 * @param req
	 * @return
	 */

	@RequestMapping("/deleteContact")
	public String deleteContact(HttpServletRequest req) {
		Integer id=Integer.parseInt(req.getParameter("cid"));
		boolean  deleteContact= service.deleteContactById(id);
		return "redirect:viewContacts";

	}
}
