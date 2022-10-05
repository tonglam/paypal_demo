package com.tong.paypal_demo.domain.order.purchaseUnites.payments.captures;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tong.paypal_demo.domain.order.LinkDescriptionVo;
import com.tong.paypal_demo.domain.order.purchaseUnites.AmountVo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by tong on 2022/10/05
 */
@Data
@Accessors(chain = true)
public class CapturesVo {

    private String id;
    private String status;
    @JsonProperty(value = "status_details")
    private StatusDetailsVo statusDetails;
    private AmountVo amount;
    @JsonProperty(value = "final_capture")
    private boolean finalCapture;
    @JsonProperty(value = "seller_protection")
    private SellerProtectionVo sellerProtection;
    private List<LinkDescriptionVo> links;
    @JsonProperty(value = "create_time")
    private String createTime;
    @JsonProperty(value = "update_time")
    private String updateTime;

}
