package com.tong.paypal_demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tong.paypal_demo.domain.order.LinkDescriptionVo;
import com.tong.paypal_demo.domain.order.PayerVo;
import com.tong.paypal_demo.domain.order.paymentSource.PaymentSourceVo;
import com.tong.paypal_demo.domain.order.purchaseUnites.PurchaseUnitsVo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by tong on 2022/10/04
 */
@Data
@Accessors(chain = true)
public class OrderOutVo {

    private String id; // 订单ID
    private String intent; // 两种取值:CAPTURE,实时收款;AUTHORIZE，3天到29天后收款
    private String status; // CREATED：创建；SAVED：保存；APPROVED：客户授权；VOIDED：无效；COMPLETED：完成；PAYER_ACTION_REQUIRED：等待支付完成
    @JsonProperty(value = "create_time")
    private String createTime; // 交易创建时间
    @JsonProperty(value = "update_time")
    private String updateTime; // 交易更新时间
    @JsonProperty(value = "payment_source")
    private PaymentSourceVo paymentSource; // 付款来源信息
    @JsonProperty(value = "purchase_units")
    private List<PurchaseUnitsVo> purchaseUnits; // 付款人向收款人购买的订单内容
    private PayerVo payer; // 付款人信息
    private List<LinkDescriptionVo> links; // 跳转链接

}
