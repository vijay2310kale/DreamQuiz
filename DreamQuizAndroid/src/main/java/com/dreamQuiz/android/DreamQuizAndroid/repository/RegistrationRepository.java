package com.dreamQuiz.android.DreamQuizAndroid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.dreamQuiz.android.DreamQuizAndroid.entites.Registration;



public interface RegistrationRepository extends JpaRepository<Registration,Long> {

	

	
	
	
	@Transactional
	@Modifying

	@Query(nativeQuery = true, value = "SELECT email FROM registration")
	List<String> findemailfrmdb();

	
	@Query(nativeQuery = true, value = "SELECT phone_no FROM registration")
	List<String> findemobilefrmdb();

	@Query(nativeQuery = true, value = "SELECT user_id FROM registration where email=:umail AND phone_no=:umobile")
	String finduserid(String umail, String umobile);

	@Query(nativeQuery = true, value = "SELECT otp FROM registration where user_id=:user_id")
	String getotp(String user_id);

	@Query(nativeQuery = true, value = "SELECT password FROM registration where phone_no=:phone_no")
	String findbyphone_no(String phone_no);

	@Query(nativeQuery = true, value = "SELECT user_id FROM registration where phone_no=:phone_no")
	long getidnyphone(String phone_no);

//	@Query(nativeQuery = true, value = "update registration r  set r.device_token =:device_token, r.device_type =:device_type,r.token=:token where r.phone_no =:phone_no")
//	void updateuser(@Param("device_token")String device_token,@Param("device_type") String device_type,@Param("token") String token,@Param("phone_no") String phone_no);

	@Query(nativeQuery = true, value = "SELECT * FROM registration where phone_no=:phone_no")
	Registration alldatabyphoneno(String phone_no);

	@Query(nativeQuery = true, value = "SELECT * FROM registration where user_id=:uid")
	Registration getalldatabyuid(long uid);


//	void saveAll(String device_token, String device_type, String token, String phone_no);


	




}
