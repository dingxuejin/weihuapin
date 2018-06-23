<template>
    <baidu-map class="map"
        :center="center"
        :zoom="zoom"
        :scroll-wheel-zoom="true"
        :continuous-zoom="true"
        :map-click="false"
        :mapStyle="mapStyle"
        @zoomend="zoomendMap"
        @click="onClickMap"
        @mousemove="mousemoveMap"
        @rightclick="rightclickMap"
    >
        <!-- 地图搜索 -->
        <bm-local-search :keyword="keyword" :auto-viewport="true" :location="location" :panel="false"></bm-local-search>
        <!-- 轨迹路线 -->
        <bm-driving
            :start="startAddress"
            :end="endAddress"
            @searchcomplete="handleSearchComplete"
            :panel="false"
        >
        </bm-driving>
        <!-- 播放轨迹 -->
        <bml-lushu
            :path="path"
            :icon="icon"
            :play="play==='start'?true:false"
            :speed="speed"
            :autoView="true"
            :rotation="true"
            content="京AAF905">
        </bml-lushu>
        <!-- 车辆轨迹 -->
        <bm-polyline
            :path="polylinePath"
            stroke-color="red"
            :stroke-opacity="0.5"
            :stroke-weight="2"
        >
        </bm-polyline>
        <!-- 车辆位置 -->
        <bml-marker-clusterer :averageCenter="true"
            :styles="[{
                url:require('../../assets/images/map/loaded.png'),
                size: {width: 32, height: 24},
                textColor:'#fff',
                textSize:16
            }]"
        >
            <bm-marker v-for="(marker,index) in markers" :key="index"
                :position="{lng: marker.lng, lat: marker.lat}"
                :icon="{url:marker.status===0?
                    require('../../assets/images/map/underloaded.png'):require('../../assets/images/map/offline.png'),
                    size: {width: 32, height: 32}
                }"
                @click="clickCarPoint"
                @mouseover="mouseoverCarPoint(marker)"
                @mouseleave="showInfoWindow=fasle"
            >
            </bm-marker>
        </bml-marker-clusterer>
        <!-- 车辆提示框 -->
        <!-- <bm-info-window :position="{lng:InfoWindowData.lng,lat:InfoWindowData.lat}" :show="showInfoWindow"
            :title="InfoWindowData.name"
        >
        </bm-info-window> -->
        <MvOverlay
            :position="{lng: InfoWindowData.lng, lat: InfoWindowData.lat}"
            v-show="showInfoWindow"
        >
            <div class="infoBox">
                <div class="infoBox_content">
                    <span class="over">{{InfoWindowData.name}}</span>
                    <span class="over" @click="getTrajectoryShow({name:InfoWindowData.name,state:true})">轨迹</span>
                    <span class="over" @click="getCarDetailsInfoShow({name:InfoWindowData.name,state:true})">详情</span>
                </div>
            </div>
        </MvOverlay>
        <!-- 车辆信息汇总 -->
        <bm-overlay
            pane="markerMouseTarget"
            @draw="draw"
            class="gatherBox"
            v-show="isShowGather"
        >
            <div class="gather_content">
                <header>
                    <img :src="require('../../assets/images/map/loaded.png')" />
                </header>
                <ul>
                    <li>|<span>车辆总数</span></li>
                    <li><span>{{qf(carGather.count) || 0}}</span></li>
                    <li>|<span>在线车辆</span></li>
                    <li><span>{{qf(carGather.online) || 0}}</span></li>
                    <li>|<span>离线车辆</span></li>
                    <li><span>{{qf(carGather.offline) || 0}}</span></li>
                </ul>
            </div>
        </bm-overlay>
        <!-- 画多边形 -->
        <bm-polygon 
            :path="polygonPath" 
            stroke-color="blue" 
            :stroke-opacity="0.5" 
            :stroke-weight="2" 
            :editing="true" 
            @lineupdate="updatePolygonPath"
        />
        <!-- <bm-polyline :path="polygonPath" ></bm-polyline> -->
    </baidu-map>
</template>
<script>
/* eslint-disable */
import {mapMutations} from 'vuex'
import MarkerClusterer from 'bmaplib.markerclusterer'
import { BmlLushu, BmlMarkerClusterer } from 'vue-baidu-map'
import mapStyleJson from '@/assets/mapStyle/mapStyle.json'
import MvOverlay from './MvOverlay.vue'
import BaiduMap from 'vue-baidu-map'

export default {
  components: {
    BmlLushu,
    BmlMarkerClusterer,
    MvOverlay
  },
  props: {
    center:{
        type:Object,
        default:function(){
            return { lng: 108.404, lat: 35.915 }
        }
    },
    zoom:{
        type:Number,
        default:5
    },
    play: {
      type: String,
      default: 'start'
    },
    speed: {
      type: Number,
      default: 60
    },
    keyword: {
      type: String,
      default: ''
    },
    location: {
      type: String,
      default: ''
    },
    carGather: {// 车辆汇总信息
      type: Object,
      default: function () {
        return {
          count: 50,
          online: 48,
          offline: 2
        }
      }
    },
    isShowGather:{
        type:Boolean,
        default:true
    },
    PlayPath: {//播放轨迹
      type: Array,
      default: function () {
        return []
      }
    },
    polylinePath:{//车辆轨迹
        type:Array,
        default:function(){
            return []
        }
    },
    markers:{//车辆坐标集合
        type:Array,
        default:function(){
            return []
        }
    },
    startAddress:{
        type:String,
        default:''
    },
    endAddress:{
        type:String,
        default:''
    },
    isEditing:{
        type:Boolean,
        default:false
    }
  },
  data() {
    return {
      mapStyle: {
        styleJson: mapStyleJson,
      },
      icon: {
        // url: 'http://api.map.baidu.com/library/LuShu/1.2/examples/car.png',
        url: require('../../assets/images/map/lushu-online.png'),
        size: { width: 32, height: 32 },
        opts: { anchor: { width: 27, height: 13 } },
      },
      path:[],
      showInfoWindow:false,
      InfoWindowData:{},
      polygonPath: [],
      Eeiting:false,
    }
  },
  methods: {
      ...mapMutations('index',['getTrajectoryShow','getCarDetailsInfoShow']),
    handleSearchComplete(res) { // 设置路数轨迹
      if (res) {
        this.path = res.getPlan(0).getRoute(0).getPath()
      }
    },
    clickCarPoint(info) { // 点击车辆
      this.$emit('clickCarPoint', info)
    },
    mouseoverCarPoint(e) { // 划过车辆
      this.showInfoWindow=true
      this.InfoWindowData={
          lng:e.lng,
          lat:e.lat,
          name:e.name
        }
    },
    zoomendMap(e) { // 缩放地图时显示隐藏所以车辆
        this.showInfoWindow=false
        this.$emit('zoomMap',e.target.Oa)
    },
    draw({ el, BMap, map }) { // 汇总时的显示信息dom
      const { lng, lat } = this.center
      const pixel = map.pointToOverlayPixel(new BMap.Point(120.453261, 40.000549))
      el.style.left = `${pixel.x - 60}px`
      el.style.top = `${pixel.y - 20}px`
    },
    onClickMap(e){
        if (!this.isEditing) return
        this.polygonPath.push(e.point)
        this.Eeiting=true        
        let num=0
        for(let i=0;i<this.markers.length;i++){
            if(this.isPointInPolygon(this.markers[i],this.polygonPath)){
                num++
            }
        }
        this.$emit('PointInPolygonCount',num)
    },
    rightclickMap(){
        if (!this.isEditing) return
        this.polygonPath.pop()
        this.Eeiting=false
    },
    mousemoveMap (e) {
      if (!this.isEditing || !this.Eeiting) return
      if(!this.polygonPath.length)return
      if(this.polygonPath.length===1){
          this.polygonPath.push(e.point)
      }
      this.$set(this.polygonPath, this.polygonPath.length-1, e.point)
    },
    updatePolygonPath (e) {
      this.polygonPath = e.target.getPath()
      let num=0
      for(let i=0;i<this.markers.length;i++){
          if(this.isPointInPolygon(this.markers[i],e.target.getPath())){
              num++
          }
      }
      this.$emit('PointInPolygonCount',num)
    },
    //判断点是否在多边形内
    isPointInPolygon(markers,polygonPoints=[]){
        let list=[]
        polygonPoints.map(e=>{
           list.push( new BMap.Point(e.lng,e.lat))
        })
        if(BMapLib.GeoUtils.isPointInPolygon(new BMap.Point(markers.lng,markers.lat),new BMap.Polygon(list))){
            return true
        }else{
            return false
        }
    }
  },
  watch:{
      isEditing(){
          if(!this.isEditing){
              this.polygonPath=[]
              this.Eeiting=false
          }
      }
  },
  created() {

  },
}
</script>
<style lang="scss" scoped>
.map{
    width:100%;
    height:100%;
}
.infoBox{
    position: absolute;
    top: 20px;
    left: -58px;
    width: 236px;
    height: 56px;
    background:url('../../assets/images/map/kuang.png') no-repeat;
    overflow: hidden;
    box-shadow: 0 0 5px #000;
    color: #fff;
    &_content{
        padding-top: 24px;
        span{
            display: inline-block;
            line-height: 24px;
            padding: 0 10px;
            border: 1px solid #05d0ed;
            text-align: center;
            border-radius: 3px;
        }
        span:first-child{
            width: 77px;
            margin-left: 10px;
        }
        span:nth-child(2):hover{
            background-color:#05d0ed;
        }
        span:nth-child(3):hover{
            background-color:#05d0ed;
        }
    }
}
.gatherBox{
    position:absolute;
}
.gather_content{
    position:relative;
    left:-50%;
    width:1000px;
    text-align:center;
    ul{
        display:inline-block;
        margin:0 auto;
        clear:both;
        li{
            display:inline-block;
            color:#89DDDF;
            padding:2px 5px;
            float:left;
            line-height:24px;
            background:#000102;
        }
        li:nth-child(2n+1){
            border:1px solid rgba(0,191,229,0.5);
            span{
                padding:0 10px;
            }
        }
        li:nth-child(2n){
            min-width:80px;
            border:1px solid rgba(3,249,242,0.4);
            border-left:none;
        }
        li:nth-child(1),li:nth-child(2){
            color:#05e0db;
        }
        li:nth-child(3),li:nth-child(4){
            color:#d98930;
        }
        li:nth-child(5),li:nth-child(6){
            color:#898989;
        }
    }
}
</style>
