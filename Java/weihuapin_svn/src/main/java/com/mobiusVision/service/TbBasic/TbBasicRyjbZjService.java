package com.mobiusVision.service.TbBasic;

import com.mobiusVision.dao.TbBasic.TbBasicRyjbZjMapper;
import com.mobiusVision.pojo.TbBasic.TbBasicRyjbBasicZj;
import com.mobiusVision.pojo.TbBasic.TbBasicRyjbBusinessZj;
import com.mobiusVision.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 15:41 2018/6/20/020
 * @Modify By:
 **/
public class TbBasicRyjbZjService {

    //通过driver_id查询TB_BASIC_RYJB users,TB_BASIC_ZJ zj,TB_DICTIONARY_ZJZT zt,TB_DICTIONARY_ZJLX lx表中基础证件数据
    public List<TbBasicRyjbBasicZj> findAllBaiscZjByDriverId(String driver_id){

        //获取SpringBean
        ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
        TbBasicRyjbZjMapper tbBasicRyjbZjMapper =(TbBasicRyjbZjMapper)aplc.getBean("tbBasicRyjbZjMapper");

        List<TbBasicRyjbBasicZj> tbBasicRyjbBasicZjList=tbBasicRyjbZjMapper.findAllBaiscZjByDriverId(driver_id);
        return tbBasicRyjbBasicZjList;
    }

    //通过driver_id查询TB_BASIC_RYJB users,TB_BASIC_ZJ zj,TB_DICTIONARY_ZJZT zt,TB_DICTIONARY_ZJLX lx表中基础证件数据
    public List<TbBasicRyjbBusinessZj> findAllBusinessZjByDriverId(String driver_id){

        //获取SpringBean
        ApplicationContext aplc= ApplicationContextUtil.getApplicationContext();
        TbBasicRyjbZjMapper tbBasicRyjbZjMapper =(TbBasicRyjbZjMapper)aplc.getBean("tbBasicRyjbZjMapper");

        List<TbBasicRyjbBusinessZj> tbBasicRyjbBusinessZjList=tbBasicRyjbZjMapper.findAllBusinessZjByDriverId(driver_id);
        return tbBasicRyjbBusinessZjList;
    }
}
