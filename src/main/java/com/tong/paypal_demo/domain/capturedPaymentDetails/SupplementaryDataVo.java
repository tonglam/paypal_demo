package com.tong.paypal_demo.domain.capturedPaymentDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by tong on 2022/10/05
 */
@Data
@Accessors(chain = true)
public class SupplementaryDataVo {

    @JsonProperty(value = "related_ids")
    private RelatedIdsVo relatedIds;

}
