<template>
  <div class="box">
    <div class="title">
      <div :class="{hover:show}" @click='show=!show'>本年</div>
      <div :class="{hover:!show}" @click='show=!show'>本月</div>
    </div>
    <div class="select">
      <select name="" id="">
        <option value="" v-for='item in select'>{{item}}</option>
      </select>
      <div>统计类型</div>
    </div>
    <div class="top red">
      <div class="name">分公司安全排名红榜TOP10</div>
      <div class="header">
        <div>排名</div>
        <div>分公司</div>
      </div>
      <ul>
        <li v-for='(item,index) in data1' :class="{hover:red===index}" @click='red=index'>
          <div>{{index+1}}</div>
          <div>{{item}}</div>
        </li>
      </ul>
    </div>
    <div class="top black">
      <div class="name">分公司安全排名黑榜TOP10</div>
      <div class="header">
        <div>排名</div>
        <div>分公司</div>
      </div>
      <ul>
        <li v-for='(item,index) in data2' :class="{hover:black===index}" @click='black=index'>
          <div>{{index+1}}</div>
          <div>{{item}}</div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
  export default {
    props: ['data1', 'data2'],
    data() {
      return {
        show: true,
        red: null,
        black: null,
        select: ['分公司', '总公司'],
      }
    },
  }

</script>
<style lang="scss" scoped>
  .box {
    margin-left: 30px;
    .title {
      height: 25px;
      div {
        width: 180px;
        height: 25px;
        line-height: 23px;
        text-align: center;
        float: left;
        box-sizing: border-box;
        font-size: 14px;
        color: #b5b5b5;
        border: 1px solid rgba(0, 191, 229, 1);
        background-color: rgba(0, 191, 229, 0.2);
        cursor: pointer;
      }
      .hover {
        background-color: rgba(0, 191, 229, 0.5);
        color: #ffffff;
      }
      div:nth-child(1) {
        margin-right: 10px;
      }
    }
    .select {
      height: 26px;
      width: 370px;
      margin-top: 10px;
      div {
        float: right;
        line-height: 26px;
        margin-right: 10px;
      }
      select {
        float: right;
        height: 26px;
        width: 200px;
        box-sizing: border-box;
        outline: none;
        border: 1px solid rgba(0, 191, 229, 1);
        background: #000000;
        color: #d5d5d5;
      }
      select:nth-child(2) {
        margin-right: 10px;
      }
    }
    .top {
      margin-top: 10px;
      height: 225px;
      .name {
        margin-top: 10px;
        width: 280px;
        height: 30px;
        line-height: 30px;
        text-align: center;
        font-size: 16px;
        font-weight: bold;
      }
      .header {
        height: 30px;
        margin-top: 10px;
        div {
          box-sizing: border-box;
          height: 30px;
          line-height: 28px;
          text-align: center;
          float: left;
          font-size: 16px;
          color: #b5b5b5;
        }
        div:nth-child(1) {
          width: 140px;
          margin-right: 10px;
        }
        div:nth-child(2) {
          width: 220px;
        }
      }
      ul {
        height: 145px;
        margin-top: 10px;
        width: 370px;
        overflow-y: scroll;
        list-style: none;
        li {
          height: 25px;
          margin-bottom: 5px;
          cursor: pointer;
          div {
            font-size: 14px;
            color: #b5b5b5;
            text-align: center;
            line-height: 23px;
            height: 25px;
            box-sizing: border-box;
            float: left;
          }
          div:nth-child(1) {
            width: 140px;
            margin-right: 10px;
          }
          div:nth-child(2) {
            width: 210px;
          }
        }
      }
      ul::-webkit-scrollbar {
        background: rgba(0, 191, 229, 0.5);
        width: 6px;
      }
      ul::-webkit-scrollbar-thumb {
        background: rgba(0, 191, 229, 1);
      }
    }
    .red {
      .name {
        color: #89dddf;
        background: rgba(129, 217, 229, .3)
      }
      .header {
        div {
          border: 1px solid #81d9e5;
        }
      }
      ul {
        li {
          div {
            border: 1px solid rgba(0, 191, 229, 1);
            background: rgba(0, 191, 229, 0.2);
          }
        }
        .hover {
          div {
            background: rgba(0, 191, 229, 1);
            color: #ffffff;
          }
        }
      }
    }
    .black {
      .name {
        color: #e75029;
        background: rgba(231, 80, 41, .3);
      }
      .header {
        div {
          border: 1px solid #e75029;
        }
      }
      ul {
        li {
          div {
            border: 1px solid rgba(231, 80, 41, 1);
            background: rgba(231, 80, 41, 0.2);
          }
        }
        .hover {
          div {
            background: rgba(231, 80, 41, 1);
            color: #ffffff;
          }
        }
      }
    }
  }

</style>
