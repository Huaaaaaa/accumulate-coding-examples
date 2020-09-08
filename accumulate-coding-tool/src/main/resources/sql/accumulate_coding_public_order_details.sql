create table order_details
(
    id           bigserial not null
        constraint order_details_pk
            primary key,
    order_number varchar,
    product_type integer,
    product_info json,
    time_unit    integer,
    time_span    integer,
    pay_time     bigint
);

comment on table order_details is '订单详情表';

comment on column order_details.order_number is '订单编号';

comment on column order_details.product_type is '商品类型：1-主机；2-硬盘；3-ip；4-数据库';

comment on column order_details.product_info is '商品信息';

comment on column order_details.time_unit is '购买时间单位：1-小时；2-天；3-月；4-年';

comment on column order_details.time_span is '购买时间';

comment on column order_details.pay_time is '支付时间';

alter table order_details
    owner to postgres;

