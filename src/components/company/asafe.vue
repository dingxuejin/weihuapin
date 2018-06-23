<template>
  <div class="box">
    <div class="title">
      <div :class="{hover:show}"
           @click="change('year')">本年</div>
      <div :class="{hover:!show}"
           @click="change('month')">本月</div>
    </div>
    <div class="select">
      <select name=""
              id=""
              v-model="title"
              @click='type'>
        <option v-for='(item,index) in select'
                :value="item"
                :key='index'>{{item}}</option>
      </select>
      <div>统计类型</div>
    </div>
    <div class="top red">
      <div class="name">{{title}}安全排名红榜TOP10</div>
      <!-- 切换分组 -->
      <div class="header jstitle"
           v-if="jshow==='driver'">
        <div>排名</div>
        <div>驾驶员姓名</div>
        <div>所属车队</div>
      </div>
      <div class="header"
           v-else>
        <div>排名</div>
        <div>{{title}}</div>
      </div>
      <!-- 切换分组 -->
      <ul v-if="jshow==='driver'"
          class="jsy">
        <li v-for='(item,index) in driver.good'
            :class="{hover:red===index}"
            @click='red=index'
            :key='index'>
          <div>{{index+1}}</div>
          <div>{{item.name}}</div>
          <div class="over">{{item.entity_name}}</div>
        </li>
      </ul>
      <ul v-else-if="jshow==='branchCom'">
        <li v-for='(item,index) in branchCom.good'
            :class="{hover:red===index}"
            @click='red=index'
            :key='index'>
          <div>{{index+1}}</div>
          <div class="over">{{item.entity_name}}</div>
        </li>
      </ul>
      <ul v-else>
        <li v-for='(item,index) in motorcade.good'
            :class="{hover:red===index}"
            @click='red=index'
            :key='index'>
          <div>{{index+1}}</div>
          <div class="over">{{item.entity_name}}</div>
        </li>
      </ul>
    </div>
    <div class="top black">
      <div class="name">{{title}}安全排名黑榜TOP10</div>
      <!-- 切换分组 -->
      <div class="header jstitle"
           v-if="jshow==='driver'">
        <div>排名</div>
        <div>驾驶员姓名</div>
        <div>所属车队</div>
      </div>
      <div class="header"
           v-else>
        <div>排名</div>
        <div>{{title}}</div>
      </div>
      <!-- 切换分组 -->
      <ul v-if="jshow==='driver'"
          class="jsy">
        <li v-for='(item,index) in driver.bad'
            :class="{hover:black===index}"
            @click='black=index'
            :key='index'>
          <div>{{index+1}}</div>
          <div>{{item.name}}</div>
          <div class="over">{{item.entity_name}}</div>
        </li>
      </ul>
      <ul v-else-if="jshow==='branchCom'">
        <li v-for='(item,index) in branchCom.bad'
            :class="{hover:black===index}"
            @click='black=index'
            :key='index'>
          <div>{{index+1}}</div>
          <div class="over">{{item.entity_name}}</div>
        </li>
      </ul>
      <ul v-else>
        <li v-for='(item,index) in motorcade.bad'
            :class="{hover:black===index}"
            @click='black=index'
            :key='index'>
          <div>{{index+1}}</div>
          <div class="over">{{item.entity_name}}</div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
/*eslint-disable */
import { mapActions } from "vuex";

export default {
  props: ["branchCom", "driver", "motorcade"],
  data() {
    return {
      show: true,
      red: null,
      black: null,
      title: "分公司",
      select: ["分公司", "驾驶员", "车队"],
      jshow: "branchCom",
      yearOrmonth: "year",
      data1: [],
      data2: []
    };
  },
  methods: {
    ...mapActions("safeMsgStore", ["getYearOrMonthMsg"]),
    change(str) {
      this.show = !this.show;
      if (str === "year") {
        const arg = {
          year: 2018
        };
        this.getYearOrMonthMsg(arg);
      } else {
        const arg = {
          year: 2018,
          month: 11
        };
        this.getYearOrMonthMsg(arg);
      }
      this.yearOrmonth = str;
    },
    type() {
      if (this.title === "分公司") {
        this.jshow = "branchCom";
      } else if (this.title === "驾驶员") {
        this.jshow = "driver";
      } else if (this.title === "车队") {
        this.jshow = "motorcade";
      }
    }
  },
  beforeUpdate() {}
};
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
      width: 294px;
      box-sizing: border-box;
      outline: none;
      border: 1px solid rgba(0, 191, 229, 1);
      background: #000000;
      color: #d5d5d5;
      appearance: none;
      -moz-appearance: none;
      -webkit-appearance: none;
      background: url("../../assets/driver/select_arrow.png") no-repeat scroll
        calc(100% - 10px) center #000000;
      padding-left: 5px;
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
    .jstitle {
      div:nth-child(1) {
        width: 90px;
      }
      div:nth-child(2) {
        width: 140px;
        margin-right: 10px;
      }
      div:nth-child(3) {
        width: 120px;
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
    .jsy {
      li {
        div:nth-child(1) {
          width: 90px;
        }
        div:nth-child(2) {
          width: 140px;
          margin-right: 10px;
        }
        div:nth-child(3) {
          width: 104px;
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
      background: rgba(129, 217, 229, 0.3);
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
      /* color: #e75029;
        background: rgba(231, 80, 41, .3); */
      color: #89dddf;
      background: rgba(129, 217, 229, 0.3);
    }
    .header {
      div {
        border: 1px solid #038bfc;
      }
    }
    ul {
      li {
        div {
          border: 1px solid rgba(3, 139, 252, 1);
          background: rgba(3, 139, 252, 0.2);
        }
      }
      .hover {
        div {
          background: rgba(3, 139, 252, 1);
          color: #ffffff;
        }
      }
    }
    ul::-webkit-scrollbar {
      background: rgba(3, 139, 252, 0.5);
      width: 6px;
    }
    ul::-webkit-scrollbar-thumb {
      background: rgba(3, 139, 252, 1);
    }
  }
}
</style>
