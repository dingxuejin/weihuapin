<template>
  <div class="popDriverHeathy">
    <pop-up-widget title='体检信息'></pop-up-widget>
    <div class="popDriverHeathy_content" v-if='healthyData'>
      <div class="itemName">体检时间</div>
      <div class="itemName">体检结果</div>
      <div class="itemCon">{{healthyData.date}}</div>
      <div class="itemCon" :class="healthyData.physical_examination_results!=='良好'?'itemConColor':''">{{healthyData.physical_examination_results}}</div>
    </div>
  </div>
</template>
<script>
import { mapState } from 'vuex'
import PopUpWidget from '../../../components/PopUpWidget'

export default {
  components: {
    PopUpWidget,
  },
  computed: {
    ...mapState('popupdriverhealthy', ['healthyData']),
  },
  data() {
    return {
      activeTagKey: 1,
    }
  },
  methods: {
    selectTag(item) {
      this.activeTagKey = item
    },
  },
}
</script>
<style lang="scss" scoped>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.popDriverHeathy{
  @include size(345px,100%);
  position: relative;
  &_content{
    @include size(100%,90px);
    div{
      @include size(170px,40px);
      float: left;
      margin-right:5px;
      font-size: 16px;
      line-height: 40px;
      text-align: center;
      color: #81D9E5;
      &:nth-child(2n){
        margin-right:0px;
      }
    }
    .itemCon{
      background:rgba(3,139,252,0.4);
      color: #fff;
      font-size: 22px;
    }
    .itemConColor{
      color:red;
    }
  }
}
</style>
