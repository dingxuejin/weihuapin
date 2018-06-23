package com.mobiusVision.controller.TbBusiness;

import com.mobiusVision.pojo.TbBusiness.TbBusinessTj;
import com.mobiusVision.service.TbBusiness.TbBusinessTjService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 15:16 2018/6/19/019
 * @Modify By:
 **/
@Controller
public class TbBusinessTjController {

    //通过driver_id查询tb_business_tj表中一条最新数据（最新健康信息）
    @RequestMapping("/TbBusinessTjByDriverId")
    public @ResponseBody TbBusinessTj findOneByDriverId(String driver_id){
        if(driver_id==null){
            return null;
        }
        TbBusinessTjService tbBusinessTjService=new TbBusinessTjService();

        List<TbBusinessTj> tbBusinessTjList=tbBusinessTjService.findOneByDriverId(driver_id);
        return tbBusinessTjList.get(0);
    }
}
