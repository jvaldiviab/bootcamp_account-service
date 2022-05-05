package com.project.accountservice.utilities.util.impl;

import com.project.accountservice.models.dto.Client;
import com.project.accountservice.models.dto.PersonInfo;
import com.project.accountservice.models.response.ClientClientServiceResponse;
import com.project.accountservice.utilities.util.IClientTypeUtils;
import com.project.accountservice.utilities.util.IClientUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ClientUtilsImpl implements IClientUtils {
    private final IClientTypeUtils clientTypeUtils;

    @Override
    public Client clientClientServiceToClient(ClientClientServiceResponse client) {
        return Client.builder()
                .id(client.getId())
                .clientType(clientTypeUtils.clientTypeClientServiceResponseDTOToClientType(client.getClientType()))
                .personInfo(PersonInfo.builder()
                        .name(client.getPersonInfo().getName())
                        .lastname(client.getPersonInfo().getLastname())
                        .documentNumber(client.getPersonInfo().getDocumentNumber())
                        .mobileNumber(client.getPersonInfo().getMobileNumber())
                        .email(client.getPersonInfo().getEmail())
                        .build())
                .status(client.getStatus())
                .build();
    }

    @Override
    public ClientClientServiceResponse customerToCustomerCustomerServiceResponseDTO(Client customer) {
        return ClientClientServiceResponse.builder()
                .id(customer.getId())
                .clientType(clientTypeUtils.clientTypeToClientTypeClientServiceResponseDTO(customer.getClientType()))
                .status(customer.getStatus())
                .build();
    }
}