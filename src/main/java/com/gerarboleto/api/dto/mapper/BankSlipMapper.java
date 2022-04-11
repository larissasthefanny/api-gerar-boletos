package com.gerarboleto.api.dto.mapper;

import com.gerarboleto.api.dto.BankSlipDTO;
import com.gerarboleto.api.entity.BankSlipEntity;

public interface BankSlipMapper {

    BankSlipDTO toBankSlipDTO(BankSlipEntity bankSlipEntity);
    BankSlipEntity toBankSlipEntity(BankSlipDTO bankSlipDTO);

}
