package com.dreamQuiz.android.DreamQuizAndroid.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dreamQuiz.android.DreamQuizAndroid.configuration.MD5;
import com.dreamQuiz.android.DreamQuizAndroid.configuration.OTPServerMsg91;
import com.dreamQuiz.android.DreamQuizAndroid.entites.LoginResponce;
import com.dreamQuiz.android.DreamQuizAndroid.entites.Registration;
import com.dreamQuiz.android.DreamQuizAndroid.entites.RegistrationResponce;
import com.dreamQuiz.android.DreamQuizAndroid.service.RegistrationService;




@RestController
public class RegistrationController {
	
	@Autowired
     RegistrationService registrationService;
	
	     
	
	@RequestMapping(value="/api/signup",method = RequestMethod.POST)
    public RegistrationResponce createAccount(@ModelAttribute Registration registration) throws IOException, NoSuchAlgorithmException
    {
		RegistrationResponce responce =new RegistrationResponce();
		
		String upassword=registration.getPassword();
		
		MD5 md5 = new MD5();
		String passworddb = md5.getpass(upassword);
		
		registration.setPassword(passworddb);
		
		String umail=registration.getEmail();
		String umobile=registration.getPhone_no();
		List<String> findemailfromdb=registrationService.findemailfromdb();
		List<String> findmobilenofromdb=registrationService.findmobilenofromdb();
		System.out.println("size of emil "+findemailfromdb.size());
        try {
		if(findemailfromdb.contains(umail) ||findmobilenofromdb.contains(umobile) ){
			
			
			responce.setMessage(" user Email Or Phone allready Present ");
			responce.setStatus("0");
		
	
		}
		
		else {
			 registrationService.newregisteration(registration);
			
			 String user_id=registrationService.finduserid(umail,umobile);
			 
			 
			 Random random = new Random();
				int otp = random.nextInt(10000);
				String otpnew = Integer.toString(otp);
				if (otp < 999) {
					otpnew = otp + "0";
				}
				String message = "Your DreamQuiz OTP is " + otpnew;
				OTPServerMsg91 obj = new OTPServerMsg91();
				registration.setOtp(otpnew);
				 registrationService.newregisteration(registration);
			//	registrationService.updateotpforuaer(otpnew,user_id);
				// This message sendMessage
				int result = obj.sendMessage(umobile, message);
				if (result != 0) {
					
					responce.setMessage("You have registered successfully please verify ");
					responce.setStatus("1");
					responce.setUser_id(user_id);
					responce.setOtp(otpnew);
					
					
				}else {
					responce.setMessage("otp msg not send ");
					
				}
				

		}
        }
        
        catch (Exception e) {

			e.printStackTrace();
		}
       
       return responce;
    }

	
	@RequestMapping(value="/api/verify",method = RequestMethod.POST)
	public RegistrationResponce verifyOTP( String otp, String user_id)throws Exception{
		
		RegistrationResponce responce =new RegistrationResponce();
		String otpfromdb=registrationService.getotpfromdb(user_id);
		try {
		if(otpfromdb.equals(otp)) {
			responce.setMessage("Verify Successfully ");
			responce.setStatus("1");
		
			
			
		}
		
		else {
			responce.setMessage("otp not match ");
			responce.setStatus("0");
			
			
		}
		
		}
		
		catch (Exception e) {

			e.printStackTrace();
		}
		 return responce;
	}
	
//	
//	@RequestMapping(value="/api/ReSendOTP",method = RequestMethod.POST)
//	public RegistrationResponce ReSendOTP(String user_id)throws Exception{
//		
//		RegistrationResponce responce =new RegistrationResponce();
//		
//		try {
//		
//		
//		Random random = new Random();
//			int otp = random.nextInt(10000);
//			String otpnew = Integer.toString(otp);
//			if (otp < 999) {
//				otpnew = otp + "0";
//			}
//			String message = "Your DreamQuiz OTP is " + otpnew;
//			OTPServerMsg91 obj = new OTPServerMsg91();
//			registration.setOtp(otpnew);
//			 registrationService.newregisteration(registration);
//		//	registrationService.updateotpforuaer(otpnew,user_id);
//			// This message sendMessage
//			int result = obj.sendMessage(umobile, message);
//			if (result != 0) {
//				
//				responce.setMessage("You have registered successfully please verify ");
//				responce.setStatus("1");
//				responce.setUser_id(user_id);
//				responce.setOtp(otpnew);
//				
//				
//			else {
//				responce.setMessage("otp msg not send ");
//				
//			}
//			
//
//	}
// 
// 
// catch (Exception e) {
//
//		e.printStackTrace();
//	}
//
//return responce;
//
//		
//	
//}
	
	
	@RequestMapping(value="/api/login",method = RequestMethod.POST)
	public LoginResponce login(String phone_no,String password,String device_token,String device_type)throws Exception{
	
		LoginResponce loginresponce =new LoginResponce();
		Registration getalldatabyphone=registrationService.getallbyphone_no(phone_no);
		try {
		
			List<String> phonefromdb=registrationService.findmobilenofromdb();
		
			if(phonefromdb.contains(phone_no)) {
		
		String passfromdb=registrationService.getpassbyphoneno(phone_no);
		long userid=registrationService.getuserid(phone_no);
		MD5 md5 = new MD5();
		String passworddb = md5.getpass(password);
		if(passworddb.equals(passfromdb)) {
			 String token="token111";
			 getalldatabyphone.setDevice_token(device_token);
			 getalldatabyphone.setDevice_type(device_type);
			 getalldatabyphone.setToken("token");
			 
			 System.out.println("currect password");
			//registrationService.updateuser(device_token,device_type,token,phone_no);
			registrationService.updatedata(getalldatabyphone);
			
			loginresponce.setMessage("You have login successfully");
			loginresponce.setStatus("1");
			loginresponce.setUser_id(userid);
			loginresponce.setToken("token");
		
		}else {
			loginresponce.setMessage("password not match");
			loginresponce.setStatus("0");
			loginresponce.setUser_id(userid);
			loginresponce.setToken("token");
			
		}
		
		}
		else {
			loginresponce.setMessage("Do Registration first... ");
			loginresponce.setStatus("2");
			
			
		}
	}
		catch (Exception e) {

			e.printStackTrace();
		}
		return loginresponce;
	
	}
	
	
	@RequestMapping(value="/api/forgotpassword",method = RequestMethod.POST)
	public RegistrationResponce forgotpassword(String phone_no)throws Exception{
		
		RegistrationResponce responce =new RegistrationResponce();
		Registration getalldatabyphone=registrationService.getallbyphone_no(phone_no);
		long userid=getalldatabyphone.getUser_id();
		String uid=String.valueOf(userid);
		try {
			
			List<String> phonefromdb=registrationService.findmobilenofromdb();
			
			if(phonefromdb.contains(phone_no)) {
				
				
				 Random random = new Random();
					int otp = random.nextInt(10000);
					String otpnew = Integer.toString(otp);
					if (otp < 999) {
						otpnew = otp + "0";
					}
					String message = "Your DreamQuiz OTP is " + otpnew;
					OTPServerMsg91 obj = new OTPServerMsg91();
					getalldatabyphone.setOtp(otpnew);
					 registrationService.newregisteration(getalldatabyphone);
				//	registrationService.updateotpforuaer(otpnew,user_id);
					// This message sendMessage
					int result = obj.sendMessage(phone_no, message);
					if (result != 0) {
						
						responce.setMessage("Otp has been send to registered mobile No ");
						responce.setStatus("1");
						responce.setUser_id(uid);
						responce.setOtp(otpnew);
						
						
					}else {
						responce.setMessage("otp msg not send ");
						
					}
					

				
				
				
			}else {
				responce.setMessage("Mobile No Not Invalid or Not found... ");
				responce.setStatus("2");
				
				
			}
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		return responce;
	}
	
	@RequestMapping(value="/api/resetpassword",method = RequestMethod.POST)
	public RegistrationResponce resetpassword(String password,String otp,String user_id)throws Exception{
	
		
		
		RegistrationResponce responce =new RegistrationResponce();
		long uid=Long.valueOf(user_id);
		
		Registration regi=registrationService.getalldatabyuid(uid);
		String otpfromdb=regi.getOtp();
		String dbpassword=regi.getPassword();
		MD5 md5 = new MD5();
		String passworddb = md5.getpass(password);
		if(otpfromdb.equals(otp)) {
			
			regi.setOtp("");
			regi.setPassword(passworddb);
			
			 registrationService.newregisteration(regi);
			 
			 responce.setMessage("Password Reset Successfully... ");
			 responce.setStatus("1");
			
			
		}else {
			
			responce.setMessage("In valid OTP ... ");
			responce.setStatus("2");
			
			
			
		}
		
		return null;
	
		
		
		
	}
}