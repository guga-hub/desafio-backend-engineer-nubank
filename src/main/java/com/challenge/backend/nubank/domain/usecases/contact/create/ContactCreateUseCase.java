package com.challenge.backend.nubank.domain.usecases.contact.create;

import com.challenge.backend.nubank.domain.vos.ContactVO;
import com.challenge.backend.nubank.infrastructure.repositories.ContactRepository;
import com.challenge.backend.nubank.shared.utils.mapper.ContactMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContactCreateUseCase {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public ContactVO createContact(ContactVO contactVO) {
        // Map ContactVO to ContactEntity
        var contactEntity = contactMapper.toEntity(contactVO);

        // Save ContactEntity using ContactRepository
        var savedContactEntity = contactRepository.save(contactEntity);

        // Map saved ContactEntity back to ContactVO
        return contactMapper.toVO(savedContactEntity);
    }
}
