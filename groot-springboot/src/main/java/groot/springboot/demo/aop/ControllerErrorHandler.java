package groot.springboot.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/8/23
 */
@Slf4j
@ControllerAdvice
public class ControllerErrorHandler {

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R<?> MethodArgumentNotValidHandler(HttpServletRequest request,
                                              MethodArgumentNotValidException exception) {
        List<ObjectError> errors = exception.getBindingResult().getAllErrors();
        StringBuffer errorMsg = new StringBuffer();
        errors.stream().forEach(x -> errorMsg.append(x.getDefaultMessage()).append(";"));
        log.error("---MethodArgumentNotValidException Handler--- ERROR: {}", errorMsg.toString());
        return R.failed(errorMsg.toString());
    }

}
