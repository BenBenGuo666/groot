package groot.springboot.demo.http5.util.reactor;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.Header;

/**
 * @author: GuoBen~
 * @date: 2023/6/30 09:57
 * @description:
 */
@Getter
@Setter
@Builder
public class HttpPost {

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
     * 请求 body
     */
    private String body;

    /**
     * 请求 contentType
     */
    private ContentType contentType;

}
