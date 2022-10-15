package com.tong.paypal_demo.utils;

import com.tong.paypal_demo.constant.Constant;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.Base64Utils;

import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Create by tong on 2018/2/8
 */
public class HttpUtils {

    private static final CookieStore cookieStore = new BasicCookieStore();
    private static final PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
    private static final CloseableHttpClient httpclient = createHttpClient();

    private static CloseableHttpClient createHttpClient() {
        cm.setMaxTotal(10);
        cm.setDefaultMaxPerRoute(10);
        return HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .setConnectionManager(cm)
                .setConnectionManagerShared(true)
                .build();
    }

    public static Optional<String> httpGet(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + Base64Utils.encodeToString(StringUtils.joinWith(":", Constant.CLIENT_ID, Constant.CLIENT_SECRET).getBytes()));
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            if (String.valueOf(response.getStatusLine().getStatusCode()).startsWith("20")) {
                String result = EntityUtils.toString(response.getEntity(), "UTF-8");
                return Optional.of(result);
            }
        } catch (Exception e) {
            throw new ExportException(e.getMessage());
        } finally {
            httpclient.close();
        }
        return Optional.empty();
    }

    public static Optional<String> httpPost(String url, String content) throws IOException {
        HttpClientContext httpClientContext = HttpClientContext.create();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + Base64Utils.encodeToString(StringUtils.joinWith(":", Constant.CLIENT_ID, Constant.CLIENT_SECRET).getBytes()));
        if (StringUtils.isNotBlank(content)) {
            StringEntity stringEntity = new StringEntity(content);
            stringEntity.setContentEncoding("UTF-8");
            httpPost.setEntity(stringEntity);
        }
        httpPost.setHeader("Content-Type", "application/json");
        try (CloseableHttpResponse response = httpclient.execute(httpPost, httpClientContext)) {
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            return Optional.of(result);
        } catch (Exception e) {
            throw new ExportException(e.getMessage());
        } finally {
            httpclient.close();
        }
    }

    public static Optional<String> httpPostForm(String url, Map<String, String> map) throws IOException {
        HttpClientContext httpClientContext = HttpClientContext.create();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + Base64Utils.encodeToString(StringUtils.joinWith(":", Constant.CLIENT_ID, Constant.CLIENT_SECRET).getBytes()));
        List<NameValuePair> parameters = new ArrayList<>(0);
        for (String key :
                map.keySet()) {
            parameters.add(new BasicNameValuePair(key, map.get(key)));
        }
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
        httpPost.setEntity(formEntity);
        try (CloseableHttpResponse response = httpclient.execute(httpPost, httpClientContext)) {
            if (String.valueOf(response.getStatusLine().getStatusCode()).startsWith("20")) {
                String result = EntityUtils.toString(response.getEntity(), "UTF-8");
                return Optional.of(result);
            }
        } catch (Exception e) {
            throw new ExportException(e.getMessage());
        } finally {
            httpclient.close();
        }
        return Optional.empty();
    }

}
