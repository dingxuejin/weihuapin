<template>
  <div class="workMileageCountInfoContent">
    <pop-up-widget title="行驶里程统计"
                   detailsBtnShow="true"
                   @popUpdetailsBtn="popMileagedetail = true"></pop-up-widget>

    <!-- 内容部分 -->
    <div class="mileageCon">
      <!-- 标题 -->
      <div class="selectCon clearfix">
        <div class="itemCon fr clearfix">
          <div class="fl">统计周期</div>
          <div class="fl">
            <key-value-select :data="selectYearData"
                              width="120px"
                              @select='select("year",$event)'></key-value-select>
          </div>

          <div class="fl">
            <key-value-select :data="selectMonthData"
                              width="120px"
                              @select='select("month",$event)'></key-value-select>
          </div>

        </div>
      </div>

      <!-- 数据类型 -->
      <div class="dataTypeCon clearfix">
        <div :class="{dataTypeActive:currentDataTypeIndex === 1}"
             @click="dataTypeActive(1)">环比</div>
        <div :class="{dataTypeActive:currentDataTypeIndex === 0}"
             @click="dataTypeActive(0)">同比</div>
      </div>

      <!-- 图表 -->
      <div class="chartsCon">
        <line-data-zoom chartTheme="dark"
                    :data="workMileageCountInfo"
                    :color="mileageChartColor"
                    :areaOpacity= 0.3
                    :dataZoom= true
                    v-if="workMileageCountInfo"
                    yaxisName="占比(%)"></line-data-zoom>
      </div>
    </div>

    <!-- 三级弹窗 -->
    <div class="mileageDetailsInfoContainer" v-if="popMileagedetail">
        <pop-up-frame @close="popMileagedetail = false">
            <work-mileage-details-info></work-mileage-details-info>
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
import WorkMileageDetailsInfo from '../workmileagedetailsinfo/WorkMileageDetailsInfo'

const { date: { year, month } } = Dictionary

export default {
  name: 'workMileageCountInfo',
  components: {
    PopUpFrame,
    PopUpWidget,
    KeyValueSelect,
    Dictionary,
    lineDataZoom,
    WorkMileageDetailsInfo,
  },
  computed: {
    ...mapState('workmileagecountinfo', ['workMileageCountInfo']),
    ...mapState('driverbase', ['ryjb']),
    fetchData() {
      return {
        driver_id: this.ryjb.driver_id,
        year: this.year,
        month: this.month,
        type: ['同比', '环比'][this.currentDataTypeIndex],
      }
    },
  },
  data() {
    return {
      selectYearData: [{ label: '全部', value: null }, ...year],
      selectMonthData: [{ label: '全部', value: null }, ...month],
      currentDataTypeIndex: 1,
      mileageChartData: [
        {
          name: '数据一',
          data: [
            {
              name: '数据一',
              value: 1,
            },
            {
              name: '数据二',
              value: 2,
            },
            {
              name: '数据三',
              value: 3,
            },
            {
              name: '数据四',
              value: 4,
            },
            {
              name: '数据五',
              value: 8,
            },
            {
              name: '数据六',
              value: 1,
            },
            {
              name: '数据七',
              value: 4,
            },
            {
              name: '数据八',
              value: 1,
            },
            {
              name: '数据九',
              value: 6,
            },
            {
              name: '数据十',
              value: 10,
            },
          ],
        },
        {
          name: '数据二',
          data: [
            {
              name: '数据一',
              value: 10,
            },
            {
              name: '数据二',
              value: 2,
            },
            {
              name: '数据三',
              value: 3,
            },
            {
              name: '数据四',
              value: 40,
            },
            {
              name: '数据五',
              value: 8,
            },
            {
              name: '数据六',
              value: 1,
            },
            {
              name: '数据七',
              value: 4,
            },
            {
              name: '数据八',
              value: 10,
            },
            {
              name: '数据九',
              value: 60,
            },
            {
              name: '数据十',
              value: 10,
            },
          ],
        },
      ],
      mileageChartColor: [
        '#05d0eb',
        '#81d9e5',
        '#f6ffcb',
        '#e75029',
        '#038bfc',
        '#006a55',
      ],
      // 三级开关
      popMileagedetail: false,
      year: null,
      month: null,
    }
  },
  methods: {
    ...mapActions('workmileagecountinfo', ['getWorkMileageCountInfo']),
    select(name, item) {
      this[name] = item.value
      this.getWorkMileageCountInfo(this.fetchData)
    },
    dataTypeActive(index) {
      this.currentDataTypeIndex = index
      this.getWorkMileageCountInfo(this.fetchData)
    },
  },
  mounted() {
    // console.log('this.workMileageCountInfo', this.workMileageCountInfo)
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
.workMileageCountInfoContent {
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
        div:nth-child(n+2) {
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
      @include size(100%,180px);
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
    min-height:200px;
    background: green;
    position: absolute;
    top: 0px;
    left: -800px;
  }
}
</style>