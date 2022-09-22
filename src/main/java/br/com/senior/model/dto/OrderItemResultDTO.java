package br.com.senior.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResultDTO {

    public UUID id;
    public UUID itemId;
    public Double quantity;
    public Double totalValue;
}
