<template>
  <div class="popupframe clearfix">
    <div class="popupframe_close"
         @click="close">×</div>
    <slot></slot>
  </div>
</template>

<script>
export default {
  name: 'popupframe',
  components: {},
  data() {
    return {}
  },

  methods: {
    close() {
      this.$emit('close')
    },
  },
  mounted() {},
}
</script>
<style lang="scss" scoped>
.popupframe {
  width: 100%;
  height: 100%;
  border: 1px solid #05d0eb;
  box-sizing: border-box;
  position: relative;
  &_close {
    width: 36px;
    height: 36px;
    line-height: 28px;
    text-align: center;
    color: #05d0eb;
    font-size: 48px;
    border: 1px solid #05d0eb;
    box-sizing: border-box;
    position: absolute;
    top: -18px;
    right: -18px;
    background:#000;
  }
  &_close:hover {
    color: #fff;
    cursor: pointer;
  }
}
</style>

