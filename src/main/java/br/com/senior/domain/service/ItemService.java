package br.com.senior.domain.service;

import br.com.senior.domain.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


import javax.transaction.Transactional;

import br.com.senior.domain.model.Item;
import br.com.senior.domain.model.dto.ItemDTO;
import br.com.senior.domain.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Transactional
	public List<Item> list() {
		return itemRepository.findAll();

	}

	@Transactional
	public Optional<Item> read(Long id) {
		return itemRepository.findById(id);
	}

	@Transactional
	public Item create(ItemDTO itemDTO) {

		Item item = new Item();
		item.setDescription(itemDTO.getDescription());
		item.setType(itemDTO.getType());
		item.setValue(itemDTO.getValue());
		return itemRepository.save(item);
	}

	@Transactional
	public Item update(Item item, ItemDTO itemDTO) {

		item.setDescription(itemDTO.getDescription());
		item.setType(itemDTO.getType());
		item.setValue(itemDTO.getValue());

		return itemRepository.save(item);
	}

	@Transactional
	public void delete(Long itemID) {
		try {
			itemRepository.deleteById(itemID);
		}catch (EmptyResultDataAccessException e){
			throw new EntityNotFoundException(
					String.format("Não existe cadastro de Item com o código %d", itemID));

	}}

}
