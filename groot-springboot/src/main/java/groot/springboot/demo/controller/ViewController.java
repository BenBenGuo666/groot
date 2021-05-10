package groot.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/4/22
 */
@Controller
@RequestMapping(value = "/view")
public class ViewController {

    @RequestMapping("/goUpload")
    public ModelAndView goUpload() {
        return new ModelAndView("upload_picture.html");
    }

}
