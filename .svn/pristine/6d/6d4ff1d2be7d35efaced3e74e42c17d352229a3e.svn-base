<template>
  <div class="real1">
    <div class="online people">{{now}}</div>
    <div class="all people">{{all}}</div>
    <div class="numline num">
      <div>
        <span>空车数</span>
        <span>{{dw}}</span>
        <span>{{nowk}}</span>
      </div>
      <div>
        <span>重车数</span>
        <span>{{dw}}</span>
        <span>{{nowz}}</span>
      </div>
    </div>
    <div class="numall num">
      <span>{{allnum}}</span>
      <div>{{dw}}</div>
    </div>
  </div>
</template>

<script>
export default {
  props: ['now', 'all', 'nowk', 'nowz', 'allnum', 'dw'],
}
</script>

<style lang="scss" scoped>
.real1 {
  width: 460px;
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
    position: relative;
    color: #88dddf;
  }
  .numline {
    width: 190px;
    margin-right: 10px;
    border: 1px solid #81d9e5;
    div {
      line-height: 29px;
      span:nth-child(1) {
        margin-left: 10px;
      }
      span:nth-child(2) {
        margin-right: 10px;
        margin-left: 20px;
        float: right;
      }
      span:nth-child(3) {
        float: right;
        font-family: "digi";
        font-size: 24px;
        font-weight: bold;
      }
    }
  }
  .numall {
    width: 190px;
    color: #efca0f;
    background: rgba(3, 139, 252, 0.2);
    font-size: 32px;
    font-weight: bold;
    font-family: "digi";
    line-height: 60px;
    text-align: center;
    div {
      color: #88dddf;
      position: absolute;
      font-size: 14px;
      right: 10px;
      bottom: 5px;
      line-height: 10px;
    }
  }
}
</style>