<template>
  <div class="popDriverMileage">
    <pop-up-widget title='行驶里程统计'></pop-up-widget>
    <div class="popDriverMileage_legend" v-if="barhorEventData">
      <div></div>
      <div>公里数(公里)</div>
    </div>
    <div class="popDriverMileage_charts" v-if="barhorEventData">
      <barhor-sort chartTheme="dark" :data="barhorEventData"></barhor-sort>
    </div>
  </div>
</template>
<script>
// import { mapState } from 'vuex'
import PopUpWidget from '../../../components/PopUpWidget'
import barhorSort from '../../../components/charts/barhorSort'

export default {
  components: {
    PopUpWidget,
    barhorSort,
  },
  computed: {
    // ...mapState('popupdriverhealthy', ['healthyData']),
    // getBarhorEventData() {
    //   const b = this.barhorEventData.sort((a, b) => a.value > b.value)
    //   return b
    // },
  },
  data() {
    return {
      // activeTagKey: 1,
      barhorEventData: [
        { name: '危险路段报警1', value: 555 },
        { name: '危险路段报警2', value: 112 },
        { name: '危险路段报警3', value: 200 },
        { name: '危险路段报警4', value: 114 },
        { name: '危险路段报警5', value: 115 },
        { name: '危险路段报警6', value: 16 },
      ],
      // barhorEventData: [
      //   {
      //     name: '公里数(公里)',
      //     data: [
      //       { name: '危险路段报警1', value: 555 },
      //       { name: '危险路段报警2', value: 112 },
      //       { name: '危险路段报警3', value: 200 },
      //       { name: '危险路段报警4', value: 114 },
      //       { name: '危险路段报警5', value: 115 },
      //       { name: '危险路段报警6', value: 16 },
      //     ],
      //   },
      // ],
    }
  },
  methods: {
    // selectTag(item) {
    //   this.activeTagKey = item
    // },
  },
}
</script>
<style lang="scss" scoped>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.popDriverMileage{
  @include size(550px,100%);
  position: relative;
  &_legend{
    @include size(120px,20px);
    margin-right: 33.4px;
    margin-top:3px;
    position: absolute;
    right:0;
    div{
      &:nth-child(1){
        @include size(11.5px,2px);
        background: #89DDDF;
        position: absolute;
        top:10px;
        left:20px;
      }
      &:nth-child(2){
        @include size(120px,20px);
        color: #B5B5B5;
        font-size: 14px;
        text-align: right;
        line-height: 20px;

      }
    } 
  }
  &_charts{
    @include size(550px,170px);
    margin-top:40px;
  }
}
</style>
