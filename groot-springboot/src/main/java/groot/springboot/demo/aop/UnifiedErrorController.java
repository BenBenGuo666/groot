package groot.springboot.demo.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/8/23
 */
@Slf4j
/*
@RestController*/
public class UnifiedErrorController implements ErrorController {
    MethodArgumentNotValidException e;
    private final static String ERROR_PATH = "/error";

    @ResponseBody
    @RequestMapping(path = ERROR_PATH)
    public R<?> error(HttpServletRequest request, HttpServletResponse response, Exception e) {
        log.info("访问/error" + "  错误代码：" + response.getStatus());
        try {
            OutputStream outputStream = response.getOutputStream();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return R.failed(response.getStatus());
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

}
