package com.tong.paypal_demo;

import com.google.common.collect.Lists;
import com.tong.paypal_demo.domain.*;
import com.tong.paypal_demo.domain.order.ApplicationContextVo;
import com.tong.paypal_demo.domain.order.purchaseUnites.AmountVo;
import com.tong.paypal_demo.domain.order.purchaseUnites.PurchaseUnitsVo;
import com.tong.paypal_demo.service.IPaypalService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tong on 2022/10/04
 */
public class PaypalTest extends PaypalDemoApplicationTests {

    @Autowired
    private IPaypalService paypalService;

    @Test
    void generateToken() {
        TokenOutVo data = this.paypalService.generateToken();
        System.out.println(1);
    }

    @Test
    void createOrder() {
        CreateOrderInVo createOrderInVo = new CreateOrderInVo().setIntent("CAPTURE");
        // purchase_units
        PurchaseUnitsVo purchaseUnitsVo = new PurchaseUnitsVo();
        AmountVo purchaseUnitsAmountVo = new AmountVo()
                .setCurrencyCode("HKD")
                .setValue("100");
        purchaseUnitsVo.setAmount(purchaseUnitsAmountVo);
        createOrderInVo.setPurchaseUnits(Lists.newArrayList(purchaseUnitsVo));
        // application_context
        ApplicationContextVo applicationContextVo = new ApplicationContextVo()
                .setCancelUrl("https://letletme.top")
                .setReturnUrl("https://letletme.top");
        createOrderInVo.setApplicationContext(applicationContextVo);
        OrderOutVo data = this.paypalService.createOrder(createOrderInVo);
        System.out.println(1);
    }

    @ParameterizedTest
    @CsvSource({"9BT06004JY949402X"})
    void showOrderDetails(String orderId) {
        OrderOutVo data = this.paypalService.showOrderDetails(orderId);
        System.out.println(1);
    }

    @ParameterizedTest
    @CsvSource({"9BT06004JY949402X"})
    void captureOrderPayment(String orderId) {
        OrderOutVo data = this.paypalService.captureOrderPayment(orderId);
        System.out.println(1);
    }

    @ParameterizedTest
    @CsvSource({"2LR539820N479433J"})
    void capturedPaymentDetails(String captureId) {
        CapturedPaymentDetailsOutVo data = this.paypalService.capturedPaymentDetails(captureId);
        System.out.println(1);
    }

    @ParameterizedTest
    @CsvSource({"2LR539820N479433J"})
    void refundCapturedPayment(String captureId) {
        AmountVo amountVo = new AmountVo()
                .setCurrencyCode("HKD")
                .setValue("100");
        RefundCapturedPaymentsInVo refundCapturedPaymentsInVo = new RefundCapturedPaymentsInVo()
                .setCaptureId(captureId)
                .setAmount(amountVo)
                .setReason("test refund");
        RefundCapturedPaymentOutVo data = this.paypalService.refundCapturedPayment(refundCapturedPaymentsInVo);
        System.out.println(1);
    }

    @ParameterizedTest
    @CsvSource({"70N23744R70619122"})
    void refundDetails(String refundId) {
        RefundCapturedPaymentOutVo data = this.paypalService.refundDetails(refundId);
        System.out.println(1);
    }

}
