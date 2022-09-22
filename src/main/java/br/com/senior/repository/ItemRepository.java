package br.com.senior.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senior.model.ItemEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {


    List<ItemEntity> findByDescriptionContainingIgnoreCase (String description);

}
