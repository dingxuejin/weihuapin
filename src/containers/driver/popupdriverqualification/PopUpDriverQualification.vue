<template>
  <div>
    <pop-up-widget title='资格证书'
                   detailsBtnShow='true'></pop-up-widget>
    <div class='qualify'>
      <div class='qualify_wrap'>
        <div class='qualify_detail'></div>
        <div class='qualify_btn'
             @click='drivePop = true'>驾驶证</div>
      </div>
      <div class='qualify_wrap'>
        <div class='qualify_detail'></div>
        <div class='qualify_btn'
             @click='workPop = true'>从业资格证</div>
      </div>
    </div>

    <div class="driver_pop"
         :class="[drivePop?'driver_pop-show':'driver_pop-hide']">
      <pop-up-frame @close='drivePop = false'>
        <pop-up-driver-license ></pop-up-driver-license>
      </pop-up-frame>
    </div>
    <div class="work_pop"
         :class="[workPop?'work_pop-show':'work_pop-hide']">
      <pop-up-frame @close='workPop = false'>
          <pop-up-work-qualification></pop-up-work-qualification>
      </pop-up-frame>
    </div>

  </div>
</template>
<script>
import PopUpWidget from '../../../components/PopUpWidget'
import PopUpFrame from '../../../components/PopUpFrame'
import PopUpDriverLicense from '../popupdriverlicense/PopUpDriverLicense'
import PopUpWorkQualification from '../popupworkqualification/PopUpWorkQualification'

export default {
  components: {
    PopUpWidget,
    PopUpFrame,
    PopUpDriverLicense,
    PopUpWorkQualification,
  },
  data: () => ({
    drivePop: false,
    workPop: false,
  }),
}
</script>
<style lang="scss" scoped>
.qualify {
  width: 710px;
  height: 225px;
  padding-left: 20px;
  &_wrap {
    width: 320px;
    height: 205px;
    float: left;
    &:nth-child(2) {
      margin-left: 50px;
    }
  }
  &_detail {
    width: 320px;
    height: 155px;
    float: left;
    margin-bottom: 10px;
    margin-top: 10px;
    box-sizing: border-box;
    background-color: rgba(5, 208, 235, 0.4);
    border: 2px solid #81d9e5;
  }
  &_btn {
    float: left;
    height: 40px;
    width: 320px;
    box-sizing: border-box;
    background-color: rgba(5, 208, 235, 0.4);
    border: 1px solid rgba(5, 208, 235, 1);
    font-size: 24px;
    color: white;
    text-align: center;
    line-height: 40px;
  }
}
.driver_pop {
  position: absolute;
  top: 280px;
  left: 40px;
  &-show {
    display: block;
  }
  &-hide {
    display: none;
  }
}
.work_pop {
  position: absolute;
  top: 280px;
  left: 400px;

  &-show {
    display: block;
  }
  &-hide {
    display: none;
  }
}
</style>    

