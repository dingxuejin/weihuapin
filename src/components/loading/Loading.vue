<template>
  <div class="loader">
    <div  v-if="getLoadingData" class="loader-inner ball-spin-fade-loader fix_position">
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
    </div>
    <div v-else-if="getNoData"
         class='nodata'>
      暂无数据
    </div>
    <slot v-else></slot>
  </div>
</template>
<script>
// import _ from 'lodash'

export default {
  props: ['data'],
  computed: {
    getLoadingData() {
      if (
        Object.prototype.toString.call(this.data) === '[object Undefined]' ||
        Object.prototype.toString.call(this.data) === '[object Null]'
      ) {
        return true
      }
      return false
    },
    getNoData() {
      if (Object.prototype.toString.call(this.data) === '[object Array]') {
        if (this.data.length === 0) {
          return true
        }
        return false
      }
      if (Object.keys(this.data).length === 0) {
        return true
      }
      return false
    },
  },
  methods: {
    // arrayOrObject() {
    //   if (this.data instanceof Object) {
    //     return 'obj'
    //   }
    //   return 'array'
    // },
  },
}
</script>

<style scoped>
.loader {
  width: 100%;
  height: 100%;
  margin: 0 auto;
  position: relative;
}
.nodata {
  color: white;
  margin: 0 auto;
  pointer-events:none;
  /* font-size: 24px; */
  /* width: 100px */
}
.fix_position {
  position: relative;
  top: 45%;
  left: 50%;
  pointer-events:none;
}
@keyframes ball-spin-fade-loader {
  50% {
    opacity: 0.3;
    -webkit-transform: scale(0.4);
    transform: scale(0.4);
  }

  100% {
    opacity: 1;
    -webkit-transform: scale(1);
    transform: scale(1);
  }
}

.ball-spin-fade-loader {
  position: relative;
}
.ball-spin-fade-loader > div:nth-child(1) {
  top: 25px;
  left: 0;
  -webkit-animation: ball-spin-fade-loader 1s 0s infinite linear;
  animation: ball-spin-fade-loader 1s 0s infinite linear;
}
.ball-spin-fade-loader > div:nth-child(2) {
  top: 17.04545px;
  left: 17.04545px;
  -webkit-animation: ball-spin-fade-loader 1s 0.12s infinite linear;
  animation: ball-spin-fade-loader 1s 0.12s infinite linear;
}
.ball-spin-fade-loader > div:nth-child(3) {
  top: 0;
  left: 25px;
  -webkit-animation: ball-spin-fade-loader 1s 0.24s infinite linear;
  animation: ball-spin-fade-loader 1s 0.24s infinite linear;
}
.ball-spin-fade-loader > div:nth-child(4) {
  top: -17.04545px;
  left: 17.04545px;
  -webkit-animation: ball-spin-fade-loader 1s 0.36s infinite linear;
  animation: ball-spin-fade-loader 1s 0.36s infinite linear;
}
.ball-spin-fade-loader > div:nth-child(5) {
  top: -25px;
  left: 0;
  -webkit-animation: ball-spin-fade-loader 1s 0.48s infinite linear;
  animation: ball-spin-fade-loader 1s 0.48s infinite linear;
}
.ball-spin-fade-loader > div:nth-child(6) {
  top: -17.04545px;
  left: -17.04545px;
  -webkit-animation: ball-spin-fade-loader 1s 0.6s infinite linear;
  animation: ball-spin-fade-loader 1s 0.6s infinite linear;
}
.ball-spin-fade-loader > div:nth-child(7) {
  top: 0;
  left: -25px;
  -webkit-animation: ball-spin-fade-loader 1s 0.72s infinite linear;
  animation: ball-spin-fade-loader 1s 0.72s infinite linear;
}
.ball-spin-fade-loader > div:nth-child(8) {
  top: 17.04545px;
  left: -17.04545px;
  -webkit-animation: ball-spin-fade-loader 1s 0.84s infinite linear;
  animation: ball-spin-fade-loader 1s 0.84s infinite linear;
}
.ball-spin-fade-loader > div {
  background-color: #399;
  width: 15px;
  height: 15px;
  border-radius: 100%;
  margin: 2px;
  -webkit-animation-fill-mode: both;
  animation-fill-mode: both;
  position: absolute;
}
</style>