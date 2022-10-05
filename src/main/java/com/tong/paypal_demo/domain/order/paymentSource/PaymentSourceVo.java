package com.tong.paypal_demo.domain.order.paymentSource;

import com.tong.paypal_demo.domain.order.paymentSource.payapl.PaypalVo;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by tong on 2022/10/05
 */
@Data
@Accessors(chain = true)
public class PaymentSourceVo {

    private PaypalVo paypal;

}
