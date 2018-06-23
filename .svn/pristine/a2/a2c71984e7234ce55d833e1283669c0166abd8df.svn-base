<template>
  <div class="alarmEvent">
    <div class="header">
      <span>报警事件排名（风险因素排名）</span>
    </div>
    <div class="alarmEvent_title">{{title}}</div>
    <div class="alarmEvent_content">
      <barhor chartTheme="dark"
              v-if="barhorData"
              :data="barhorData"
              :color="barhorColor"></barhor>
    </div>
  </div>
</template>

<script>
import { mapState, mapMutations } from 'vuex'

import barhor from '../../../components/charts/barhor'

export default {
  components: {
    barhor,
  },
  data: () => ({
    title: '高频不良驾驶行为',
    barhorData: [
      {
        data: [
          {
            name: '左顾右盼',
            value: 12,
          },
          {
            name: '分身提醒',
            value: 10,
          },
          {
            name: '变道频次',
            value: 7,
          },
          {
            name: '急加速',
            value: 5,
          },
          {
            name: '车距过近',
            value: 3,
          },
        ],
      },
    ],
    barhorColor: ['#05d0eb', '#81d9e5', '#f6ffcb', '#e75029', '#038bfc'],
  }),
  computed: {
    ...mapState('accidentView', ['accidentList']),
    ...mapState('scoreAndRankingOfSafetyEvaluation', ['badDriver']),
  },
  methods: {
    ...mapMutations('popupSecContainer', ['getComDetails']),
    // openDetail(item) {
    //   console.log('badDriver', this.badDriver)
    //   this.getComDetails(item)
    // },
    // getBadDriver() {
    //   return [
    //     {
    //       data: this.badDriver
    //         .map(item => ({
    //           name: item.jssjlx.drive_event_type,
    //           value: item['sum(alarm_quantity)'],
    //         }))
    //         .sort((a, b) => b.value - a.value),
    //     },
    //   ]
    // },
  },
}
</script>

<style lang="scss" scoped>
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.alarmEvent {
  @include size(100%,240px);
  .header {
    @include size(100%,25px);
    background: rgba(129, 217, 299, 0.3);
    position: relative;
    font-size: 16px;
    color: #89dddf;
    line-height: 25px;
    text-indent: 20px;
  }
  &_title {
    @include size(200px,25px);
    line-height: 25px;
    background: rgba(231, 80, 41, 0.3);
    color: #e75029;
    font-size: 16px;
    text-align: center;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    margin-left: 21px;
    margin-top: 12px;
  }
  &_content{
    @include size(100%, 185px);
    float: left;
  }
}
</style>
