package groot.springboot.demo.controller;

import groot.springboot.demo.LogicResult;
import groot.springboot.demo.bean.Book;
import groot.springboot.demo.bean.Demo;
import groot.springboot.demo.service.DemoService;
import groot.springboot.demo.service.DemoServicePlus;
import groot.springboot.demo.service.TestService;
import groot.springboot.demo.utils.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * @author guoga
 * @version 11:54 2020/5/12
 */
@RestController// @RestponseBody 和 @Controller 的组合
@RequestMapping("/demo")
public class DemoController {

    private final static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Value("${book.name}")
    private String bookname;

    @Autowired
    private DemoService demoService;

    @Autowired
    private DemoServicePlus demoServicePlus;

    @Autowired
    private TestService testService;

    //@Valid
    @PostMapping("/book")
    public Book book(@RequestBody Book book) {
        logger.info("hello---------------------->id:" + book);
//        Assert.isTrue(StringUtils.isNotEmpty(book.getName()), "名称为空！");
        return book;
    }

    @GetMapping("/hello/{id}")
    public String hello(@PathVariable(value = "id") Integer id) {
        logger.info("hello---------------------->id:" + id);
        return Optional.ofNullable(demoService.getDemoById(id)).map(Demo::toString).orElse("Empty String");
    }

    @GetMapping("/helloPlus/{id}")
    public String helloPlus(@PathVariable(value = "id") Integer id) {
        logger.info("helloPlus---------------------->id:" + id);
        return Optional.ofNullable(demoServicePlus.getDemoById(id)).map(Demo::toString).orElse("Empty String");
    }

    @GetMapping("/getBookname")
    public String getBookname() {
        return bookname;

    }

    @PostMapping("/getBookname_1")
    public Book getBookname_1() {
        Book book = new Book();
        book.setName(bookname);
        return book;
    }

    @GetMapping("/test")
    public String test() {
        return testService.test();
    }


    @PostMapping("/uploadPic")
    public LogicResult uploadPic(@RequestParam(value = "pic", required = false) MultipartFile pic) throws IOException {
        File picFile = new File("D:\\pic\\" + pic.getOriginalFilename());
//        EncrypRSA e;
        byte[] picData = pic.getBytes();
        FileUtils.writeLocalFile(picFile, picData);
        return LogicResult.builder().build();
    }

    @GetMapping("/getPic")
    public void getPic() {
        String filePath = "";
    }

}
