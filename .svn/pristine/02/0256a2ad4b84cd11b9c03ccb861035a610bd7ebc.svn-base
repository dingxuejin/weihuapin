<template>
  <div class="indexMap clearfix">
    <!-- 地图图例 -->
    <div class="indexMap_legend">
      <div>
        <img src="../../assets/images/map/underloaded.png" />
        <span>在线</span>
      </div>
      <div>
        <img src="../../assets/images/map/offline.png" />
        <span>离线</span>
      </div>
    </div>
    <!-- 查询选框btn -->
    <div class="indexMap_carSearchBtn">
      <div class="indexMap_carSearchBtn_region">
        <span @click="regionSearch">区域查车</span>
      </div>
      <div class="indexMap_carSearchBtn_polygon">
        <span @click="polygonSearch">多边形查车</span>
      </div>
      <div class="indexMap_carSearchBtn_plateNo">
        <span @click="plateNoSearch">车牌号查车</span>
      </div>
    </div>
    <!-- 显示查询选框:start -->
    <!-- 1. 区域选择 -->
    <div class="indexMap_content_region"
         v-show="regionShow">
      <!-- 所属区域 -->
      <div class="indexMap_content_region_category fl">
        <div class="indexMap_content_region_category_select fl" @click="showCarNativeProvince=!showCarNativeProvince;showCarCurrentProvince=false">
          <span>|</span>{{carNative}}
        </div>
        <i class="el-icon-arrow-down"></i>
        <div class="indexMap_content_region_category_province" v-show="showCarNativeProvince">
          <ProvinceView @selectProvince="selectProvince"></ProvinceView>
        </div>
      </div>
      <!-- 数量 -->
      <div class="indexMap_content_region_category fl">
        <div class="indexMap_content_region_category_title fl">|&nbsp;&nbsp;数量</div>
        <div class="indexMap_content_region_category_input fl">
          {{region_count}}
        </div>
      </div>
    </div>
    <!-- 1.车辆所在地 -->
    <div class="indexMap_content_polygon"
         v-show="regionShow" style="top:65px;">
      <!-- 总车辆数 -->
      <div class="indexMap_content_region_category fl">
        <div class="indexMap_content_region_category_select fl" @click="showCarCurrentProvince=!showCarCurrentProvince">
          <span>|</span>{{carCurrent}}
        </div>
        <i class="el-icon-arrow-down"></i>
        <div class="indexMap_content_region_category_province" v-show="showCarCurrentProvince">
          <ProvinceView  @selectProvince="selectCurrentProvince"></ProvinceView>
        </div>
      </div>
      <!-- 数量 -->
      <div class="indexMap_content_region_category fl">
        <div class="indexMap_content_region_category_title fl">|&nbsp;&nbsp;数量</div>
        <div class="indexMap_content_region_category_input fl">
          {{region_count}}
        </div>
      </div>
    </div>
    <!-- 2.多边形选择 -->
    <div class="indexMap_content_polygon"
         v-show="polygonShow">
      <!-- 总车辆数 -->
      <div class="indexMap_content_region_category fl">
        <div class="indexMap_content_region_category_title fl">|&nbsp;&nbsp;总车辆数</div>
        <div class="indexMap_content_region_category_input fl">
          {{region_totalCount}}
        </div>
      </div>
    </div>

    <!-- 3.车牌号查车 -->
    <div class="indexMap_content_plateNo"
         v-if="plateNoShow">
      <el-input v-model="CarCode"
        placeholder="输入车牌号查询">
        <i slot="suffix" class="el-input__icon el-icon-search" @click="CarCodeSearch"></i>
      </el-input>
    </div>
    <!-- 显示查询选框:end -->
    <!-- 地图 -->
    <div class="indexMap_mapbox">
      <!-- 
        center Array 地图中心
          {lng:120.21,lat:20.21}
        play true/false 是否播放
        speed Number 播放速率
        keyword String 搜索地名关键字
        isEditing Boolean 是否可编辑
        startAddress String 路数起始地址
        endAddress String 路数结束地址
        carGather Object  车辆汇总信息
          数据结构：
          {
            count:Number 车辆总数
            online:Number 车辆在线数量
            offline:Number 车辆离线数量
          }
        isShowGather Boolean true/false 是否显示车辆汇总信息
        PlayPath Array 播放轨迹
          数据结构：
          [{
            lnt:123.2154,
            lat:30.154
          },{
            lnt:123.2154,
            lat:30.154
          }] 经纬度集合
        polylinePath Array 车辆轨迹
          数据结构：
          [{
            lnt:123.2154,
            lat:30.154
          },{
            lnt:123.2154,
            lat:30.154
          }] 经纬度集合
        markers Array 车辆坐标集合
          数据结构：
          [{
            lnt:123.215,
            lat:23.151,
            status:0 / 1  0在线 1离线
          },{
            lnt:123.215,
            lat:23.151,
            status:0
          }]
        事件event
        clickCarPoint 点击车辆事件
          clickCarPoint(info) 可获取车辆信息info
        zoomMap 缩放地图时
          zoomMap(zoom) zoom为地图缩放层级
       -->
      <CarBMap
        :keyword="provinceName"
        :isEditing="polygonShow"
        :play="playInfo.play"
        :startAddress="playInfo.startAddress"
        :endAddress="playInfo.endAddress"
        :zoom="zoom"
        :center="center"
        :markers="markersData"
        :isShowGather="isShowGather"
        @zoomMap="zoomMap"
        @PointInPolygonCount="(e)=>region_totalCount=e"
      >
      </CarBMap>
    </div>
  </div>
</template>

<script>
/* eslint-disable */
import {mapState,mapMutations} from 'vuex'
import CarBMap from "./CarBMap.vue";
import ProvinceView from './ProvinceView.vue'

export default {
  name: "indexMap",
  components: {
    CarBMap,
    ProvinceView
  },
  data() {
    return {
      region_count: "", // 区域选择：数量
      region_totalCount:0 , // 区域选择：总车辆数
      regionShow: false, // 显示区域查询弹出框
      polygonShow: false, // 显示多边形查询弹出框
      plateNoShow: false, // 显示车辆查询选择弹出框
      input:'',
      CarCode: "",
      isShowGather:true,
      markersData:[],
      center:{ lng: 108.404, lat: 35.915 },
      zoom:5,
      play:false,
      startAddress:'',
      endAddress:'',

      tempMarkers:[],
      carNative:'车辆车籍地',
      carCurrent:'车辆所在地',
      showCarNativeProvince:false,
      showCarCurrentProvince:false
    };
  },
  computed:{
    ...mapState('index',['markers','playInfo','provinceName'])
  },
  methods: {
    ...mapMutations('index',['setProvinceName']),
    regionSearch() {
      this.regionShow = !this.regionShow;
    },
    polygonSearch() {
      this.polygonShow = !this.polygonShow;
      this.region_totalCount=0
    },
    plateNoSearch() {
      this.plateNoShow = !this.plateNoShow;
    },
    zoomMap(zoom){
      this.zoom=zoom
      if (zoom>5) {
        this.isShowGather=false
        this.markersData=this.tempMarkers
      }else{
        this.markersData=[]
        this.isShowGather=true
      }
    },
    CarCodeSearch(){
      this.markers.map((item)=>{
        if(item.name.indexOf(this.CarCode)>=0){
          this.center={lng:item.lng,lat:item.lat}
          this.zoom=10
        }
      })
    },
    selectProvince(info){
      this.setProvinceName(info.name)
      this.carNative=info.name
      this.showCarNativeProvince=false
      this.showCarCurrentProvince=false
    },
    selectCurrentProvince(info){
      this.setProvinceName(info.name)
      this.carCurrent=info.name
      this.showCarNativeProvince=false
      this.showCarCurrentProvince=false
    }
  },
  created(){
    let tempMarkers=[]
    for(let i=0;i<50;i++){
      tempMarkers[i]={
        lng:116.1+Math.random(),
        lat:39.1+Math.random(),
        status: 0,
        name: '京AAF90'+i,
      }
    }
    this.tempMarkers=tempMarkers
  }
};
</script>

<style lang="scss" scoped>
.indexMap {
  width: 100%;
  height: 100%;
  position: relative;
  &_legend{
    position: absolute;
    top: 20px;
    right: 20px;
    z-index:10;
    div{
      padding:5px 10px;
      img{
        vertical-align: middle;
      }
    }
    div:first-child{
      color:#d98930;
    }
    div:last-child{
      color:#898989;
    }
  }
  &_mapbox {
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0px;
    left: 0px;
  }
  &_carSearchBtn {
    height: 130px;
    width: 120px;
    position: relative;
    top: 23px;
    left: 34px;
    z-index: 11;
    &_region {
      height: 40px;
      width: 120px;
      border: 2px solid #05d0eb;
      padding: 8px;
      box-sizing: border-box;
      margin-bottom: 47px;
      background: #000;
      span {
        text-align: center;
        color: #b5b5b5;
        font-size: 14px;
        margin: 0;
        padding: 0;
        display: inline-block;
        width: 100px;
        height: 20px;
        line-height: 20px;
        background: rgba(5, 208, 235, 0.3);
      }
      span:hover {
        background: rgba(0, 191, 229, 0.6);
        color: #fff;
        cursor: pointer;
      }
    }
    &_polygon {
      height: 40px;
      width: 120px;
      border: 2px solid #05d0eb;
      padding: 8px;
      box-sizing: border-box;
      margin-bottom: 47px;
      background: #000;
      span {
        text-align: center;
        color: #b5b5b5;
        font-size: 14px;
        margin: 0;
        padding: 0;
        display: inline-block;
        width: 100px;
        height: 20px;
        line-height: 20px;
        background: rgba(5, 208, 235, 0.3);
      }
      span:hover {
        background: rgba(0, 191, 229, 0.6);
        color: #fff;
        cursor: pointer;
      }
    }
    &_plateNo {
      height: 40px;
      width: 120px;
      border: 2px solid #05d0eb;
      padding: 8px;
      box-sizing: border-box;
      background: #000;
      span {
        text-align: center;
        color: #b5b5b5;
        font-size: 14px;
        margin: 0;
        padding: 0;
        display: inline-block;
        width: 100px;
        height: 20px;
        line-height: 20px;
        background: rgba(5, 208, 235, 0.3);
      }
      span:hover {
        background: rgba(0, 191, 229, 0.6);
        color: #fff;
        cursor: pointer;
      }
    }
  }
  &_content_region {
    width: 652px;
    height: 56.5px;
    position: absolute;
    top: 20px;
    left: 200px;
    z-index: 11;
    &_category {
      position: relative;
      height: 40px;
      margin-right: 5px;
      &_select{
        width: 374px;
        height: 40px;
        line-height: 36px;
        color: #b5b5b5;
        border: 1px solid #00bfe5;
        box-sizing: border-box;
        margin-right: 1px;
        cursor:pointer;
        span{
          padding: 0 10px;
        }
      }
      &_title {
        width: 95px;
        height: 40px;
        line-height: 36px;
        color: #b5b5b5;
        text-align: center;
        border: 1px solid #00bfe5;
        box-sizing: border-box;
        margin-right: 1px;
      }
      &_input{
        width: 113px;
        height: 40px;
        line-height: 36px;
        color: #fff;
        border: 1px solid #00bfe5;
        box-sizing: border-box;
        text-align: center;
      }
      &_province{
        position: absolute;
        top: 45px;
        left: 0px;
        width: 100%;
        height: 300px;
      }
      i{
        position: absolute;
        right: 10px;
        color: #fff;
        top: 12px;
      }
    }
  }
  &_content_polygon {
    width: 652px;
    height: 56.5px;
    position: absolute;
    top: 110px;
    left: 200px;
    z-index: 10;
    &_category {
      width: 212px;
      height: 40px;
      margin-right: 5px;
      &_title {
        width: 95px;
        height: 40px;
        line-height: 36px;
        color: #b5b5b5;
        text-align: center;
        border: 1px solid #00bfe5;
        box-sizing: border-box;
        margin-right: 1px;
      }
      &_input {
        width: 113px;
        height: 40px;
        line-height: 36px;
        color: #b5b5b5;
        border: 1px solid #00bfe5;
        box-sizing: border-box;
        text-align: center;
      }
    }
  }
  &_content_plateNo {
    width: 467px;
    height: 40px;
    position: absolute;
    top: 198px;
    left: 200px;
    z-index: 11;
  }
}
.el-icon-search{
  cursor:pointer;
}
</style>
