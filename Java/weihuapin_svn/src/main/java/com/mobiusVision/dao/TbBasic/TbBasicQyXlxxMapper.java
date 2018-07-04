package com.mobiusVision.dao.TbBasic;

import com.mobiusVision.pojo.TbBasic.TbBasicQyXlxx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:线路信息相关
 * @Date:Created in 19:43 2018/6/29/029
 * @Modify By:
 **/
public interface TbBasicQyXlxxMapper {

    //通过route_id查询线路名称
    public TbBasicQyXlxx findAllByRId(@Param("route_id")String route_id);
}
