package com.challenge.backend.nubank.domain.vos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientVO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String cpf;
    private LocalDateTime audCreateDate;
    private LocalDateTime audUpdateDate;
}
