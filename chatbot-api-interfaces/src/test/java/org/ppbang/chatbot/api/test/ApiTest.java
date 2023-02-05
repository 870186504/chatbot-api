package org.ppbang.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * 单元测试
 */
public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        //groupId：28885855552551
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885855552551/topics?scope=unanswered_questions&count=20");

        get.setHeader("cookie", "zsxq_access_token=3E882423-78A9-9E64-3991-9102BC8B9B0A_D493C3B91AAF0386; zsxqsessionid=b078fc24d9df6c02431eeb8f78cad8d1; abtest_env=product; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22841542812544852%22%2C%22first_id%22%3A%221861fda3e9552a-071948b0fcd6ea-16525635-1930176-1861fda3e961578%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2MWZkYTNlOTU1MmEtMDcxOTQ4YjBmY2Q2ZWEtMTY1MjU2MzUtMTkzMDE3Ni0xODYxZmRhM2U5NjE1NzgiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI4NDE1NDI4MTI1NDQ4NTIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22841542812544852%22%7D%2C%22%24device_id%22%3A%221861fda3e9552a-071948b0fcd6ea-16525635-1930176-1861fda3e961578%22%7D; UM_distinctid=186201c6694e4f-079f3b4d74934c-16525635-1d73c0-186201c66951413");
        get.setHeader("Context-type", "application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //181551548485422：topicId
//        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/814884821455582/answer");
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/814884821455582/answer");
        post.setHeader("Cookie", "zsxq_access_token=3E882423-78A9-9E64-3991-9102BC8B9B0A_D493C3B91AAF0386; zsxqsessionid=b078fc24d9df6c02431eeb8f78cad8d1; abtest_env=product; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22841542812544852%22%2C%22first_id%22%3A%221861fda3e9552a-071948b0fcd6ea-16525635-1930176-1861fda3e961578%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2MWZkYTNlOTU1MmEtMDcxOTQ4YjBmY2Q2ZWEtMTY1MjU2MzUtMTkzMDE3Ni0xODYxZmRhM2U5NjE1NzgiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI4NDE1NDI4MTI1NDQ4NTIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22841542812544852%22%7D%2C%22%24device_id%22%3A%221861fda3e9552a-071948b0fcd6ea-16525635-1930176-1861fda3e961578%22%7D; UM_distinctid=186201c6694e4f-079f3b4d74934c-16525635-1d73c0-186201c66951413");
        post.setHeader("Context-type", "application/json;charset=utf8");


        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"PHP世界最好的语言（🐶）！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
