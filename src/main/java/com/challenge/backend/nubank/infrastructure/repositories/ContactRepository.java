package com.challenge.backend.nubank.infrastructure.repositories;

import com.challenge.backend.nubank.infrastructure.entities.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
}
