package com.feirinhaoo.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.feirinhaoo.api.models.ItemsModel;
import com.feirinhaoo.api.repositories.ItemsRepository;

@Service
public class ItemsService {
    
    final ItemsRepository itemsRepository;

    ItemsService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<ItemsModel> getItems() {
        return itemsRepository.findAll();
    }


}
