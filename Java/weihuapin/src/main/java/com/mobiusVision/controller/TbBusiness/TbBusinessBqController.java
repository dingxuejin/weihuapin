package com.mobiusVision.controller.TbBusiness;

import com.mobiusVision.pojo.TbBusiness.TbBusinessBq;
import com.mobiusVision.pojo.TbBusiness.TbBusinessBqTBR;
import com.mobiusVision.service.TbBusiness.TbBusinessBqService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:人员标签相关Controller
 * @Date:Created in 10:28 2018/6/20/020
 * @Modify By:
 **/
@Controller
public class TbBusinessBqController {

    private TbBusinessBqService tbBusinessBqService=new TbBusinessBqService();
    //通过driver_id和label_source查询tb_business_bq表中所有数据
    //label_source=null则返回系统评价，否则返回单人评价
    @RequestMapping("/TbBusinessBqByIAS")
    public @ResponseBody List<TbBusinessBq> findAllByDriverIdAndLabelSource(String driver_id, String label_source){
        if(driver_id==null)
            return null;

        List<TbBusinessBq> tbBusinessBqList=tbBusinessBqService.findAllByDriverIdAndLabelSource(driver_id,label_source);

        return tbBusinessBqList;
    }

    //通过driver_id和label_source=system和label_source与driver_id关联查询tb_business_bq表和tb_basic_ryjb表中最新数据（去重条件Label_source）
    @RequestMapping("/TbBusinessBqTBRByI")
    public @ResponseBody List<TbBusinessBqTBR> findAllByDriverIdAndNotSystemAndTBR(String driver_id){
        if(driver_id==null)
            return null;
        List<TbBusinessBqTBR> tbBusinessBqTBRList=tbBusinessBqService.findAllByDriverIdAndNotSystemAndTBR(driver_id);
        return  tbBusinessBqTBRList;
    }
}
