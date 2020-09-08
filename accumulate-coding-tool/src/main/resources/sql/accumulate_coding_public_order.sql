create table "order"
(
    id            bigserial not null
        constraint order_pk
            primary key,
    order_number  varchar,
    order_type    integer,
    price         numeric,
    order_status  integer,
    purchase_user varchar,
    create_time   bigint,
    update_time   bigint
);

comment on table "order" is '订单表';

comment on column "order".order_number is '订单编号';

comment on column "order".order_type is '订单类型：1-新购；2-续费';

comment on column "order".price is '订单价格';

comment on column "order".order_status is '订单状态：1-未支付；2-成功；3-失败；4-取消；5-退款';

comment on column "order".purchase_user is '购买人';

comment on column "order".create_time is '创建时间';

comment on column "order".update_time is '更新时间';

alter table "order"
    owner to postgres;

create unique index order_order_number_uindex
    on "order" (order_number);

