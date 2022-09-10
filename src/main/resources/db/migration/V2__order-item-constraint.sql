  alter table if exists orders_items_tb 
       add constraint FK9
       foreign key (item_id) 
       references items_tb 
       on delete cascade;

    alter table if exists orders_items_tb 
       add constraint FKnqxoawcrm5rt8i7429379u50g 
       foreign key (order_id) 
       references orders_tb 
       on delete cascade;


