package com.mobiusVision.dao.TbBasic;


import com.mobiusVision.pojo.TbBasic.TbBasicRyjbBasicZj;
import com.mobiusVision.pojo.TbBasic.TbBasicRyjbBusinessZj;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 14:57 2018/6/20/020
 * @Modify By:
 **/
public interface TbBasicRyjbZjMapper {

    //通过driver_id查询TB_BASIC_RYJB users,TB_BASIC_ZJ zj,TB_DICTIONARY_ZJZT zt,TB_DICTIONARY_ZJLX lx表中基础证件数据
    public List<TbBasicRyjbBasicZj> findAllBaiscZjByDriverId(@Param("driver_id")String driver_id);

    //通过driver_id查询TB_BASIC_RYJB users,TB_BASIC_ZJ zj,TB_DICTIONARY_ZJZT zt,TB_DICTIONARY_ZJLX lx表中业务证件数据
    public List<TbBasicRyjbBusinessZj> findAllBusinessZjByDriverId(@Param("driver_id")String driver_id);
}
