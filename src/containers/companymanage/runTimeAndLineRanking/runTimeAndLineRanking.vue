<template>

  <div class="runtimecontainer">
    <div class="flex-between">
      <div @click="active=0">
        <run-real-title title='运输时段运行车辆次数分布'
                        :isDian='false'
                        width='240px'
                        class="point"
                        :isActive='active==0'></run-real-title>
      </div>

      <div @click="active=1">
        <run-real-title title='路线排名'
                        :isDian='true'
                        width='150px'
                        class="point"
                        :isActive='active==1'
                        @openDetail="getDetails"></run-real-title>
      </div>
    </div>
    <!-- 运输时段运行车辆次数分布 -->
    <div v-if="active==0">
      <run-time></run-time>
    </div>
    <!-- 线路排名 -->
    <div v-if="active==1">
      <line-ranking></line-ranking>
    </div>

  </div>
</template>
<script>
import { mapMutations } from 'vuex'
import runTime from '../runTime/runTime'
import lineRanking from '../lineRanking/lineRanking'
import RunRealTitle from '../../../components/companymanage/RunRealTitle'


export default {
  name: 'runTimeAndLineRanking',
  data() {
    return {
      active: 0,
    }
  },
  methods: {
    ...mapMutations('popupContainer', ['getComDetails']),
    getDetails() {
      this.getComDetails('lineRank')
    },
  },
  components: {
    runTime,
    RunRealTitle,
    lineRanking,
  },
}
</script>

<style scoped>
.runtimecontainer {
  width: 400px;
  height: 270px;
  overflow: hidden;
}
.point {
  cursor: pointer;
}
</style>
