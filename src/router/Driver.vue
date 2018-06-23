<template>
  <div class='driver'>
    <header class="driver_header">
      <div class="driver_title fl" @click='$router.push("/")'>亿顺凯危货运输有限公司</div>
      <div class="driver_name">
        危货运输人员管理
        <i></i>
      </div>
      <div class="driver_datetime fr">
        <div class="driver_time fr">
          {{time}}
        </div>
        <div class="driver_date fr">
          {{day}}
        </div>
      </div>
    </header>
    <div class="driver_content">
      <!-- <div class="driver_container"> -->
        <router-view></router-view>
      <!-- </div> -->

    </div>
    <!-- <footer class="driver_footer">

    </footer> -->
  </div>
</template>
<script>
export default {
  name: 'driver',
  data() {
    return {
      time: '',
      day: '',
      detail: false,
    }
  },

  methods: {
    nav() {
      this.detail = !this.detail
      if (this.detail) {
        this.$router.push('/driver/detail')
      } else {
        this.$router.push('/driver')
      }
    },
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
  mounted() {
    setInterval(() => {
      this.showTime()
    }, 1000)
  },
}
</script>
<style lang="scss" scoped>
.driver {
  width: 1920px;
  height: 1080px;
  overflow: hidden;
  background-color: black;
  // background: url("../assets/driver/bg_driver-01.png");
  // background-size: 1920px 1080px;
  .driver_header {
    width: 100%;
    height: 80px;
    overflow: hidden;
    margin-top: 20px;
    position: relative;
    background: url("../assets/driver/header_bg.png");
  }
  .driver_title {
    width: 630px;
    height: 60px;
    overflow: hidden;
    margin-top: 10px;
    background: url("../assets/driver/title_top_bg.png") no-repeat;
    color: #81d9e5;
    font-size: 30px;
    font-weight: bold;
    line-height: 60px;
    padding-left: 75px;
    box-sizing: border-box;
    cursor: pointer;
  }
  .driver_name {
    width: 500px;
    height: 60px;
    overflow: hidden;
    // background-size: 100% 100%;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    color: #81d9e5;
    font-size: 24px;
    font-weight: bold;
    text-indent: 180px;
    line-height: 60px;
    background: url("../assets/driver/page_top_bg.png");
    i {
      width: 32px;
      height: 32px;
      display: inline-block;
      position: absolute;
      top: 15px;
      left: 100px;
      background: url(../assets/driver/people_icon.png) no-repeat center center;
    }
  }
  .driver_datetime {
    width: 400px;
    height: 60px;
    overflow: hidden;
    background: url("../assets/driver/time_top_bg.png");
    // background-size: 100% 100%;
    margin-top: 10px;
  }
  .driver_date {
    color: #81d9e5;
    font-size: 28px;
    line-height: 60px;
    margin-right: 40px;
  }
  .driver_time {
    color: #81d9e5;
    font-size: 34px;
    font-weight: bold;
    line-height: 60px;
    margin-right: 50px;
  }
  .driver_content {
    width: 1890px;
    height: 950px;
    overflow: hidden;
    margin: 15.5px 15px 15px 15px;
  }
  .driver_footer {
    width: 100%;
    // width: 2460px;
    height: 10px;
    overflow: hidden;
    background: url("../assets/car/footer_line.png") no-repeat;
    // background-size: 100%;
  }
}
</style>
