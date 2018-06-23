<template>
  <div class="services-layout" @mousemove="onMousemove">
    <!-- header -->
    <header class="heaer clearfix">
      <div class="header-title fl" @click='$router.push("/index")'>亿顺凯危货运输有限公司</div>
      <div class="header-name"
           :class="{switchBg:active}"><img src="../assets/zonghe.png" />企业测评服务</div>
      <div class="header-time fr clearfix">
        <div class="time fr">{{time}}</div>
        <div class="date fr">{{day}}</div>
      </div>
    </header>
    <!-- content -->
    <div class="content">
        <!-- services 页面 -->
        <sever-index></sever-index>
    </div>
    <div class="services-layout_left" v-show="showRoute">
      <img src="../assets/qiehuanzuo.png" @click='$router.push("/kanban")' />
    </div>
  </div>
</template>

<script>
import SeverIndex from '../containers/services/indexLayout'

export default {
  name: 'services',
  components: {
    SeverIndex,
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
.services-layout {
  width: 1920px;
  height: 1080px;
  overflow: hidden;
  background: url("../assets/company/bg.png");
  background-size: 100% 100%;
}

.services-layout_left{
    position:fixed;
    left:5px;
    top:45%;
    z-index: 111;
    img{
      cursor: pointer;
    }
  }
// header
.heaer {
  width: 100%;
  height: 77.5px;
  overflow: hidden;
  margin-top: 20px;
  position: relative;
  background: url("../assets/company/header_bg.png");
  background-size: 100% 100%;
}
.header-title {
  width: 630px;
  height: 60px;
  overflow: hidden;
  margin-top: 10px;
  background: url("../assets/company/header_name.png");
  background-size: 100% 100%;
  color: #81d9e5;
  font-size: 30px;
  font-weight: bold;
  line-height: 60px;
  padding-left:75px;
  box-sizing:border-box;
  cursor: pointer;
}
.header-name {
  width: 600px;
  height: 60px;
  overflow: hidden;
  background: url("../assets/company/system_top_bg.png");
  background-size: 100% 100%;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: #81d9e5;
  font-size: 30px;
  font-weight: bold;
  text-align: center;
  line-height: 60px;
  // cursor: pointer;
  img{
    position: relative;
    right: 120px;
    top: -8px;
    vertical-align: middle;
  }
}
// 单击改变背景
.switchBg {
  background: url("../assets/company/system_top_bg.png") center center
    no-repeat;
}
.header-time {
  width: 400px;
  height: 60px;
  overflow: hidden;
  background: url("../assets/company/header_time.png");
  background-size: 100% 100%;
  margin-top: 10px;
}

// 时间
.time {
  color: #81d9e5;
  font-size: 34px;
  font-weight: bold;
  line-height: 60px;
  margin-right: 50px;
}
.date {
  color: #81d9e5;
  font-size: 28px;
  line-height: 60px;
  margin-right: 40px;
}

// content
.content {
  width: 100%;
  height: 980px;
  overflow: hidden;
  color:#fff;
  // margin-top:15.5px;
  // background:yellow;
    // background:url(../assets/qiyeceping.png) no-repeat center center;
    // background-size:1920px 980px;
}
</style>
