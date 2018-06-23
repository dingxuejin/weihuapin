<template>
    <div class="ChangeTrend">
      <div class="ChangeTrend_wrap">
        <div class="ChangeTrend_title">各月总得分/排名变化总趋势</div>
        <div class="ChangeTrend_conent">
          <div class="month">月</div>
          <!-- 详情btn -->
          <div class="btnWrap clearfix">
            <div class="title"
                 :class="{box_on:!chartShow}"
                 @click="getDetails(1)">企业</div>
            <div class="title"
                 :class="{box_on:chartShow}"
                 @click="getDetails(2)">服务商</div>
          </div>
          <!-- 图例 -->
          <!-- 切换内容：服务商 -->
          <div class="costStatisticsWrap" v-if="chartShow">
            <lineDoubleAxis chartTheme="dark"
                            :data="lineDoubleAxisCostData"
                            :dataZoom=false
                            :property="lineDoubleCostProperty"
                            yaxisNameL="总得分"
                            yaxisNameR="排名"
                            v-if="lineDoubleAxisCostData"
                            >
            </lineDoubleAxis>
          </div>
            <!-- <Loading :data='lineDoubleAxisCostData'></Loading> -->
            <!-- 调用数据 -->
            <div v-show="false">{{getMaintenanceCostData}}</div>
          <!-- 切换内容：企业 -->
          <div class="TimeConsumingStatisticsWrap" v-if="!chartShow">
            <lineDoubleAxis chartTheme="dark"
                            :data="lineDoubleAxisCostData"
                            :dataZoom=false
                            v-if="lineDoubleAxisCostData"
                            :property="lineDoubleTimeProperty"
                            yaxisNameL="总得分"
                            yaxisNameR="排名"
                            >
            </lineDoubleAxis>
          </div>
            <!-- <Loading :data='lineDoubleAxisTimeData'></Loading> -->
            <!-- 调用数据 -->
            <div v-show="false">{{getMaintenanceTimeData}}</div>
        </div>
      </div>
    </div>
</template>
<script>
/* eslint-disable */

import lineDoubleAxis from '@/components/charts/lineDoubleAxis1'
export default {
  components: {
    lineDoubleAxis,
  },
  data() {
    return {
      chartShow: true,
      lineDoubleTimeProperty:[
        {name:'各月总得分',type:'bar',axis:0},
        {name:'各月排名',type:'line',axis:1}
      ],
      lineDoubleAxisCostData:[
        {
          "name":"各月总得分",
          "data":[
            {"name":"1","value":Math.random()*1000},
            {"name":"2","value":Math.random()*1000},
            {"name":"3","value":Math.random()*1000},
            {"name":"4","value":Math.random()*1000},
            {"name":"5","value":Math.random()*1000},
            {"name":"6","value":Math.random()*1000},
            {"name":"7","value":Math.random()*1000},
            {"name":"8","value":Math.random()*1000},
            {"name":"9","value":Math.random()*1000},
            {"name":"10","value":Math.random()*1000},
            {"name":"11","value":Math.random()*1000},
            {"name":"12","value":Math.random()*1000},
          ]
        },
        {
          "name":"各月排名",
          "data":[
            {"name":"1","value":Math.random()*50},
            {"name":"2","value":Math.random()*50},
            {"name":"3","value":Math.random()*50},
            {"name":"4","value":Math.random()*50},
            {"name":"50","value":Math.random()*50},
            {"name":"6","value":Math.random()*50},
            {"name":"7","value":Math.random()*50},
            {"name":"8","value":Math.random()*50},
            {"name":"9","value":Math.random()*50},
            {"name":"10","value":Math.random()*50},
            {"name":"11","value":Math.random()*50},
            {"name":"12","value":Math.random()*50},
           ]
         }
        ],
      lineDoubleAxisTimeData: null,
      lineDoubleCostProperty:[
       {name:'各月总得分',type:'bar',axis:0},
       {name:'各月排名',type:'line',axis:1}
      ],
      lineDoubleAxisColor: [
        '#05d0eb',
        '#81d9e5',
        '#f6ffcb',
        '#e75029',
        '#038bfc',
        '#006a55',
      ],
    };
  },
  methods:{
    getMaintenanceCostData() {
      if (this.maintainInfomationData) {
        this.lineDoubleCostProperty = [
          {
            name: '各月总得分',
            type: 'bar',
            axis: 0,
          },
          {
            name: "各月排名",
            type: 'line',
            axis: 1,
          },
        ]
        //  年度保养次数费用统计
        this.lineDoubleAxisCostData = [
          {
            name: '各月总得分',
            data: Math.random()*1000,
          },
          {
            name: "各月排名",
            data: Math.random()*50,
          },
        ]
        console.log('年度保养次数费用统计', JSON.stringify(this.lineDoubleAxisCostData))
      }
      return null
    },
    getMaintenanceTimeData() {
        this.lineDoubleTimeProperty = [
          {
            name: '各月总得分',
            type: 'bar',
            axis: 0,
          },
          {
            name: "各月排名",
            type: 'line',
            axis: 1,
          },
        ]
        //  年度保养次数耗时统计
        this.lineDoubleAxisTimeData = [
          {
            name: '各月总得分',
            data: Math.random()*1000,
          },
          {
            name: "各月排名",
            data: Math.random()*50,
          },
        ]
        // console.log('年度保养次数耗时统计', JSON.stringify(this.lineDoubleAxisTimeData))
      return null
    },
    getDetails(item) {
      if (item === 1) {
        this.chartShow = false
      } else if (item === 2) {
        this.chartShow = true
      }
    },
  }
};
</script>
<style lang="scss" scoped>
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.ChangeTrend{
  @include size(100%,100%);
  position: relative;
  &_wrap{
    @include size(558px,402px);
    position: absolute;
    bottom: 24px;
    left:0px;
    // background: pink;
    .ChangeTrend_title{
      @include size(558px,26px);
      margin-bottom: 12px;
      background:	rgba(129,217,229,0.3);
      box-sizing:border-box;
      font-size: 16px;
      color:#89DDDF;
      padding-left:23px;
      line-height:26px;
      text-align:left;
    }
    .ChangeTrend_conent{
      @include size(558px,364px);
      background: #0A4159;
      position: relative;
      .month{
        @include size(5px,5px);
        background: #0A4159;
        position: absolute;
        right:24px;
        bottom: 10px;
        font-size:14px;
        color: #ABADAE;
      }
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
            border: 1px solid rgba(0, 191, 229, 1);
            background: rgba(0, 191, 229, 0.2);
            box-sizing: border-box;
            float: right;
            margin-right: 20px;
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
        .costStatisticsWrap {
          @include size(558px,328px);
          position: absolute;
          top:36px;
          // background:pink;
        }
        .TimeConsumingStatisticsWrap {
          @include size(558px,328px);
          position: absolute;
          top:36px;
          // background:skyblue;
        }
        .CumulativeMaintenanceInfoWrap {
          width: 100%;
          margin-top: 10px;
          padding-top: 20px;
          .CumulativeMaintenanceInfo {
            width: 100%;
            margin-top: 10px;
            .item {
              width: 230px;
              float: left;
              margin-right: 10px;
              .rerpaireTitle {
                line-height: 16px;
                font-size: 16px;
                color: #89dddf;
                text-align: center;
                margin-top: 10px;
                margin-bottom: 10px;
              }
              .repaireData {
                height: 40px;
                line-height: 40px;
                text-align: center;
                color: #fff;
                background: rgba(3, 139, 252, 0.4);
              }
            }
            .last {
              margin-right: 0px;
            }
          }
      }
    }
  }
}
</style>
