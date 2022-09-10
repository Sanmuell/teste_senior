//package br.com.senior.test;
//
//import java.util.Arrays;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//
//import br.com.senior.model.Item;
//import br.com.senior.model.Order;
//import br.com.senior.model.OrderItem;
//import br.com.senior.respository.ItemRepository;
//import br.com.senior.respository.OrderItemRepository;
//import br.com.senior.respository.OrderRepository;
//
//@Configuration
//public class TestConfig implements CommandLineRunner {
//
//	@Autowired
//	private ItemRepository itemRepository;
//
//	@Autowired
//	private OrderRepository orderRepository;
//
//	@Autowired
//	private OrderItemRepository orderItemRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//
//		Item item1 = new Item();
//		item1.setDescription("Descrição teste");
//		item1.setValue(43.5435);
//		item1.setType('R');
//
//		Item item2 = new Item();
//		item2.setDescription("Descrição teste 2");
//		item2.setValue(43.5435);
//		item2.setType('S');
//
//		Item item3 = new Item();
//		item3.setDescription("Descrição teste 3");
//		item3.setValue(43.5435);
//		item3.setType('S');
//
//		Order order1 = new Order();
//		order1.setNumber(1);
//		order1.setPercentualDiscount(2.0);
//		order1.setTotalValue(10.000);
//
//		Order order2 = new Order();
//		order2.setNumber(2);
//		order2.setPercentualDiscount(4.0);
//		order2.setTotalValue(4.000);
//
//		Order order3 = new Order();
//		order3.setNumber(1);
//		order3.setPercentualDiscount(2.0);
//		order3.setTotalValue(1.000);
//
//		itemRepository.saveAll(Arrays.asList(item1, item2, item3));
//		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
//
//		OrderItem orderItem1 = new OrderItem();
//		orderItem1.setItemId(item3);
//		orderItem1.setOrderId(order1);
//		orderItem1.setQuantity(200.00);
//		orderItem1.setTotalValue(90.000);
//
//		OrderItem orderItem2 = new OrderItem();
//		orderItem2.setItemId(item1);
//		orderItem2.setOrderId(order1);
//		orderItem2.setQuantity(500.00);
//		orderItem2.setTotalValue(80.000);
//
//		OrderItem orderItem3 = new OrderItem();
//		orderItem3.setItemId(item2);
//		orderItem3.setOrderId(order3);
//		orderItem3.setQuantity(10.00);
//		orderItem3.setTotalValue(5.000);
//
//		orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3));
//
//
//
//	}}
//
//
