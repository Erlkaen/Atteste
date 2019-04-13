/*
 *
 */
package com.libriciel.Atteste.BDD.mails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libriciel.Atteste.BDD.certs.CertificatRepository;

/**
 * The Class MailController.
 */
@RestController
public class MailController {

	/** The repository. */
	@Autowired
	MailRepository repository;

	@Autowired
	CertificatRepository certificatRepository;

	/**
	 * Save.
	 *
	 * @param adresseMail the adresse mail
	 * @return the mail
	 */
	@PostMapping("/saveMail")
	public Mail save(@RequestParam("adresseMail") String adresseMail) {
		return repository.save(new Mail(adresseMail));
	}

	@GetMapping("/selectAllMail")
	public List<Mail> selectAll(){
		return repository.findAll();
	}

}
