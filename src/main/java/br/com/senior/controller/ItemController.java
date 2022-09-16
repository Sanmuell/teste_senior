package br.com.senior.controller;

import java.util.List;
import java.util.Optional;


import javax.servlet.http.HttpServletResponse;

import br.com.senior.domain.exception.EntityNotFoundException;
import br.com.senior.domain.model.Order;
import br.com.senior.domain.repository.ItemRepository;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.senior.domain.service.ItemService;
import br.com.senior.domain.model.Item;
import br.com.senior.domain.model.dto.ItemDTO;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemRepository itemRepository;

	@GetMapping
	public List<Item> list() {
		return itemService.list();

	}

	@GetMapping("/por-descricao")
	public List<Item> findByDescription(@RequestParam("description") String description){
		return itemRepository.findByDescriptionContainingIgnoreCase(description);
	}


	@GetMapping("/{itemID}")
	public ResponseEntity<Item> readItem(@PathVariable Long itemID) {
		Optional<Item> item = this.itemService.read(itemID);
		return item.isPresent() ? ResponseEntity.ok(item.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping()
	public ResponseEntity<Item> create(@RequestBody ItemDTO itemDTO, HttpServletResponse response) {
		Item itemCreated = itemService.create(itemDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(itemCreated);

	}

	@PutMapping("/{itemID}")
	public ResponseEntity<Item> updateItem(@RequestBody ItemDTO itemDTO, @PathVariable Long itemID) {
		Optional<Item> itemRead = itemService.read(itemID);

		if (itemRead.isPresent()) {
			BeanUtils.copyProperties(itemDTO, itemRead.get());
			Item itemActual = itemService.update(itemRead.get(), itemDTO);
			return ResponseEntity.ok(itemActual);
		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{itemID}")
	public ResponseEntity<Item> deleteItem(@PathVariable Long itemID) {
		try {
			itemService.delete(itemID);
			return ResponseEntity.noContent().build();
		}catch (EntityNotFoundException e ){
			return ResponseEntity.notFound().build();
		}


	}

}
