package com.dreamQuiz.android.DreamQuizAndroid.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Applyform {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long fid;
	
	
	 @Column(name = "name") 
		private String name;
	 
	 @Column(name = " fathername") 
		private String  fathername;
	 
	 @Column(name = "mothername") 
		private String mothername;
	 
	 @Column(name = "dob") 
		private String dob;
	 
	 @Column(name = "sscmarksheet") 
		private String sscmarksheet;
	 
	 @Column(name = "hscmarksheet") 
		private String hscmarksheet;
	 
	 @Column(name = "Graduationmarksheet") 
		private String Graduationmarksheet;
	 
	 @Column(name = "pgmarksheet") 
		private String pgmarksheet;
	 
	 @Column(name = "photo") 
		private String photo;
	 
	 @Column(name = "signature") 
		private String signature;
	 
	 @Column(name = "Categoty") 
		private String Categoty;
	 
	 @Column(name = "whatsappno") 
		private String whatsappno;
	 
	 @Column(name = "message") 
		private String message;
	 
	 @Column(name = "datetimespan") 
		private String datetimespan;

	 
	 
	 
	public String getDatetimespan() {
		return datetimespan;
	}

	public void setDatetimespan(String datetimespan) {
		this.datetimespan = datetimespan;
	}

	public long getFid() {
		return fid;
	}

	public void setFid(long fid) {
		this.fid = fid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getMothername() {
		return mothername;
	}

	public void setMothername(String mothername) {
		this.mothername = mothername;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSscmarksheet() {
		return sscmarksheet;
	}

	public void setSscmarksheet(String sscmarksheet) {
		this.sscmarksheet = sscmarksheet;
	}

	public String getHscmarksheet() {
		return hscmarksheet;
	}

	public void setHscmarksheet(String hscmarksheet) {
		this.hscmarksheet = hscmarksheet;
	}

	public String getGraduationmarksheet() {
		return Graduationmarksheet;
	}

	public void setGraduationmarksheet(String graduationmarksheet) {
		Graduationmarksheet = graduationmarksheet;
	}

	public String getPgmarksheet() {
		return pgmarksheet;
	}

	public void setPgmarksheet(String pgmarksheet) {
		this.pgmarksheet = pgmarksheet;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getCategoty() {
		return Categoty;
	}

	public void setCategoty(String categoty) {
		Categoty = categoty;
	}

	public String getWhatsappno() {
		return whatsappno;
	}

	public void setWhatsappno(String whatsappno) {
		this.whatsappno = whatsappno;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
