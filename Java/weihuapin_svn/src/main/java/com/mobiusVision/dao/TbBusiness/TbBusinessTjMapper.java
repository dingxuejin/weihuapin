package com.mobiusVision.dao.TbBusiness;

import com.mobiusVision.pojo.TbBusiness.TbBusinessTj;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:查询驾驶员健康信息
 * @Date:Created in 14:59 2018/6/19/019
 * @Modify By:
 **/
public interface TbBusinessTjMapper {

    //通过driver_id查询tb_business_tj表中一条最新数据
    public List<TbBusinessTj> findOneByDriverId(@Param("driver_id") String driver_id);
}
