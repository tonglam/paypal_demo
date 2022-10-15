package com.tong.paypal_demo;

import com.google.common.collect.Lists;
import com.tong.paypal_demo.domain.*;
import com.tong.paypal_demo.domain.order.ApplicationContextVo;
import com.tong.paypal_demo.domain.order.LinkDescriptionVo;
import com.tong.paypal_demo.domain.order.purchaseUnites.AmountVo;
import com.tong.paypal_demo.domain.order.purchaseUnites.PurchaseUnitsVo;
import com.tong.paypal_demo.domain.webhook.EventTypeVo;
import com.tong.paypal_demo.domain.webhook.ResourceVo;
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

    @Test
    void createWebhook() {
        EventTypeVo eventType = new EventTypeVo().setName("PAYMENT.CAPTURE.COMPLETED");
        WebhookCreateInVo webhookCreateInVo = new WebhookCreateInVo()
                .setUrl("https://letletme.top/api/common/paypalListener")
                .setEventTypes(Lists.newArrayList(eventType));
        WebhookCreateOutVo webhookCreateOutVo = this.paypalService.createWebhook(webhookCreateInVo);
        System.out.println(1);
    }

    @ParameterizedTest
    @CsvSource("4XL97046GJ395401P")
    void deleteWebhook(String webhookId) {
        this.paypalService.deleteWebhook(webhookId);
        System.out.println(1);
    }

    @ParameterizedTest
    @CsvSource("4XL97046GJ395401P")
    void verityWebhookSignature(String webhookId) {
        AmountVo amountVo = new AmountVo()
                .setValue("0.99")
                .setCurrencyCode("USD");
        LinkDescriptionVo linkDescriptionVo1 = new LinkDescriptionVo()
                .setHref("https://api.paypal.com/v2/payments/refunds/1Y107995YT783435V")
                .setRel("self")
                .setMethod("GET");
        LinkDescriptionVo linkDescriptionVo2 = new LinkDescriptionVo()
                .setHref("https://api.paypal.com/v2/payments/captures/0JF852973C016714D")
                .setRel("up")
                .setMethod("GET");
        ResourceVo resourceVo = new ResourceVo()
                .setDisbursementMode(null)
                .setAmount(amountVo)
                .setSellerProtection(null)
                .setSupplementaryData(null)
                .setUpdateTime("2018-08-15T12:13:29-07:00")
                .setCreateTime("2018-08-15T12:13:29-07:00")
                .setFinalCapture(false)
                .setSellerReceivableBreakdown(null)
                .setInvoiceId(null)
                .setLinks(Lists.newArrayList(linkDescriptionVo1, linkDescriptionVo2))
                .setId("1Y107995YT783435V")
                .setStatus("COMPLETED");
        LinkDescriptionVo linkDescriptionVo3 = new LinkDescriptionVo()
                .setHref("https://api.paypal.com/v1/notifications/webhooks-events/WH-1GE84257G0350133W-6RW800890C634293G")
                .setRel("self")
                .setMethod("GET");
        LinkDescriptionVo linkDescriptionVo4 = new LinkDescriptionVo()
                .setHref("https://api.paypal.com/v1/notifications/webhooks-events/WH-1GE84257G0350133W-6RW800890C634293G/resend")
                .setRel("send")
                .setMethod("POST");
        WebhookEventDataVo webhookEventDataVo = new WebhookEventDataVo()
                .setId("WH-1GE84257G0350133W-6RW800890C634293G")
                .setCreateTime("2018-08-15T19:14:04.543Z")
                .setResourceType("refund")
                .setEventType("PAYMENT.CAPTURE.REFUNDED")
                .setSummary("A $ 0.99 USD capture payment was refunded")
                .setResource(resourceVo)
                .setStatus(null)
                .setTransmissions(null)
                .setLinks(Lists.newArrayList(linkDescriptionVo3, linkDescriptionVo4))
                .setEventVersion("1.0")
                .setResourceVersion("2.0");
        WebhookVerifyInVo verifyInVo = new WebhookVerifyInVo()
                .setWebhookId(webhookId)
                .setTransmissionId("e1e91240-4c56-11ed-a27f-c1a6f3376134")
                .setTransmissionTime("2022-10-15T06:59:15Z")
                .setTransmissionSig("mAYJ4n5r9tbC9TWlpXIxs8IMKlckQG08aWALFsdOnOSrv+dDvEZ7XiVTyPKUIzW1hVJVV52VBSQaUSNmwrjXG4C+k/CEEfcOL90Hs3Z9F/xKtA9SiBo7QH/XZ2W5L46BoLDXdNyL/mmRP6myZGC8WMZk6e4xxTTDnB9h9DulwWrel9iSlKTfIz2cEljhvr7NPqZ7j0gG7rqr0NCw01NSUAMQEGfwb+4Q2by+XMhEyx7FEgItCjgnJiOKTmLlYwsYsg7TbWTE4TShCVzOWIm/ZEV+zUgjzGlvpfXQ1BanKBFtEPEzo8OodYa3LioXxwi6ujEpEz0Gqy/3dFKPsnfmtQ==")
                .setCertUrl("https://api.paypal.com/v1/notifications/certs/CERT-360caa42-fca2a594-38317689")
                .setAuthAlgo("SHA256withRSA")
                .setWebhookEvent(webhookEventDataVo);
        String result = this.paypalService.verifyWebhookSignature(verifyInVo);
        System.out.println(1);
    }

}
