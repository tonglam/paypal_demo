package com.tong.paypal_demo.domain.webhook;

import com.tong.paypal_demo.domain.order.purchaseUnites.AmountVo;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Create by tong on 2022/10/14
 */
@Data
@Accessors(chain = true)
public class PlatformFeesVo {

    private AmountVo amount;
    private PayeeVo payee;

}
