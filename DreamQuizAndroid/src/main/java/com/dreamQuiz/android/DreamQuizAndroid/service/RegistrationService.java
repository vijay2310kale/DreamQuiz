package com.dreamQuiz.android.DreamQuizAndroid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dreamQuiz.android.DreamQuizAndroid.entites.Registration;
import com.dreamQuiz.android.DreamQuizAndroid.repository.RegistrationRepository;

import java.util.List;

@Service
public class RegistrationService {
	
	
	@Autowired
	
	RegistrationRepository registrationRepository;

	public Registration newregisteration(Registration registration) {
		// TODO Auto-generated method stub
		return registrationRepository.save(registration);
	}

	public List<String> findemailfromdb() {
		
		return registrationRepository.findemailfrmdb();
	}

	public List<String> findmobilenofromdb() {
		// TODO Auto-generated method stub
		return registrationRepository.findemobilefrmdb();
	}

	public String finduserid(String umail, String umobile) {
		// TODO Auto-generated method stub
		return registrationRepository.finduserid(umail,umobile);
	}

	public String getotpfromdb(String user_id) {
		// TODO Auto-generated method stub
		return registrationRepository.getotp(user_id);
	}

	public String getpassbyphoneno(String phone_no) {
		// TODO Auto-generated method stub
		return registrationRepository.findbyphone_no(phone_no);
	}

	public long getuserid(String phone_no) {
		// TODO Auto-generated method stub
		return registrationRepository.getidnyphone(phone_no);
	}

	

	public Registration getallbyphone_no(String phone_no) {
		// TODO Auto-generated method stub
		return registrationRepository.alldatabyphoneno(phone_no);
	}

	public void updatedata(Registration getalldatabyphone) {
		registrationRepository.save(getalldatabyphone);
		
	}

	public Registration getalldatabyuid(long uid) {
		// TODO Auto-generated method stub
		return registrationRepository.getalldatabyuid(uid);
	}

	

	
	

	

}
