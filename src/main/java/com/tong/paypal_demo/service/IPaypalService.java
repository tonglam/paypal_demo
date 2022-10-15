package com.tong.paypal_demo.service;

import com.tong.paypal_demo.domain.*;

/**
 * Created by tong on 2022/10/04
 */
public interface IPaypalService {

    TokenOutVo generateToken();

    OrderOutVo createOrder(CreateOrderInVo createOrderInVo);

    OrderOutVo showOrderDetails(String orderId);

    OrderOutVo captureOrderPayment(String orderId);

    CapturedPaymentDetailsOutVo capturedPaymentDetails(String captureId);

    RefundCapturedPaymentOutVo refundCapturedPayment(RefundCapturedPaymentsInVo refundCapturedPaymentsInVo);

    RefundCapturedPaymentOutVo refundDetails(String refundId);

    WebhookCreateOutVo createWebhook(WebhookCreateInVo webhookCreateInVo);

    void deleteWebhook(String webhookId);

    String verifyWebhookSignature(WebhookVerifyInVo verifyInVo);

}
