package com.project.accountservice.utilities.util;

import com.project.accountservice.models.dto.ClientType;
import com.project.accountservice.models.response.ClientTypeClientServiceResponse;

public interface IClientTypeUtils {

    ClientTypeClientServiceResponse clientTypeToClientTypeClientServiceResponseDTO(ClientType customerType);
    ClientType clientTypeClientServiceResponseDTOToClientType(ClientTypeClientServiceResponse customerTypeDTO);
}
