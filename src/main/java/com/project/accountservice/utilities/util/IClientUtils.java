package com.project.accountservice.utilities.util;

import com.project.accountservice.models.dto.Client;
import com.project.accountservice.models.response.ClientClientServiceResponse;

public interface IClientUtils {

    Client clientClientServiceToClient(ClientClientServiceResponse customerDTO);
    ClientClientServiceResponse customerToCustomerCustomerServiceResponseDTO(Client customer);
}
