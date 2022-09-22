


package br.com.senior.test;

import java.util.Arrays;

import br.com.senior.model.ItemEntity;
import br.com.senior.model.OrderEntity;
import br.com.senior.model.OrderItemEntity;
import br.com.senior.model.enums.ItemTypeEnum;
import br.com.senior.repository.ItemRepository;
import br.com.senior.repository.OrderItemRepository;
import br.com.senior.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {

        ItemEntity item1 = new ItemEntity();
		item1.setDescription("Descrição teste");
		item1.setValue(43.5435);
		item1.setType(ItemTypeEnum.P);

        ItemEntity item2 = new ItemEntity();
		item2.setDescription("Descrição teste 2");
		item2.setValue(4.500);
		item2.setType(ItemTypeEnum.S);

        ItemEntity item3 = new ItemEntity();
		item3.setDescription("Descrição teste 3");
		item3.setValue(3.200);
		item3.setType(ItemTypeEnum.S);


		OrderEntity order1 = new OrderEntity();
		order1.setNumber(1);
		order1.setPercentualDiscount(2.0);
		order1.setTotalValue(10.000);

        OrderEntity order2 = new OrderEntity();
		order2.setNumber(2);
		order2.setPercentualDiscount(4.0);
		order2.setTotalValue(4.000);

        OrderEntity order3 = new OrderEntity();
		order3.setNumber(1);
		order3.setPercentualDiscount(2.0);
		order3.setTotalValue(1.000);

		itemRepository.saveAll(Arrays.asList(item1, item2, item3));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));

		OrderItemEntity orderItem1 = new OrderItemEntity();
		orderItem1.setItemEntityId(item3);
		orderItem1.setOrderEntityId(order1);
		orderItem1.setQuantity(200.00);
		orderItem1.setTotalValue(90.000);

        OrderItemEntity orderItem2 = new OrderItemEntity();
		orderItem2.setItemEntityId(item1);
		orderItem2.setOrderEntityId(order1);
		orderItem2.setQuantity(500.00);
		orderItem2.setTotalValue(80.000);

        OrderItemEntity orderItem3 = new OrderItemEntity();
		orderItem3.setItemEntityId(item2);
		orderItem3.setOrderEntityId(order3);
		orderItem3.setQuantity(10.00);
		orderItem3.setTotalValue(5.000);

		orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3));



	}}


