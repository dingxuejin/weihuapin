<template>
  <div class="real1">
    <div class="online people">{{now}}</div>
    <div class="all people">{{all}}</div>
    <div class="numline num">
      <span>{{nownum}}</span>
      <div>{{dw}}</div>
    </div>
    <div class="numall num">
      <span>{{allnum}}</span>
      <div class="numUnit">{{dw}}</div>
      <div :class="{totalCountDetailsBtn:detailsBtnShow}"
           @click="openDetail"></div>
    </div>
  </div>
</template>

<script>
export default {
  props: ['now', 'all', 'nownum', 'allnum', 'dw', 'detailsBtnShow', 'type'],
  methods: {
    openDetail() {
      this.$emit('openDetail')
    },
  },
}
</script>

<style lang="scss" scoped>
.real1 {
  width: 390px;
  height: 100px;
  .online {
    background: rgba(3, 139, 252, 0.3);
    margin-right: 10px;
    width: 190px;
  }
  .all {
    width: 190px;
  }
  .people {
    height: 30px;
    line-height: 30px;
    text-align: center;
    font-size: 14px;
    color: #88dddf;
    float: left;
    margin-bottom: 10px;
  }
  .num {
    float: left;
    height: 60px;
    box-sizing: border-box;
    font-size: 32px;
    font-weight: bold;
    font-family: "digi";
    line-height: 60px;
    text-align: center;
    position: relative;
    color: #88dddf;
    div {
      position: absolute;
      font-size: 14px;
      right: 10px;
      bottom: 5px;
      line-height: 10px;
    }
  }
  .numline {
    width: 190px;
    margin-right: 10px;
    border: 1px solid #81d9e5;
  }
  .numall {
    width: 190px;
    color: #efca0f;
    background: rgba(3, 139, 252, 0.2);
    position: relative;
    .numUnit {
      color: #88dddf;
    }
    .totalCountDetailsBtn {
      width: 25px;
      height: 25px;
      overflow: hidden;
      margin-bottom: 30px;
      margin-right: 0px;
      background: url("../../assets/companymanage/drill_icon_off.png") no-repeat
        center center;
      cursor: pointer;
    }
    .totalCountDetailsBtn:hover {
      background: url("../../assets/companymanage/drill_icon_on.png") no-repeat
        center center;
    }
  }
}
</style>