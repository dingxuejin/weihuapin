<template>
  <div class="company_manage_waybill_content_ratio_wrap">
    <!-- line图 -->
    <div class="company_manage_waybill_content_statistic_line_wrap">
      <lineChart chartTheme="dark"
                 :data="waybillYearOnYearThisMonth"
                 yaxisName="占比(100%)"
                 v-if="waybillYearOnYearThisMonth"></lineChart>
      <loading :data="waybillYearOnYearThisMonth"></loading>
    </div>
  </div>
</template>
<script>
import { mapState } from 'vuex'
import lineChart from '../../../components/charts/lineChart'

export default {
  components: {
    lineChart,
  },
  computed: {
    ...mapState('waybillYearOnYearThisMonth', ['waybillYearOnYearThisMonth']),
  },
}
</script>
<style lang="scss" scoped>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.company_manage_waybill_content_ratio_wrap {
  @include size(100%,200px);
  .company_manage_waybill_content_statistic_line_wrap {
    @include size(100%,200px);
    margin-top: 10px;
  }
}
</style>