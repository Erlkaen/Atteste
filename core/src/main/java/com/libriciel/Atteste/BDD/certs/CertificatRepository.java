/*
 * 
 */
package com.libriciel.Atteste.BDD.certs;

import java.security.cert.X509Certificate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface CertificatRepository.
 */
@Repository
public interface CertificatRepository extends JpaRepository<Certificat, Integer> {
	public default X509Certificate[] saveAll(X509Certificate[] x509Certificates){
		for(int i = 0; i < x509Certificates.length; i++) {
			this.save(new Certificat(x509Certificates[i]));
		}
		return x509Certificates;
	}
}
