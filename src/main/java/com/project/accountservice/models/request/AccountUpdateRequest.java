package com.project.accountservice.models.request;

import com.project.accountservice.models.dto.PersonInfo;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AccountUpdateRequest {
    private String id;
    private String status;
    private Date updateDate;
    private Double currentBalance;
    private Integer freeTransactionPerMonth;
    private ArrayList<PersonInfo> holders;
    private ArrayList<PersonInfo> signers;
}
