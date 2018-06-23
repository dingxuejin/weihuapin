package com.mobiusVision.service.TbBusiness;

import com.mobiusVision.dao.TbBusiness.TbBusinessTjMapper;
import com.mobiusVision.pojo.TbBusiness.TbBusinessTj;
import com.mobiusVision.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:查询驾驶员健康信息
 * @Date:Created in 15:13 2018/6/19/019
 * @Modify By:
 **/
public class TbBusinessTjService {

    //通过driver_id查询tb_business_tj表中一条最新数据（最新健康信息）
    public List<TbBusinessTj> findOneByDriverId(String driver_id){

        //获取SpringBean
        ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
        TbBusinessTjMapper tbBusinessTjMapper =(TbBusinessTjMapper)aplc.getBean("tbBusinessTjMapper");

        List<TbBusinessTj> tbBusinessTjList=tbBusinessTjMapper.findOneByDriverId(driver_id);
        return tbBusinessTjList;
    }
}
