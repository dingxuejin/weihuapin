<template>
  <div class="kind">
    <div class="icon"></div>
    <div class="name">{{name}}</div>
    <div class="iconx" :class='[type]'></div>
    <div class="score">
      <div>本年得分</div>
      <div>{{year}}</div>
      <div></div>
    </div>
    <div class="score month">
        <div>本月得分</div>
        <div>{{month}}</div>
        <div></div>
    </div>
  </div>
</template>

<script>
export default{
  props: ['type', 'name', 'year', 'month'],
}
</script>
<style lang="scss" scoped>
  .kind {
    // width: 330px;
    width: 500px;
    height: 80px;
    background: rgba(9, 122, 206, .2);
    .icon {
      width: 10px;
      height: 10px;
      float: left;
      background: url('../../assets/companysecure/icon_font.png');
      margin-left: 20px;
      margin-top: 15px;
    }
    .name{
      font-size: 18px;
      font-weight: bold;
      color: #81d9e5;
      float: left;
      margin-top: 10px;
      margin-left: 10px;
    }
    .iconx {
      height: 28px;
      float: right;
      margin-top: 10px;
      margin-right: 10px;
    }
    .danger{
      width: 45px;
      background: url('../../assets/companysecure/danger_icon.png') no-repeat;
    }
    .illegal{
      width: 33px;
      background: url('../../assets/companysecure/illegal_icon.png') no-repeat;
    }
    .law{
      width: 33px;
      background: url('../../assets/companysecure/law_icon.png') no-repeat;
    }
    .event{
      width: 24px;
      background: url('../../assets/companysecure/event_icon.png') no-repeat;
    }
    .score{
      float: left;
      width:155px;
      position: relative;
      top:-8px;
      left: 184px;
      div{
        float: left;
      }
      div:nth-child(1){
        color:#ffffff;
        line-height: 55px;
        margin-right: 14px;
        font-size: 14px;
        text-indent:16px;
      }
      div:nth-child(2){
        line-height: 55px;
        font-size: 26px;
        font-weight: bold;
        font-family: 'digi';
        color:#89dddf;
        margin-right: 10px;
      }
      div:nth-child(3){
        width: 9px;
        height: 28px;
        background: url('../../assets/companysecure/up_green.png') no-repeat;
        margin-top: 13px;
      }
    }
    .month{
      div:nth-child(2){
        color:#efca0f;
      }
      div:nth-child(3){
        background: url('../../assets/companysecure/down_red.png') no-repeat;
      }
    }
    div:nth-child(4){
      // margin-left: 40px;
      // margin-right: 20px;
      clear: both;
    }
  }

</style>
