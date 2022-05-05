package com.project.accountservice.models.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AddressClientServiceResponse {
    private Integer number;
    private String street;
    private String city;
    private String country;
}