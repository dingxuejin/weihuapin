package com.mobiusVision.service.TbBasic;

import com.mobiusVision.dao.TbBasic.TbBasicQyXlxxMapper;
import com.mobiusVision.pojo.TbBasic.TbBasicQyXlxx;
import com.mobiusVision.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;

/**
 * @Author: zhangzhirong
 * @Description:线路信息相关
 * @Date:Created in 19:49 2018/6/29/029
 * @Modify By:
 **/
public class TbBasicQyXlxxService {

    //获取SpringBean
    ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
    TbBasicQyXlxxMapper tbBasicQyXlxxMapper =(TbBasicQyXlxxMapper)aplc.getBean("tbBasicQyXlxxMapper");

    //通过route_id查询线路名称
    public TbBasicQyXlxx findAllByRId(String route_id){
        TbBasicQyXlxx tbBasicQyXlxx=tbBasicQyXlxxMapper.findAllByRId(route_id);
        return tbBasicQyXlxx;
    }
}
