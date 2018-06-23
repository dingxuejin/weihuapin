<template>
    <div class="box">
        <Popupframe  @close="close">
            <div class="content">
                <!-- 地图 -->
                <div class="content_map" id="kanbanPopupMap"></div>
                <header>
                    <div class="line"></div>
                    <h3>车辆跨省经营统计</h3>
                    <div class="line"></div>
                </header>
                <!-- 筛选 -->
                <div class="content_screen">
                    <!-- 归属地 -->
                    <div class="itemCon1 fr clearfix">
                        <div class="fl">归属地</div>
                        <div class="fl">
                            <key-value-select width="100px"
                                            :data="yearOption"
                                            @select='selectYear'></key-value-select>
                        </div>
                        <div class="fl">
                            <key-value-select width="82px"
                                            :data="monthOption"
                                            @select="selectMonth"></key-value-select>
                        </div>
                        <div class="fl">
                            <key-value-select width="82px"
                                            :data="dayOption"
                                            @select="selectDay"></key-value-select>
                        </div>
                    </div>
                    <!-- 开始日期 -->
                    <div class="itemCon1 fr clearfix">
                        <div class="fl">开始日期</div>
                        <div class="fl">
                            <key-value-select width="100px"
                                            :data="yearOption"
                                            @select='selectYear'></key-value-select>
                        </div>
                        <div class="fl">
                            <key-value-select width="82px"
                                            :data="monthOption"
                                            @select="selectMonth"></key-value-select>
                        </div>
                        <div class="fl">
                            <key-value-select width="82px"
                                            :data="dayOption"
                                            @select="selectDay"></key-value-select>
                        </div>
                    </div>
                    <!-- 结束日期 -->
                    <div class="itemCon1 fr clearfix">
                        <div class="fl">结束日期</div>
                        <div class="fl">
                            <key-value-select width="100px"
                                            :data="yearOption"
                                            @select='selectYear'></key-value-select>
                        </div>
                        <div class="fl">
                            <key-value-select width="82px"
                                            :data="monthOption"
                                            @select="selectMonth"></key-value-select>
                        </div>
                        <div class="fl">
                            <key-value-select width="82px"
                                            :data="dayOption"
                                            @select="selectDay"></key-value-select>
                        </div>
                    </div>
                    <!-- 车辆数 -->
                    <div class="itemCon1 fr clearfix">
                        <div class="fl">车辆数</div>
                        <div class="fl carNum">12306</div>
                    </div>
                </div>
                <!-- 右侧列表 -->
                <div class="content_list">
                    <div class="content_list_header">
                        <div class="btnWrap clearfix">
                            <div class="title"
                                :class="{box_on:!chartShow}"
                                @click="getDetails(1)">外来车辆</div>
                            <div class="title"
                                :class="{box_on:chartShow}"
                                @click="getDetails(2)">跨省经营</div>
                        </div>
                    </div>
                    <div class="content_list_main">
                        <div class="content_list_main_title clearfix">
                            <span class="fl">省份</span>
                            <span class="fl">跨省经营数量</span>
                        </div>
                        <ul class="content_list_main_detailList">
                            <li v-for="(item,index) in detailListData" :key="index">
                                <div>{{item.name}}</div>
                                <div>{{item.value}}
                                    <div><img src="../../assets/car/icons_icon1_block.png"></div>
                                </div>
                            </li>

                        </ul>
                        <div class="content_list_main_TotleNum">
                            <span class="fl">总数</span>
                            <span class="fl">2222</span>
                        </div>
                    </div>
                </div>
                <!-- 图例显示 -->
                <ul class="content_legend">
                    <li><i></i><span>100辆以上</span></li>
                    <li><i></i><span>50-99辆</span></li>
                    <li><i></i><span>10-49辆</span></li>
                    <li><i></i><span>5-9辆</span></li>
                    <li><i></i><span>5辆以下</span></li>
                </ul>
                <ul class="content_legendicon">
                    <li><img src="" alt=""><span>所在地</span></li>
                    <li><img src="" alt=""><span>归属地</span></li>
                </ul>
            </div>
        </Popupframe>
        <!-- @close='closeDetailsPopupShow' v-if='CrossMapPopupShow'-->
    </div>
</template>
<script>
import Echarts from 'vue-echarts'
// import { mapMutations } from 'vuex'
// import 'echarts/extension/bmap/bmap'
// import bmapStyle from '../../assets/mapStyle/mapStyle.json'
import Popupframe from '../../containers/index/popupframe'
import uploadedDataURL from '../../assets/mapStyle/china.json'
import KeyValueSelect from '../../components/KeyValueSelect'
import Dictionary from '../../util/dictionary'

const { date: { year, month, day } } = Dictionary
export default {
  components: {
    Echarts,
    Popupframe,
    Dictionary,
    KeyValueSelect,
  },
  data() {
    return {
      chartShow: true,
      detailListData: [
          { name: '北京', value: 200 },
          { name: '北京', value: 200 },
          { name: '北京', value: 200 },
          { name: '北京', value: 200 },
          { name: '北京', value: 200 },
          { name: '北京', value: 200 },
          { name: '北京', value: 200 },
          { name: '北京', value: 200 },
          { name: '北京', value: 200 },
          { name: '北京', value: 200 },
          { name: '北京', value: 200 },
          { name: '北京', value: 200 },
          { name: '北京', value: 200 },
          { name: '北京', value: 200 },
          { name: '北京', value: 200 },
          { name: '北京', value: 200 },
          { name: '北京', value: 200 },
          { name: '北京', value: 200 },
          { name: '北京', value: 200 },
          { name: '北京', value: 200 },
          { name: '北京', value: 200 },
      ],
      yearOption: year,
      monthOption: [{ label: '全年', value: null }, ...month],
      dayOption: [{ label: '全月', value: null }, ...day],
      year: 2017,
      month: '01',
      day: '01',
    }
  },
  methods: {
    drowMap() {
      const myChart = this.$echarts.init(document.getElementById('kanbanPopupMap'))
      const mapName = 'china'
      this.$echarts.registerMap(mapName, uploadedDataURL)
      const options = {
        backgroundColor: '#031528',
        tooltip: {
          trigger: 'item',
          enterable: true,
        },
        geo: {
          name: 'china',
          type: 'map',
          map: mapName,
          roam: true,
          silent: true,
          zoom: 0.8,
          itemStyle: {
            normal: {
              areaColor: 'rgba(0,0,0,0.5)',
              borderColor: '#3fdaff',
              borderWidth: 1,
              shadowColor: 'rgba(63, 218, 255, 0.5)',
              shadowBlur: 2,
            },
            emphasis: {
              areaColor: 'rgba(0,0,0,0.5)',
            },
          },
        },
        series: [{
          type: 'lines',
          zlevel: 2,
          effect: {
            show: true,
            period: 6,
            trailLength: 0.1,
            color: '#db9982',
            symbol: 'arrow',
            symbolSize: 8,
          },
          lineStyle: {
            normal: {
              color: '#a6c84c',
              width: 1,
              opacity: 0.4,
              curveness: 0.2,
            },
          },
          data: [{
            coords: [[116.1651515, 39.1531515], [110.1651515, 32.1531515]],
          }, {
            coords: [[116.1651515, 39.1531515], [102.1651515, 38.1531515]],
          }],
        },
        {
          type: 'effectScatter',
          coordinateSystem: 'geo',
          showEffectOn: 'render',
          rippleEffect: {
            brushType: 'stroke',
          },
          hoverAnimation: true,
        //   label: {
        //     normal: {
        //       formatter: '{b}',
        //       position: 'right',
        //       show: true,
        //       fontSize: 12,
        //     },
        //   },
          itemStyle: {
            normal: {
              color: '#F4E925',
              shadowBlur: 10,
              shadowColor: '#05C3F9',
            },
          },
          symbolSize: 6,
          data: [{
            name: '北京',
            value: [116.1651515, 39.1531515],
          }],
        },
        {
          type: 'effectScatter',
          coordinateSystem: 'geo',
          showEffectOn: 'render',
          rippleEffect: {
            brushType: 'stroke',
          },
          hoverAnimation: true,
          data: [{
            value: [102.1651515, 38.1531515],
          }, {
            value: [110.1651515, 32.1531515],
          }],
        },
        ],
      }
      myChart.setOption(options)
    },
    close() {
      this.$emit('onclose')
    },
    getDetails(item) {
      if (item === 1) {
        this.chartShow = false
      } else if (item === 2) {
        this.chartShow = true
      }
    },
    selectYear(item) {
      this.year = item.value
    },
    selectMonth(item) {
      this.month = item.value
    },
    selectDay(item) {
      this.day = item.value
    },
  },
  mounted() {
    this.drowMap()
  },
}
</script>
<style lang="scss" scoped>
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.box{
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    width: 1100px;
    height: 700px;
    .content{
        width: 1100px;
        height: 700px;
        position: relative;
        &_map{
            width: 1098px;
            height: 698px;
            position: absolute;
            top: 0px;
            left: 0px;
            .echarts{
                width: 100%;
                height: 100%;
            }
        }
        header{
            position: absolute;
            top: 18px;
            left: 18px;
            right: 18px;
            h3{
                line-height: 35px;
                padding: 0 35px;
                color: #89DDDF;
            }
        }
        &_screen{
            @include size(392px, 232px);
            position: absolute;
            top: 70px;
            color: #B5B5B5;
            .itemCon1 {
                @include size(392px, 32px);
                color: #b5b5b5;
                font-size: 14px;
                line-height: 25px;
                box-sizing: border-box;
                padding-left: 15px;
                padding-top: 7px;
                div {
                    &:nth-child(1) {
                        @include size(60px, 25px);
                        margin-left: 10px;
                        text-align: right;
                    }
                }
                .carNum{
                    @include size(98px, 23px);
                    line-height: 23px;
                    text-align: center;
                    border: 1px solid #81D9E5;
                    margin-left:10px;
                }
            }
        }
        &_list{
            position: absolute;
            right: 18px;
            top: 70px;
            font-size: 12px;
            &_header{
                width:200px;
                height:40px;
                // background:red;
               .btnWrap {
                    width: 100%;
                    position: absolute;
                    top:10px;
                    .title {
                        width: 100px;
                        height: 25px;
                        line-height: 25px;
                        color: #b5b5b5;
                        font-size: 14px;
                        text-align: center;
                        // border: 1px solid rgba(0, 191, 229, 1);
                        background: rgba(0, 191, 229, 0.2);
                        box-sizing: border-box;
                        float: right;
                        // margin-right: 20px;
                        cursor: pointer;
                    }
                    .box_off {
                        color: #b5b5b5;
                        background: rgba(0, 191, 229, 0.2);
                    }
                    .box_on {
                        color: #fff;
                        background: rgba(0, 191, 229, 0.5);
                    }
                    .title:hover {
                        color: #fff;
                    }
                }
            }
            &_main{
                width: 200px;
                border: 1px solid #05d0eb;
                &_title{
                    width:180px;
                    height:25px;
                    margin:10px 10px 0 10px;
                    box-sizing: border-box;
                    // padding:5px;
                    background:#528D9B;
                    span{
                        line-height: 25px;
                        font-size: 14px;
                        text-align: center;
                        width: 100px;
                        height:25px;
                        text-align: center;
                        display: inline-block;
                        &:nth-child(1){
                            width:90px;
                            float: left;
                        }
                        &:nth-child(2){
                            width:88px;
                        }
                    }
                }
                &_detailList{
                    height: 300px;
                    list-style: none;
                    overflow-y: scroll;
                    li{
                        width:180px;
                        height:25px;
                        margin:5px 10px;
                        background:#244152;
                        div{
                            line-height: 25px;
                            font-size: 14px;
                            text-align: center;
                            width: 100px;
                            height:25px;
                            text-align: center;
                            &:nth-child(1){
                                width:90px;
                                float: left;
                            }
                            &:nth-child(2){
                                width:90px;
                                float: right;
                                box-sizing:border-box;
                                border: 1px solid #05d0eb;
                                div{
                                    width:20px;
                                    height:20px;
                                    box-sizing:border-box;
                                    padding:7px;
                                    img{
                                        display:block;
                                        width:10px;
                                        height:10px;
                                    }
                                }
                            }
                        }
                    }
                }
                &_detailList::-webkit-scrollbar {
                    background: #69a3b1;
                    width: 6px;
                }
                &_detailList::-webkit-scrollbar-thumb {
                    background: #05d0eb;
                }
                &_TotleNum{
                    width:180px;
                    height:25px;
                    margin:5px 10px 10px 10px;
                    box-sizing: border-box;
                    // padding:5px;
                    background:#035779;
                    span{
                        line-height: 25px;
                        font-size: 14px;
                        text-align: center;
                        width: 100px;
                        height:25px;
                        text-align: center;
                        display: inline-block;
                        &:nth-child(1){
                            width:90px;
                            float: left;
                        }
                        &:nth-child(2){
                            width:88px;
                        }
                    }
                }
            }
        }
        &_legend{
            position: absolute;
            bottom: 20px;
            left: 50px;
            color: #B5B5B5;    
            li{
                line-height: 22px;
                i{
                    display: inline-block;
                    width: 15px;
                    height: 8px;
                    background-color: #81D9E5;
                    position: relative;
                    top: -2px;
                }
                span{
                    padding-left: 15px;
                }
            }
        }
        &_legendicon{
            position: absolute;
            bottom: 20px;
            left: 240px;
            color: #B5B5B5; 
            li{
                line-height: 25px;
            }
        }
    }
}
.line{
    width: 100%;
    height: 1px;
    background-color: rgba(129,217,229,0.5);
    position: relative;
}
.line:after{
    content: "";
    display:block;
    width: 30px;
    height: 3px;
    position: absolute;
    background-color:  #81D9E5;
    top: -1px;
}
.line:before{
    content: "";
    display:block;
    width: 30px;
    height: 3px;
    position: absolute;
    background-color:  #81D9E5;
    top: -1px;
    right: 0px;
}
</style>

