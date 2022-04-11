package com.gerarboleto.api.controller;

import com.gerarboleto.api.dto.BankSlipDTO;
import com.gerarboleto.api.entity.BankSlipEntity;
import com.gerarboleto.api.service.BankSlipService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/bankslips")
public class BankSlip {
    private final BankSlipService bankSlipService;

    @GetMapping
    public ResponseEntity<Iterable<BankSlipEntity>> getBankSlips(){
        return new ResponseEntity(bankSlipService.getBankSlips(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getBankSlipById(@PathVariable UUID id){
        BankSlipDTO bankSlipDTO = bankSlipService.getBankSlipById(id);
        return ResponseEntity.ok(bankSlipDTO);
    }

    @PostMapping
    public ResponseEntity postBankSlip(@RequestBody BankSlipDTO bankSlipDTO){
        bankSlipService.postBankSlip(bankSlipDTO);
        return ResponseEntity.created(URI.create("/bankslips/" + bankSlipDTO.getId())).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity cancelBankSlip(@PathVariable UUID id){
        bankSlipService.cancelBankSlip(id);
        return ResponseEntity.ok().build();
    }
}
