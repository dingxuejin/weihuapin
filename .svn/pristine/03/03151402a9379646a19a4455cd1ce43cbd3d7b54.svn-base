<template>
  <div class="dropDownWrap">

    <!-- 下拉按钮 -->
    <i @click="detailsBtn"></i>

    <!-- 输入框 -->
    <input type="text"
           v-model='optionSelected'
           @focus='detailsBtn'>
    <!-- 显示默认第一个option(调用computed : firstItem方法)  -->
    <div style="display:none;">{{firstOption}}</div>

    <!-- options -->
    <div class="optionContent"
         v-if="showOptions" 
           @mouseleave='mouseLeaveHide'>
      <ul>
        <li v-for="option in options"
            :key=option.id
            @click="selectItem(option)">{{option}}</li>
      </ul>
    </div>

  </div>
</template>

<script>
export default {
  // props: ['options'],
  data() {
    return {
      optionSelected: '',
      showOptions: false,
      options: ['车队', '总公司1', '总公司2', '总公司3', '总公司4', '总公司5'],
    }
  },
  computed: {
    firstOption() {
      if (this.options.length > 0) {
        this.optionSelected = this.options[0]
      }
      return null
    },
  },
  methods: {
    selectItem(option) {
      this.optionSelected = option
      this.$emit('selected', this.optionSelected)
      this.showOptions = false
    },
    detailsBtn() {
      this.showOptions = !this.showOptions
    },
    mouseLeaveHide() {
      this.showOptions = false
    },
  },
}
</script>

<style lang="scss">
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.dropDownWrap {
  @include size(100%,25px);
  i {
    @include size(15px,8px);
    position: absolute;
    top: 10px;
    right: 12px;
    z-index: 15;
    background: url(~assets/car/css_sprite_car-01.png) no-repeat -760px -40px;
  }
  i:hover {
    background: url(~assets/car/css_sprite_car-01.png) no-repeat -820px -40px;
  }
  input {
    @include size(100%,100%);
    outline: none;
    display: block;
    line-height: 100%;
    padding-left: 10px;
    color: #b5b5b5;
    font-size: 14px;
    margin: 0 auto;
    border: 0.5px solid rgba(129, 217, 229, 0.6);
    background: #090a0b;
    box-sizing: border-box;
  }

  .optionContent {
    width: 100%;
    padding-top: 5px;
    padding-bottom: 5px;
    position: relative;
    top: 5px;
    left: 0px;
    border: 1px solid #81d9e5;
    box-sizing: border-box;
    z-index: 21;
    background: #090a0b;
    overflow: hidden;
    ul {
      width: 98%;
      max-height: 135px;
      list-style: none;
      margin: 0;
      padding: 0;
      background: #090a0b;
      position: relative;
      top: 0px;
      left: 0px;
      overflow: hidden;
      overflow-y: scroll;
      box-sizing: border-box;
      li {
        height: 25px;
        list-style: none;
        margin: 0;
        padding: 0;
        line-height: 25px;
        font-size: 14px;
        color: #b5b5b5;
        padding-left: 20px;
        box-sizing: border-box;
        cursor: pointer;
      }
      li:hover {
        background: rgba(5, 208, 235, 0.5);
        color: #fff;
      }
    }
    ul::-webkit-scrollbar {
      width: 5px;
      height: 125px;
      background: url(~assets/car/scroll.png) no-repeat center center;
      // position: relative;
      // right: 10px;
      // top: 5px;
    }
    ul::-webkit-scrollbar-thumb {
      background: rgba(5, 208, 235, 1);
    }
  }
}
</style>
