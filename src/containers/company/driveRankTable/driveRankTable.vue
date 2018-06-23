<template>
  <div class="driveRankTable">
    <div class="driveRank-titleCon clearfix">
      <div class="driveRank-title-item fl">排名</div>
      <div class="driveRank-title-item fl">驾驶员姓名</div>
      <div class="driveRank-title-item fl">安全指数得分</div>
    </div>
    <div class="driveRank-table">
      <div class="driveRank-table-content eleScrollBar">
        <!-- 循环显示items -->
        <div v-for="(item,index) in data" class="driveRank-table-item clearfix">
          <div class="fl">{{'#'}}{{index<9 ? '0'+(index+1) : (index+1)}}</div>
          <div class="fl">{{item.name}}</div>
          <div class="fl">{{item.value}}</div>
        </div>
      </div>
    </div>
  </div>

</template>

<script type="text/javascript">
export default {
  name: 'driveRankTable',
  components: {},
  props: ['data'],
  data() {
    return {}
  },
}
</script>

<style lang="scss" scoped>
.driveRankTable {
  width: 100%;
  height: 100%;
  overflow: hidden;
  // background: pink;
}
// 标题
.driveRank-titleCon {
  width: 100%;
  height: 30px;
  overflow: hidden;
  // background: cyan;
}
.driveRank-title-item {
  width: 100px;
  height: 100%;
  overflow: hidden;
  box-sizing: border-box;
  border: 1px solid #81d9e5;
  text-align: center;
  line-height: 28px;
  color: #b5b5b5;
  font-size: 16px;
}
.driveRank-title-item:nth-child(2) {
  width: 150px;
  margin-left: 10px;
}
.driveRank-title-item:nth-child(3) {
  width: 130px;
  margin-left: 10px;
}

// 表格内容
.driveRank-table {
  width: 100%;
  height: 115px;
  overflow: hidden;
  margin-top: 10px;
  // background: cyan;
}
// 定义滚动条
.eleScrollBar::-webkit-scrollbar {
  width: 5px;
  height: 100%;
  // border: 1px solid grey;
  background: url("../../../assets/company/strip_scrollbg.png");
}
.eleScrollBar::-webkit-scrollbar-thumb {
  background: #05d0eb;
}
.driveRank-table-content {
  width: 100%;
  height: 100%;
  overflow-y: auto;
  // background: pink;
}
.driveRank-table-item {
  width: 390px;
  height: 25px;
  overflow: hidden;
  // background: red;

  div {
    width: 100px;
    height: 25px;
    overflow: hidden;
    box-sizing: border-box;
    border: 1px solid #05e0db;
    text-align: center;
    line-height: 23px;
    color: #fff;
    font-size: 14px;
    background: rgba(5, 208, 235, 0.5);
  }
  div:nth-child(2) {
    width: 150px;
  }
  div:nth-child(3) {
    width: 120px;
  }
  div:nth-child(n + 2) {
    margin-left: 10px;
  }
}
.driveRank-table-item:nth-child(n + 2) {
  margin-top: 5px;
  div {
    color: #b5b5b5;
    border: 1px solid rgba(5, 208, 235, 0.5);
    background: rgba(5, 208, 235, 0.2);
  }
}
</style>