package com.project.accountservice.models.request;


import com.project.accountservice.models.dto.AccountSpecifications;
import com.project.accountservice.models.dto.AccountType;
import com.project.accountservice.models.dto.PersonInfo;
import lombok.*;

import java.util.ArrayList;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AccountCreateRequest {
    private String clientId;
    private AccountType accountType;
    private AccountSpecifications accountSpecifications;
    private ArrayList<PersonInfo> holders;
    private ArrayList<PersonInfo> signers;
}
