package com.tong.paypal_demo.service.impl;

import com.google.common.collect.Maps;
import com.tong.paypal_demo.constant.Constant;
import com.tong.paypal_demo.domain.*;
import com.tong.paypal_demo.domain.refund.RefundCapturedPaymentsBodyVo;
import com.tong.paypal_demo.service.IPaypalService;
import com.tong.paypal_demo.utils.HttpUtils;
import com.tong.paypal_demo.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * Created by tong on 2022/10/04
 */
@Service
public class PaypalServiceImpl implements IPaypalService {

    @Override
    public TokenOutVo generateToken() {
        try {
            Map<String, String> map = Maps.newHashMap();
            map.put("grant_type", "client_credentials");
            map.put("ignoreCache", "true");
            map.put("return_authn_schemes", "true");
            map.put("return_client_metadata", "true");
            map.put("return_unconsented_scopes", "true");
            String result = HttpUtils.httpPostForm(Constant.GENERATE_TOKEN, map).orElse("");
            if (StringUtils.isBlank(result)) {
                return null;
            }
            return JsonUtils.json2obj(result, TokenOutVo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public OrderOutVo createOrder(CreateOrderInVo createOrderInVo) {
        try {
            String result = HttpUtils.httpPost(Constant.CREATE_ORDER, JsonUtils.obj2json(createOrderInVo)).orElse("");
            if (StringUtils.isBlank(result)) {
                return null;
            }
            return JsonUtils.json2obj(result, OrderOutVo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public OrderOutVo showOrderDetails(String orderId) {
        try {
            String result = HttpUtils.httpGet(String.format(Constant.SHOW_ORDER_DETAIL, orderId)).orElse("");
            if (StringUtils.isBlank(result)) {
                return null;
            }
            return JsonUtils.json2obj(result, OrderOutVo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public OrderOutVo captureOrderPayment(String orderId) {
        try {
            String result = HttpUtils.httpPost(String.format(Constant.CAPTURE_PAYMENT_FOR_ORDER, orderId), null).orElse("");
            if (StringUtils.isBlank(result)) {
                return null;
            }
            return JsonUtils.json2obj(result, OrderOutVo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CapturedPaymentDetailsOutVo capturedPaymentDetails(String captureId) {
        try {
            String result = HttpUtils.httpGet(String.format(Constant.SHOW_CAPTURED_PAYMENT_DETAILS, captureId)).orElse("");
            if (StringUtils.isBlank(result)) {
                return null;
            }
            return JsonUtils.json2obj(result, CapturedPaymentDetailsOutVo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public RefundCapturedPaymentOutVo refundCapturedPayment(RefundCapturedPaymentsInVo refundCapturedPaymentsInVo) {
        try {
            RefundCapturedPaymentsBodyVo body = new RefundCapturedPaymentsBodyVo()
                    .setAmount(refundCapturedPaymentsInVo.getAmount())
                    .setNoteToPayer(refundCapturedPaymentsInVo.getReason());
            String result = HttpUtils.httpPost(String.format(Constant.REFUND_CAPTURED_PAYMENT, refundCapturedPaymentsInVo.getCaptureId()), JsonUtils.obj2json(body)).orElse("");
            if (StringUtils.isBlank(result)) {
                return null;
            }
            return JsonUtils.json2obj(result, RefundCapturedPaymentOutVo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public RefundCapturedPaymentOutVo refundDetails(String refundId) {
        try {
            String result = HttpUtils.httpGet(String.format(Constant.SHOW_REFUND_DETAILS, refundId)).orElse("");
            if (StringUtils.isBlank(result)) {
                return null;
            }
            return JsonUtils.json2obj(result, RefundCapturedPaymentOutVo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public WebhookCreateOutVo createWebhook(WebhookCreateInVo webhookCreateInVo) {
        try {
            WebhookCreateInVo body = new WebhookCreateInVo()
                    .setUrl(webhookCreateInVo.getUrl())
                    .setEventTypes(webhookCreateInVo.getEventTypes());
            String result = HttpUtils.httpPost(Constant.CREATE_WEBHOOK, JsonUtils.obj2json(body)).orElse("");
            if (StringUtils.isBlank(result)) {
                return null;
            }
            return JsonUtils.json2obj(result, WebhookCreateOutVo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteWebhook(String webhookId) {
        try {
            HttpUtils.httpGet(String.format(Constant.DELETE_WEBHOOK, webhookId));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String verifyWebhookSignature(WebhookVerifyInVo verifyInVo) {
        try {
            WebhookVerifyInVo body = new WebhookVerifyInVo()
                    .setWebhookId(verifyInVo.getWebhookId())
                    .setTransmissionId(verifyInVo.getTransmissionId())
                    .setTransmissionTime(verifyInVo.getTransmissionTime())
                    .setCertUrl(verifyInVo.getCertUrl())
                    .setAuthAlgo(verifyInVo.getAuthAlgo())
                    .setTransmissionSig(verifyInVo.getTransmissionSig())
                    .setWebhookEvent(verifyInVo.getWebhookEvent());
            String result = HttpUtils.httpPost(Constant.VERIFY_WEBHOOK_SIGNATURE, JsonUtils.obj2json(body)).orElse("");
            if (StringUtils.isBlank(result)) {
                return null;
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
