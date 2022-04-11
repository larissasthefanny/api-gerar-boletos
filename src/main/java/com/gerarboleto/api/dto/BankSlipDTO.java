package com.gerarboleto.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gerarboleto.api.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankSlipDTO {

    private UUID id;

    @JsonProperty("due_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    @JsonProperty("total_in_cents")
    private BigDecimal totalInCents;

    @JsonProperty("customer")
    private String customer;

    @JsonProperty("status")
    private Status status;
}
