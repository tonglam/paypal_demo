package com.tong.paypal_demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tong.paypal_demo.domain.capturedPaymentDetails.SellerPayableBreakdownVo;
import com.tong.paypal_demo.domain.capturedPaymentDetails.SupplementaryDataVo;
import com.tong.paypal_demo.domain.order.LinkDescriptionVo;
import com.tong.paypal_demo.domain.order.purchaseUnites.AmountVo;
import com.tong.paypal_demo.domain.order.purchaseUnites.payments.captures.SellerProtectionVo;
import com.tong.paypal_demo.domain.order.purchaseUnites.payments.captures.StatusDetailsVo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by tong on 2022/10/05
 */
@Data
@Accessors(chain = true)
public class RefundCapturedPaymentOutVo {

    private String id;
    private AmountVo amount;
    @JsonProperty(value = "note_to_payer")
    private String noteToPayer;
    @JsonProperty(value = "final_capture")
    private boolean finalCapture;
    @JsonProperty(value = "seller_protection")
    private SellerProtectionVo sellerProtection;
    @JsonProperty(value = "seller_payable_breakdown")
    private SellerPayableBreakdownVo sellerPayableBreakdown;
    @JsonProperty(value = "invoice_id")
    private String invoiceId;
    private String status;
    @JsonProperty(value = "status_details")
    private StatusDetailsVo statusDetails;
    @JsonProperty(value = "supplementary_data")
    private SupplementaryDataVo supplementaryData;
    @JsonProperty(value = "create_time")
    private String createTime;
    @JsonProperty(value = "update_time")
    private String updateTime;
    private List<LinkDescriptionVo> links;

}
