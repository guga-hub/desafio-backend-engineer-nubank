package com.challenge.backend.nubank.application.dtos.contacts;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequestDTO {

    @Schema(example = "Lima Teste")
    private String name;

    @Schema(example = "limaEmailTeste@gmail.com")
    private String email;

    @Schema(example = "+5511999999999")
    private String phoneNumber;
}
