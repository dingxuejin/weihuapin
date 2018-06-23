<template>
  <div class="company_manage_waybill_content_trend_wrap">
    <div class="company_manage_waybill_content_trend_title_wrap clearfix">
      <div class="company_manage_waybill_content_trend_toggleTitle"
           :class="{trend_line_box_on:option==='toThisDay'}"
           @click="switchType('toThisDay')">本月至今运单数趋势</div>
      <div class="company_manage_waybill_content_trend_toggleTitle"
           :class="{trend_line_box_on:option==='toThisMonth'}"
           @click="switchType('toThisMonth')">本年度至今月运单数趋势</div>
    </div>
    <div class="company_manage_waybill_content_trend_line_wrap">
      <lineDataZoom chartTheme="dark"
                    :data="periodData"
                    yaxisName="运单数(单)"
                    v-if="waybillTrendRecently"></lineDataZoom>
      <loading :data="waybillTrendRecently"></loading>
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
    ...mapState('waybillTrendRecently', ['waybillTrendRecently']),
    periodData() {
      return this.waybillTrendRecently[this.option]
    },
  },
  data: () => ({
    option: 'toThisMonth',
  }),
  methods: {
    switchType(item) {
      // console.log('this item', item)
      this.option = item
    },
  },
}
</script>
<style lang="scss" scoped>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.company_manage_waybill_content_trend_wrap {
  @include size(100%,235px);
  margin-top: 10px;
  margin-bottom: 20px;
  .company_manage_waybill_content_trend_title_wrap {
    @include size(100%,25px);
    margin-top: 10px;
    .company_manage_waybill_content_trend_toggleTitle {
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
    .company_manage_waybill_content_trend_toggleTitle:hover {
      color: #fff;
      background: rgba(0, 191, 229, 0.5);
    }
    .trend_line_box_on {
      color: #fff;
      background: rgba(0, 191, 229, 0.5);
    }
  }
  .company_manage_waybill_content_trend_line_wrap {
    @include size(100%,200px);
    margin-top: 10px;
  }
}
</style>
