/*
 * 
 */
package com.libriciel.Atteste.BDD.mails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface MailRepository.
 */
@Repository
public interface MailRepository extends JpaRepository<Mail, Integer> {}
