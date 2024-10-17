package com.example.reactive_webflux_demo.controller;


import com.example.reactive_webflux_demo.model.Item;
import com.example.reactive_webflux_demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/items")   //GET http://localhost:8080/api/items
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public Flux<Item> getAllItems() {
        return itemRepository.findAll();
    }
    //GET http://localhost:8080/api/items/{id}
    @GetMapping("/{id}")
    public Mono<Item> getItemById(@PathVariable String id) {
        return itemRepository.findById(id);
    }
    //http://localhost:8080/api/items
    @PostMapping
    public Mono<Item> createItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }
    //DELETE http://localhost:8080/api/items/{id}
    @DeleteMapping("/{id}")
    public Mono<Void> deleteItem(@PathVariable String id) {
        return itemRepository.deleteById(id);
    }
}
