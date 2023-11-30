package groot.springboot.demo.http5.util.client;

import lombok.Builder;
import lombok.Getter;
import org.apache.hc.core5.http.Header;

import java.util.Map;

/**
 * @author: GuoBen~
 * @date: 2023/7/10 14:55
 * @description:
 */
@Getter
@Builder
public class Http5Get {

    /**
     * 请求 uri
     */
    private String uri;

    /**
     * 请求 path
     */
    private String path;

    /**
     * 请求 header
     */
    private Header header;

    /**
     * 请求 form
     */
    private Map<String, String> formMap;

}
