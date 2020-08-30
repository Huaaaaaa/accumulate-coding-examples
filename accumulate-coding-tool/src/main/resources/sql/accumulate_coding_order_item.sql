create table order_item
(
    id             bigint auto_increment
        primary key,
    order_number   varchar(20)   null comment '订单号',
    product_type   int           null comment '商品类型：1-主机；2-硬盘；3-ip；4-rds',
    product_detail varchar(1000) null comment '商品详情',
    time_unit      int           null comment '购买时长：1-小时；2-天；3-月；4-年',
    time_span      int           null comment '时长',
    pay_time       timestamp     null comment '支付时间'
)
    comment '订单详情表';

