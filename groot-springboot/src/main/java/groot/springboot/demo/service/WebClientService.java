package groot.springboot.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/9/27
 */
@Component
public class WebClientService {

/*    @Autowired
    private WebClient webClient;*/

    public Mono<String> post(String url, Object object) {
        /*return webClient.post().uri(url).contentType(MediaType.APPLICATION_JSON)
                .bodyValue(object)
                .exchangeToMono(response -> {
                    if (response.statusCode().equals(HttpStatus.OK)) {
                        return response.bodyToMono(String.class);
                    } else if (response.statusCode().is4xxClientError()) {
                        // Suppress error status code
                        return response.bodyToMono(String.class);
                    } else {
                        // Turn to error
                        return response.createException().flatMap(Mono::error);
                    }
                });*/
        return null;
    }

}
