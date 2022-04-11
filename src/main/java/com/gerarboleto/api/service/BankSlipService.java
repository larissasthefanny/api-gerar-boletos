package com.gerarboleto.api.service;

import com.gerarboleto.api.dto.BankSlipDTO;
import com.gerarboleto.api.enums.Status;
import com.gerarboleto.api.dto.mapper.BankSlipMapper;
import com.gerarboleto.api.entity.BankSlipEntity;
import com.gerarboleto.api.repository.BankSlipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class BankSlipService {
    private final BankSlipRepository repository;
    private final BankSlipMapper mapper;

    public Iterable<BankSlipEntity> getBankSlips(){
        Iterable<BankSlipEntity> bankSlipEntity = repository.findAll();
        return bankSlipEntity;
    }

    public BankSlipDTO getBankSlipById(UUID id){
        Optional<BankSlipEntity> bankSlipEntity = repository.findById(id);
        BankSlipDTO bankSlipDTO = new BankSlipDTO();
        if(bankSlipEntity.isPresent()){
            bankSlipDTO = mapper.toBankSlipDTO(bankSlipEntity.get());
        }
        return bankSlipDTO;
    }

    public void postBankSlip(BankSlipDTO bankSlipDTO){
        BankSlipEntity bankSlipEntity = mapper.toBankSlipEntity(bankSlipDTO);
        bankSlipEntity.setStatus(Status.PENDING);
        repository.save(bankSlipEntity);
    }

    public void cancelBankSlip(UUID id){
        repository.deleteById(id);
    }
}
