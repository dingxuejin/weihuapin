<template>
  <div class="costRatio_content">
    <div class="title clearfix">
      成本比例变化趋势
      <div class="detailsBtn fr"
           @click="getDetails"></div>
    </div>
    <div class="chartsCon"
         v-if="costRatio">
      <lineDataZoom chartTheme="dark"
                    :data="costRatio"
                    :color="lineDataZoomColor"
                    :areaOpacity=0.3
                    :dataZoom=false
                    yaxisName="费用(万元)"></lineDataZoom>
    </div>
  </div>
</template>

<script type="text/javascript">
import { mapState, mapMutations } from 'vuex'
import lineDataZoom from '../../../components/charts/costRatioLineDataZoom'

export default {
  name: '',
  components: {
    lineDataZoom,
  },
  computed: {
    ...mapState('manageCostRatio', ['costRatio']),
    ...mapState('popupContainer', ['cost_trend_float']),
  },
  data() {
    return {
      lineDataZoomColor: [
        '#05d0eb',
        '#81d9e5',
        '#f6ffcb',
        '#e75029',
        '#038bfc',
        '#006a55',
      ],
    }
  },
  methods: {
    ...mapMutations('popupContainer', ['getComDetails']),

    getDetails() {
      this.getComDetails('costRatio')
      // console.log('awefwae')
      // if (this.cost_trend_float) {

      // }
    },
  },
}
</script>

<style lang="scss" scoped>
@mixin font_level_3 {
  color: #89dddf;
  font-size: 16px; // font-weight:bold;
}

.costRatio_content {
  width: 100%;
  height: 100%;
  // overflow: hidden; 
  //   background: green;
  //标题
  .title {
    width: 440px;
    height: 25px;
    overflow: hidden;
    background: rgba(129, 217, 229, 0.3);
    text-indent: 20px;
    line-height: 25px;
    @include font_level_3; // 详情按钮
    position: relative;
    .detailsBtn {
      width: 25px;
      height: 25px;
      overflow: hidden;
      margin-top: 0px;
      margin-right: 10px;
      background: url("../../../assets/companymanage/drill_icon_off.png")
        no-repeat center center;
      cursor: pointer;
    }
    .detailsBtn:hover {
      background: url("../../../assets/companymanage/drill_icon_on.png")
        no-repeat center center;
    }
  } // 图表
  .chartsCon {
    width: 100%;
    height: 165px;
    margin-top: 10px;
  }
}
</style>
