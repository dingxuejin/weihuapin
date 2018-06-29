<template>
  <div class="expenseCondition_contend">
      <table></table>
      <!-- 切换统计时间和货物类型 -->
      <div class="switch_time_cargoType">
        <div class="statisticTime">
          <div class="staText">统计时间</div>
          <!-- 年 -->
          <div class="switch_years">
               <KeyValueSelect :data="years"
                            width="100px"
                            height="24px"></KeyValueSelect>
          </div>
          <!-- 月 -->
          <div class="switch_months">
            <KeyValueSelect :data="months"
                            width="75px"
                            height="24px"></KeyValueSelect>
          </div>
        </div>
        <div class="cargoType">
        <div class="cargoType_text">货物类型</div>
        <div class="switch_cargoType">
            <KeyValueSelect :data="cargoTypes"
                            width="92px"
                            height="24px"></KeyValueSelect>
        </div>
        </div>
      </div>
      <!-- 切换路线和  驾驶员或企业 -->
      <div class="switch_route_driCom">
        <div class="switchRoute">
          <div class="routeText">线路</div>
          <div class="routeList">
            <KeyValueSelect :data="routes"
                            width="128px"
                            height="24px"></KeyValueSelect>
          </div>    
        </div>
        <div class="switchDriOrCom">
          <div class="driver" 
          :class='{active:choise==="driver"}'
          @click="choise='driver'">驾驶员</div>
          <div class="company"
          :class='{active:choise==="company"}'
          @click="choise='company'">企业</div>
        </div>
      </div>
      <!-- echarts图部分 -->
      <div class="echarts_part">
        <div class="driver_Echarts" v-if="choise==='driver'">
          <div class="rightEcharts">
            <div class="rightEcharts_chart">
              <barTransverse :data="leftData" gridWidth="90%" height="101"></barTransverse>
            </div>
            <div class="rightEcharts_text">收入</div>
          </div>
          <div class="leftEcharts">
            <div class="leftEcharts_chart">
              <barTransverse :data="rightData" gridWidth="90%" height="101"></barTransverse>
            </div>
            <div class="leftEcharts_text">支出</div>
          </div>
        </div>
        <div class="company_Echarts" v-if="choise==='company'"><lineBarInOutCome></lineBarInOutCome></div>
      </div>
  </div>
</template>

<script type="text/javascript">
import KeyValueSelect from './../../../../components/KeyValueSelect'
import barTransverse from './../../../../components/charts/barTransverse'
import lineBarInOutCome from './../../../../components/charts/lineBarInOutCome'

export default {
  name: '',
  components: {
    KeyValueSelect,
    barTransverse,
    lineBarInOutCome,
  },
  computed: {},
  methods: {

  },
  data() {
    return {
      years: [
        { label: '2017年', value: '2017年' },
        { label: '2016年', value: '2016年' },
        { label: '2015年', value: '2015年' },
        { label: '2014年', value: '2014年' },
      ],
      months: [
        { label: '1月', value: '1月' },
        { label: '2月', value: '2月' },
        { label: '3月', value: '3月' },
        { label: '4月', value: '4月' },
        { label: '5月', value: '5月' },
        { label: '6月', value: '6月' },
        { label: '7月', value: '7月' },
        { label: '8月', value: '8月' },
        { label: '9月', value: '9月' },
        { label: '10月', value: '10月' },
        { label: '11月', value: '11月' },
        { label: '12月', value: '12月' },
      ],
      cargoTypes: [
        { label: '天然气', value: '天然气' },
        { label: '天然气', value: '天然气' },
        { label: '天然气', value: '天然气' },
        { label: '天然气', value: '天然气' },
        { label: '天然气', value: '天然气' },
      ],
      routes: [
        { label: 'xxxxxx', value: 'xxxxxx' },
        { label: 'xxxxxx', value: 'xxxxxx' },
        { label: 'xxxxxx', value: 'xxxxxx' },
        { label: 'xxxxxx', value: 'xxxxxx' },
      ],
      choise: 'driver',
      leftData: [
        { label: '张三', value: 6 },
        { label: '李四', value: 8 },
        { label: '王二', value: 10 },
        { label: '麻子', value: 12 },
        { label: '张龙', value: 14 },
      ],
      rightData: [
        { label: '张三', value: 6 },
        { label: '李四', value: 8 },
        { label: '王二', value: 10 },
        { label: '麻子', value: 12 },
        { label: '张龙', value: 14 },
      ],
    }
  },
}
</script>

<style lang="scss" scoped>
.expenseCondition_contend{
    width: 100%;
    height:100%;
    .switch_time_cargoType{
      width: 100%;
      height:24px;
      margin-top: 5px;
      font-size: 14px;
      color: #b5b5b5;
      .statisticTime{
        width: 264px;
        height:24px;
        float: left;
        div{
          float: left;
        }
        .staText{
          width: 84px;
          height:24px;
          text-align: center;
          line-height: 24px;
        }
        .switch_years{
          width: 102px;
          height:24px;
        }
        .switch_months{
          width: 75px;
          height:24px;
        }
      }
      .cargoType{
        width: 184px;
        height:24px;
        float: right;
        div{
          float: left;
        }
        .cargoType_text{
          width: 74px;
          height:24px;
          text-align: center;
          line-height: 24px;
        }
        .switch_cargoType{
          width: 110px;
          height:24px;
        }
      }
    }
    .switch_route_driCom{
      width: 100%;
      height:30px;
      margin-top: 5px;
      .switchRoute{
        width: 184px;
        height:30px;
        float: left;
        font-size: 14px;
        color: #b5b5b5;
        div{
          float: left;
        }
        .routeText{
          width: 56px;
          height: 100%;
          text-align: center;
          line-height: 25px;
        }
        .routeList{
          width: 128px;
          height: 100%;
        }
      }
      .switchDriOrCom{
        width: 266px;
        height:30px;
        float: right;
        div{
          float: left;
          width: 130px;
          height:30px;
          text-align: center;
          line-height: 30px;
          color: #fff;
          border: 1px solid #05D0EB;
          background: rgba(5,208,235,0.60);
          box-sizing: border-box;
          font-size: 14px;
          cursor: pointer;
        }
        .driver{
          margin-right: 6px;
        }
        .active{
          color: #b5b5b5;
          background-color: rgba(5, 208, 235, 0.2);
        }
      }
    }
    .echarts_part{
      width: 100%;
      height:125px;
      display: flex;
      .driver_Echarts{
        width: 100%;
        height:100%;
        display: flex;
        div{
          flex: 1;
        }
        .rightEcharts{
          .rightEcharts_chart{
            height: 101px;
            width: 100%;
            overflow-y: auto;
          }
          .rightEcharts_chart::-webkit-scrollbar {
            background: #69A3B1;
            width: 4px;
          }
          .rightEcharts_chart::-webkit-scrollbar-thumb {
            background: #05D0EB ;
          }
          .rightEcharts_text{
            height: 24px;
            width: 100%;
            line-height: 24px;
            font-size: 14px;
            text-align: center;
            color: #89DDDF ;
          }
        }
        .leftEcharts{
          .leftEcharts_chart{
            height: 101px;
            width: 100%;
            overflow-y: auto;
          }
          .leftEcharts_chart::-webkit-scrollbar {
            background: #69A3B1;
            width: 4px;
          }
          .leftEcharts_chart::-webkit-scrollbar-thumb {
            background: #05D0EB ;
          }
          .leftEcharts_text{
            height: 24px;
            width: 100%;
            line-height: 24px;
            font-size: 14px;
            text-align: center;
            color: #89DDDF ;
          }
        }
      }
    }
      .company_Echarts{
        width: 100%;
        height:100%;
      }
}
</style>