package groot.springboot.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import groot.springboot.demo.bean.Demo;
import groot.springboot.demo.bean.UploadFile;
import groot.springboot.demo.bean.UploadFileExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UploadFileMapper extends BaseMapper<UploadFile> {
    long countByExample(UploadFileExample example);

    int deleteByExample(UploadFileExample example);

    int deleteByPrimaryKey(Integer fileId);

    int insert(UploadFile record);

    int insertSelective(UploadFile record);

    List<UploadFile> selectByExample(UploadFileExample example);

    UploadFile selectByPrimaryKey(Integer fileId);

    int updateByExampleSelective(@Param("record") UploadFile record, @Param("example") UploadFileExample example);

    int updateByExample(@Param("record") UploadFile record, @Param("example") UploadFileExample example);

    int updateByPrimaryKeySelective(UploadFile record);

    int updateByPrimaryKey(UploadFile record);
}