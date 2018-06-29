<template>
  <div class="driveEfficiency_contend">
    <table></table>
    <!-- 切换部分 -->
      <div class="switch_part">
        <div class="statisticTime">
          <div class="timeText">统计时间</div>
          <div class="yearOfTime">
               <KeyValueSelect :data="years"
                            width="99px"
                            height="24px"></KeyValueSelect>
          </div>
          <div class="monthOfTime">
            <KeyValueSelect :data="months"
                            width="75px"
                            height="24px"></KeyValueSelect>
          </div>
        </div>
        <div class="route">
          <div class="routeText">线路</div>
          <div class="routeList">
            <KeyValueSelect :data="routes"
                            width="116px"
                            height="24px"></KeyValueSelect>
          </div>
        </div>
        <div class="cargoType">
          <div class="cargoTypeText">货物类型</div>
          <div class="cargoTypeList">
            <KeyValueSelect :data="cargoTypes"
                            width="90px"
                            height="24px"></KeyValueSelect>
          </div>
        </div>
      </div>
      <!-- 合计部分 -->
      <div class="altogether">
        <div class="avrDriveTime">平均驾驶时长（企业）</div>
        <div class="avrDriveTime_value">10</div>
        <div class="avrOilConsume">平均油耗（企业）</div>
        <div class="avrOilConsume_value">46</div>
      </div>
      <!-- echart图部分 -->
      <div class="echarts_part">
        <div class="leftEchart">
          <barTransverse :data="leftData" gridWidth="90%" height="109"></barTransverse>
        </div>
        <div class="rightEchart">
          <barTransverse :data="rightData" gridWidth="90%" height="109"></barTransverse>
        </div>
      </div>
      <div class="someText">
        <div>平均驾驶时长</div>
        <div>平均油耗</div>
      </div>
  </div>
</template>

<script type="text/javascript">
import KeyValueSelect from './../../../../components/KeyValueSelect'
import barTransverse from './../../../../components/charts/barTransverse'

export default {
  name: '',
  components: {
    KeyValueSelect,
    barTransverse,
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
      routes: [
        { label: 'xxxxxx', value: 'xxxxxx' },
        { label: 'xxxxxx', value: 'xxxxxx' },
        { label: 'xxxxxx', value: 'xxxxxx' },
        { label: 'xxxxxx', value: 'xxxxxx' },
      ],
      cargoTypes: [
        { label: '天然气', value: '天然气' },
        { label: '天然气', value: '天然气' },
        { label: '天然气', value: '天然气' },
        { label: '天然气', value: '天然气' },
        { label: '天然气', value: '天然气' },
      ],
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
.driveEfficiency_contend{
    width: 100%;
    height:100%;
    // background: red;
    .switch_part{
      width: 100%;;
      height: 25px;
      margin-top: 6px;
      font-size: 14px;
      color: #B5B5B5;
      div{
        float: left;
      }
      .statisticTime{
        width: 255px;
        height: 100%;
        .timeText{
          width: 80px;
          height: 100%;
          text-align: center;
          line-height: 25px;
        }
        .yearOfTime{
          width: 100px;
          height: 100%;
        }
        .monthOfTime{
          width: 75px;
          height: 100%;
        }
      }
      .route{
        width: 156px;
        height: 100%;
        .routeText{
          width: 40px;
          height: 100%;
          text-align: center;
          line-height: 25px;
        }
        .routeList{
          width: 116px;
          height: 100%;
        }
      }
      .cargoType{
        width: 156px;
        height: 100%;
        // background: cyan;
        .cargoTypeText{
          width: 62px;
          height: 100%;
          text-align: center;
          line-height: 25px;
        }
        .cargoTypeList{
          width: 90px;
          height: 100%;
        }
      }
    }
    .altogether{
      width: 100%;
      height:20px;
      margin-top: 5px;
      div{
        float: left;
        text-align: center;
        line-height: 20px;
        font-size: 14px;
        color: #05D0EB;
      }
      .avrDriveTime{
        width: 173px;
        height:100%;
        background-color: rgba(74,113,142,0.50)
      }
      .avrDriveTime_value{
        width: 122px;
        height:100%;
        background-color: rgba(3,139,252,0.40);
      }
      .avrOilConsume{
        width: 149px;
        height:100%;
        background-color: rgba(74,113,142,0.50)
      }
      .avrOilConsume_value{
        width: 124px;
        height:100%;
        background-color: rgba(3,139,252,0.40);
      }
    }
    .echarts_part{
      width: 100%;
      height: 109px;
      display: flex;
      .leftEchart{
        height: 100%;
        flex:1;
        overflow-y: auto;
      }
    .leftEchart::-webkit-scrollbar {
      background: #69A3B1;
      width: 4px;
    }
    .leftEchart::-webkit-scrollbar-thumb {
      background: #05D0EB ;
    }
      .rightEchart{
        height: 100%;
        flex:1;
        overflow-y: auto;
      }
    .rightEchart::-webkit-scrollbar {
      background: #69A3B1;
      width: 4px;
    }
    .rightEchart::-webkit-scrollbar-thumb {
      background: #05D0EB ;
    }
    }
    .someText{
      width: 100%;
      height: 24px;
      display: flex;
      div{
      flex: 1;
      line-height: 24px;
      font-size: 14px;
      text-align: center;
      color: #89DDDF ;
    }
    }
}
</style>