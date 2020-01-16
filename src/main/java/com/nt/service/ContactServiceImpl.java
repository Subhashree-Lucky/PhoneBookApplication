package com.nt.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.ContactDetailsEntity;
import com.nt.model.Contact;
import com.nt.repository.ContactDetailsRepository;
import com.nt.utils.EmailUtils;

/**
 * It is handling bussness logics
 * 
 * @author Subhashree
 *
 */

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDetailsRepository cdrepo;
	@Autowired
	private EmailUtils utils;
	
	/**
	 * This method is used to save contact details
	 */

	@Override
	public boolean saveContact(Contact c) {
		//convert model to entity
		ContactDetailsEntity entity = new ContactDetailsEntity();
		BeanUtils.copyProperties(c, entity);
		entity.setActiveSw("Y");
		entity = cdrepo.save(entity);
		return entity.getContactId() > 0;
	}

	/**
	 * It is used for fetching all the contacts form the table
	 */

	@Override
	public List<Contact> getAllContacts() {
		List<ContactDetailsEntity> listEntity = cdrepo.findAll();
		List<ContactDetailsEntity> filteredList= listEntity.stream().filter(ent -> "Y".equals(ent.getActiveSw())).collect(Collectors.toList());
		List<Contact> listContact = new ArrayList<>();
		filteredList.forEach(ent -> {
			Contact contact = new Contact();
			BeanUtils.copyProperties(ent, contact);
			listContact.add(contact);
		});

		return listContact;
	}

	@Override
	public Contact getContactById(Integer cid) {
		Optional<ContactDetailsEntity> findById = cdrepo.findById(cid);
		Contact c = null;
		if (findById.isPresent()) {
			ContactDetailsEntity contactEntity = findById.get();
			c = new Contact();
			BeanUtils.copyProperties(contactEntity, c);
		}
		
		return c;
	}
	
	/**
	 * It is used for inserting contact details in db by using repository method
	 */

	@Override
	public boolean deleteContactById(Integer cid) {
		cdrepo.softDelete("N", cid);
		return true;
	}
}

