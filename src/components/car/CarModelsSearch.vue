<template>
  <div class="carModelsSearch">
    <i @click="submitInputMsg"></i>
    <input type="text"
           placeholder='输入车辆车牌搜索，如"京AAF905"'
           v-model='inputMsg'
           @keyup.enter="submitInputMsg">
    <div class="validationvMsg"
         v-if="validationvMsg">请输入正确车辆型号,如"京AAF905"</div>
    <div class="validationvMsg"
         v-if="dataErroMsg">{{showErroMsg}}</div>
  </div>
</template>

<script>
export default {
  name: 'car-models-search',
  props: ['cljcxxData_ErroMsg'],
  data() {
    return {
      inputMsg: '',
      validationvMsg: false,
      dataErroMsg: false,
    }
  },
  computed: {
    showErroMsg() {
      if (this.cljcxxData_ErroMsg) {
        this.dataErroMsg = true
        return this.cljcxxData_ErroMsg
      }
      return true
    },
  },
  methods: {
    submitInputMsg() {
      if (this.inputMsg === '') {
        this.validationvMsg = true
        setTimeout(() => {
          this.validationvMsg = false
        }, 1000)
      } else {
        this.$emit('receiverParams', this.inputMsg)
        this.inputMsg = ''
      }
    },
  },
}
</script>

<style lang="scss">
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.carModelsSearch {
  @include size(100%,100%);
  position: relative;
  padding: 5px;
  background: rgba(3, 139, 252, 0.2);
  box-sizing: border-box;
  i {
    @include size(20px,18px);
    position: absolute;
    top: 12px;
    right: 26px;
    background: url(~assets/car/css_sprite_car-01.png) no-repeat -520px -40px;
    z-index: 5;
  }
  i:hover {
    background: url(~assets/car/css_sprite_car-01.png) no-repeat -580px -40px;
  }
  input {
    @include size(100%,30px);
    color: #b5b5b5;
    font-size: 16px;
    border: 2px solid rgba(0, 191, 229, 0.5);
    padding-left: 19px;
    padding-top: 5px;
    padding-bottom: 5px;
    outline: none;
    box-sizing: border-box;
    background: none;
  }
  input:focus {
    outline: 1px solid rgba(0, 191, 229, 0.8);
  }
  .validationvMsg {
    width: 235px;
    height: 30px;
    line-height: 30px;
    text-align: center;
    font-size: 14px;
    color: red;
    position: absolute;
    top: 5px;
    right: -240px;
  }
}
</style>
