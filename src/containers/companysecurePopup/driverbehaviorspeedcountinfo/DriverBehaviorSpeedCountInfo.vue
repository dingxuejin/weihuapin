<template>
  <div class="driverBehaviorSpeedCountInfo">
    <pop-up-widget title="每日均速/驾驶平稳度统计"></pop-up-widget>
    <!-- 内容部分 -->
    <div class="content">
      <!-- 标题及数据切换 -->
      <div class="titleCon clearfix">
        <div class="title fl">每日均速/平稳度统计</div>
        <div class="typecon fr clearfix">
          <div :class="{dataTypeActive:currentDataTypeIndex === 0}"
               @click="dataTypeActive(0)">车队</div>
          <div :class="{dataTypeActive:currentDataTypeIndex === 1}"
               @click="dataTypeActive(1)">总公司</div>
        </div>
      </div>

      <!-- 参数包裹 -->
      <div class="indexCon clearfix"
           v-if="driverBehaviorSpeedStatistics">
        <div class="itemCon fl">
          <div>速度平均值</div>
          <div>{{driverBehaviorSpeedStatistics.ranking.speed_average}}</div>
        </div>
        <div class="itemCon fl">
          <div>速度平稳度</div>
          <div>{{driverBehaviorSpeedStatistics.ranking.speed_standarddeviation}}</div>
        </div>
        <div class="itemCon fl">
          <div>速度平均值排名</div>
          <div>{{driverBehaviorSpeedStatistics.ranking[`speed_average_${group}_ranking`]}}</div>
        </div>
        <div class="itemCon fl">
          <div>速度平稳度排名</div>
          <div>{{driverBehaviorSpeedStatistics.ranking[`speed_standarddeviation_${group}_ranking`]}}</div>
        </div>
      </div>

      <!-- 标题及数据切换 -->
      <div class="filterWrap clearfix">
        <div class="title fl">速度标准差变化趋势</div>
        <div class="filterCon fr">
          <div>统计周期</div>
          <div>
            <key-value-select :data="selectYearData"
                              width="90px"
                              @select='select("year",$event)'></key-value-select>
          </div>
          <div>
            <key-value-select :data="selectMonthData"
                              width="90px"
                              @select='select("month",$event)'></key-value-select>
          </div>
        </div>
      </div>

      <!-- 图表 -->
      <div class="chartsCon">
        <line-data-zoom chartTheme="dark"
                        :data="driverBehaviorSpeedCountInfo.deviation"
                        :color="chartColor"
                        :areaOpacity=0.3
                        :dataZoom=true
                        v-if="driverBehaviorSpeedCountInfo&&driverBehaviorSpeedCountInfo.deviation"
                        yaxisName="占比(%)"></line-data-zoom>
      </div>
    </div>

    <!-- 三级弹窗 -->
    <div class="mileageDetailsInfoContainer"
         v-if="popDriverBehaviorAlarm">
      <pop-up-frame @close="popDriverBehaviorAlarm = false">
        <driver-behavior-alarm-details-info></driver-behavior-alarm-details-info>
      </pop-up-frame>
    </div>
  </div>
</template>

<script type="text/javascript">
import { mapState, mapActions } from 'vuex'
import PopUpFrame from '../../../components/PopUpFrame'
import PopUpWidget from '../../../components/PopUpWidget'
import KeyValueSelect from '../../../components/KeyValueSelect'
import Dictionary from '../../../util/dictionary'
import lineDataZoom from '../../../components/charts/lineDataZoom'

// 三级弹窗
import DriverBehaviorAlarmDetailsInfo from '../driverbehavioralarmdetailsinfo/DriverBehaviorAlarmDetailsInfo'

const {
  driveEventType: { danger },
  date: { year, month, day },
  countType,
  timeSlot,
} = Dictionary

export default {
  name: 'workStrengthCountInfo',
  components: {
    PopUpFrame,
    PopUpWidget,
    KeyValueSelect,
    Dictionary,
    lineDataZoom,
    DriverBehaviorAlarmDetailsInfo,
  },
  data() {
    return {
      year: 2017,
      month: 10,
      selectYearData: year,
      selectMonthData: [{ label: '全年', value: null }, ...month],
      selectDayData: [{ label: '全月', value: null }, ...day],
      selectAlarmType: danger,
      selectCountType: countType,
      selectTimeSlot: timeSlot,
      currentDataTypeIndex: 0,
      chartColor: [
        '#05d0eb',
        '#81d9e5',
        '#f6ffcb',
        '#e75029',
        '#038bfc',
        '#006a55',
      ],
      // 三级开关
      popDriverBehaviorAlarm: false,
    }
  },
  computed: {
    ...mapState('driverbehaviorspeedcountinfo', ['driverBehaviorSpeedCountInfo', 'driverBehaviorSpeedStatistics']),
    ...mapState('driverbase', ['ryjb']),
    group() {
      return ['fleet', 'company'][this.currentDataTypeIndex]
    },
    Statistics() {
      return {
        driver_id: this.ryjb.driver_id,
      }
    },
    fetchData() {
      return {
        driver_id: this.ryjb.driver_id,
        year: this.year,
        month: this.month,
        day: this.day,
      }
    },
  },
  methods: {
    ...mapActions('driverbehaviorspeedcountinfo', ['getDriverBehaviorSpeedCountInfo']),
    select(name, item) {
      this[name] = item.value
      this.getDriverBehaviorSpeedCountInfo(this.fetchData)
    },
    dataTypeActive(index) {
      this.currentDataTypeIndex = index
    },
  },
}
</script>

<style lang="scss" scoped>
// 公用样式
@mixin size($w, $h) {
  width: $w;
  height: $h;
}

// 组件包裹
.driverBehaviorSpeedCountInfo {
  position: relative;
  // 标题包裹
  .titleCon {
    @include size(100%, 25px);
    // background: red;
    // 标题
    .title {
      @include size(200px, 100%);
      color: #89dddf;
      font-size: 16px;
      text-align: center;
      line-height: 25px;
      background: #2f525b;
    }

    // 切换数据
    .typecon {
      @include size(250px, 25px);
      // background:cyan;
      div {
        @include size(120px, 25px);
        box-sizing: border-box;
        border: 1px solid #00bfe5;
        text-align: center;
        line-height: 23px;
        color: #b5b5b5;
        float: left;
        background: rgba(0, 191, 229, 0.2);
        cursor: pointer;
      }
      .dataTypeActive {
        color: #fff;
        background: rgba(0, 191, 229, 0.5);
      }
      div:nth-child(n + 2) {
        margin-left: 10px;
      }
    }
    // end
  }
  // 内容包裹
  .content {
    position: relative;
    // 下拉框包裹
    .selectCon {
      @include size(100%, 25px);
      color: #b5b5b5;
      font-size: 14px;
      line-height: 25px;
      .itemCon {
        div:nth-child(n + 2) {
          margin-left: 5px;
        }
      }
      .itemCon:nth-child(n + 2) {
        margin-left: 10px;
      }
    }

    // 参数包裹
    .indexCon {
      @include size(100%, 68px);
      margin-top: 10px;
      // background: red;
      font-size: 14px;
      text-align: center;
      .itemCon {
        // background: green;
        div:nth-child(1) {
          @include size(170px, 18px);
          color: #89dddf;
          line-height: 18px;
          background: rgba(0, 191, 229, 0.2);
        }
        div:nth-child(2) {
          @include size(170px, 40px);
          color: #89dddf;
          font-size: 22px;
          line-height: 40px;
          margin-top: 10px;
          background: rgba(0, 139, 262, 0.4);
        }
      }
      .itemCon:nth-child(n + 2) {
        margin-left: 10px;
      }
    }

    // 筛选条件
    .filterWrap {
      @include size(100%, 25px);
      margin-top: 10px;
      color: #b5b5b5;
      font-size: 14px;
      .title {
        @include size(200px, 25px);
        text-align: center;
        line-height: 25px;
        color: #89dddf;
        font-size: 16px;
        background: rgba(129, 217, 229, 0.3);
      }

      .filterCon {
        > div {
          float: left;
          line-height: 25px;
        }

        > div:nth-child(2) {
          margin-left: 10px;
        }

        > div:nth-child(n + 3) {
          margin-left: 5px;
        }
      }
    }

    // 图表包裹
    .chartsCon {
      @include size(100%, 200px);
      // overflow: hidden;
      margin-top: 10px;
      // background: red;
    }
  }

  // 三级弹窗
  .mileageDetailsInfoContainer {
    // @include size(750px,350px);
    // overflow: hidden;
    width: 750px;
    min-height: 200px;
    // background: green;
    position: absolute;
    top: 0px;
    left: 750px;
  }
}
</style>