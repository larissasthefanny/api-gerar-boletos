package com.gerarboleto.api.repository;

import com.gerarboleto.api.entity.BankSlipEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface BankSlipRepository extends CrudRepository<BankSlipEntity, UUID> {

    @Override
    Optional<BankSlipEntity> findById(UUID uuid);

    void deleteById(UUID id);
}
