package com.mobiusVision.test;

import com.mobiusVision.service.TbBasic.TbBasicCljcxxService;
import org.junit.Test;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 17:08 2018/6/14/014
 * @Modify By:
 **/
public class TbBasicCljcxxServiceTest {

    @Test
    public void testFindTbBasicCljcxxByPlateNumber() {
        TbBasicCljcxxService tbs=new TbBasicCljcxxService();
        tbs.findTbBasicCljcxxOthersByPlateNumber("1");
    }
}