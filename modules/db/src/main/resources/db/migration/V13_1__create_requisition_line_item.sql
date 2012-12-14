drop table if exists requisition_line_item;
create table requisition_line_item (
id serial primary key,
rnr_id int not null references requisition(id),
product_code varchar(50) not null references product(code),
product varchar(250),
beginning_balance integer,
quantity_received integer,
quantity_dispensed integer,
estimated_consumption integer,
stock_in_hand integer,
quantity_requested integer,
reason_for_requested_quantity text,
calculated_order_quantity integer,
quantity_approved integer,
losses_and_adjustments integer,
reason_for_losses_and_adjustments text,
new_patient_count integer,
stock_out_days integer,
normalized_consumption integer,
amc numeric(8,4),
max_stock_quantity integer,
packs_to_ship integer,
cost numeric(8, 4),
remarks text,
modified_by varchar(50),
modified_date timestamp  DEFAULT  CURRENT_TIMESTAMP
);