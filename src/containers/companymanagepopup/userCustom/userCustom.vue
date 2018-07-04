<template>
  <div class="custom-container"
       v-if="computeShow"
       @mousedown.stop="isStopMaopao=true">
    <!-- 自定义 -->
    <div class="user-custom"
         v-drag
         @mousedown.stop="move=true"
         @mouseup="move=false"
         :style="{cursor,top,left}">
      <div>
        <pop-up-frame @close='closePopFrame()'>
          <pop-up-widget title="自定义"></pop-up-widget>
          <div>
            <slot></slot>
          </div>
        </pop-up-frame>

      </div>

    </div>

  </div>

</template>
<script>
import popUpFrame from '../../../components/PopUpFrame'
import popUpWidget from '../../../components/PopUpWidget'

export default {
  props: ['top', 'left', 'isShow'],
  data() {
    return {
      isStopMaopao: false,
      move: false,
    }
  },
  methods: {
    closePopFrame() {
      this.$emit('close')
    },
  },
  computed: {
    cursor() {
      if (this.move) {
        return 'move'
      }
      return ''
    },
    computeShow() {
      return this.isShow
    },
  },
  components: { popUpFrame, popUpWidget },
}
</script>
<style scoped>
.custom-container {
  width: 100vw;
  height: 100vh;
  position: fixed;
  top: 0px;
  left: 0px;
  background: rgba(0, 0, 0, 0.3);
  z-index: 2;
}
.user-custom {
  width: 600px;
  min-width: 500px;
}
</style>

