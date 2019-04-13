package com.libriciel.Atteste.BDD.certs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.libriciel.Atteste.BDD.mails.Mail;

public class CertificatTest {

	@Before
	public void before() {
		System.out.println("New Test :---------->");
	}
	
	@After
	public void after() {
		System.out.println("OK");
		System.out.println("End of test <---:");
	}

	@Test
	public void testConstructeurVide() {
		System.out.println("Test du constructeur vide :");

		Certificat c = new Certificat();
		assertNull(c.getNotAfter());
		assertTrue(c.getMails().isEmpty());
	}
	
	@Test
	public void testContructeurNotID() {
		System.out.println("Test du constructeur sans ID :");

		Date d1 = new Date();
		Date d2 = new Date();
		Certificat c = new Certificat(d1, d2);
		
		assertEquals(c.getNotBefore(), d1);
		assertEquals(c.getNotAfter(), d2);
		assertTrue(c.getMails().isEmpty());
	}
	
	@Test
	public void testConstructeurID() {
		System.out.println("Test du constructeur avec ID :");

		Date d1 = new Date();
		Date d2 = new Date();
		Certificat c = new Certificat(100, d1, d2);
		
		assertEquals(c.getId() , 100);
		assertEquals(c.getNotBefore(), d1);
		assertEquals(c.getNotAfter(), d2);
		assertTrue(c.getMails().isEmpty());	
	}
	
	@Test
	public void testAddMail() {
		System.out.println("Test de la méthode addMail() :");

		Certificat c = new Certificat();
		
		assertTrue(c.getMails().isEmpty());	
		
		c.addMail(new Mail());
		
		assertFalse(c.getMails().isEmpty());
		assertEquals(c.getMails().size(), 1);
	}
	
	@Test
	public void testAddMails() {
		System.out.println("Test de la méthode addMails() :");

		Certificat c = new Certificat();
		
		assertTrue(c.getMails().isEmpty());	
		
		List<Mail> lm = new ArrayList<Mail>();
		lm.add(new Mail());
		lm.add(new Mail());
		c.addMails(lm);
		
		assertFalse(c.getMails().isEmpty());
		assertEquals(c.getMails().size(), 2);
	}

}
