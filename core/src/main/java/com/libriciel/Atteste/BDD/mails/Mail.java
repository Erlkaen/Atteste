/*
 * 
 */
package com.libriciel.Atteste.BDD.mails;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.libriciel.Atteste.BDD.certs.Certificat;

/**
 * The Class Mail.
 */
@Entity
@Table(name = "mails")
public class Mail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mailId;
	
	@Column(name = "adresseMail")
	private String adresseMail;
	
	@ManyToMany(mappedBy = "mails")
	@JsonIgnore
	private List<Certificat> certificates = new ArrayList<Certificat>();
	
	public Mail(String adresseMail) {
		this.adresseMail = adresseMail;
	}
	
	public Mail(int mailId, String adresseMail) {
		this.mailId = mailId;
		this.adresseMail = adresseMail;
	}
	
	public Mail() {
		this.adresseMail = null;
	}
	
	public List<Certificat> getCertificats() {
		return this.certificates;
	}
	
	public String getAdresseMail() {
		return this.adresseMail;
	}
	
	public void addCertificat(Certificat c) {
		this.certificates.add(c);
	}
	
	public void addCertificats(List<Certificat> cl) {
		this.certificates.addAll(cl);
	}
	
	public int getId() {
		return this.mailId;
	}
}
