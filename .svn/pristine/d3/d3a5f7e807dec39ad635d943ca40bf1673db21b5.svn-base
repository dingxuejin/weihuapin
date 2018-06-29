package com.mobiusVision.pojo.TbBusiness;

import com.mobiusVision.pojo.TbDictionary.TbDictionarySfxl;
import com.mobiusVision.pojo.TbDictionary.TbDictionarySgdj;
import com.mobiusVision.pojo.TbDictionary.TbDictionarySgzr;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 9:40 2018/6/21/021
 * @Modify By:
 **/
public class TbBusinessYzsgNDjZrXl extends TbBusinessYzsg {
    private String name;
    private TbDictionarySgdj sgdj;
    private TbDictionarySgzr sgzr;
    private TbDictionarySfxl sfxl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TbDictionarySgdj getSgdj() {
        return sgdj;
    }

    public void setSgdj(TbDictionarySgdj sgdj) {
        this.sgdj = sgdj;
    }

    public TbDictionarySgzr getSgzr() {
        return sgzr;
    }

    public void setSgzr(TbDictionarySgzr sgzr) {
        this.sgzr = sgzr;
    }

    public TbDictionarySfxl getSfxl() {
        return sfxl;
    }

    public void setSfxl(TbDictionarySfxl sfxl) {
        this.sfxl = sfxl;
    }

    @Override
    public void setAccidentType_Time(String accidentType_Time) {
        if(accidentType_Time!=null) accidentType_Time=accidentType_Time.substring(0,4)+'-'+accidentType_Time.substring(4,6)+'-'+accidentType_Time.substring(6,8);
        super.setAccidentType_Time(accidentType_Time);
    }
}
