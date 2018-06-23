<template>
  <div class="company-driveBehavior">
    <div class="titleCon">
      <p>{{data.name}}</p>
    </div>
    <div class="msgCon clearfix">
      <div class="msgCon-left fl">
        {{qf(data.total)}}
      </div>
      <div class="msgCon-right fr">
        <div>已处理数量</div>
        <div>{{qf(data.deal_num)}}</div>
      </div>
    </div>
    <div class="driveBehavior-btn">

    </div>

  </div>
</template>

<script type="text/javascript">
export default {
  name: 'driveBehavior',
  components: {},
  props: ['data'],
  data() {
    return {}
  },
}
</script>

<style lang="scss" scoped>
.company-driveBehavior {
  width: 100%;
  height: 100%;
  overflow: hidden;
  position: relative;
  // background:pink;
}

//标题部分
.titleCon {
  width: 100%;
  height: 40px;
  overflow: hidden;
  border-bottom: 2px solid #81d9e5;
  p {
    width: 200px;
    height: 30px;
    text-indent: 20px;
    line-height: 30px;
    background: rgba(231, 80, 41, 0.5);
  }
}

// 内容部分
.msgCon {
  width: 100%;
  height: 60px;
  overflow: hidden;
  margin-top: 10px;
  // background: red;
}
.msgCon-left {
  width: 200px;
  height: 60px;
  overflow: hidden;
  box-sizing: border-box;
  border: 1px solid #81d9e5;
  text-align: center;
  line-height: 60px;
  color: #e75029;
  font-size: 48px;
  font-weight: bold;
  font-family: "digi";
}
.msgCon-right {
  width: 180px;
  height: 100%;
  overflow: hidden;
  background: url("../../assets/company/icon_yes.png") right top no-repeat;

  div:nht-child(1) {
    width: 100%;
    // height: 25px;
    color: #fff;
    font-size: 16px;
    // line-height: 25px;
  }
  div:nth-child(2) {
    width: 144px;
    height: 35px;
    margin-top: 6px;
    background: #004668;
    color: #81d9e5;
    font-size: 36px;
    font-weight: bold;
    font-family: "digi";
    text-indent: 10px;
    line-height: 35px;
  }
}

.driveBehavior-btn {
  width: 20px;
  height: 5px;
  overflow: hidden;
  position: absolute;
  top: 12px;
  right: 10px;
  background: url("../../assets/company/icons_more.png");
  cursor: pointer;
}
</style>