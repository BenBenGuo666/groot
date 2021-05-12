package groot.springboot.demo.service;

import groot.springboot.demo.bean.UploadFile;
import groot.springboot.demo.bean.UploadFileExample;
import groot.springboot.demo.dao.UploadFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/5/12
 */
@Service
public class UploadFileService {

    @Autowired
    private UploadFileMapper uploadFileMapper;

    public List<UploadFile> getList() {
        return uploadFileMapper.selectByExample(new UploadFileExample());
    }


}
