<template>
  <div>
    <pop-up-widget title='驾驶员基本信息'></pop-up-widget>
    <div class="popUpBoxContent"
         slot="popUpBoxContent"
         v-if="ryjb">
      <div class="itemWrap">
        <div class="subTitle">驾驶员基本信息</div>
        <div class="content">{{ryjb.idcertificate_number}}
          <div class="rotateBox"></div>
        </div>
      </div>
      <div class="itemWrap clearMarginRight">
        <div class="subTitle">国籍</div>
        <div class="content">{{ryjb.nationality}}
          <div class="rotateBox"></div>
        </div>
      </div>
      <div class="itemWrap">
        <div class="subTitle">出生日期</div>
        <div class="content">{{formatDate(ryjb.birth_date||'')}}
          <div class="rotateBox"></div>
        </div>
      </div>
      <div class="itemWrap clearMarginRight">
        <div class="subTitle">性别</div>
        <div class="content">{{ryjb.ryxb.gender}}
          <div class="rotateBox"></div>
        </div>
      </div>
      <div class="itemWrap">
        <div class="subTitle">学历</div>
        <div class="content">{{ryjb.ryxl.education}}
          <div class="rotateBox"></div>
        </div>
      </div>
      <div class="itemWrap clearMarginRight">
        <div class="subTitle">婚姻状况</div>
        <div class="content">{{ryjb.ryhy.marital_status}}
          <div class="rotateBox"></div>
        </div>
      </div>
      <div class="itemWrap">
        <div class="subTitle">驾龄</div>
        <div class="content">{{ryjb.employment_years}}
          <div class="rotateBox"></div>
        </div>
      </div>
      <div class="itemWrap clearMarginRight">
        <div class="subTitle">住址</div>
        <div class="content">{{ryjb.address}}
          <div class="rotateBox"></div>
        </div>
      </div>
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
}
</script>
<style lang="scss" scoped>
@mixin size($width,$height) {
  width: $width;
  height: $height;
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
