package com.accumulate.coding.tool.enums;

/**
 * @ClassName ProductType
 * @Description
 * @Date 2020/8/18  11:57
 */
public enum ProductTypeEnum {

    PRODUCT_TYPE_VM(1, "云主机", "vm"),
    PRODUCT_TYPE_DISK(2, "云硬盘", "disk"),
    PRODUCT_TYPE_IP(3, "云IP", "ip");

    private int productCode;

    private String productName;

    private String serviceCode;

    ProductTypeEnum() {
    }

    ProductTypeEnum(int productCode, String productName, String serviceCode) {
        this.productCode = productCode;
        this.productName = productName;
        this.serviceCode = serviceCode;
    }}
