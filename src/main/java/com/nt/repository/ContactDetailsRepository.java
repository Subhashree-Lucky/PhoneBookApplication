package com.nt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nt.entity.ContactDetailsEntity;

/**
 * It is for handling persistence logic
 * @author Subhashree
 *
 */
@Repository
public interface ContactDetailsRepository extends JpaRepository<ContactDetailsEntity, Integer> {

	@Modifying
	@Transactional
	@Query(value = "update  ContactDetailsEntity set activeSw=:sw where contactId=:id")
	public void softDelete(String sw,Integer id);
}
