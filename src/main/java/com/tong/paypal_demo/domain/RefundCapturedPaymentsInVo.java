package com.tong.paypal_demo.domain;

import com.tong.paypal_demo.domain.order.purchaseUnites.AmountVo;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by tong on 2022/10/05
 */
@Data
@Accessors(chain = true)
public class RefundCapturedPaymentsInVo {

    private String captureId;
    private AmountVo amount;
    private String reason;

}
