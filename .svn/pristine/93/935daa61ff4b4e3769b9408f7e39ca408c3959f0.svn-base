<template>
  <div class="popupBox_outframe_wrap clearfix">
    <pop-up-frame @close='closeDetails'>
      <pop-up-widget :title="title"></pop-up-widget>
      <!-- 弹框主要内容 -->
      <div class="popupBox_outframe_mainContent clearfix">
        <slot></slot>
      </div>
    </pop-up-frame>
  </div>
</template>
<script>
import PopUpFrame from '@/components/PopUpFrame'
import PopUpWidget from '@/components/PopUpWidget'

import {
  mapState,
  mapMutations,
} from '../../../../node_modules/_vuex@3.0.1@vuex'

export default {
  props: ['title'],
  components: {
    PopUpFrame,
    PopUpWidget,
  },
  data() {
    return {}
  },
  computed: {
    ...mapState('warningCarouselpopupContainer', [
      // 弹框显示/隐藏：
      'detailsShow',
    ]),
  },
  methods: {
    ...mapMutations('warningCarouselpopupContainer', ['closeComDetails']),
    // 关闭弹窗
    closeDetails() {
      this.closeComDetails()
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
.popupBox_outframe_wrap {
  width: 100%;
  .popupBox_outframe_mainContent {
    width: 100%;
    margin-top: 10px;
  }
}
</style>