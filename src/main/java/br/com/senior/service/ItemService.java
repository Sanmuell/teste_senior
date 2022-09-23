package br.com.senior.service;

import br.com.senior.exception.EntityNotFoundException;
import br.com.senior.model.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import javax.transaction.Transactional;

import br.com.senior.model.dto.ItemDTO;
import br.com.senior.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Transactional
	public List<ItemEntity> list() {
		return itemRepository.findAll();


	}

	@Transactional
	public Optional<ItemEntity> read(UUID id) {
		return itemRepository.findById(id);
	}

	@Transactional
	public ItemEntity create(ItemDTO itemDTO) {

		ItemEntity itemEntity = new ItemEntity();
		itemEntity.setDescription(itemDTO.getDescription());
		itemEntity.setType(itemDTO.getType());
		itemEntity.setValue(itemDTO.getValue());
		return itemRepository.save(itemEntity);
	}

	@Transactional
	public ItemEntity update(ItemEntity itemEntity, ItemDTO itemDTO) {

		itemEntity.setDescription(itemDTO.getDescription());
		itemEntity.setType(itemDTO.getType());
		itemEntity.setValue(itemDTO.getValue());

		return itemRepository.save(itemEntity);
	}

	@Transactional
	public void delete(UUID itemID) {
		try {
			itemRepository.deleteById(itemID);
		}catch (EmptyResultDataAccessException e){
			throw new EntityNotFoundException(
					String.format("Não existe cadastro de Item com o código %d", itemID));

	}}

}
