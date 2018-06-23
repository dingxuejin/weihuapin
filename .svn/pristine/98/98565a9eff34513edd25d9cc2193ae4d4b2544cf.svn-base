<template>
  <div class="ranking">
    <div class="name">{{name}}</div>
    <div class="title">
      <div v-for='(item,index) in title' :key='index'>{{item}}</div>
    </div>
    <ul>

      <li v-for='(item,index) in orderedData' :key='index'>
        <div>{{item.ranking}}</div>
        <div>
          <nav :style='{width:(item[type]/maxValue)*140+"px"}'></nav>
          <nav>{{item[type]}}</nav>
        </div>
        <div class="over">{{item.qy_xlxx && item.qy_xlxx.route_name}}</div>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  props: ['name', 'title', 'data', 'type'],
  computed: {
    orderedData() {
      const clone = [...this.data]
      return clone.sort((a, b) => a.ranking - b.ranking)
    },
    maxValue() {
      // return this.data.reduce((total, curr) => total + parseInt(curr[this.type], 0), 0)
      return this.orderedData.filter(r => r.ranking === '1')[0][this.type]
    },
  },
}
</script>

<style lang="scss" scoped>
.ranking {
  width: 500px;
  height: 250px;
  overflow: hidden;
  .name {
    margin-top: 10px;
    margin-left: 20px;
    font-size: 18px;
    font-weight: bold;
    color: #89dddf;
    width: 250px;
    height: 30px;
    line-height: 30px;
    text-align: center;
    background: #005b71;
  }
  .title {
    margin-left: 20px;
    margin-top: 10px;
    margin-bottom: 10px;
    height: 30px;
    div {
      box-sizing: border-box;
      // width: 145px;
      height: 30px;
      float: left;
      line-height: 28px;
      text-align: center;
      border: 1px solid #81d9e5;
      font-size: 16px;
      color: #b5b5b5;
      margin-right: 10px;
    }
    div:nth-child(1) {
      width: 35px;
    }
    div:nth-child(2) {
      width: 238px;
    }
    div:nth-child(3) {
      width: 185px;
      margin-right:0;
    }
  }
  ul {
    width: 665px;
    overflow-y: auto;
    height: 145px;
    margin-left: 20px;
    li {
      height: 25px;
      margin-bottom: 5px;
      div {
        float: left;
        width: 200px;
        height: 25px;
        border: 1px solid rgba(0, 191, 229, 1);
        background: rgba(0, 191, 229, 0.2);
        line-height: 23px;
        text-align: center;
        font-size: 14px;
        color: #b5b5b5;
        margin-right: 10px;
        box-sizing: border-box;
        nav {
          float: left;
        }
        nav:nth-child(1) {
          height: 10px;
          background: #89dddf;
          margin-top: 6px;
          margin-left: 9px;
          margin-right: 10px;
        }
      }
      div:nth-child(1) {
        width: 35px;
      }
      div:nth-child(2) {
        width: 238px;
      }
      div:nth-child(3) {
        margin-right: 0px;
        width: 185px;
      }
    }
  }
  ul::-webkit-scrollbar {
    width: 5px;
    background: #69a3b1;
  }
  ul::-webkit-scrollbar-thumb {
    background: #05f0eb;
  }
}
</style>