<template>
  <header class="heaer clearfix">
    <div class="header-title fl" @click='$router.push("/index")'>{{leftHeaderTitle}}</div>
    <div class="header-name">
      <img src="../assets/zonghe.png" />
      {{headerTitle}}
    </div>
    <div class="header-time fr clearfix">
      <div class="time fr">{{time}}</div>
      <div class="date fr">{{day}}</div>
      <!-- 设置 -->
      <div class="indexMap_set" @click="()=>{this.showSet=!this.showSet}">
        <img src="../assets/shezhi.png" />
      </div>
    </div>
    <!-- 设置首页 -->
    <div class="indexMapBox" v-show="showSet">
      <ul class="indexMap_setpage">
        <li @click="()=>{ this.showSet=false;this.selectpage=1}" :style="{color:selectpage===1?'#fff':''}">
          <img src="../assets/suo-xinxichaxun.png" />
          <p>设为下次播放首页</p>
        </li>
        <li @click="()=>{ this.showSet=false;this.selectpage=2}" :style="{color:selectpage===2?'#fff':''}">
          <img src="../assets/suo-yunyingkanban.png" />
          <p>设为下次播放首页</p>
        </li>
        <li @click="()=>{ this.showSet=false;this.selectpage=3}" :style="{color:selectpage===3?'#fff':''}">
          <img src="../assets/suo-cepingfuwu.png" />
          <p>设为下次播放首页</p>
        </li>
      </ul>
    </div>
  </header>
</template>

<script>
export default {
  name: 'commonHeader',
  props: ['headerTitle', 'leftHeaderTitle'],
  data() {
    return {
      time: '',
      day: '',
      active: false,
      showSet: false,
      selectpage: 1,
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
  },
  mounted() {
    setInterval(() => {
      this.showTime()
    }, 1000)
  },
}
</script>

<style lang="scss" scoped>
// header
.heaer {
  width: 100%;
  height: 80px;
  overflow: hidden;
  position: relative;
  background: url("../../src/assets/header_bg.png");
  background-size: 100% 100%;
}
.header-title {
  width: 630px;
  height: 60px;
  overflow: hidden;
  margin-top: 10px;
  background: url("../../src/assets/header_name.png");
  background-size: 100% 100%;
  color: #81d9e5;
  font-size: 30px;
  font-weight: bold;
  line-height: 60px;
  padding-left: 75px;
  box-sizing: border-box;
  cursor: pointer;
}
.header-name {
  width: 600px;
  height: 60px;
  overflow: hidden;
  background: url("../../src/assets/system_top_bg.png");
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
  cursor: pointer;
  img{
    position: relative;
    right: 120px;
    top: -8px;
    vertical-align: middle;
  }
}
.header-time {
  width: 400px;
  height: 60px;
  overflow: hidden;
  background: url("../../src/assets/header_time.png");
  background-size: 100% 100%;
  margin-top: 10px;
  padding-right:50px;
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
.indexMap_set{
    position:absolute;
    bottom:22px;
    right:30px;
    z-index:10;
    cursor:pointer;
}
.indexMapBox{
  position:fixed;
  top:100px;
  left:0px;
  width:100%;
  height:100%;
  background:rgba(0,0,0,0.3);
  z-index:111;
  text-align:center;
}
.indexMap_setpage{
    position:absolute;
    top:30%;
    border:2px solid #03F9E6;
    display:inline-block;
    background:#000;
    li{
      display:inline-block;
      text-align:center;
      padding:5px;
      cursor:pointer;
      color:#898989;
      p{
        font-size:12px;
        padding:5px 0;
      }
    }
    li:nth-child(2){
      border-left:1px solid #03F9E6 ;
      border-right:1px solid #03F9E6 ;
    }
  }
</style>
