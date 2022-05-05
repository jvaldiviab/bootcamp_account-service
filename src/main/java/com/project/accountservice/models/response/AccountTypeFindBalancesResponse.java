package com.project.accountservice.models.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AccountTypeFindBalancesResponse {
    private String description;
    private String type;
}
