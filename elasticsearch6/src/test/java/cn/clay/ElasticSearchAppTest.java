package cn.clay;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;

import java.io.IOException;

public class ElasticSearchAppTest {

//    @Test
//    public void tes1() throws IOException {
//        System.out.println("开始初始化客户端！");
//        try (RestHighLevelClient client = new RestHighLevelClient(
//                RestClient.builder(
//                        new HttpHost("192.168.96.86", 9204, "http"),
//                        new HttpHost("192.168.96.87", 9204, "http"),
//                        new HttpHost("192.168.96.88", 9204, "http")));
//        ) {
//            GetRequest request = new GetRequest("shakespeare", "doc", "1");
//            GetResponse getFields = client.get(request);
//            System.out.println(getFields);
//        }
//
//
//    }
}