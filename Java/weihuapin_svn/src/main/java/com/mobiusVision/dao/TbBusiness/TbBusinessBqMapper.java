package com.mobiusVision.dao.TbBusiness;

import com.mobiusVision.pojo.TbBusiness.TbBusinessBq;
import com.mobiusVision.pojo.TbBusiness.TbBusinessBqTBR;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 9:59 2018/6/20/020
 * @Modify By:
 **/
public interface TbBusinessBqMapper {

    //通过driver_id和label_source查询tb_business_bq表中所有数据
    public List<TbBusinessBq> findAllByDriverIdAndLabelSource(@Param("driver_id") String driver_id,@Param("label_source") String label_source);

    //通过driver_id和label_source=system和label_source与driver_id关联查询tb_business_bq表和tb_basic_ryjb表中最新数据（去重条件Label_source）
    public List<TbBusinessBqTBR> findAllByDriverIdAndNotSystemAndTBR(@Param("driver_id") String driver_id);

}
