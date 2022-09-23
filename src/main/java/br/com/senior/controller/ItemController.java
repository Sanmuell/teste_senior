package br.com.senior.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import javax.servlet.http.HttpServletResponse;

import br.com.senior.exception.EntityNotFoundException;
import br.com.senior.repository.ItemRepository;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.senior.service.ItemService;
import br.com.senior.model.ItemEntity;
import br.com.senior.model.dto.ItemDTO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemRepository itemRepository;

	@GetMapping
	public ResponseEntity<List<ItemEntity>> list() {
		List<ItemEntity> listItems =  itemService.list();
		if (listItems.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			for (ItemEntity item : listItems) {
				UUID id = item.getItemId();
				item.add(linkTo(methodOn(ItemController.class).readItem(item.getItemId())).withSelfRel());
			}
		}
		return new ResponseEntity<List<ItemEntity>>(listItems, HttpStatus.OK);

	}

	@GetMapping("/por-descricao")
	public List<ItemEntity> findByDescription(@RequestParam("description") String description){
		return itemRepository.findByDescriptionContainingIgnoreCase(description);
	}


	@GetMapping("/{itemID}")
	public ResponseEntity<ItemEntity> readItem(@PathVariable UUID itemID) {
		Optional<ItemEntity> item = this.itemService.read(itemID);
	 	if (!item.isPresent()){
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			 item.get().add(linkTo(methodOn(ItemController.class).list()).withRel("Lista de Items"));
			return new ResponseEntity<ItemEntity>(item.get(), HttpStatus.OK);
		}

	}

	@PostMapping()
	public ResponseEntity<ItemEntity> create(@RequestBody ItemDTO itemDTO, HttpServletResponse response) {
		ItemEntity itemEntityCreated = itemService.create(itemDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(itemEntityCreated);

	}

	@PutMapping("/{itemID}")
	public ResponseEntity<ItemEntity> updateItem(@RequestBody ItemDTO itemDTO, @PathVariable UUID itemID) {
		Optional<ItemEntity> itemRead = itemService.read(itemID);

		if (itemRead.isPresent()) {
			BeanUtils.copyProperties(itemDTO, itemRead.get());
			ItemEntity itemEntityActual = itemService.update(itemRead.get(), itemDTO);
			return ResponseEntity.ok(itemEntityActual);
		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{itemID}")
	public ResponseEntity<ItemEntity> deleteItem(@PathVariable UUID itemID) {
		try {
			itemService.delete(itemID);
			return ResponseEntity.noContent().build();
		}catch (EntityNotFoundException e ){
			return ResponseEntity.notFound().build();
		}


	}

}
