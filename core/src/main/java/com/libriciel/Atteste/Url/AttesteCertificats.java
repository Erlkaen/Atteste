/*
 *
 */
package com.libriciel.Atteste.Url;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libriciel.Atteste.BDD.certs.CertificatRepository;
import com.libriciel.Atteste.BDD.mails.Mail;
import com.libriciel.Atteste.BDD.mails.MailRepository;

/**
 * The Class AttesteCertificats.
 */
@RestController
public class AttesteCertificats {

	@Autowired
	public CertificatRepository cr;

	@Autowired
	public MailRepository mr;

	/**
	 * Sets the connection.
	 *
	 * @param url the url
	 * @return the https URL connection
	 */
	public static HttpsURLConnection setHttpsonnection(URL url) {
		HttpsURLConnection co = null;
		try {
			co = (HttpsURLConnection) url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			co.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return co;
	}

	public static HttpURLConnection setHttpConnection(URL url) {
		HttpURLConnection co = null;
		try {
			co = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			co.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return co;
	}

	public static boolean isValidURL(String urlString){
		try{
			URL url = new URL(urlString);
			url.toURI();
			return true;
		} catch (Exception exception){
			return false;
		}
	}

	public X509Certificate[] getCertificateFromURL(String url) {
		if(isValidURL(url)) {
			URLConnection co = null;
			HttpsURLConnection httpsCo = null;
			HttpURLConnection httpCo = null;
			URL coUrl = null;
			try {
				coUrl = new URL(url);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}

			try {
				co = coUrl.openConnection();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(co instanceof HttpsURLConnection) {
				httpsCo = (HttpsURLConnection) co;
				try {
					httpsCo.connect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(co instanceof HttpURLConnection) {
				httpCo = (HttpURLConnection) co;
			}

			if(httpsCo != null) {
				Certificate[] certs = null;
				try {
					certs = httpsCo.getServerCertificates();
				} catch (SSLPeerUnverifiedException e) {
					e.printStackTrace();
				}
				return (X509Certificate[]) certs;
			}else if(httpCo != null) {
				//http so no certificates
				return null;
			}else {
				//error
				return null;
			}
		}else {
			return null;
		}
	}


	@RequestMapping("/api/testBDD")
	public void test() {

		cr.deleteAllInBatch();
		
		System.out.println(cr.saveAll(getCertificateFromURL("https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/PostMapping.html")));
		System.out.println(cr.saveAll(getCertificateFromURL("https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html")));
		System.out.println(cr.saveAll(getCertificateFromURL("https://www.youtube.com/watch?v=S8ufs-tDNwU&list=RDGMEMHDXYb1_DDSgDsobPsOFxpAVMnHGJu45vLQo&index=6&has_verified=1")));
		System.out.println(mr.save(new Mail("truc@truc.truc")));
		System.out.println(mr.save(new Mail("truc@truc.truc2")));
		System.out.println(mr.save(new Mail("truc@truc.truc3")));
	}
}
