<template>
  <div class="blameAccidentNumCountInfoCon">
    <pop-up-widget title="有责事故次数统计"
                   detailsBtnShow="true"
                   @popUpdetailsBtn="popBlameAccidentNumCountInfo = true"></pop-up-widget>
    <!-- 内容部分 -->
    <div class="mileageCon">
      <!-- 标题 -->
      <div class="selectCon clearfix">
        <div class="itemCon fr clearfix">
          <div class="fl">统计周期</div>
          <div class="fl">
            <key-value-select width="90px"
                              :data="selectYearData"
                              @select='select("year",$event)'></key-value-select>
          </div>

          <div class="fl">
            <key-value-select width="90px"
                              :data="selectMonthData"
                              @select='select("month",$event)'></key-value-select>
          </div>

          <div class="fl">
            <key-value-select width="90px"
                              :data="selectDayData"
                              @select='select("day",$event)'></key-value-select>
          </div>
        </div>

        <div class="itemCon fr clearfix">
          <div class="fl">报警类型</div>
          <div class="fl">
            <key-value-select width="200px"
                              :data="selectAlarmType"
                              @select='select("accident_level_code",$event)'></key-value-select>
          </div>
        </div>
      </div>

      <!-- 图表 -->
      <div class="chartsCon">
        <line-data-zoom chartTheme="dark"
                        :data="blameAccidentNumCountInfo"
                        :color="chartColor"
                        :areaOpacity= 0
                        :dataZoom= true
                        v-if="blameAccidentNumCountInfo"
                        yaxisName="占比(%)"></line-data-zoom>
      </div>
    </div>

    <!-- 三级弹窗 -->
    <div class="mileageDetailsInfoContainer"
         v-if="popBlameAccidentNumCountInfo">
      <pop-up-frame @close="popBlameAccidentNumCountInfo = false">
        <blame-accident-details-info></blame-accident-details-info>
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
import BlameAccidentDetailsInfo from '../blameaccidentdetailsinfo/BlameAccidentDetailsInfo'

// 三级弹窗
const {
  accidentLevelCode,
  date: { year, month, day },
  countType,
  timeSlot,
} = Dictionary

export default {
  name: 'illegalBehaviorAlarmCount',
  components: {
    PopUpFrame,
    PopUpWidget,
    KeyValueSelect,
    Dictionary,
    lineDataZoom,
    BlameAccidentDetailsInfo,
  },
  computed: {
    ...mapState('blameaccidentnumcountinfo', ['blameAccidentNumCountInfo']),
    ...mapState('driverbase', ['ryjb']),
  },
  data() {
    return {
      selectYearData: year,
      selectMonthData: [{ label: '全年', value: null }, ...month],
      selectDayData: [{ label: '全月', value: null }, ...day],
      selectAlarmType: accidentLevelCode,
      selectCountType: countType,
      selectTimeSlot: timeSlot,
      //   currentDataTypeIndex: 0,
      // chartData: [
      //   {
      //     name: '数据一',
      //     data: [
      //       {
      //         name: '数据一',
      //         value: 10,
      //       },
      //       {
      //         name: '数据二',
      //         value: 2,
      //       },
      //       {
      //         name: '数据三',
      //         value: 8,
      //       },
      //       {
      //         name: '数据四',
      //         value: 14,
      //       },
      //       {
      //         name: '数据五',
      //         value: 8,
      //       },
      //       {
      //         name: '数据六',
      //         value: 1,
      //       },
      //       {
      //         name: '数据七',
      //         value: 4,
      //       },
      //       {
      //         name: '数据八',
      //         value: 10,
      //       },
      //       {
      //         name: '数据九',
      //         value: 6,
      //       },
      //       {
      //         name: '数据十',
      //         value: 10,
      //       },
      //     ],
      //   },
      //   {
      //     name: '数据二',
      //     data: [
      //       {
      //         name: '数据一',
      //         value: 10,
      //       },
      //       {
      //         name: '数据二',
      //         value: 12,
      //       },
      //       {
      //         name: '数据三',
      //         value: 3,
      //       },
      //       {
      //         name: '数据四',
      //         value: 40,
      //       },
      //       {
      //         name: '数据五',
      //         value: 8,
      //       },
      //       {
      //         name: '数据六',
      //         value: 1,
      //       },
      //       {
      //         name: '数据七',
      //         value: 4,
      //       },
      //       {
      //         name: '数据八',
      //         value: 10,
      //       },
      //       {
      //         name: '数据九',
      //         value: 60,
      //       },
      //       {
      //         name: '数据十',
      //         value: 10,
      //       },
      //     ],
      //   },
      // ],
      chartColor: [
        '#05d0eb',
        '#81d9e5',
        '#f6ffcb',
        '#e75029',
        '#038bfc',
        '#006a55',
      ],
      // 三级开关
      popBlameAccidentNumCountInfo: false,

      accident_level_code: 4,
      year: 2017,
      month: 11,
    }
  },
  methods: {
    ...mapActions('blameaccidentnumcountinfo', [
      'getBlameAccidentNumCountInfo',
    ]),
    fetchData() {
      this.getBlameAccidentNumCountInfo({
        driver_id: this.ryjb.driver_id,
        year: this.year,
        month: this.month,
        accident_level_code: this.accident_level_code,
      })
    },
    select(name, item) {
      this[name] = item.value
      this.fetchData()
    },
    // dataTypeActive(index) {
    //   this.currentDataTypeIndex = index
    // },
  },
}
</script>

<style lang="scss" scoped>
// 公用样式
@mixin size($w,$h) {
  width: $w;
  height: $h;
}

// 组件包裹
.blameAccidentNumCountInfoCon {
  position: relative;
  // 内容包裹
  .mileageCon {
    position: relative;
    // 下拉框包裹
    .selectCon {
      @include size(100%,25px);
      color: #b5b5b5;
      font-size: 14px;
      line-height: 25px;
      .itemCon {
        div:nth-child(n + 2) {
          margin-left: 5px;
        }
      }
      //   .itemCon:nth-child(1) {
      //     margin-left: 132px;
      //   }
      .itemCon:nth-child(n + 2) {
        margin-right: 10px;
      }
    }
    .selectCon:nth-child(2) {
      margin-top: 10px;
    }

    // 切换数据
    .dataTypeCon {
      @include size(100%,25px);
      margin-top: 10px;
      // background: green;
      div {
        @include size(160px,25px);
        box-sizing: border-box;
        text-align: center;
        line-height: 23px;
        color: #b5b5b5;
        float: right;
        background: rgba(0, 191, 229, 0.2);
        cursor: pointer;
      }
      .dataTypeActive {
        color: #fff;
        background: rgba(0, 191, 229, 0.5);
      }
      div:nth-child(2) {
        margin-right: 10px;
      }
      div:nth-child(n + 2) {
        margin-left: 10px;
      }
    }

    // 图表包裹
    .chartsCon {
      @include size(100%,200px);
      // overflow: hidden;
      margin-top: 10px;
      //   background:green;
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
    top: 80px;
    left: -100px;
  }
}
</style>