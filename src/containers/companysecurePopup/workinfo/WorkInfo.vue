<template>
  <div class="workCountWrap">
    <!-- 行驶里程统计 -->
    <div class="mileageWrap">
      <work-mileage-count-info></work-mileage-count-info>
    </div>

    <!-- 工作强度统计 -->
    <div class="workWrap">
      <work-strength-count-info></work-strength-count-info>
    </div>

    <!-- 订单统计 -->
    <div class="orderWrap">
      <work-order-count-info></work-order-count-info>
    </div>
  </div>
</template>

<script type="text/javascript">
// 行驶里程二级弹窗
import WorkMileageCountInfo from '../workmileagecountinfo/WorkMileageCountInfo'
// 工作强度二级弹窗
import WorkStrengthCountInfo from '../workstrengthcountinfo/WorkStrengthCountInfo'
// 运单二级弹窗
import WorkOrderCountInfo from '../workordercountinfo/WorkOrderCountInfo'

export default {
  name: 'workCountInfo',
  components: {
    WorkMileageCountInfo,
    WorkStrengthCountInfo,
    WorkOrderCountInfo,
  },
  data() {
    return {}
  },
}
</script>

<style lang="scss" scoped>
@mixin size($w,$h){
  width:$w;
  height:$h;
}
.workCountWrap{
  // 行驶里程统计
  >div{
    @include size(100%,290px);
    // background: red;
  }

  >div:nth-child(n+2){
    margin-top:10px;
  }
}

</style>