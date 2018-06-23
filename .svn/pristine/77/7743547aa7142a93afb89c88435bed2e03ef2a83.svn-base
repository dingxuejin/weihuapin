<template>
  <div class="popDriverSafe">
    <pop-up-widget title='积分详情'></pop-up-widget>
    <div class="popDriverSafe_Title">
      <div class="itemName">时间</div>
      <div class="itemName">扣分原因</div>
      <div class="itemName">扣除分数</div>
      <div class="itemName">扣除奖金数</div>
    </div>
    <div class="popDriverSafe_Con">
      <ul>
        <li>
          <div>2017-12-28</div>
          <div>超车</div>
          <div>6分</div>
          <div>80元</div>
        </li>
        <li>
          <div>2017-12-28</div>
          <div>超车</div>
          <div>6分</div>
          <div>80元</div>
        </li>
        <li>
          <div>2017-12-28</div>
          <div>超车</div>
          <div>6分</div>
          <div>80元</div>
        </li>
        <li>
          <div>2017-12-28</div>
          <div>超车</div>
          <div>6分</div>
          <div>80元</div>
        </li>
        <li>
          <div>2017-12-28</div>
          <div>超车</div>
          <div>6分</div>
          <div>80元</div>
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
    ...mapState('driverbase', ['ryjb']),
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
.popDriverSafe{
  @include size(710px,192px);
  position: relative;
  &_Title{
    @include size(100%,40px);
    .itemName{
      @include size(170px,100%);
      float: left;
      margin-right:5px;
      font-size: 16px;
      line-height: 40px;
      text-align: center;
      color: #81D9E5;
      &:nth-child(4n){
        margin-right:0px;
      }
    }
    // div{
    //   @include size(170px,40px);
    //   float: left;
    //   margin-right:5px;
    //   font-size: 16px;
    //   line-height: 40px;
    //   text-align: center;
    //   color: #81D9E5;
    //   &:nth-child(2n){
    //     margin-right:0px;
    //   }
    // }
    // .itemCon{
    //   background:rgba(3,139,252,0.4);
    //   color: #fff;
    //   font-size: 22px;
    // }
    //  .tagContent2{
    //   @include size(100%,auto);
    //   .tagContent2Tag{ 
    //     @include size(100%,auto);
    //     margin-top:3px;
    //     .itemCon{
    //       @include size(170px,40px);
    //       display:inline-block;
    //       background: rgba(3,139,252,0.4);
    //       text-align: center;
    //       color: #fff;
    //       font-size: 18px;
    //       line-height: 40px;
    //       margin-top:10px;
    //       margin-right:5px;
    //       &:nth-child(4n){
    //         margin-right: 0;
    //       }
    //     }
    //   }
    // }
  }
  &_Con {
    @include size(710px,82px);
    // background:palevioletred;
    ul{
        @include size(100%,82px);
        margin-top:10px;
        overflow: hidden;
        overflow-y: scroll;
        // background: #00bfe5;
        li{
          @include size(100%,40px);
          box-sizing: border-box;
          font-size: 22px;
          color:#fff;
          line-height:40px;
          // padding-left: 40px;
          div{
            @include size(170px,37px);
            background:rgba(3,139,252,0.4);
            display: inline-block;
            font-size:16px;
            color:#fff;
            text-align:center;
            line-height: 37px;
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
</style>
