package com.dreamQuiz.android.DreamQuizAndroid.configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendMessage {
	
	
	public String sendSms(String SendOTP,String numbers) {
		try {

		// Construct data
		String apiKey = "apikey=" + "c0wQnTXLUmk-SmQKIatPsts4KlHxvlmTbwFnYfLRom";
		numbers = "&numbers=" + numbers;
		String sender = "&sender=" + "JYSAPP";
		   String message = "&message="+"Your Verification OTP is "+SendOTP;

		// Send data
		HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
		String data = apiKey + numbers + sender + message;
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
		conn.getOutputStream().write(data.getBytes("UTF-8"));
		final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		final StringBuffer stringBuffer = new StringBuffer();
		String line;
		while ((line = rd.readLine()) != null) {
		stringBuffer.append(line);
		}
		rd.close();

		return stringBuffer.toString();
		} catch (Exception e) {
		System.out.println("Error SMS "+e);
		return "Error "+e;
		}

		}


}
