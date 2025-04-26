package com.teknologiinformasi.restapi.item.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teknologiinformasi.restapi.item.model.Item;
import com.teknologiinformasi.restapi.item.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item itemDetails) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item tidak ditemukan dengan id " + id));
        item.setNama(itemDetails.getNama());
        item.setDeskrispi(itemDetails.getDeskripsi());
        item.setHarga(itemDetails.getHarga());
        item.setStok(itemDetails.getStok());
        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item tidak ditemukan dengan id " + id));
        itemRepository.delete(item);
    }
}