package com.tong.paypal_demo.domain.order.purchaseUnites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by tong on 2022/10/04
 */
@Data
@Accessors(chain = true)
public class AmountVo {

    @JsonProperty(value = "currency_code")
    private String currencyCode; // 货币编码（HKD、USD，参考：https://developer.paypal.com/api/rest/reference/currency-codes/）
    private String value; // 金额

}
