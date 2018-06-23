<template>
  <div class="illegalBehaviorCountInfoCon">
    <!-- 违法行为报警次数统计 -->
    <div>
        <illegal-behavior-alarm-count></illegal-behavior-alarm-count>
    </div>

    <!-- 违法行为占比统计 -->
    <div>
      <illegal-behavior-proportion-count></illegal-behavior-proportion-count>
    </div>
  </div>
</template>

<script type="text/javascript">
import IllegalBehaviorAlarmCount from '../illegalbehavioralarmcount/IllegalBehaviorAlarmCount'
import IllegalBehaviorProportionCount from '../illegalbehaviorproportioncount/IllegalBehaviorProportionCount'

export default {
  name: 'workCountInfo',
  components: {
    IllegalBehaviorAlarmCount,
    IllegalBehaviorProportionCount,
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
.illegalBehaviorCountInfoCon{
  // 行驶里程统计
  >div{
    width:100%;
    min-height:10px;
    // background: green;
  }

  >div:nth-child(n+2){
    margin-top:20px;
  }
}

</style>