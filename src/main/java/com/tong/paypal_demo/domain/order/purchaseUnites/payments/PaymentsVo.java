package com.tong.paypal_demo.domain.order.purchaseUnites.payments;

import com.tong.paypal_demo.domain.order.purchaseUnites.payments.captures.CapturesVo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by tong on 2022/10/05
 */
@Data
@Accessors(chain = true)
public class PaymentsVo {

    private List<CapturesVo> captures;

}
