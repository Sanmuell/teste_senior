package br.com.senior.respository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senior.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
