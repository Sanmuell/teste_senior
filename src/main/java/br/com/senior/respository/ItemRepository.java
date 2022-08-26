package br.com.senior.respository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senior.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

}
