package com.project.accountservice.utilities.util.impl;

import com.project.accountservice.models.dto.ClientType;
import com.project.accountservice.models.response.ClientTypeClientServiceResponse;
import com.project.accountservice.utilities.util.IClientTypeUtils;
import org.springframework.stereotype.Component;

@Component
public class ClientTypeUtilsImpl implements IClientTypeUtils {
    @Override
    public ClientTypeClientServiceResponse clientTypeToClientTypeClientServiceResponseDTO(ClientType clientType) {
        return ClientTypeClientServiceResponse.builder()
                .description(clientType.getDescription())
                .type(clientType.getType())
                .build();
    }

    @Override
    public ClientType clientTypeClientServiceResponseDTOToClientType(ClientTypeClientServiceResponse clientTypeDTO) {
        return ClientType.builder()
                .description(clientTypeDTO.getDescription())
                .type(clientTypeDTO.getType())
                .build();
    }
}