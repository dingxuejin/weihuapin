<template>
    <div class="monthScore">
      <div class="monthScore_wrap">
        <div class="facilitatorMonth">
        <div class="facilitatorMonth_title">服务商月度评分
          <div class="facilitatorMonth_title_date">统计周期
            <div class="dataSelect">
              <el-date-picker
                v-model="value6"
                type="daterange"
                range-separator="至"
                start-placeholder="开始日期"
                end-placeholder="结束日期">
              </el-date-picker>
            </div>
          </div>
        </div>
        <div class="facilitatorMonth_content">
          <div class="listTitle">
            <div>服务商</div>
            <div v-for='(item,index) in listTitle'
                :key='index'>{{item}}</div>
          </div>
          <div class="company">
            CCCCCCCCCC
          </div>
          <ul>
            <li v-for='(item,index) in listdata'
                :key='index'>
              <div>{{item.name}}</div>
              <div>{{item.value}}</div>
            </li>
          </ul>
        </div> 
      </div>
      <div class="businessMonth">
        <div class="businessMonth_title">企业月度评分
          <div class="businessMonth_title_date">统计周期
            <div class="dataSelect">
              <el-date-picker
                v-model="value6"
                type="daterange"
                range-separator="至"
                start-placeholder="开始日期"
                end-placeholder="结束日期">
              </el-date-picker>
            </div>
          </div>
        </div>
        <div class="businessMonth_content">
          <div class="listTitle">
            <div>企业</div>
            <div v-for='(item,index) in listTitle'
                :key='index'>{{item}}</div>
          </div>
          <div class="company">
            CCCCCCCCCC
          </div>
          <ul>
            <li v-for='(item,index) in listdata'
                :key='index'>
              <div>{{item.name}}</div>
              <div>{{item.value}}</div>
            </li>
          </ul>
        </div>
      </div>
      </div>
    </div>
</template>
<script>
/* eslint-disable */
export default {
  components: {
  },
  data() {
    return {
      listTitle: ["项目", "评分"],
      listdata: [
        { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
        { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
        { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
        { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
        { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
        { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
        { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
        { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
        { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
        { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
        { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
        { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
        { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 },
        { name: "CCCCCCCC", value: 99, value1: 22, value2: 33, value3: 20 }
      ],
      value6: '',
    };
  },
};
</script>
<style lang="scss" scoped>
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.monthScore{
  @include size(100%,100%);
  position: relative;
  &_wrap{
    @include size(596px,404px);
    border-right:2px solid rgba(3,139,252,0.2);
    position: absolute;
    bottom: 24px;
    left:37px;
    .facilitatorMonth{
      @include size(100%,210px);
      position: absolute;
      // background: pink;
      &_title{
        @include size(560px,26px);
        margin-bottom: 12px;
        background:	rgba(129,217,229,0.3);
        box-sizing:border-box;
        font-size: 16px;
        color:#89DDDF;
        padding-left:10px;
        line-height:26px;
        text-align:left;
        position: absolute;
        &_date{
          @include size(318px,100%);
          background: rgba(74,132,216,0.2);
          position: absolute;
          right:0;
          top:0;
          font-size:14px;
          color:#B5B5B5;
          line-height:26px;
          text-align:left;
          box-sizing: border-box;
          padding-left:10px;
          .dataSelect{
            @include size(246px,100%);
            // background: #05d0eb;
            position: absolute;
            right:0;
            top:0;
            el-date-picker{
              @include size(246px,100%);
            }
          }
        }
      }
      &_content{
        @include size(100%,172px);
        margin-top:38px;
        // background: yellowgreen;
        .listTitle {
          @include size(100%, 30px);
          // clear: both;
          margin-bottom: 10px;
          float: left;
          div {
            @include size(100%, 100%);
            float: left;
            margin-left: 20px;
            box-sizing: border-box;
            text-align: center;
            line-height: 30px;
            border: 1px solid #81d9e5;
            color: #b5b5b5;
            font-size: 16px;
          }
          div:nth-child(1) {
            @include size(200px, 100%);
            margin-left: 0px;
          }
          div:nth-child(2) {
            @include size(220px, 100%);
          }
          div:nth-child(3) {
            @include size(100px, 100%);
          }
        }
        .company{
          @include size(200px, 115px);
          float: left;
          margin-right:20px;
          box-sizing: border-box;
          border: 1px solid #81d9e5;
          text-align: center;
          line-height:115px;
          font-size: 14px;
          color:#fff;
        }
        ul {
          @include size(340px, 115px);
          list-style: none;
          overflow-y: scroll;
          color: #b5b5b5;
          float: left;
          // margin-left:220px;
          li {
            margin-bottom: 5px;
            height: 25px;
            cursor: pointer;
            div {
              float: left;
              height: 25px;
              box-sizing: border-box;
              line-height: 25px;
              text-align: center;
              border: 1px solid rgba(0, 191, 229, 1);
              background: rgba(0, 191, 229, 0.2);
              width: 89px;
              margin-left: 20px;
              overflow: hidden;
              text-overflow: ellipsis;
              white-space: nowrap;
            }
            // div:nth-child(1) {
            //   @include size(200px, 100%);
            //   margin-left: 0px;
            // }
            div:nth-child(1) {
              @include size(220px, 100%);
              margin-left: 0px;
            }
            div:nth-child(2) {
              @include size(90px, 100%);
            }
            &:hover div {
              background: rgba(0, 191, 229, 0.5);
              color: #ffffff;
            }
          }
        }
        ul::-webkit-scrollbar {
          background: #69a3b1;
          width: 6px;
        }
        ul::-webkit-scrollbar-thumb {
          background: #05d0eb;
        }
      }
    }
    .businessMonth{
      @include size(100%,184px);
      position: absolute;
      top:210px;
      // background: pink;
      &_title{
        @include size(560px,26px);
        margin-bottom: 12px;
        background:	rgba(129,217,229,0.3);
        box-sizing:border-box;
        font-size: 16px;
        color:#89DDDF;
        padding-left:10px;
        line-height:26px;
        text-align:left;
        position: absolute;
        &_date{
          @include size(318px,100%);
          background: rgba(74,132,216,0.2);
          position: absolute;
          right:0;
          top:0;
          font-size:14px;
          color:#B5B5B5;
          line-height:26px;
          text-align:left;
          box-sizing: border-box;
          padding-left:10px;
          .dataSelect{
            @include size(246px,100%);
            // background: #05d0eb;
            position: absolute;
            right:0;
            top:0;
            el-date-picker{
              @include size(246px,100%);
            }
          }
        }
      }
      &_content{
        @include size(100%,172px);
        margin-top:38px;
        // background: yellowgreen;
        .listTitle {
          @include size(100%, 30px);
          // clear: both;
          margin-bottom: 10px;
          float: left;
          div {
            @include size(100%, 100%);
            float: left;
            margin-left: 20px;
            box-sizing: border-box;
            text-align: center;
            line-height: 30px;
            border: 1px solid #81d9e5;
            color: #b5b5b5;
            font-size: 16px;
          }
          div:nth-child(1) {
            @include size(200px, 100%);
            margin-left: 0px;
          }
          div:nth-child(2) {
            @include size(220px, 100%);
          }
          div:nth-child(3) {
            @include size(100px, 100%);
          }
        }
        .company{
          @include size(200px, 115px);
          float: left;
          margin-right:20px;
          box-sizing: border-box;
          border: 1px solid #81d9e5;
          text-align: center;
          line-height:115px;
          font-size: 14px;
          color:#fff;
        }
        ul {
          @include size(340px, 115px);
          list-style: none;
          overflow-y: scroll;
          color: #b5b5b5;
          float: left;
          // margin-left:220px;
          li {
            margin-bottom: 5px;
            height: 25px;
            cursor: pointer;
            div {
              float: left;
              height: 25px;
              box-sizing: border-box;
              line-height: 25px;
              text-align: center;
              border: 1px solid rgba(0, 191, 229, 1);
              background: rgba(0, 191, 229, 0.2);
              width: 89px;
              margin-left: 20px;
              overflow: hidden;
              text-overflow: ellipsis;
              white-space: nowrap;
            }
            // div:nth-child(1) {
            //   @include size(200px, 100%);
            //   margin-left: 0px;
            // }
            div:nth-child(1) {
              @include size(220px, 100%);
              margin-left: 0px;
            }
            div:nth-child(2) {
              @include size(90px, 100%);
            }
            &:hover div {
              background: rgba(0, 191, 229, 0.5);
              color: #ffffff;
            }
          }
        }
        ul::-webkit-scrollbar {
          background: #69a3b1;
          width: 6px;
        }
        ul::-webkit-scrollbar-thumb {
          background: #05d0eb;
        }
      }
      // background: skyblue;
    }
  }
}
</style>
