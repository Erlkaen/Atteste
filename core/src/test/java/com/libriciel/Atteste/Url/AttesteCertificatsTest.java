package com.libriciel.Atteste.Url;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AttesteCertificatsTest {
	
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
	public void testIsValidURL() {
		System.out.println("Test de la méthode isValidURL()");
		assertFalse(AttesteCertificats.isValidURL(""));
		assertFalse(AttesteCertificats.isValidURL("https/github.com/"));
		assertTrue(AttesteCertificats.isValidURL("https://github.com/"));
	}
	
	@Test
	public void testGetCertificateFromURL() {
		System.out.println("Test de la méthode getCertificateFromURL()");
		AttesteCertificats atc = new AttesteCertificats();
		assertNull(atc.getCertificateFromURL(""));
		assertNull(atc.getCertificateFromURL("https/github.com/"));
		assertNull(atc.getCertificateFromURL("http://websico.com/fr/maquettes-et-prototypes-web.html"));
		assertNull(atc.getCertificateFromURL("zegrhtyejkur"));
		assertNull(atc.getCertificateFromURL("http://glossaire.infowebmaster.fr/http/"));
		assertNotNull(atc.getCertificateFromURL("https://github.com/"));
	}

}
