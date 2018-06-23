<template>
  <bm-overlay
    ref="customOverlay"
    class="sample"
    pane="labelPane"
    @draw="draw">
    <slot></slot>
  </bm-overlay>
</template>

<script>
/* eslint-disable */
export default {
  props: ['text', 'position', 'active'],
  watch: {
    position: {
      handler() {
        this.$refs.customOverlay.reload()
      },
      deep: true,
    },
  },
  methods: {
    draw({ el, BMap, map }) {
      const { lng, lat } = this.position
      const pixel = map.pointToOverlayPixel(new BMap.Point(lng, lat))
      el.style.left = `${pixel.x - 60}px`
      el.style.top = `${pixel.y - 20}px`
    },
  },
}
</script>

<style>
.sample {
  position: relative;
}
</style>