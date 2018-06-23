<template>
  <div class="cost_ratio_trend_content_wrap">
    <div class="cost_ratio_trend_toggleTitle_wrap clearfix">
      <div class="cost_ratio_trend_toggleTitle"
           :class="{cost_ratio_trend_toggleTitle_box_on:option===1}"
           @click="option=1">年度周转量成本统计</div>
      <div class="cost_ratio_trend_toggleTitle"
           :class="{cost_ratio_trend_toggleTitle_box_on:option===2}"
           @click="option=2">年度变动成本统计</div>
      <div class="cost_ratio_trend_toggleTitle"
           :class="{cost_ratio_trend_toggleTitle_box_on:option===3}"
           @click="option=3">年度固定成本统计</div>
    </div>
    <!-- 固定成本 -->
    <div class="cost_ratio_trend_fixed_wrap"
         v-if="option===1">
      <line-data-zoom chartTheme="dark"
                 :data="yearCostTrendFixed"
                 yaxisName="line"></line-data-zoom>
      <loading :data="yearCostTrendFixed"></loading>
    </div>
    <!-- 周转量成本 -->
    <div class="cost_ratio_trend__wrap"
         v-if="option===2">
     <line-data-zoom chartTheme="dark"
                 :data="yearCostTrendTurnover"
                 yaxisName="line"></line-data-zoom>
      <loading :data="yearCostTrendTurnover"></loading>
    </div>
    <!-- 变动成本 -->
    <div class="cost_ratio_trend_variation_wrap"
         v-if="option===3">
     <line-data-zoom chartTheme="dark"
                 :data="yearCostTrendFloat"
                 yaxisName="line"></line-data-zoom>
      <loading :data="yearCostTrendFloat"></loading>
    </div>
  </div>
</template>
<script>
import { mapState } from 'vuex'
import lineDataZoom from '../../../components/charts/lineDataZoom'

export default {
  components: {
    lineDataZoom,
  },
  computed: {
    ...mapState('yearCostTrend', [
      'yearCostTrendFixed',
      'yearCostTrendTurnover',
      'yearCostTrendFloat',
    ]),
  },
  data: () => ({
    option: 1,
  }),
}
</script>
<style lang="scss" scoped>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.cost_ratio_trend_content_wrap {
  @include size(100%,235px);
  margin-top: 10px;
  .cost_ratio_trend_toggleTitle_wrap {
    @include size(100%,25px);
    .cost_ratio_trend_toggleTitle {
      @include size(160px,25px);
      line-height: 25px;
      float: right;
      margin-left: 10px;
      color: #b5b5b5;
      font-size: 14px;
      text-align: center;
      background: rgba(0, 191, 229, 0.2);
      cursor: pointer;
    }
    .cost_ratio_trend_toggleTitle:hover {
      color: #fff;
      background: rgba(0, 191, 229, 0.5);
    }
    .cost_ratio_trend_toggleTitle_box_on {
      color: #fff;
      background: rgba(0, 191, 229, 0.5);
    }
  }
    .cost_ratio_trend_fixed_wrap {
      @include size(710px,200px);
    }
    .cost_ratio_trend_turnover_wrap {
      @extend .cost_ratio_trend_fixed_wrap;
    }
    .cost_ratio_trend_variation_wrap {
      @extend .cost_ratio_trend_fixed_wrap;
    }
}
</style>
