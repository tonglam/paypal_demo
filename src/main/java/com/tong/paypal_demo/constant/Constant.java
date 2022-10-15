package com.tong.paypal_demo.constant;

/**
 * Created by tong on 2022/09/28
 */
public class Constant {

    // date_format
    public static final String DATETIME = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE = "yyyy-MM-dd";
    public static final String SHORTDAY = "yyyyMMdd";

    public static final String BASE_URL = "https://api-m.sandbox.paypal.com";
    public static final String CLIENT_ID = "Ab3877wQxdfvQfcNkftVa0uTyO-fT9N7lg26tqVrEB6EVP-e-zPYmUf_QzwFI7zYRp5WzlrNsznL8Ee0";
    public static final String CLIENT_SECRET = "EHWltPguzlxvGbQEvvCYmChT6ZbWSSIPODC_6Xr6GeA0kYDRQj8aWuh9Rw5W0OxrkVrN54tAnu7X_mpl";

    public static final String GENERATE_TOKEN = BASE_URL + "/v1/oauth2/token";
    public static final String CREATE_ORDER = BASE_URL + "/v2/checkout/orders";
    public static final String SHOW_ORDER_DETAIL = BASE_URL + "/v2/checkout/orders/%s";
    public static final String CAPTURE_PAYMENT_FOR_ORDER = BASE_URL + "/v2/checkout/orders/%s/capture";
    public static final String SHOW_CAPTURED_PAYMENT_DETAILS = BASE_URL + "/v2/payments/captures/%s";
    public static final String REFUND_CAPTURED_PAYMENT = BASE_URL + "/v2/payments/captures/%s/refund";
    public static final String SHOW_REFUND_DETAILS = BASE_URL + "/v2/payments/refunds/%s";
    public static final String CREATE_WEBHOOK = BASE_URL + "/v1/notifications/webhooks";
    public static final String DELETE_WEBHOOK = BASE_URL + "/v1/notifications/webhooks/%s";
    public static final String VERIFY_WEBHOOK_SIGNATURE = BASE_URL + "/v1/notifications/verify-webhook-signature";

}