/* Classe définissant un certificat
 *
 */
package com.libriciel.Atteste.BDD.certs;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.libriciel.Atteste.BDD.mails.Mail;

/**
 * Classe Certificat.
 */
@Entity
@Table(name = "certificats")
public class Certificat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int certificatId;

	@Column(name = "notBefore")
	private Date notBefore;

	@Column(name = "notAfter")
	private Date notAfter;

	@ManyToMany
	@JoinTable(name = "carnetadresses",
		joinColumns = { @JoinColumn(name = "certificatId") },
		inverseJoinColumns = { @JoinColumn(name = "mailId") }
	)
	@JsonIgnore
	private List<Mail> mails = new ArrayList<Mail>();

	//constructors
	public Certificat(Date notBefore, Date notAfter) {
		this.notBefore = notBefore;
		this.notAfter = notAfter;
	}

	public Certificat(int certificatId, Date notBefore, Date notAfter) {
		this.certificatId = certificatId;
		this.notBefore = notBefore;
		this.notAfter = notAfter;
	}

	public Certificat() {
		this.notBefore = null;
		this.notAfter = null;
	}

	public Certificat(X509Certificate cert) {
		this.notBefore = cert.getNotBefore();
		this.notAfter = cert.getNotAfter();
	}

	//getters
	public Date getNotBefore() {
		return this.notBefore;
	}

	public Date getNotAfter() {
		return this.notAfter;
	}

	public int getId() {
		return this.certificatId;
	}

	public List<Mail> getMails(){
		return this.mails;
	}

	//methods
	public void addMail(Mail m) {
		this.mails.add(m);
	}

	public void addMails(List<Mail> ml) {
		this.mails.addAll(ml);
	}
}
