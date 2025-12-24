package com.challenge.backend.nubank.domain.services;

import com.challenge.backend.nubank.domain.vos.ContactVO;
import org.springframework.stereotype.Service;

@Service
public interface ContactServiceInterface {

    ContactVO createContact(ContactVO contactVO);
}
