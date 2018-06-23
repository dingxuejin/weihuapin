<template>
  <div class="costStatisticsDetailsPopupbig_wrap"
       v-if="showCostStatisticsDetails"
       v-drag
       @mousedown="move=true"
       @mouseup="move=false"
       :style="move?'cursor:move':''">
    <div class="costStatisticsDetailsPopupWrap clearfix">
      <pop-up-frame @close='closeDetailsShow'>
        <pop-up-widget title="费用统计信息"
                       :detailsBtnShow='false'></pop-up-widget>
        <!-- 详情弹出内容 -->
        <div class="costStatisticsDetailsWrap clearfix">
          <div class="btnWrap clearfix">
            <div class="title"
                 :class="{box_off:!costDetailsShow}"
                 @click="getFloatCostDetails">浮动费用统计</div>
            <div class="title"
                 :class="{box_off:costDetailsShow}"
                 @click="getFixedCostDetails">固定费用统计</div>
          </div>
          <!-- 浮动费用详情 -->
          <div class="detailsWrap floatCost"
               v-if="costDetailsShow">
            <!-- 各项浮动费用统计 -->
            <div class="costStatisticsDetailsWrap">
              <div class="subTilte">各项浮动费用统计</div>
              <!-- bar图 -->
              <div class="costStatisticsBarChart">
                <loading :data="carCostStatisticsData">
                  <bar-stack chartTheme="dark"
                             :data="carCostStatisticsData.fixed.statistics"
                             :color="barStackColor"
                             yName="费用(元)"></bar-stack>
                </Loading>
              </div>
              <!-- 年度燃油及年度费用二级弹框 -->
              <div class="moreDetailsWrap clearfix">
                <div class="subTitle"
                     @click="openmoreDetailsWrap"
                     :class="{hightLightBtn:hightLightBtn}">
                  年度燃油费用与里程对比
                </div>
              </div>
            </div>
            <!-- 浮动费用对比 -->
            <div class="costBenchmarkDetailsWrap">
              <div class="subTilte">浮动费用对比</div>
              <!-- bar图 -->
              <div class="benchmarkCostPieChartWrap">
                <div class="benchmarkCostPieChartTitleWrap">
                  <div class="title">年度各项费用占比</div>
                  <div class="selectDateWrap">
                    <div class="title">统计周期</div>
                    <div class="selectDate">
                      <key-value-select width="100px"
                                        :data="years"
                                        @up="selectYear_fixed"></key-value-select>
                    </div>
                  </div>
                </div>
                <!-- pie饼图 -->
                <div class="benchmarkCostPieChart">
                  <loading :data="costStatisticsPie_fixedData">
                    <ring-and-legend chartTheme="dark"
                                     :data="costStatisticsPie_fixedData"
                                     :color="ringAndLegendColor"
                                     marginLeft="0px"></ring-and-legend>></loading>
                </div>
              </div>
            </div>
            <!-- 各年度各项费用变化趋势 -->
            <div class="costChangeTrend">
              <div class="subTitle">
                各年度各项费用变化趋势
              </div>
              <!-- line 图 -->
              <div class="costChangeTrendLineChart">
                <loading :data="carCostStatisticsData">
                  <lineDataZoom chartTheme="dark"
                                :data="carCostStatisticsData.fixed.statistics"
                                :color="lineDataZoomColor"
                                :areaOpacity=0.3
                                yaxisName="费用(元)"
                                 :dataZoom=false></lineDataZoom>
                </Loading>
              </div>
            </div>
            <!-- 显示耗油警示 -->
            <div class="fuelWarning"
                 v-if="getoilConsumptionAlert">耗油高</div>
          </div>



          <!--/////////////////////////////////////////////////////////////// -->
          <!-- 固定费用详情 -->
          <div class="detailsWrap fixedCost"
               v-if="!costDetailsShow">
            <!-- 各项固定费用统计 -->
            <div class="costStatisticsDetailsWrap">
              <div class="subTilte">各项固定费用统计</div>
              <!-- bar图 -->
              <div class="costStatisticsBarChart">
                <loading :data="carCostStatisticsData">
                  <bar-stack chartTheme="dark"   
                             :data="carCostStatisticsData.float.statistics"
                             :color="barStackColor"
                             yName="费用(元)"></bar-stack>
                </Loading>
              </div>
            </div>
            <!-- 固定费用对比 -->
            <div class="costBenchmarkDetailsWrap">
              <div class="subTilte">固定费用对比</div>
              <!-- bar图 -->
              <div class="benchmarkCostPieChartWrap">
                <div class="benchmarkCostPieChartTitleWrap">
                  <div class="title">年度各项费用占比</div>
                  <div class="selectDateWrap">
                    <div class="title">统计周期</div>
                    <div class="selectDate">
                      <key-value-select width="100px"
                                        :data="years"
                                        @up="selectYear_float"></key-value-select>
                    </div>
                  </div>
                </div>
                <!-- pie饼图 -->
                <div class="benchmarkCostPieChart">
                  <loading :data="costStatisticsPie_floatData">
                    <ring-and-legend chartTheme="dark"   
                                     :data="costStatisticsPie_floatData"
                                     :color="ringAndLegendColor"
                                     marginLeft="0px"></ring-and-legend>
                  </loading>
                </div>
              </div>
            </div>
            <!-- 各年度各项费用变化趋势 -->
            <div class="costChangeTrend">
              <div class="subTitle">
                各年度各项费用变化趋势
              </div>
              <!-- line 图 -->
              <div class="costChangeTrendLineChart">
                <loading :data="carCostStatisticsData">
                  <lineDataZoom chartTheme="dark"   
                                :data="carCostStatisticsData.float.statistics"
                                :color="lineDataZoomColor"
                                :areaOpacity=0.3
                                yaxisName="费用(元)"
                                :dataZoom=false></lineDataZoom>
                </loading>
              </div>
            </div>
          </div>
        </div>
      </pop-up-frame>
    </div>
    <!-- 二级弹出框详情 -->
    <div class="moreDetailsPopupWrap"
         v-if="moreDetailsPopupWrapShow"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-frame @close='closeMoreDetailsPopupShow'>
        <pop-up-widget title="年度燃油费用与里程对比"
                       :detailsBtnShow='false'></pop-up-widget>
        <!-- 二级详情弹出内容: barchart -->
        <div class="moreDetailsPopup">
          <loading :data="carFuelvsMileageData">
            <lineDoubleAxis chartTheme="dark"
                            :data="lineDoubleAxisData"
                            :color="lineDoubleAxisColor"
                            :dataZoom=false
                            :property="lineDoubleProperty"
                            yaxisNameL="费用(元)"
                            yaxisNameR="里程(km)"></lineDoubleAxis>
          </loading>
        </div>
      </pop-up-frame>
    </div>
    <!-- 调用数据 -->
    <div v-show="false">{{getCostStatisticsPieData}}</div>
    <!-- <div v-show="false">{{getoilConsumptionAlert}}</div> -->
  </div>
</template>
<script>
import _ from 'lodash'
import { mapState, mapMutations, mapActions } from 'vuex'
import PopUpFrame from '@/components/PopUpFrame'
import PopUpWidget from '@/components/PopUpWidget'
import KeyValueSelect from '@/components/KeyValueSelect'
import ringAndLegend from '@/components/charts/ringAndLegend'
import lineDataZoom from '@/components/charts/lineDataZoom'
import BarStack from '@/components/charts/BarStack'
import lineDoubleAxis from '@/components/charts/lineDoubleAxis'
import xxx from '../../../util/dictionary'

export default {
  components: {
    PopUpFrame,
    PopUpWidget,
    BarStack,
    KeyValueSelect,
    ringAndLegend,
    lineDataZoom,
    lineDoubleAxis,
  },
  data() {
    return {
      move: false,
      costStatisticsDetailsShow: false,
      costDetailsShow: true,
      moreDetailsPopupWrapShow: false,
      hightLightBtn: false,
      years: [...xxx.date.year],
      ringAndLegendColor: [
        '#05d0eb',
        '#81d9e5',
        '#f6ffcb',
        '#e75029',
        '#038bfc',
        '#006a55',
      ],
      lineDataZoomColor: [
        '#05d0eb',
        '#81d9e5',
        '#f6ffcb',
        '#e75029',
        '#038bfc',
        '#006a55',
      ],
      barStackColor: [
        '#05d0eb',
        '#81d9e5',
        '#f6ffcb',
        '#e75029',
        '#038bfc',
        '#006a55',
      ],
      lineDoubleAxisColor: [
        '#05d0eb',
        '#81d9e5',
        '#f6ffcb',
        '#e75029',
        '#038bfc',
        '#006a55',
      ],
      lineDoubleAxisData: null,
      lineDoubleProperty: null,
      costStatisticsPie_floatData: null,
      costStatisticsPie_fixedData: null,
      // 耗油高
      oilConsumptionShow: false,
    }
  },
  computed: {
    ...mapState('carListCostsContainer', ['clfytjData']),
    ...mapState('costStatisticPopupContainer', ['showCostStatisticsDetails']),
    ...mapState('carModelsSearchContainer', ['fuelCost', 'vehicle_id']),
    ...mapState('costStatisticPopupContainer', [
      'carCostStatisticsData',
      'carFuelvsMileageData',
    ]),
    getCostStatisticsPieData() {
      this.lineDoubleProperty = [
        {
          name: this.carFuelvsMileageData[0].name,
          type: 'bar',
          axis: 0,
        },
        {
          name: this.carFuelvsMileageData[1].name,
          type: 'line',
          axis: 1,
        },
      ]
      this.lineDoubleAxisData = this.carFuelvsMileageData.map(o => ({
        name: o.name,
        data: o.data,
      }))
      const defaultYear = this.years[0].value
      // 固定费用
      this.costStatisticsPie_floatData = this.carCostStatisticsData.float.ratio[
        `${defaultYear}`
      ]
      // 打印固定费用
      // console.log('costStatisticsPie_floatData',
      // JSON.stringify(this.costStatisticsPie_floatData))
      this.costStatisticsPie_fixedData = this.carCostStatisticsData.fixed.ratio[
        `${defaultYear}`
      ]
      return null
    },
    getoilConsumptionAlert() {
      if (this.fuelCost && this.vehicle_id) {
        const now_date = String(new Date().getFullYear() - 1)

        const defaultFuelCost = Number(this.fuelCost.filter(
        o => o.vehicle_id === this.vehicle_id && o.year === now_date)[0].fuel_cost)

        const now_fuelCost_max = _.max(this.fuelCost.filter(o => o.year === now_date)
                                .map(o => Number(o.fuel_cost)))
        const result = !(defaultFuelCost < now_fuelCost_max)
        return result
      }
      return false
    },
  },
  methods: {
    ...mapMutations('costStatisticPopupContainer', ['closeDetailsShow']),
    ...mapActions('costStatisticPopupContainer', ['getcarFuelvsMileage']),
    ...mapActions('carModelsSearchContainer', ['getfuel']),
    getFloatCostDetails() {
      this.costDetailsShow = true
    },
    getFixedCostDetails() {
      this.costDetailsShow = false
    },
    // 固定费用---下拉年份
    selectYear_float(item) {
      this.costStatisticsPie_floatData = this.carCostStatisticsData.float.ratio[
        `${item}`
      ]
      // console.log(`固定费用---costStatisticsPie_floatData${item}`,
      //  JSON.stringify(this.costStatisticsPie_floatData))
    },
    //  浮动费用---下拉年份
    selectYear_fixed(item) {
      this.costStatisticsPie_fixedData = this.carCostStatisticsData.fixed.ratio[
        `${item}`
      ]
    },
    closeMoreDetailsPopupShow() {
      this.moreDetailsPopupWrapShow = false
      this.hightLightBtn = false
    },
    openmoreDetailsWrap() {
      this.moreDetailsPopupWrapShow = !this.moreDetailsPopupWrapShow
      this.hightLightBtn = !this.hightLightBtn
    },
  },
  mounted() {
    this.getfuel()
  },
}
</script>
<style lang="scss" scoped>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.clearfix {
  &:before,
  &:after {
    content: "";
    display: table;
  }
  &:after {
    clear: both;
    overflow: hidden;
  }
}
.costStatisticsDetailsPopupbig_wrap {
  width: 100%;
  .costStatisticsDetailsPopupWrap {
    width: 100%;
    .btnWrap {
      width: 100%;
      .title {
        width: 200px;
        height: 25px;
        line-height: 25px;
        color: #fff;
        font-size: 14px;
        text-align: center;
        border: 1px solid rgba(0, 191, 229, 1);
        background: rgba(0, 191, 229, 0.5);
        box-sizing: border-box;
        float: left;
        margin-right: 20px;
        cursor: pointer;
      }
      .box_off {
        color: #b5b5b5;
        background: rgba(0, 191, 229, 0.2);
      }
      .title:hover {
        color: #fff;
      }
    }
    .detailsWrap {
      width: 100%;
      margin-top: 10px;
      .costStatisticsDetailsWrap {
        width: 100%;
        height: 270px;
        .subTilte {
          width: 200px;
          height: 25px;
          line-height: 25px;
          color: #89dddf;
          text-align: center;
          font-size: 16px;
          background: rgba(129, 217, 229, 0.3);
        }
        .costStatisticsBarChart {
          width: 100%;
          height: 195px;
          margin-top: 10px;
        }
        .moreDetailsWrap {
          width: 100%;
          margin-top: 10px;
          .subTitle {
            width: 200px;
            height: 30px;
            float: right;
            line-height: 30px;
            color: #b5b5b5;
            font-size: 14px;
            text-align: center;
            background: rgba(0, 91, 127, 0.5);
            margin-left: 10px;
            cursor: pointer;
          }
          .subTitle:hover {
            color: #fff;
          }
          .hightLightBtn {
            background: #005b7f;
            color: #fff;
          }
        }
        // 二级弹出框详情
        .moreDetailsPopupWrap {
          width: 750px;
          position: absolute;
          top: 330px;
          left: 750px;
          z-index: 32;
          .moreDetailsPopup {
            height: 200px;
          }
        }
      }
      .costBenchmarkDetailsWrap {
        width: 100%;
        height: 270px;
        .subTilte {
          width: 200px;
          height: 25px;
          line-height: 25px;
          padding-left: 23px;
          color: #89dddf;
          font-size: 16px;
          background: rgba(129, 217, 229, 0.3);
          box-sizing: border-box;
        }
        .benchmarkCostPieChartWrap {
          width: 100%;
          height: 235px;
          margin-top: 10px;
          .benchmarkCostPieChartTitleWrap {
            width: 100%;
            height: 25px;
            .title {
              width: 200px;
              font-size: 14px;
              color: #89dddf;
              line-height: 25px;
              float: left;
            }
            .selectDateWrap {
              width: 210px;
              height: 25px;
              float: right;
              .title {
                width: 100px;
                text-align: center;
                line-height: 25px;
                float: left;
                color: #b5b5b5;
                font-size: 14px;
                margin-right: 10px;
                float: left;
              }
              .selectDate {
                width: 100px;
                float: left;
              }
            }
          }
          .benchmarkCostPieChart {
            height: 205px;
            margin-top: 10px;
          }
        }
      }
      .costChangeTrend {
        width: 100%;
        margin-top: 10px;
        .subTitle {
          font-size: 14px;
          line-height: 14px;
          color: #89dddf;
        }
        .costChangeTrendLineChart {
          height: 200px;
          width: 100%;
          margin-top: 10px;
        }
      }
      // 显示耗油警示
      .fuelWarning {
        width: 85px;
        height: 30px;
        position: absolute;
        top: 100px;
        right: 20px;
        color: #e75029;
        font-size: 14px;
        font-weight: bold;
        text-align: right;
        background: url(../../../assets/car/css_sprite_car-01.png) no-repeat -1000px -128px;
      }
    }
  }
  // 二级弹出框详情
  .moreDetailsPopupWrap {
    width: 750px;
    position: absolute;
    top: 330px;
    left: 750px;
    z-index: 32;
    .moreDetailsPopup {
      height: 200px;
    }
  }
}
</style>
