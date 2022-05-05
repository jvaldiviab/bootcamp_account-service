package com.project.accountservice.models.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CreditCardCreditCardResponse {
    private String id;
    private String creditCardNumber;
    private String status;
    private Double creditLine; // Monto max
    private Double availableAmount; // Monto available ############
}
