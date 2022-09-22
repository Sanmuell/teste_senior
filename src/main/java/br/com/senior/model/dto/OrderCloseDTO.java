package br.com.senior.model.dto;


import antlr.collections.List;
import br.com.senior.model.OrderEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class OrderCloseDTO {

    public UUID id;
    public Integer number;
    @JsonFormat(pattern = "dd/MM/yyyy")
    public Date date;
    public Double percentualDiscount;
    public Double totalValue;




}
