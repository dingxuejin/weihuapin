package com.mobiusVision.dao.TbBusiness;

import com.mobiusVision.pojo.TbBusiness.TbBusinessAqxwjfjjAndSw;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:安全行为积分和奖金相关接口dao
 * @Date:Created in 13:24 2018/6/21/021
 * @Modify By:
 **/
public interface TbBusinessAqxwjfjjMapper {

    //通过driver_id查询TB_BUSINESS_AQXWJFJJ aqxwjfjj,TB_DICTIONARY_SW sw表中所有违章数据
    public List<TbBusinessAqxwjfjjAndSw> findAllJfJjSwByDriverId(@Param("driver_id")String driver_id);
}
