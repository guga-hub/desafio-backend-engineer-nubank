package com.challenge.backend.nubank.shared.utils.mapper;

import com.challenge.backend.nubank.application.dtos.contacts.ContactRequestDTO;
import com.challenge.backend.nubank.domain.vos.ContactVO;
import com.challenge.backend.nubank.infrastructure.entities.ContactEntity;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    public ContactEntity toEntity(@Valid ContactRequestDTO contactRequestDTO) {
        if (contactRequestDTO == null) {
            return null;
        }

        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setName(contactRequestDTO.getName());
        contactEntity.setEmail(contactRequestDTO.getEmail());
        contactEntity.setPhoneNumber(contactRequestDTO.getPhoneNumber());

        return contactEntity;
    }

    public ContactEntity dtoToEntity(ContactRequestDTO contactRequestDTO) {
        if (contactRequestDTO == null) {
            return null;
        }

        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setName(contactRequestDTO.getName());
        contactEntity.setEmail(contactRequestDTO.getEmail());
        contactEntity.setPhoneNumber(contactRequestDTO.getPhoneNumber());

        return contactEntity;
    }

    public ContactEntity toEntity(ContactVO contactVO) {
        if (contactVO == null) {
            return null;
        }

        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setId(contactVO.getId());
        contactEntity.setName(contactVO.getName());
        contactEntity.setEmail(contactVO.getEmail());
        contactEntity.setPhoneNumber(contactVO.getPhoneNumber());

        return contactEntity;
    }

    public ContactVO toVO(ContactEntity contactEntity) {
        if (contactEntity == null) {
            return null;
        }

        ContactVO contactVO = new ContactVO();
        contactVO.setId(contactEntity.getId());
        contactVO.setName(contactEntity.getName());
        contactVO.setEmail(contactEntity.getEmail());
        contactVO.setPhoneNumber(contactEntity.getPhoneNumber());

        return contactVO;
    }
}
