<template>
  <div class="carHeaderDate clearfix">
    <!-- <div class="dateText">{{nowday}}</div>
    <div class="timeText">{{nowtime}}</div> -->
  <div class="dateText">{{day}}</div>
    <div class="timeText">{{time}}</div>
  </div>
</template>

<script>
// 时间显示
// function getNowTime() {
//   function setTimeFormat(n) {
//     return n < 10 ? 0 + n : n
//   }
//   const date = new Date()
//   const day = `${date.getFullYear().toString()}.${setTimeFormat(
//     date.getMonth() + 1,
//   )}.${setTimeFormat(date.getDate())}`
//   const time = `${setTimeFormat(date.getHours())}:${setTimeFormat(
//     date.getMinutes(),
//   )}:${setTimeFormat(date.getSeconds())}`
//   return { time, day }
// }
export default {
  name: 'car-header-date',
  data() {
    return {
      // nowday: '',
      // nowtime: '',
      time: '',
      day: '',
    }
  },
  mounted() {
    // setInterval(() => {
    //   this.nowday = getNowTime().day
    //   this.nowtime = getNowTime().time
    // }, 1000),
    setInterval(() => {
      this.showTime()
    }, 1000)
  },
  methods: {
    add0(n) {
      return n < 10 ? `0${n}` : n
    },
    showTime() {
      const date = new Date()
      const day = `${date.getFullYear().toString()}.${this.add0(
        date.getMonth() + 1,
      )}.${this.add0(date.getDate())}`
      const time = `${this.add0(date.getHours())}:${this.add0(
        date.getMinutes(),
      )}:${this.add0(date.getSeconds())}`
      this.time = time
      this.day = day
    },
  },

}
</script>

<style lang="scss" scoped>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.carHeaderDate {
  @include size(400px,60px);
  .dateText {
    @include size(214px,60px);
    line-height: 60px;
    float:left;
    font-weight: bold;
    text-align: center;
    color: #81d9e5;
    text-align: center;
    font-size: 28px;
    margin: 0;
    padding:0;
  }
  .timeText {
    @include size(186px,60px);
    line-height: 60px;
    float:left;
    text-align: left;
     color: #81d9e5;
    font-size: 34px;
    font-weight: bold;
  }
}
</style>
