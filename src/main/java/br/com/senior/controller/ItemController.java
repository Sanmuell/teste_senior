package br.com.senior.controller;

import java.util.List;
import java.util.Optional;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.domain.service.ItemService;
import br.com.senior.model.Item;
import br.com.senior.model.dto.ItemDTO;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping
	public List<Item> list() {
		return itemService.list();

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
	public Item updateItem(@RequestBody ItemDTO itemDTO, @PathVariable Long itemID) {
		Item itemRead = itemService.read(itemID).orElseThrow(IllegalArgumentException::new);
		return itemService.update(itemRead, itemDTO);

	}

	@DeleteMapping("/{itemID}")
	public void deleteItem(@PathVariable Long itemID) {
		itemService.delete(itemID);

	}

}
