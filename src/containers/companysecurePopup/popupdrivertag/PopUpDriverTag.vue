<template>
  <div class="popDriverTag">
    <div class="tagName">
      <div :class="activeTagKey===1?'activeTag':''" @click="selectTag(1)">他的标签</div>
      <div :class="activeTagKey===2?'activeTag':''" @click="selectTag(2)">同事印象</div>
    </div>
    <div class="lineDis"></div>
    <div class="tagContent1" v-if="activeTagKey===1&&DriverMyselfTag&&DriverMyselfTag!==null">
      <div class="itemCon" v-for="(item,index) in DriverMyselfTag" :key="index">{{item.label_content}}</div>
    </div>
    <div class="tagContent2" v-if="activeTagKey===2&&DriverTheirTag&&DriverTheirTag !== null">
      <div class="tagContent2Tag">
        <div class="itemCon" v-for="(item,index) in DriverTheirTag" :key="index">{{item.label_content}}</div>
      </div>
      <ul>
        <li v-for="(item,index) in DriverTheirTag" :key="index">
          {{item.ryjb.name}}于{{item.date}}评价他：{{item.label_content}}
        </li>
      </ul> 
    </div>
  </div>
</template>
<script>
import { mapState } from 'vuex'
import PopUpWidget from '../../../components/PopUpWidget'

export default {
  components: {
    PopUpWidget,
  },
  computed: {
    ...mapState('PopUpDriverTag', ['DriverMyselfTag', 'DriverTheirTag']),
  },
  data() {
    return {
      activeTagKey: 1,
    }
  },
  methods: {
    selectTag(item) {
      this.activeTagKey = item
    },
  },
}
</script>
<style lang="scss" scoped>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.popDriverTag{
  @include size(710px,100%);
  position: relative;
  .tagName{
    @include size(100%,60px);
    display: flex;
    justify-content:space-around;
    margin-top:10px;
    div{
      @include size(200px,40px);
      background: rgba(0, 191, 229, 0.2);
      text-align: center;
      line-height:40px;
      color: #b5b5b5;
      box-sizing:border-box;
      border:1px solid #00bfe5;
      cursor: pointer;
      font-size: 22px;
    }
    .activeTag{
      background: rgba(0, 191, 229, 0.5);
      color:#fff!important;
    }
  }
  .lineDis{
    @include size(710px,2px);
    position: absolute;
    background: rgba(129, 217, 229, 0.5);
    &::before{
      content:'';
      @include size(20px,2px);
      background: #81d9e5;
      position: absolute;
      top: 0px;
      left: 0;
    }
    &::after{
      content:'';
      @include size(20px,2px);
      background: #81d9e5;
      position: absolute;
      top: 0px;
      right: 0;
    }
  }
  .tagContent1{
    // @include size(100%,154px);
    @include size(100%,104px);
    // display:flex;
    // justify-content: space-around;
    // flex-wrap: wrap;
    margin-top:10px;
    .itemCon{
      @include size(170px,40px);
      float: left;
      // display:inline-block;
      background: rgba(3,139,252,0.4);
      text-align: center;
      color: #fff;
      font-size: 18px;
      line-height: 40px;
      margin-top:12px;
      margin-right:10px;
      &:nth-child(4n){
        margin-right: 0;
      }
    }
  }
  .tagContent2{
    @include size(100%,auto);
    .tagContent2Tag{ 
      @include size(100%,auto);
      margin-top:3px;
      .itemCon{
        @include size(170px,40px);
        display:inline-block;
        background: rgba(3,139,252,0.4);
        text-align: center;
        color: #fff;
        font-size: 18px;
        line-height: 40px;
        margin-top:10px;
        margin-right:10px;
        &:nth-child(4n){
          margin-right: 0;
        }
      }
    }
    ul{
      @include size(100%,190px);
      margin-top:10px;
      overflow: hidden;
      overflow-y: scroll;
      // background: #00bfe5;
      li{
        @include size(100%,40px);
        box-sizing: border-box;
        background: rgba(81,81,81,0.30);
        // background: rgba(5,208,235,0.20);
        display: inline-block;
        // border-top:2px solid rgba(129,217,229,0.5);
        font-size: 16px;
        color:#fff;
        line-height:40px;
        padding-left: 40px;
        margin-top:10px;
        &:nth-child(1){
          margin-top:0;
        }
      }
    }
    ul::-webkit-scrollbar {
      width: 3px;
      background: #69a3b1;
    }
    ul::-webkit-scrollbar-thumb {
      background: #05f0eb;
    }
  }
}

.popUpBoxContent {
  @include size(710px,100%);
  // margin: 16px;

  position: relative;
  overflow: hidden;
  .itemWrap {
    @include size(350px,30px);
    line-height: 30px;
    margin-bottom: 10px;
    margin-right: 10px;
    float: left;
    .subTitle {
      @include size(110px,30px);
      line-height: 30px;
      text-align: left;
      color: #89dddf;
      font-size: 14px;
      float: left;
    }
    .content {
      @include size(240px,30px);
      line-height: 30px;
      padding-left: 30px;
      color: #fff;
      font-size: 14px;
      font-weight: bold;
      border: 1px solid #89dddf;
      float: left;
      position: relative;
      box-sizing: border-box;
      .rotateBox {
        @include size(7px,7px);
        position: absolute;
        top: 11px;
        left: 10px;
        transform: rotate(45deg);
        background: #05d0eb;
      }
    }
  }
  .remindRed {
    .content {
      background: rgba(231, 80, 41, 0.4);
      border: 1px solid rgba(231, 80, 41, 1);
      .rotateBox {
        background: rgba(231, 80, 41, 1);
      }
    }
  }
  .remindYellow {
    .content {
      background: rgba(255, 185, 46, 0.4);
      border: 1px solid rgba(255, 185, 46, 1);
      .rotateBox {
        background: rgba(255, 185, 46, 1);
      }
    }
  }
  .remindGreen {
    .content {
      background: rgba(5, 208, 235, 0.4);
      border: 1px solid rgba(5, 208, 235, 1);
      .rotateBox {
        background: rgba(5, 208, 235, 1);
      }
    }
  }

  .clearMarginRight {
    margin-right: 0;
  }
}
</style>
