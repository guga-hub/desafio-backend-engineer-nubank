package com.challenge.backend.nubank.domain.services.impl;

import com.challenge.backend.nubank.domain.services.ContactServiceInterface;
import com.challenge.backend.nubank.domain.usecases.contact.create.ContactCreateUseCase;
import com.challenge.backend.nubank.domain.vos.ContactVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactServiceInterface {

    private final ContactCreateUseCase contactCreateUseCase;

@Override
public ContactVO createContact(ContactVO contactVO) {
    return contactCreateUseCase.createContact(contactVO);
}
}
