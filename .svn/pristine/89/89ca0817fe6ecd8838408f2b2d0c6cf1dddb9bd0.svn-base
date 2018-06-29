package com.mobiusVision.service.TbBusiness;

import com.mobiusVision.dao.TbBusiness.TbBusinessYzsgMapper;
import com.mobiusVision.pojo.TbBusiness.TbBusinessYzsgNDjZrXl;
import com.mobiusVision.util.ApplicationContextUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:事故相关接口Service
 * @Date:Created in 10:09 2018/6/21/021
 * @Modify By:
 **/
public class TbBusinessYzsgService {

    //通过driver_id查询tb_business_yzsg yzsg,tb_dictionary_sgdj sgdj,tb_dictionary_sgzr sgzr,tb_dictionary_sfxl sfxl,tb_basic_ryjb ryjb表中所有数据数据(查询一个人的事故按最新时间排列)
    public List<TbBusinessYzsgNDjZrXl> findSgxqByDriverId(String driver_id){

        //获取SpringBean
        ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
        TbBusinessYzsgMapper tbBusinessYzsgMapper =(TbBusinessYzsgMapper)aplc.getBean("tbBusinessYzsgMapper");

        List<TbBusinessYzsgNDjZrXl> tbBusinessYzsgNDjZrXlList=tbBusinessYzsgMapper.findSgxqByDriverId(driver_id);
        return tbBusinessYzsgNDjZrXlList;
    }

    //通过entity_id查询tb_business_yzsg yzsg,tb_dictionary_sgdj sgdj,tb_dictionary_sgzr sgzr,tb_dictionary_sfxl sfxl,tb_basic_ryjb ryjb表中所有数据数据(查询一个人的事故按最新时间排列)
    public List<TbBusinessYzsgNDjZrXl> findSgxqByEntityId(String entity_id){

        //获取SpringBean
        ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
        TbBusinessYzsgMapper tbBusinessYzsgMapper =(TbBusinessYzsgMapper)aplc.getBean("tbBusinessYzsgMapper");

        List<TbBusinessYzsgNDjZrXl> tbBusinessYzsgNDjZrXlList=tbBusinessYzsgMapper.findSgxqByEntityId(entity_id);
        return tbBusinessYzsgNDjZrXlList;
    }
}
