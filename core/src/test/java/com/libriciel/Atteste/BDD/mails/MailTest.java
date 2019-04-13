package com.libriciel.Atteste.BDD.mails;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.libriciel.Atteste.BDD.certs.Certificat;

public class MailTest {
	
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
		
		Mail m = new Mail();
		assertNull(m.getAdresseMail());
		assertTrue(m.getCertificats().isEmpty());
	}
	
	@Test
	public void testContructeurString() {
		System.out.println("Test du constructeur sans ID :");
		
		Mail m = new Mail("truc@truc.truc");
		assertEquals(m.getAdresseMail(), "truc@truc.truc");
		assertTrue(m.getCertificats().isEmpty());
	}
	
	@Test
	public void testConstructeurIntString() {
		System.out.println("Test du constructeur avec ID :");

		Mail m = new Mail(200, "truc@truc.truc");
		
		assertEquals(m.getAdresseMail(),"truc@truc.truc");
		assertEquals(m.getId(), 200);
		assertTrue(m.getCertificats().isEmpty());	
	}
	
	@Test
	public void testAddCertificat() {
		System.out.println("Test de la méthode addCertificat() :");
		
		Mail m = new Mail();
		
		assertTrue(m.getCertificats().isEmpty());	
		
		m.addCertificat(new Certificat());
		
		assertFalse(m.getCertificats().isEmpty());
		assertEquals(m.getCertificats().size(), 1);
	}
	
	@Test
	public void testAddCertificats() {
		System.out.println("Test de la méthode addcertificats() :");
		
		Mail m = new Mail();
		
		assertTrue(m.getCertificats().isEmpty());
		
		List<Certificat> lc = new ArrayList<Certificat>();
		lc.add(new Certificat());
		lc.add(new Certificat());

		m.addCertificats(lc);

		assertFalse(m.getCertificats().isEmpty());
		assertEquals(m.getCertificats().size(), 2);
	}

}
