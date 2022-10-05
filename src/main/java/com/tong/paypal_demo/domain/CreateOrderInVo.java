package com.tong.paypal_demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tong.paypal_demo.domain.order.ApplicationContextVo;
import com.tong.paypal_demo.domain.order.purchaseUnites.PurchaseUnitsVo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by tong on 2022/10/04
 */
@Data
@Accessors(chain = true)
public class CreateOrderInVo {

    private String intent; // 必传，两种取值:CAPTURE,实时收款;AUTHORIZE，3天到29天后收款
    @JsonProperty(value = "purchase_units")
    private List<PurchaseUnitsVo> purchaseUnits; // 必传，付款人向收款人购买的订单内容
    @JsonProperty(value = "application_context")
    private ApplicationContextVo applicationContext; // paypal付款过程的定制内容

}
