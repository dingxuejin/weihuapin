package com.mobiusVision.service;

import com.mobiusVision.pojo.TbBusiness.TbBusinessTj;
import com.mobiusVision.service.TbBusiness.TbBusinessTjService;
import org.junit.Test;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 17:44 2018/6/19/019
 * @Modify By:
 **/
public class TbBusinessTjServiceTest {

    @Test
    public void findOneByDriverId() {
        TbBusinessTjService tbBusinessTjService=new TbBusinessTjService();

        List<TbBusinessTj> tbBusinessTjList=tbBusinessTjService.findOneByDriverId("201408000001");

        System.out.println(tbBusinessTjList.get(0).toString());
    }
}