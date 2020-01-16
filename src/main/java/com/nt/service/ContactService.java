package com.nt.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.nt.model.Contact;

@Service
public interface ContactService {
	 
	public boolean saveContact(Contact c);
	public List<Contact>getAllContacts();
	public Contact getContactById(Integer cid);
	public boolean deleteContactById(Integer cid);

}
