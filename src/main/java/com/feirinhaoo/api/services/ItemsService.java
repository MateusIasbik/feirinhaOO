package com.feirinhaoo.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.feirinhaoo.api.dtos.ItemsDTO;
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

    public Optional<ItemsModel> getItemsById(Long id) {
        Optional<ItemsModel> items = itemsRepository.findById(id);
        
        if (!items.isPresent()) {
            return Optional.empty();
        } else {
            return items;
        }
    }

    public ItemsModel createItems(ItemsDTO body) {
        ItemsModel items = new ItemsModel(body);
        itemsRepository.save(items);
        return items;
    }

    public Optional<ItemsModel> updateItems(Long id, ItemsDTO body) {
        Optional<ItemsModel> items = itemsRepository.findById(id);
        
        if(!items.isPresent()) {
            return Optional.empty();
        }

        ItemsModel newItems = new ItemsModel(body);
        newItems.setId(id);
        itemsRepository.save(newItems);
        return Optional.of(newItems);
    }


}
