package com.mobiusVision.dao.TbBusiness;

import com.mobiusVision.pojo.TbBusiness.TbBusinessPxATTT;
import com.mobiusVision.pojo.TbBusiness.TbBusinessPxOrTTT;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:人员培训信息查询
 * @Date:Created in 17:31 2018/6/21/021
 * @Modify By:
 **/
public interface TbBusinessPxMapper {

    //通过driver_id等数据查询Px表所有数据
    public List<TbBusinessPxATTT> findPxByDidCodeDate(
            @Param("driver_id")String driver_id,
            @Param("training_type_code")String training_type_code,
            @Param("training_theme_code")String training_theme_code,
            @Param("year")String year,
            @Param("month")String month);

    //通过driver_id等数据查询Px表中人员培训次数,人员培训时长,培训通过人数
    public List<TbBusinessPxOrTTT> findAllTrainingTTT(
            @Param("driver_id")String driver_id,
            @Param("training_type_code")String training_type_code,
            @Param("training_theme_code")String training_theme_code,
            @Param("year")String year);

}
