package groot.springboot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import groot.springboot.demo.aop.R;
import groot.springboot.demo.bean.Goods;
import groot.springboot.demo.bean.InfoCheckVo;
import groot.springboot.demo.service.WebClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author guoga
 * @version 11:54 2020/5/12
 */
@RestController
@RequestMapping("/demo2")
public class Demo2Controller {

    @Autowired
    private WebClientService webClientService;

    private final static Logger logger = LoggerFactory.getLogger(Demo2Controller.class);

    @PostMapping("/infoCheck")
    public R book() {
        String url = "http://127.0.0.1:8081/qw/api/zdgs/infoCheck";
        InfoCheckVo infoCheckVo = new InfoCheckVo();
        Goods goods = new Goods();
        goods.setExt_item_id("skuId");
        goods.setProduct_num(Long.valueOf(1));
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(goods);
        infoCheckVo.setItem_list(goodsList);
        infoCheckVo.setOrder_type(3);
        infoCheckVo.setMerchant_code("供货商编码");
        Mono<String> mono = webClientService.post(url, infoCheckVo);

        System.out.println(mono.block());
        System.out.println(JSONObject.toJSONString(mono));
        R result = JSONObject.parseObject(mono.block(), R.class);
        System.out.println(result.getData());
        if (result.getData() instanceof Map) {
            Map<String, Map<String, String>> map = (Map<String, Map<String, String>>) result.getData();
            System.out.println(map);
            Map<String, String> content = map.get("CONTENT");
            System.out.println(content);
            System.out.println(content.get("ORDER_STATUS"));
        }
        return result;
    }

}
