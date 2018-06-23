<template>
  <div class="carListCosts">
    <loading :data="clfytjData">
      <!-- 累计各项费用占比 -->
      <div class="accumulativeRatio">
        <div class="title">累计各项费用占比</div>
        <!-- 饼图 -->

        <div class="accumulativeRatioPie">
          <ringAndLegend chartTheme="dark"
                         :data="getclfytjDataRatio"
                         :color="ringAndLegendColor"></ringAndLegend>
        </div>
      </div>
      <!-- 年度总费用趋势、费用统计信息 -->
      <div class="costsPerYear">
        <div class="title">年度总费用趋势</div>
        <div class="subTitle"
             :class="{btnHightLight:btnHightLight}"
             @click="costStatisticsDetailsBtn">费用统计信息</div>
        <!-- linecharts -->
        <div class="costsPerYearLine">
          <lineDataZoom chartTheme="dark"
                        :data="getLineDataZoomData"
                        :color="lineDataZoomColor"
                        yaxisName="费用(元)"></lineDataZoom>
        </div>
      </div>
    </loading>
    <!-- 详情弹出框 -->
    <div class="costStatisticsDetails clearfix">
      <slot name="costStatisticsDetails"></slot>
    </div>
  </div>
</template>

<script>
// import _ from 'lodash'
import ringAndLegend from '../charts/costRingAndLegend'
import lineDataZoom from '../charts/costLlineDataZoom'
import { mapMutations } from '../../../node_modules/_vuex@3.0.1@vuex'

export default {
  props: ['clfytjData'],
  components: {
    ringAndLegend,
    lineDataZoom,
  },
  data() {
    return {
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
      btnHightLight: false,
    }
  },
  computed: {
    getclfytjDataRatio() {
      // console.log('this.clfytjData:', this.clfytjData)
      if (
        this.clfytjData &&
        this.clfytjData !== undefined &&
        this.clfytjData !== null
      ) {
        const clfytjDataPie = [
          {
            name: '轮胎更换费用',
            value:
              this.clfytjData.ratio[0] &&
              this.clfytjData.ratio[0]['sum(tire_cost)'],
          },
          {
            name: '燃油费用',
            value:
              this.clfytjData.ratio[0] &&
              this.clfytjData.ratio[0]['sum(fuel_cost)'],
          },
          {
            name: '维修费用',
            value:
              this.clfytjData.ratio[0] &&
              this.clfytjData.ratio[0]['sum(repair_cost)'],
          },
          {
            name: '保险费用',
            value:
              this.clfytjData.ratio[0] &&
              this.clfytjData.ratio[0]['sum(insurance_cost)'],
          },
          {
            name: '保养费用',
            value:
              this.clfytjData.ratio[0] &&
              this.clfytjData.ratio[0]['sum(maintain_cost)'],
          },
          {
            name: '检测费用',
            value:
              this.clfytjData.ratio[0] &&
              this.clfytjData.ratio[0]['sum(test_cost)'],
          },
        ]
        // console.log('clfytjDataPie', clfytjDataPie)
        return clfytjDataPie
      }
      return null
    },
    getLineDataZoomData() {
      const sumPerYear =
        this.clfytjData &&
        this.clfytjData !== null &&
        this.clfytjData !== undefined &&
        this.clfytjData.trend &&
        this.clfytjData.trend.map((o) => {
          const name = o.year
          const value =
            o['sum(fuel_cost)'] +
            o['sum(insurance_cost)'] +
            o['sum(maintain_cost)'] +
            o['sum(repair_cost)'] +
            o['sum(test_cost)'] +
            o['sum(tire_cost)']
          return {
            name,
            value,
          }
        })
      const LineDataZoomData = [{ data: sumPerYear }]
      // console.log('LineDataZoomData', LineDataZoomData)
      return LineDataZoomData
    },
  },
  methods: {
    detailsBtn() {
      this.$emit('detailsBtn')
      this.btnHightLight = !this.btnHightLight
    },
    ...mapMutations('costStatisticPopupContainer', ['costStatisticsDetailsBtn']),
  },
}
</script>

<style lang="scss">
@mixin size($width, $height) {
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
.carListCosts {
  // width: 260px;
  height: 100%;
  position: relative;
  top: 0;
  left: 0;
  .accumulativeRatio {
    @include size(250px, 190px);
    // background: red;
    // margin-left: 20px;
    margin-top: 10px;
    float: left;
    position: relative;
    .title {
      @include size(200px, 30px);
      line-height: 30px;
      color: #89dddf;
      font-size: 18px;
      font-weight: bold;
      text-align: center;
      background: #005b7f;
      float: left;
    }
    .accumulativeRatioPie {
      @include size(250px, 190px);
      margin-top: 10px;
      float: left;
    }
  }
  .costsPerYear {
    @extend .accumulativeRatio;
    @include size(275px, 230px);
    // background: pink;
    float: left;
    .title {
      @include size(160px, 30px);
      float: left;
    }
    .subTitle {
      @include size(90px, 25px);
      line-height: 25px;
      color: #b5b5b5;
      font-size: 14px;
      text-align: center;
      float: left;
      margin-top: 2px;
      margin-left: 5px;
      background: rgba(0, 91, 127, 0.5);
      cursor: pointer;
    }
    .subTitle:hover {
      color: #fff;
    }
    .btnHightLight {
      background: #005b7f;
      color: #fff;
    }
    .costsPerYearLine {
      @include size(275px, 190px);
      margin-top: 2px;
      float: left;
    }
  }

  // 详情弹出框
  .costStatisticsDetails {
    width: 750px;
    position: absolute;
    bottom: 95px;
    right: 535px;
    z-index: 33;
  }
}
</style>
