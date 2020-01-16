package com.nt.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * It is binded with repository
 * 
 * @author Subhashree
 *
 */

@Data
@Entity
@Table(name = "CONTACT_DETAIL")
public class ContactDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTACT_ID", length = 30)
	private Integer contactId;
	@Column(name = "CONTACT_NAME", length = 20)
	private String contactName;
	@Column(name = "CONATACT_EMAIL", length = 30)
	private String contactEmail;
	@Column(name = "CONTACT_PHONENO", length = 20)	
	private Long phNo;
	@Column(name = "ACTIVE_SW")
	private String activeSw;

}
