package com.projetoAgasalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoAgasalho.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
