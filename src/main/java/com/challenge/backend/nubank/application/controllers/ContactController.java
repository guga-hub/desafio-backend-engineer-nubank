package com.challenge.backend.nubank.application.controllers;

import com.challenge.backend.nubank.application.dtos.contacts.ContactRequestDTO;
import com.challenge.backend.nubank.domain.vos.ContactVO;
import com.challenge.backend.nubank.infrastructure.repositories.ContactRepository;
import com.challenge.backend.nubank.shared.utils.mapper.ContactMapper;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contatos")
@RequiredArgsConstructor
public class ContactController {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    @ApiResponses(value = {
                   @ApiResponse(responseCode = "200", description = "Contato criado com sucesso"),
                   @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                   @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
                   @ApiResponse(responseCode = "404", description = "Contato não encontrado"),
                   @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping("/createContact")
    public ResponseEntity<ContactVO> createContact(@RequestBody @Valid ContactRequestDTO contactRequestDTO) {
        var contact = contactRepository.save(contactMapper.dtoToEntity(contactRequestDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(contactMapper.toVO(contact));
    }
}
