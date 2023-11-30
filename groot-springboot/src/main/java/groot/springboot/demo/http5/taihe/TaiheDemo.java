package groot.springboot.demo.http5.taihe;

import groot.springboot.demo.http5.util.client.Http5Post;
import groot.springboot.demo.http5.util.client.Http5Util;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @author: GuoBen~
 * @date: 2023/7/10 14:02
 * @description:
 */
@Slf4j
public class TaiheDemo {

    private static final String DOMAIN = "https://dev-openapi.dmhmusic.com";

    private final static String Q_SOURCE = "rmpmkoxratqZj";

    private static final String PATH = "/OPENAPI/openApiLogin.json";

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*HttpRequest httpRequest = HttpRequest.post(DOMAIN + PATH);
        httpRequest.form("q_source", Q_SOURCE);
        log.info("httpRequest:{}", httpRequest);
        HttpResponse httpResponse = httpRequest.execute();
        log.info("httpResponse:{}", httpResponse);*/

        Map<String, String> formMap = new HashMap<>();
        formMap.put("q_source", Q_SOURCE);
        Http5Post http5Post = Http5Post.builder().uri(DOMAIN).path(PATH).formMap(formMap).build();
        Http5Util.postForm(http5Post);

    }

}
