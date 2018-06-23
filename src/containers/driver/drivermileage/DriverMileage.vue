<template>
  <div class="dmileage">
    <div class="dmileage_title">行驶里程</div>
    <ul class="dmileage_list">
      <li class="dmileage_item">
        <div class="dmileage_subtitle">累计行驶里程</div>
        <div class="dmileage_content">
          <div class="dmileage_value">9999
            <span>km</span>
          </div>
          <div class="dmileage_state">
            <div class="dmileage_stateval">25%</div>
            <div class="dmileage_statesymbol"></div>
          </div>
        </div>
      </li>
      <li class="dmileage_item">
        <div class="dmileage_subtitle">空车行驶里程</div>
        <div class="dmileage_content">
          <div class="dmileage_value">9999
            <span>km</span>
          </div>
          <div class="dmileage_state">
            <div class="dmileage_stateval">25%</div>
            <div class="dmileage_statesymbol"></div>
          </div>
        </div>
      </li>
      <li class="dmileage_item">
        <div class="dmileage_subtitle">重车行驶里程</div>
        <div class="dmileage_content">
          <div class="dmileage_value">9999
            <span>km</span>
          </div>
          <div class="dmileage_state">
            <div class="dmileage_stateval">25%</div>
            <div class="dmileage_statesymbol"></div>
          </div>
        </div>
      </li>
      <li class="dmileage_item">
        <div class="dmileage_subtitle">空重车里程比</div>
        <ul class="dmileage_contentspecial">
          <li class="dmileage_specialitem">
            <div class='dmileage_key'>上周期</div>
            <div class='dmileage_svalue'>99%</div>
            <div class='dmileage_periodstate'></div>
            <div class='dmileage_changeratio'>99%</div>
          </li>
          <li class="dmileage_specialitem ">
            <div class='dmileage_key'>上周期</div>
            <div class='dmileage_svalue dmileage_thisweek'>99%</div>
            <div class='dmileage_periodstate'></div>
            <div class='dmileage_changeratio dmileage_thisweek'>99%</div>
          </li>
        </ul>
      </li>
    </ul>
    <div class="dmileage_detail">
      <div class="dmileage_detailbtn">
        行驶里程统计
      </div>
    </div>
  </div>
</template>



<script>
export default {}
</script>
<style lang="scss" scoped>
.dmileage {
  height: 325px;
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
  &_list {
    margin-top: 20px;
    width: 720px;
    height: 230px;
    background: url("../../../assets/driver/right_decorate_line2.png") no-repeat
      center;
  }
  &_item {
    width: 50%;
    height: 115px;
    float: left;
    &:nth-child(even) {
      width: 358px;
      margin-left: 60px;
      margin-right: -60px;
    }
  }
  &_subtitle {
    color: #81d9e5;
    font-size: 16px;
  }
  &_content {
    position: relative;
    height: 99px;
    line-height: 60px;
    color: #89dddf;
    font-weight: bold;
    font-family: digi;
    font-size: 60px;
    span {
      font-size: 16px;
      font-family: "regular";
    }
  }

  &_state {
    float: right;
    margin-right: 60px;
  }
  &_value {
    margin-top: 20px;
    float: left;
  }
  &_stateval {
    line-height: 32px;
    font-family: digi;
    color: #05d0eb;
    font-size: 32px;
    font-weight: bold;
  }
  &_statesymbol {
    width: 56px;
    height: 48px;
    background: url("../../../assets/driver/right_mileage_icons_trophy_big.png")
      no-repeat;
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
  &_period {
    width: 360px;
    float: left;
    height: 60px;

    div {
      float: left;
      margin-bottom: 0px;
    }
  }

  &_contentspecial {
    width: 100%;
    li {
      height: 49.5px;
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
}
</style>
