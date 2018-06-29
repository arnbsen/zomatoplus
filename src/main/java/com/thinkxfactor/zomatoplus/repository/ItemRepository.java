package com.thinkxfactor.zomatoplus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkxfactor.zomatoplus.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	public Item findByRestaurantId(long id);
	public List<Item> findAllByRestaurantId(long id);
	public Item findByNameAndRestaurantId(String s, long l);
	public Item findByIdAndRestaurantId(long id, long res);
	public Item findById(long l);
	public List<Item> findAllByName(String n);
}
