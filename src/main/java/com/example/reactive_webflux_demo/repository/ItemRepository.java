package com.example.reactive_webflux_demo.repository;

import com.example.reactive_webflux_demo.model.Item;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ItemRepository extends ReactiveCrudRepository<Item,String>
{
}