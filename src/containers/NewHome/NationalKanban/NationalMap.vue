<template>
    <div class="home">
        <div ref="map" class="map"></div>
        <div class="btn" @click="onChange">切换</div>
    </div>
</template>
<script>
/* eslint-disable */
import 'echarts/extension/bmap/bmap'
import bmapStyle from '@/assets/mapStyle/mapStyle.json'
import '@/assets/bmap/MarkerClusterer.js'

export default {
  components: {
    
  },
  props: {
    center: {
      type: Object,
      default() {
        return { lng: 108.404, lat: 35.915 }
      },
    },
  },
  data(){
      return {

      }
  },
  methods:{
        drawMap(){
            const myChart = this.$echarts.init(this.$refs.map)
            const option = {
                tooltip: {
                show: true,
                showContent: true,
                confine: true,
                },
                bmap: {
                    center: [110, 40],
                    zoom: 5,
                    roam: true,
                    mapStyle: {
                        styleJson: bmapStyle,
                    },
                },
                series: [{
                    type:'lines',
                    coordinateSystem: 'bmap',
                    polyline: true,
                    silent: true,
                    lineStyle: {
                        normal: {
                            width:2,
                            color: 'rgba(90,221,223,1)',
                        },
                    },
                    data:[{
                        coords:[
                            [118.793471,30.958251],
                            [119.793471,29.958251],
                            [119.793471,31.958251],
                            [120.793471,30.968251],
                            [121.793471,30.958251]
                        ],
                    }]
                }],
            }
            myChart.setOption(option)
            const bmap=myChart.getModel().getComponent('bmap').getBMap()
            this.bmap=bmap
            this.getBoundary()
        },
        getBoundary(name='中国'){
            const map=this.bmap
            var bdary = new BMap.Boundary();
            bdary.get(name, function(rs){       //获取行政区域
                // map.clearOverlays();        //清除地图覆盖物       
                var count = rs.boundaries.length; //行政区域的点有多少个
                if (count === 0) {
                    return ;
                }
                var pointArray = [];
                for (var i = 0; i < count; i++) {
                    var ply = new BMap.Polygon(rs.boundaries[i], {strokeWeight: 2, strokeColor: "#45b6e0",fillColor:"rgba(24,107,179,0.3)"}); //建立多边形覆盖物
                    map.addOverlay(ply);  //添加覆盖物
                    pointArray = pointArray.concat(ply.getPath());
                }    
                map.setViewport(pointArray);    //调整视野               
            });  
        },
        BMapLibMarkerClusterer(){
            const map=this.bmap
            var MAX = 10;
            var markers = [];
            var pt = null;
            var i = 0;
            var icon=require('@/assets/images/map/underloaded.png')
            for (; i < MAX; i++) {
                pt = new BMap.Point(Math.random() * 40 + 85, Math.random() * 30 + 21);
                markers.push(new BMap.Marker(pt,{icon:new BMap.Icon(icon,new BMap.Size(30,30))}));
            }
            //最简单的用法，生成一个marker数组，然后调用markerClusterer类即可。
            var markerClusterer = new BMapLib.MarkerClusterer(map, {markers:markers});
            var styles=[{
                url:require('@/assets/images/map/loaded.png'),
                size:  new BMap.Size(32,32),
                textColor:'#fff',
                textSize:16
            }]
            markerClusterer.setStyles(styles)
        },
        onClickMap(e){
            console.log(e)
        },
        onChange(){
            const map=this.bmap
            // this.getBoundary('苏州')
            this.BMapLibMarkerClusterer()
            // console.log('center',map.getCenter())
            console.log(map)
            // map.setMapType(BMAP_PERSPECTIVE_MAP)
            // map.setCurrentCity("苏州");
        }
  },
  mounted(){
      this.drawMap()
    
  }
  
}
</script>
<style lang="scss" scoped>
.home{
    position: absolute;
    top: 0px;
    left: 0px;
    width: 100%;
    height: 100%;
    .map{
        width: 100%;
        height: 100%;
    }
    .btn{
        position: absolute;
        top: 10px;
        left: 10px;
        z-index: 1;
        color: #fff;
        cursor: pointer;
    }
}
</style>
