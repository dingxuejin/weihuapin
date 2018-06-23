<template>
  <div class="company_secure_driver_danger_outframe_wrap" v-drag @mousedown="move=true" @mouseup="move=false" :style="move?'cursor:move':''">
    <pop-up-frame @close='closeDetails'>
      <pop-up-widget :title="title"></pop-up-widget>
      <!-- 弹框主要内容 -->
      <slot></slot>
    </pop-up-frame>
  </div>
</template>
<script>
import { mapState, mapMutations } from 'vuex'
import PopUpFrame from '@/components/PopUpFrame'
import PopUpWidget from '@/components/PopUpWidget'

export default {
  props: ['title'],
  components: {
    PopUpFrame,
    PopUpWidget,
  },
  data() {
    return {
      move: false,
    }
  },
  computed: {
    ...mapState('popupSecContainer', [
      // 弹框显示/隐藏：
      'detailsShow',
    ]),
  },
  methods: {
    ...mapMutations('popupSecContainer', ['closeComDetails']),
    // 关闭弹窗
    closeDetails() {
      this.closeComDetails(this.title)
    },
  },
}
</script>

<style lang="scss" scoped>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.clearfix {
  &:before,
  &:after {
    content: "";
    display: table;
  }
  &:after {
    clear: both;
    overflow: hidden;
  }
}
.company_secure_driver_danger_outframe_wrap {
  width: 750px;
  .distributeTrendArea_chart {
    width: 100%;
    height: 200px;
    margin-top: 10px;
  }
}
</style>