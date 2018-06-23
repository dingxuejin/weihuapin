<template>
  <div class="dhlayout">
    <div class="dhlayout_left fl">
      <div class="dhlayout_base">
        <slot name='base'></slot>
      </div>
      <div class="dhlayout_certificate">
        <slot name='certificate'></slot>
      </div>
    </div>
    <div class="dhlayout_center fl">
      <div class="dhlayout_route">
        <slot name='route'></slot>
      </div>
      <div class="dhlayout_trainingreward">
        <slot name='trainingreward'></slot>
      </div>
    </div>
    <div class="dhlayout_right fl">
      <div class="dhlayout_mileage">
        <slot name='mileage'></slot>
      </div>
      <div class="dhlayout_workstrength">
        <slot name='workstrength'></slot>
      </div>
      <div class="dhlayout_waybill">
        <slot name='waybill'></slot>
      </div>
    </div>
  </div>
</template>
<script>
export default {}
</script>
<style lang="scss" scoped>
.dhlayout {
  height: 840px;
  width: 2360px;
  margin-left: 50px;
  &_left {
  }
  &_base {
    // background-color: red;
  }
  &_certificate {
    margin-top: 20px;
    // background-color: orange;
  }
  &_center {
    margin-left: 50px;
  }
  &_route {
    // background-color: yellow;
  }
  &_trainingreward {
    margin-top: 20px;
    // background-color: green;
  }
  &_right {
    margin-left: 50px;
    // background-color: blue;
  }
  &_mileage {
    // margin-top: 10px;
  }
  &_workstrength {
    margin-top: 5px;
  }
  &_waybill {
    margin-top: 5px;
  }
}
</style>
