package com.tong.paypal_demo.domain.order.purchaseUnites;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tong.paypal_demo.domain.order.purchaseUnites.payments.PaymentsVo;
import com.tong.paypal_demo.domain.order.purchaseUnites.shipping.ShippingVo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by tong on 2022/10/04
 */
@Data
@Accessors(chain = true)
public class PurchaseUnitsVo {

    @JsonProperty(value = "reference_id")
    private String referenceId; // 发起API调用后，提供方给的ID
    private AmountVo amount; // 必填，支付的总金额，breakDown里面填写详细内容
    private List<ItemVo> items; // 客户购买的详情
    private PayeeVo payee; // 商户信息
    private ShippingVo shipping;
    private PaymentsVo payments;

}
