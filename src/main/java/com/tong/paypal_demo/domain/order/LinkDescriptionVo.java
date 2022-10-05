package com.tong.paypal_demo.domain.order;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by tong on 2022/10/04
 */
@Data
@Accessors(chain = true)
public class LinkDescriptionVo {

    private String href; // 必传，完成后跳转的链接
    private String rel; // 必传，类型
    private String method; // 请求方法

}
