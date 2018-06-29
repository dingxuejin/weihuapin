package com.mobiusVision.service.TbBusiness;

import com.mobiusVision.dao.TbBusiness.TbBusinessBqMapper;
import com.mobiusVision.pojo.TbBusiness.TbBusinessBq;
import com.mobiusVision.pojo.TbBusiness.TbBusinessBqTBR;
import com.mobiusVision.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 10:05 2018/6/20/020
 * @Modify By:
 **/
public class TbBusinessBqService {

    //通过driver_id和label_source查询tb_business_bq表中所有数据
    public List<TbBusinessBq> findAllByDriverIdAndLabelSource(String driver_id,String label_source){

        //获取SpringBean
        ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
        TbBusinessBqMapper tbBusinessBqMapper =(TbBusinessBqMapper)aplc.getBean("tbBusinessBqMapper");
        List<TbBusinessBq> tbBusinessBqList=null;
        //若label_source为空，则默认为system（自身评价）
        if(label_source==null)
            tbBusinessBqList=tbBusinessBqMapper.findAllByDriverIdAndLabelSource(driver_id,"system");
        else
            tbBusinessBqList=tbBusinessBqMapper.findAllByDriverIdAndLabelSource(driver_id,label_source);
        //查看list是否满足8个
        if(tbBusinessBqList.size()>8)
            tbBusinessBqList=tbBusinessBqList.subList(0,7);
        return tbBusinessBqList;
    }

    //通过driver_id和label_source=system和label_source与driver_id关联查询tb_business_bq表和tb_basic_ryjb表中最新数据（去重条件Label_source）
    public List<TbBusinessBqTBR> findAllByDriverIdAndNotSystemAndTBR(String driver_id){
        //获取SpringBean
        ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
        TbBusinessBqMapper tbBusinessBqMapper =(TbBusinessBqMapper)aplc.getBean("tbBusinessBqMapper");
        List<TbBusinessBqTBR> tbBusinessBqTBRList=tbBusinessBqMapper.findAllByDriverIdAndNotSystemAndTBR(driver_id);
        //查看list是否满足8个
        if(tbBusinessBqTBRList.size()>8)
            tbBusinessBqTBRList=tbBusinessBqTBRList.subList(0,7);
        return tbBusinessBqTBRList;
    }
}
