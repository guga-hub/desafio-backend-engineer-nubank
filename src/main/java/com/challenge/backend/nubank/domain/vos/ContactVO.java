package com.challenge.backend.nubank.domain.vos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactVO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
}
