<template>
  <div class="driverBehaviorCountInfo">
    <!-- 驾驶行为报警次数统计 -->
    <div class="mileageWrap">
      <driver-behavior-alarm-info></driver-behavior-alarm-info>
    </div>

    <!-- 驾驶行为标准速度差统计 -->
    <div class="workWrap">
      <driver-behavior-speed-count-info></driver-behavior-speed-count-info>
    </div>
  </div>
</template>

<script type="text/javascript">
import DriverBehaviorAlarmInfo from '../driverbehavioralarmcountinfo/DriverBehaviorAlarmInfo'
import DriverBehaviorSpeedCountInfo from '../driverbehaviorspeedcountinfo/DriverBehaviorSpeedCountInfo'

export default {
  name: 'workCountInfo',
  components: {
    DriverBehaviorAlarmInfo,
    DriverBehaviorSpeedCountInfo,
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
.driverBehaviorCountInfo{
  // 行驶里程统计
  >div{
    width:100%;
    min-height:310px;
    // background: green;
  }

  >div:nth-child(n+2){
    margin-top:20px;
  }
}

</style>