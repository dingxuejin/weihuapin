package com.mobiusVision.service.TbBusiness;

import com.mobiusVision.dao.TbBusiness.TbBusinessAqxwjfjjMapper;
import com.mobiusVision.pojo.TbBusiness.TbBusinessAqxwjfjjAndSw;
import com.mobiusVision.util.ApplicationContextUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:安全行为积分和奖金相关接口Service
 * @Date:Created in 13:36 2018/6/21/021
 * @Modify By:
 **/
public class TbBusinessAqxwjfjjService {

    //通过driver_id查询TB_BUSINESS_AQXWJFJJ aqxwjfjj,TB_DICTIONARY_SW sw表中所有违章数据
    public List<TbBusinessAqxwjfjjAndSw> findAllJfJjSwByDriverId(String driver_id){

        //获取SpringBean
        ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
        TbBusinessAqxwjfjjMapper tbBusinessAqxwjfjjMapper =(TbBusinessAqxwjfjjMapper)aplc.getBean("tbBusinessAqxwjfjjMapper");

        List<TbBusinessAqxwjfjjAndSw> tbBusinessAqxwjfjjAndSwList=tbBusinessAqxwjfjjMapper.findAllJfJjSwByDriverId(driver_id);

        return tbBusinessAqxwjfjjAndSwList;
    }
}
