<template>
  <div class="layerSon"
       @click='change'>
    <div class="son_left">
      <div class="icon"
           :class='[icon]'></div>
      <div class="name" :title="labelname">{{labelname}}</div>
    </div>
    <div class="son_right"
         :class='[bgcolor]'>
      <div class="iconsmall"></div>
      <div class="value"
           :title="labelvalue">{{labelvalue}}</div>
    </div>
  </div>
</template>

<script>
export default {
  props: ['labelname', 'labelvalue', 'icon', 'bgcolor'],
  methods: {
    change() {
      this.$emit('up')
    },
  },
}
</script>

<style lang="scss" scoped>
.layerSon {
  width: 480px;
  height: 40px;
  float: left;
  margin: 10px;
  .son_left {
    width: 220px;
    height: 40px;
    background: rgba(129, 217, 229, 0.08);
    float: left;
    .icon {
      width: 40px;
      height: 24px;
      margin: 8px 10px 8px 20px;
      float: left;
    }
    .icon1 {
      background: url("../../assets/company/company_infor_icon_1.png") no-repeat;
    }
    .icon2 {
      background: url("../../assets/company/company_infor_icon_2.png") no-repeat;
    }
    .icon3 {
      background: url("../../assets/company/company_infor_icon_3.png") no-repeat;
    }
    .icon4 {
      background: url("../../assets/company/company_infor_icon_4.png") no-repeat;
    }
    .icon5 {
      background: url("../../assets/company/company_infor_icon_5.png") no-repeat;
    }
    .icon6 {
      background: url("../../assets/company/company_infor_icon_6.png") no-repeat;
    }
    .icon7 {
      background: url("../../assets/company/company_infor_icon_7.png") no-repeat;
    }
    .icon8 {
      background: url("../../assets/company/company_infor_icon_8.png") no-repeat;
    }
    .icon9 {
      background: url("../../assets/company/company_infor_icon_9.png") no-repeat;
    }
    .icon10 {
      background: url("../../assets/company/company_infor_icon_10.png")
        no-repeat;
    }
    .name {
      line-height: 40px;
      font-size: 16px;
      color: #89dddf;
      float: left;
      width: 140px;
      overflow: hidden;
      text-overflow: ellipsis;
      white-space: nowrap;
    }
  }
  .son_right {
    width: 260px;
    height: 40px;
    box-sizing: border-box;
    border: 1px solid #81d9e5;
    float: left;
    // overflow: hidden;
    .iconsmall {
      width: 10px;
      height: 10px;
      background: rgba(5, 208, 235, 1);
      transform: rotate(45deg);
      margin: 14px 20px;
      float: left;
    }
    .value {
      width: 205px;
      font-size: 18px;
      font-weight: bold;
      color: #ffffff;
      float: left;
      line-height: 38px;
      overflow: hidden;
      white-space: nowrap;
      text-overflow: ellipsis;
    }
  }
  .green {
    border-color: rgba(5, 208, 235, 1);
    background-color: rgba(5, 208, 235, 0.4);
    .iconsmall {
      background: rgba(5, 208, 235, 1);
    }
  }
  .yellow {
    border-color: rgba(255, 185, 46, 1);
    background-color: rgba(255, 185, 46, 0.4);
    .iconsmall {
      background: rgba(255, 185, 46, 1);
    }
  }
  .red {
    border-color: rgba(231, 80, 41, 1);
    background-color: rgba(231, 80, 41, 0.4);
    .iconsmall {
      background: rgba(231, 80, 41, 1);
    }
  }
}
</style>