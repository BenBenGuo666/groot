package groot.springboot.demo.service;

import groot.springboot.demo.bean.Demo;
import groot.springboot.demo.bean.DemoExample;
import groot.springboot.demo.dao.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author guoga
 * @version 11:48 2020/5/12
 */
@Service
public class DemoService
{

    @Autowired
    private DemoMapper demoMapper;

    public Demo getDemoById(Integer id)
    {
        return Optional.ofNullable(demoMapper.selectByPrimaryKey(id)).orElse(null);
    }

    public List<Demo> getList()
    {
        return demoMapper.selectByExample(new DemoExample());
    }

}
