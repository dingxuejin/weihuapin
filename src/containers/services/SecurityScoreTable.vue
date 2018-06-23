<template>
    <div class="securityScoreTable">
      <div class="securityScoreTable_content">
        <div class="listTitle">
          <div v-for='(item,index) in listTitle'
               :key='index'>{{item}}</div>
        </div>
        <ul>
          <li v-for='(item,index) in listdata'
              :key='index'>
            <div>{{item.name}}</div>
            <div>{{item.value}}</div>
            <div>{{item.value1}}</div>
            <div>{{item.value1}}</div>
            <div>{{item.value1}}</div>
          </li>
        </ul>
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
      listTitle: ["排名", "省份", "服务商", "企业", "评分"],
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
    };
  },
};
</script>
<style lang="scss" scoped>
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.securityScoreTable{
  @include size(100%,384px);
  &_content {
      @include size(100%, 100%);
      box-sizing: border-box;
      padding-top: 14px;
      padding-left: 37px;
      .listTitle {
        @include size(100%, 30px);
        // clear: both;
        margin-bottom: 10px;
        margin-top: 10px;
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
          @include size(100px, 100%);
          margin-left: 0px;
        }
        div:nth-child(2) {
          @include size(100px, 100%);
        }
        div:nth-child(3) {
          @include size(380px, 100%);
        }
        div:nth-child(4) {
          @include size(380px, 100%);
        }
        div:nth-child(5) {
          @include size(130px, 100%);
        }
      }
      ul {
        @include size(100%, 296px);
        list-style: none;
        overflow-y: scroll;
        color: #b5b5b5;
        float: left;
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
          div:nth-child(1) {
            @include size(100px, 100%);
            margin-left: 0px;
          }
          div:nth-child(2) {
            @include size(100px, 100%);
          }
          div:nth-child(3) {
            @include size(380px, 100%);
          }
          div:nth-child(4) {
            @include size(380px, 100%);
          }
          div:nth-child(5) {
            @include size(110px, 100%);
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
</style>
