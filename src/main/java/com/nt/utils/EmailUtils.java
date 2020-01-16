package com.nt.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
	
	@Autowired
	private JavaMailSender mailSender;
	
	/**
	 * 	This method is used for sending mail
	 * @param to
	 * @param sub
	 * @param body
	 */
	
	public void sendEmail(String to,String sub,String body) {
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo(to);
		msg.setSubject(sub);
		msg.setText(body);
		mailSender.send(msg);
		
	}
}
