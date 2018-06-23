<template>
  <div class="dwaybill">
    <div class="dwaybill_title">运单数量</div>
    <ul class="dwaybill_list">
      <li class="dwaybill_item">
        <div class="dwaybill_subtitle">累计运单总量</div>
        <div class="dwaybill_content">
          <div class="dwaybill_value">9999
            <span>单</span>
          </div>
          <div class="dwaybill_state">
            <div class="dwaybill_stateval">25%</div>
            <div class="dwaybill_statesymbol"></div>
          </div>
        </div>
      </li>
      <li class="dwaybill_item">
        <div class="dwaybill_subtitle">空车行驶里程</div>
        <div class="dwaybill_content">
          <div class="dwaybill_value">9999
            <span>km</span>
          </div>
          <div class="dwaybill_state">
            <div class="dwaybill_stateval">25%</div>
            <div class="dwaybill_statesymbol"></div>
          </div>
        </div>
      </li>
    </ul>
    <div class="dwaybill_detail">
      <div class="dwaybill_detailbtn">
        运单数量统计
      </div>
    </div>
  </div>
</template>
<script>
export default {}
</script>
<style lang="scss" scoped>
.dwaybill {
    height: 210px;
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
    height: 110px;
    background: url("../../../assets/driver/right_decorate_line1.png") no-repeat
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
}
</style>
