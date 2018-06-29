package com.mobiusVision.dao.TbBusiness;

import com.mobiusVision.pojo.TbBusiness.TbBusinessYzsgNDjZrXl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:事故相关接口dao
 * @Date:Created in 9:44 2018/6/21/021
 * @Modify By:
 **/
public interface TbBusinessYzsgMapper {

    //通过driver_id查询tb_business_yzsg yzsg,tb_dictionary_sgdj sgdj,tb_dictionary_sgzr sgzr,tb_dictionary_sfxl sfxl,tb_basic_ryjb ryjb表中所有数据数据(查询一个人的事故按最新时间排列)
    public List<TbBusinessYzsgNDjZrXl> findSgxqByDriverId(@Param("driver_id")String driver_id);

    //通过entity_id查询tb_business_yzsg yzsg,tb_dictionary_sgdj sgdj,tb_dictionary_sgzr sgzr,tb_dictionary_sfxl sfxl,tb_basic_ryjb ryjb表中所有数据数据(查询一个人的事故按最新时间排列)
    public List<TbBusinessYzsgNDjZrXl> findSgxqByEntityId(@Param("entity_id")String entity_id);

}
