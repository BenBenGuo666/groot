package groot.springboot.demo.t;

import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;

import java.net.HttpCookie;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: GuoBen~
 * @date: 2023/4/18 09:20
 * @description:
 */
public class Client {

    public static void main(String[] args) {

        String domain = "https://dev-openapi.dmhmusic.com/";
        String path = "OPENAPI/openApiLogin.json";
        Map<String, String > map = new HashMap<>();
        map.put("q_source","bJsAgfkBmMWfq");
        map.put("zone","CN");
        path += "?q_source=bJsAgfkBmMWfq&zone=CN";
        HttpRequest httpRequest = HttpRequest.get(domain + path);
        httpRequest.contentType(ContentType.FORM_URLENCODED.getValue());
        httpRequest.header("q_source", "bJsAgfkBmMWfq");
        httpRequest.header("zone", "CN");
        httpRequest.header(Header.CONTENT_TYPE, ContentType.FORM_URLENCODED.getValue());
//        httpRequest.body(JSONUtil.toJsonStr(map));
        HttpCookie[] hc = new HttpCookie[2];
        HttpCookie httpCookie = new HttpCookie("q_source","bJsAgfkBmMWfq");
        HttpCookie httpCookie2 = new HttpCookie("zone","CN");
        hc[0] = httpCookie;
        hc[1] = httpCookie2;
        httpRequest.cookie(hc);
        System.out.println(httpRequest);
        System.out.println(httpRequest.execute());
    }

}
