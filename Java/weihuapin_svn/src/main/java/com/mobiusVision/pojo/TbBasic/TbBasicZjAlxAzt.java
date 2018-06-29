package com.mobiusVision.pojo.TbBasic;

import com.mobiusVision.pojo.TbDictionary.TbDictionaryZjlx;
import com.mobiusVision.pojo.TbDictionary.TbDictionaryZjzt;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 14:49 2018/6/20/020
 * @Modify By:
 **/
public class TbBasicZjAlxAzt extends TbBasicZj {


    private String expire_days;

    private TbDictionaryZjlx zjlx;

    private TbDictionaryZjzt zjzt;

    public TbDictionaryZjlx getZjlx() {
        return zjlx;
    }

    public void setZjlx(TbDictionaryZjlx zjlx) {
        this.zjlx = zjlx;
    }

    public TbDictionaryZjzt getZjzt() {
        return zjzt;
    }

    public void setZjzt(TbDictionaryZjzt zjzt) {
        this.zjzt = zjzt;
    }

    public String getExpire_days() {
        return expire_days;
    }

    public void setExpire_days(String expire_days) {
        this.expire_days = expire_days;
    }
}
