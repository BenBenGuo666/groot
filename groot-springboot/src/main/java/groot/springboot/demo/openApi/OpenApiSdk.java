package groot.springboot.demo.openApi;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import groot.springboot.demo.openApi.model.CompletionsHo;
import groot.springboot.demo.utils.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: e-Benben.Guo
 * @date: 2023/2/10 11:15
 * @description:
 */
public class OpenApiSdk {

    public static final String APIKey = "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";

    public static final String organizationId = "org-JYyk1MRHNc9u1qLo9q4hJ8vR";

    public static final String domain = "https://api.openai.com";


    public static void setHttpHeader(HttpRequest httpRequest) {
        httpRequest.header(Header.AUTHORIZATION.getValue(), "Bearer " + APIKey);
        httpRequest.header("OpenAI-Organization", "org-JYyk1MRHNc9u1qLo9q4hJ8vR");
    }

    public static String completions(String prompt) {
        String path = "/v1/completions";
        HttpRequest postRequest = HttpRequest.post(domain + path);
        CompletionsHo completionsHo = CompletionsHo.builder()
                .model(Properties.model)
                .prompt(prompt)
                .temperature(Properties.temperature)
                .max_tokens(Properties.max_tokens)
                .top_p(Properties.top_p)
                .frequency_penalty(Properties.frequency_penalty)
                .presence_penalty(Properties.presence_penalty)
                .build();
        setHttpHeader(postRequest);
        postRequest.body(JsonUtils.toGson(completionsHo));
        HttpResponse httpResponse = postRequest.execute();
        System.out.println(httpResponse);
        System.out.println(httpResponse.body());
        return httpResponse.body();
    }

    public static void main(String[] args) {
        String prompt = "I want to prototype a product based on a requirement.";
        String body = OpenApiSdk.completions(prompt);
        Map<String, Object> map = JsonUtils.gsonToObj(body, HashMap.class);
        System.out.println(map);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(prompt);
        ArrayList<Map> list = (ArrayList) map.get("choices");
        System.out.println(list.get(0).get("text"));
    }

}
