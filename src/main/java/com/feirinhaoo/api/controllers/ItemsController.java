package com.feirinhaoo.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feirinhaoo.api.services.ItemsService;

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

}
