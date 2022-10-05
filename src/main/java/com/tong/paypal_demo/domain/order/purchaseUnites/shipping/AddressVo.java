package com.tong.paypal_demo.domain.order.purchaseUnites.shipping;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by tong on 2022/10/05
 */
@Data
@Accessors(chain = true)
public class AddressVo {

    @JsonProperty(value = "address_line_1")
    private String addressLine1;
    @JsonProperty(value = "admin_area_2")
    private String adminArea2;
    @JsonProperty(value = "admin_area_1")
    private String adminArea1;
    @JsonProperty(value = "postal_code")
    private String postalCode;
    @JsonProperty(value = "country_code")
    private String countryCode;

}
