package com.tong.paypal_demo.domain.order.purchaseUnites.shipping;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by tong on 2022/10/05
 */
@Data
@Accessors(chain = true)
public class ShippingVo {

    private NameVo name;
    private AddressVo address;

}
