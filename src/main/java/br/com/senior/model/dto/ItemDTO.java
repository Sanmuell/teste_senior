package br.com.senior.model.dto;

import br.com.senior.model.enums.ItemTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ItemDTO {

	private String description;
	private Double value;
	private ItemTypeEnum type;


}
