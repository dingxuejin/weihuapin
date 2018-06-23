<template>
  <div class="content">

    <baidu-map @ready="handler"
               :center="center"
               :zoom="zoom"
               :min-zoom="minZoom"
               :max-zoom="maxZoom"
               :scroll-wheel-zoom="scrollwheelzoom"
               class="bmap"
               :theme="mapTheme">
      <!-- 默认导航 -->
      <bm-navigation anchor="BMAP_ANCHOR_BOTTOM_LEFT"></bm-navigation>
      <!-- 自定义控件 -->
      <div class="controlCon">
        <bm-control class="bm-control">
          <div @click="addZoom"
               class="btn">+</div>
          <div @click="reduceZoom"
               class="btn">-</div>
          <!-- 定位控件 -->
          <!-- <bm-geolocation anchor="BMAP_ANCHOR_BOTTOM_RIGHT" :showAddressBar="true" :autoLocation="true"></bm-geolocation> -->
        </bm-control>
      </div>

      <!-- label -->
      <!-- <bm-label content="我爱北京天安门" :position="{lng: 116.404, lat: 39.915}" :labelStyle="{color: 'red', fontSize : '24px'}" title="Hover me"/> -->

      <!-- marker -->
      <!-- <bm-marker :position="{lng: 116.404, lat: 39.915}" :dragging="false" :icon="{url: '../../../static/mapImgs/marker_small.png', size: {width: 16, height: 20}}" :zIndex="100" title="第一标注点" @mouseover="markerMouseover" @mouseout="markerMouseout" @click="infoWindowOpen"> -->
      <!-- <bm-marker :position="{lng: 116.404, lat: 39.915}" :icon="{url: '../../../static/mapImgs/marker_small.png', size: {width: 16, height: 20}}" @mouseover="markerMouseover" @mouseout="markerMouseout" @click="infoWindowOpen"> -->
      <!-- <bm-label content="我爱北京天安门" :labelStyle="{color: 'red', fontSize : '24px'}" :offset="{width: -35, height: 30}"/> -->

      <!-- 弹窗 -->
      <!-- <bm-info-window :show="show" @close="infoWindowClose" @open="infoWindowOpen">弹窗1</bm-info-window> -->
      <!-- </bm-marker> -->

      <!-- <bm-marker :position="{lng: 116.404, lat: 39.815}" :icon="{url: '../../../static/mapImgs/marker_small.png', size: {width: 16, height: 20}}" @mouseover="markerMouseover" @mouseout="markerMouseout" @click="infoWindowOpen"> -->
      <!-- 弹窗 -->
      <!-- <bm-info-window :show="show" @close="infoWindowClose" @open="infoWindowOpen">弹窗2</bm-info-window> -->
      <!-- </bm-marker> -->

      <bm-marker v-for="(item,index) in data"
                 :key="item.title"
                 :position="item.position"
                 :icon="{url: '../../../static/mapImgs/marker_small.png', size: {width: 16, height: 20}}"
                 @mouseover="markerMouseover"
                 @mouseout="markerMouseout"
                 @click="infoWindowOpen(index)">
        <!-- 弹窗 -->
        <bm-info-window :show="show===index"
                        @close="infoWindowClose(-1)"
                        @open="infoWindowOpen(index)"
                        :width="100"
                        :height="40">
          <p class="infoMsg">{{item.title}}</p>
        </bm-info-window>

      </bm-marker>

    </baidu-map>

  </div>

</template>


<script type="text/javascript">
import mapStyle from '../../assets/mapStyle/mapStyle.json'

export default {
  name: 'maptest',
  props: ['data'],
  data() {
    return {
      center: { lng: 116.404, lat: 39.915 },
      // 地图样式
      mapTheme: mapStyle,
      zoom: 12,
      minZoom: 5,
      maxZoom: 19,
      scrollwheelzoom: true,
      show: -1,
    }
  },

  methods: {
    // marker mouseover事件
    markerMouseover({ target }) {
      target.setIcon(
        new BMap.Icon(
          '../../../static/mapImgs/marker_big.png',
          new BMap.Size(80, 80),
        ),
      )
    },

    markerMouseout({ target }) {
      target.setIcon(
        new BMap.Icon(
          '../../../static/mapImgs/marker_small.png',
          new BMap.Size(16, 20),
        ),
      )
    },

    infoWindowClose(i) {
      this.show = i
    },
    infoWindowOpen(i) {
      this.show = i
      // console.log('open this',this);
    },

    // 由于百度地图 JS API 只有 JSONP 一种加载方式，因此 BaiduMap 组件及其所有子组件的渲染只能是异步的。因此，请使用在组件的 ready 事件来执行地图 API 加载完毕后才能执行的代码，不要试图在 vue 自身的生命周期中调用 BMap 类，更不要在这些时机修改 model 层。
    handler({ BMap, map }) {
      // console.log('核心类BMap',BMap);
      // console.log('map实例',map);


    },

    addZoom() {
      if (this.zoom < 20) {
        this.zoom += 1
      }
      // console.log('放大',this.zoom);
    },

    reduceZoom() {
      if (this.zoom > 4) {
        this.zoom -= 1
      }
      // console.log('缩小',this.zoom);
    },
  },

  mounted() {
    // 弹窗样式
    // var infoMsg = document.getElementsByClassName('infoMsg')[0];
    // console.log(infoMsg);
    // var par=infoMsg.parentNode.parentNode.parentNode.parentNode;
    // console.log('父级',par);
    // par.style.backgroundColor = 'green';
  },
}
</script>


<style type="text/css" scoped>
.content,
.bmap {
  width: 100%;
  height: 100%;
  position: relative;
  /*background: red;*/
}

.controlCon {
  width: 20px;
  min-height: 60px;
  position: absolute;
  right: 10px;
  bottom: 25px;
  color: #ccc;
  font-size: 16px;
  font-weight: bold;
  /*border: 1px solid red;*/
}

.bm-control {
  width: 100%;
}

.btn {
  width: 100%;
  height: 20px;
  color: #666;
  text-align: center;
  line-height: 20px;
  margin-top: 5px;
  cursor: pointer;
  background: #ddd;
}

/* 弹窗背景 */
.infoMsg {
  /*height:100px;*/
  /*background:rgba(255,154,44,0.5);*/
  color: #000;
  font-size: 18px;
  margin-top: 10px;
  text-align: center;
}

/*.infoMsg*/
</style>
