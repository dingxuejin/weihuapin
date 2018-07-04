<template>
    <div class="content">
        <div ref="map" class="map"></div>
        <div class="btn">
            <span  @click="onChange">切换</span>
            <span @click="lushu.start()">播放</span>
            <span @click="lushu.pause()">暂停</span>
            <span @click="lushu.stop()">停止</span>
        </div>
    </div>
</template>
<script>
/* eslint-disable */
import 'echarts/extension/bmap/bmap'
import bmapStyle from '@/assets/mapStyle/mapStyle.json'
import '@/assets/bmap/BMapLib_LuShu.js'
export default {
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
        getBoundary(name='江苏'){
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
        onChange(){
            const self=this
            const map=this.bmap
            // map.clearOverlays();
            // this.getBoundary('苏州')
            this.createdLushu(function(lushu){
                console.log(lushu)
                lushu.showInfoWindow()
                self.lushu=lushu
            })
            console.log('center',map.getCenter())
        },
        createdLushu(callback){
            const map=this.bmap
            var drv = new BMap.DrivingRoute('北京', {
                onSearchComplete: function(res) {
                    if (drv.getStatus() == BMAP_STATUS_SUCCESS) {
                        var plan = res.getPlan(0);
                        var arrPois =[];
                        for(var j=0;j<plan.getNumRoutes();j++){
                            var route = plan.getRoute(j);
                            arrPois= arrPois.concat(route.getPath());
                        }
                        map.addOverlay(new BMap.Polyline(arrPois, {strokeColor: '#ff0000'}));
                        map.setViewport(arrPois);
                        
                        var lushu = new BMapLib.LuShu(map,arrPois,{
                            defaultContent:"",//"从天安门到百度大厦"
                            autoView:true,//是否开启自动视野调整，如果开启那么路书在运动过程中会根据视野自动调整
                            icon  : new BMap.Icon('http://lbsyun.baidu.com/jsdemo/img/car.png', new BMap.Size(52,26),{anchor : new BMap.Size(27, 13)}),
                            speed: 4500,
                            enableRotation:true,//是否设置marker随着道路的走向进行旋转
                            landmarkPois:[]
                        });
                        callback && callback(lushu)  
                    }
                }
            });
            drv.search('苏州', '上海');
                
        }
    },
    mounted(){
        this.drawMap()
    }
}
</script>
<style lang="scss" scoped>
.content{
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
