package br.com.senior.controller;

import java.util.List;
import java.util.Optional;


import javax.servlet.http.HttpServletResponse;

import br.com.senior.exception.EntityNotFoundException;
import br.com.senior.repository.ItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.senior.service.ItemService;
import br.com.senior.model.ItemEntity;
import br.com.senior.model.dto.ItemDTO;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemRepository itemRepository;

	@GetMapping
	public List<ItemEntity> list() {
		return itemService.list();

	}

	@GetMapping("/por-descricao")
	public List<ItemEntity> findByDescription(@RequestParam("description") String description){
		return itemRepository.findByDescriptionContainingIgnoreCase(description);
	}


	@GetMapping("/{itemID}")
	public ResponseEntity<ItemEntity> readItem(@PathVariable Long itemID) {
		Optional<ItemEntity> item = this.itemService.read(itemID);
		return item.isPresent() ? ResponseEntity.ok(item.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping()
	public ResponseEntity<ItemEntity> create(@RequestBody ItemDTO itemDTO, HttpServletResponse response) {
		ItemEntity itemEntityCreated = itemService.create(itemDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(itemEntityCreated);

	}

	@PutMapping("/{itemID}")
	public ResponseEntity<ItemEntity> updateItem(@RequestBody ItemDTO itemDTO, @PathVariable Long itemID) {
		Optional<ItemEntity> itemRead = itemService.read(itemID);

		if (itemRead.isPresent()) {
			BeanUtils.copyProperties(itemDTO, itemRead.get());
			ItemEntity itemEntityActual = itemService.update(itemRead.get(), itemDTO);
			return ResponseEntity.ok(itemEntityActual);
		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{itemID}")
	public ResponseEntity<ItemEntity> deleteItem(@PathVariable Long itemID) {
		try {
			itemService.delete(itemID);
			return ResponseEntity.noContent().build();
		}catch (EntityNotFoundException e ){
			return ResponseEntity.notFound().build();
		}


	}

}
