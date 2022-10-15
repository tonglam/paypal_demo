package com.tong.paypal_demo.domain.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tong.paypal_demo.domain.capturedPaymentDetails.SupplementaryDataVo;
import com.tong.paypal_demo.domain.order.LinkDescriptionVo;
import com.tong.paypal_demo.domain.order.purchaseUnites.AmountVo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Create by tong on 2022/10/14
 */
@Data
@Accessors(chain = true)
public class ResourceVo {

    @JsonProperty(value = "disbursement_mode")
    private String disbursementMode;
    private AmountVo amount;
    @JsonProperty(value = "seller_protection")
    private SellerProtectionVo sellerProtection;
    @JsonProperty(value = "supplementary_data")
    private SupplementaryDataVo supplementaryData;
    @JsonProperty(value = "update_time")
    private String updateTime;
    @JsonProperty(value = "create_time")
    private String createTime;
    @JsonProperty(value = "final_capture")
    private boolean finalCapture;
    @JsonProperty(value = "seller_receivable_breakdown")
    private SellerReceivableBreakdownVo sellerReceivableBreakdown;
    @JsonProperty(value = "invoice_id")
    private String invoiceId;
    private List<LinkDescriptionVo> links;
    private String id;
    private String status;

}
