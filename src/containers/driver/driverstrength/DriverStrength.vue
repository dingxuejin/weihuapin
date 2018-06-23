<template>
  <div class="dstrength">
    <div class="dstrength_title">工作强度</div>
    <div class="dstrength_acc">
      <div class="dstrength_key">累计驾驶时长</div>
      <div class="dstrength_time">245</div>
      <div class="dstrength_unit">h</div>
      <div class="dstrength_state"></div>
      <div class="dstrength_value">56%</div>
    </div>
    <ul class="dstrength_list">
      <li class="dstrength_item">
        <div class="dstrength_subtitle">日均驾驶时长</div>
        <ul class="dstrength_contentspecial">
          <li class="dstrength_specialitem">
            <div class='dstrength_key'>上周期</div>
            <div class='dstrength_svalue'>99%</div>
            <div class='dstrength_periodstate'></div>
            <div class='dstrength_changeratio'>99%</div>
          </li>
          <li class="dstrength_specialitem ">
            <div class='dstrength_key'>上周期</div>
            <div class='dstrength_svalue dstrength_thisweek'>99%</div>
            <div class='dstrength_periodstate'></div>
            <div class='dstrength_changeratio dstrength_thisweek'>99%</div>
          </li>
        </ul>
      </li>
      <li class="dstrength_item">
        <div class="dstrength_subtitle">昼夜驾驶时长比例</div>
        <ul class="dstrength_contentspecial">
          <li class="dstrength_specialitem">
            <div class='dstrength_key'>上周期</div>
            <div class='dstrength_svalue'>99%</div>
            <div class='dstrength_periodstate'></div>
            <div class='dstrength_changeratio'>99%</div>
          </li>
          <li class="dstrength_specialitem ">
            <div class='dstrength_key'>上周期</div>
            <div class='dstrength_svalue dstrength_thisweek'>99%</div>
            <div class='dstrength_periodstate'></div>
            <div class='dstrength_changeratio dstrength_thisweek'>99%</div>
          </li>
        </ul>
      </li>
    </ul>
    <div class="dstrength_detail">
      <div class="dstrength_detailbtn">
        行驶里程统计
      </div>
    </div>
  </div>
</template>
<script>
export default {}
</script>
<style lang="scss" scoped>
.dstrength {
  height: 265px;
  &_title {
    text-align: center;
    font-weight: bold;
    line-height: 30px;
    height: 30px;
    width: 165px;
    color: #89dddf;
    font-size: 18px;
    background-color: rgba(129, 217, 229, 0.3);
  }
  &_acc {
    height: 80px;
    margin-right: -100px;
    div {
      display: inline-block;
      margin-right: 100px;
    }
  }
  &_key {
    color: #81d9e5;
    font-size: 16px;
  }
  &_time {
    line-height: 60px;
    color: #89dddf;
    font-weight: bold;
    font-family: digi;
    font-size: 60px;
  }
  &_unit {
    color: #89dddf;
    font-size: 16px;
    font-family: "regular";
  }
  &_state {
    width: 56px;
    height: 48px;
    background: url("../../../assets/driver/right_mileage_icons_trophy_big.png")
      no-repeat;
  }
  &_value {
    line-height: 32px;
    font-family: digi;
    color: #05d0eb;
    font-size: 32px;
    font-weight: bold;
  }
  &_list {
    background: url("../../../assets/driver/right_decorate_line1.png") no-repeat
      center;
    width: 720px;
    height: 110px;
  }
  &_item {
    float: left;
    width: 50%;
    height: 110px;
    &:nth-child(even) {
      margin-left: 60px;
      margin-right: -60px;
    }
  }
  &_subtitle {
    color: #81d9e5;
    font-size: 16px;
  }
  &_contentspecial {
    width: 100%;
    li {
      height: 47px;
      width: 100%;
      div {
        // float:left;
        display: inline-block;
      }
    }
  }
  &_key {
    font-size: 16px;
    color: #81d9e5;
  }
  &_svalue {
    color: #89dddf;
    font-size: 36px;
    font-weight: bold;
    font-family: digi;

    margin-left: 20px;
  }
  &_periodstate {
    width: 28px;
    height: 24px;
    background: url("../../../assets/driver/right_mileage_icons_trophy_small.png");

    margin-left: 60px;
  }
  &_changeratio {
    font-family: digi;
    color: #05d0eb;
    font-size: 32px;
    font-weight: bold;

    margin-left: 20px;
  }
  &_thisweek {
    color: #efca0f;
  }
  &_detail {
    margin-top: 5px;
    position: relative;
  }
  &_detailbtn {
    height: 40px;
    float: right;
    width: 200px;
    background-color: rgba(5, 208, 235, 0.2);
    border: 1px solid rgba(5, 208, 235, 0.4);
    color: #b5b5b5;
    font-size: 16px;
    line-height: 38px;
    text-align: center;
    box-sizing: border-box;

    float: right;
  }
}
</style>
