package com.feirinhaoo.api.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feirinhaoo.api.dtos.ItemsDTO;
import com.feirinhaoo.api.models.ItemsModel;
import com.feirinhaoo.api.services.ItemsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/items")
public class ItemsController {

    private final ItemsService itemsService;

    ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping()
    public ResponseEntity<Object> getItems() {
        return ResponseEntity.status(HttpStatus.OK).body(itemsService.getItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getItemsById(@PathVariable("id") Long id) {
        Optional<ItemsModel> items = itemsService.getItemsById(id);

        if (!items.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este item não existe para este id");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(items.get());
        }
    }

    @PostMapping()
    public ResponseEntity<Object> createContacts(@RequestBody @Valid ItemsDTO body) {
        ItemsModel items = itemsService.createItems(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(items);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateItems(@PathVariable Long id, @RequestBody @Valid ItemsDTO body) {
        Optional<ItemsModel> items = itemsService.updateItems(id, body);
        
        if(!items.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(items.get());
        
    }


}
