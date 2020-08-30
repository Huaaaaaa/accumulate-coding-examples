create table `order`
(
    id           bigint auto_increment comment '主键，自动增长'
        primary key,
    order_number varchar(20) null comment '订单号',
    user_name    varchar(20) null comment '购买用户名',
    price        decimal     null comment '订单价格',
    type         int         null comment '订单类型：1-新购；2-续费',
    create_time  timestamp   null comment '创建时间',
    update_time  timestamp   null comment '更新时间',
    order_status int         null comment '订单状态：1-未支付；2-成功；3-失败；4-取消；5-退款'
);

