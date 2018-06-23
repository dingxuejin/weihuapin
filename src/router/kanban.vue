<template>
  <div class="kanban-layout"
       @mousemove="onMousemove">
    <!-- header -->
    <header class="heaer clearfix">
      <div class="header-title fl"
           @click='$router.push("/index")'>危货运输安全管理系统</div>
      <div class="header-name">
        企业综合运营看板
      </div>
      <div class="header-time fr clearfix">
        <div class="date">{{day}}</div>
        <div class="time">{{time}}</div>
      </div>
    </header>
    <!-- content -->
    <!-- kanban 页面 -->
    <div class="content">
      <IndexLayout></IndexLayout>
    </div>
    <div class="kanban-layout_right"
         v-show="showRoute">
      <img src="../assets/qiehuanyou.png"
           @click='$router.push("/services")' />
    </div>
    <div class="kanban-layout_left"
         v-show="showRoute">
      <img src="../assets/qiehuanzuo.png"
           @click='$router.push("/")' />
    </div>
  </div>
</template>

<script>
/* eslint-disable */
import IndexLayout from '../containers/kanban/indexLayout.vue'

export default {
  name: 'kanban',
  components: {
    IndexLayout,
  },
  data() {
    return {
      time: '',
      day: '',
      active: false,
      showRoute: true,
    }
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
    // 单击改变背景,改变路由
    switchRouter() {
      // location当前路由地址
      const currentRouter = location.hash
      // console.log('location is', location)
      if (currentRouter === '#/company') {
        // console.log('企业首页router', this.$router)
        this.$router.push('/company/detail')
        this.active = true
      } else {
        // console.log('企业详情router', this.$router)
        this.$router.push('/company')
        this.active = false
      }
    },
    onMousemove() {
      // this.showRoute = true
      // setTimeout(() => {
      //   this.showRoute = false
      // }, 3000)
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
// 企业页布局
.kanban-layout {
  width: 1920px;
  height: 1080px;
  overflow: hidden;
  background: url("../assets/kanban/bg.png") no-repeat center center;
  background-size: 100% 100%;
}
.kanban-layout_right {
  position: fixed;
  right: 5px;
  top: 45%;
  z-index: 111;
  img {
    cursor: pointer;
  }
}
.kanban-layout_left {
  position: fixed;
  left: 5px;
  top: 45%;
  z-index: 111;
  img {
    cursor: pointer;
  }
}
// header
.heaer {
  width: 100%;
  height: 80px;
  overflow: hidden;
  margin-top: 20px;
  position: relative;
  background: url("../assets/kanban/header_bg.png") no-repeat center center;
  background-size: 100% 100%;
}
.header-title {
  width: 476px;
  height: 58px;
  overflow: hidden;
  margin-top: 10px;
  background: url("../assets/kanban/header_name.png") no-repeat center center;
  background-size: 100% 100%;
  color: #81d9e5;
  font-size: 30px;
  font-weight: bold;
  line-height: 60px;
  padding-left: 40px;
  box-sizing: border-box;
  cursor: pointer;
}
.header-name {
  width: 495px;
  height: 58px;
  overflow: hidden;
  background: url("../assets/kanban/system_top_bg.png") no-repeat center center;
  background-size: 495px 58px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  font-size: 24px;
  font-weight: bold;
  text-align: center;
  line-height: 60px;
  color: #81d9e5;
  // cursor: pointer;
  // img{
  //   position: relative;
  //   right: 120px;
  //   top: -8px;
  //   vertical-align: middle;
  // }
}
// 单击改变背景
.switchBg {
  background: url("../assets/kanban/system_top_bg.png") no-repeat center center;
}
.header-time {
  width: 400px;
  height: 60px;
  overflow: hidden;
  background: url("../assets/kanban/header_time.png") no-repeat center center;
  background-size: 100% 100%;
  margin-top: 10px;
  // 时间
  .time {
    // color: #81d9e5;
    // font-size: 34px;
    // font-weight: bold;
    // line-height: 60px;
    // margin-right: 50px;

    width: 186px;
    height: 60px;
    line-height: 60px;
    float: left;
    text-align: left;
    color: #81d9e5;
    font-size: 34px;
    font-weight: bold;
  }
  .date {
    // color: #81d9e5;
    // font-size: 28px;
    // line-height: 60px;
    // margin-right: 40px;

    width: 214px;
    height: 60px;
    line-height: 60px;
    float: left;
    font-weight: bold;
    text-align: center;
    color: #81d9e5;
    text-align: center;
    font-size: 28px;
    margin: 0;
    padding: 0;
  }
}

// content
.content {
  width: 100%;
  height: 980px;
  overflow: hidden;
  color: #fff;
  // margin-top:15.5px;
  // background:yellow;
  //  background: url("../assets/kanban/bg.jpg") no-repeat center center;
  // background-size: 100% 100%;
}
</style>
