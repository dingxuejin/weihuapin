<template>
  <div>
    <pop-up-widget title='资格证书'
                   detailsBtnShow='true'
                   @popUpdetailsBtn="otherPop = true"></pop-up-widget>
    <div class='qualify'
         v-if="ryjb">
      <div class='qualify_wrap'
           v-if="popUpDriverLicense">
        <!-- 驾驶证 -->
        <div class='qualify_detail eleScrollBar'>
          <div class="item qualify_detail-front">
            <div class="titleName">中华人民共和国机动车驾驶证</div>
            <div class="titleNameEnglish">Driving License Of People's Republic Of China</div>
            <div class="qualifyIdCon clearfix">
              <div class="fl">证号</div>
              <div class="fl">{{popUpDriverLicense.license_number}}</div>
            </div>

            <div class="indexDetailsCon clearfix">
              <div class="detailsItem clearfix">
                <div class="fl clearfix">
                  <div class="title fl">姓名</div>
                  <div class="index fl">{{popUpDriverLicense.ryjb.name}}</div>
                </div>

                <div class="fl clearfix">
                  <div class="title fl">性别</div>
                  <div class="index fl">{{popUpDriverLicense.ryjb.ryxb.gender}}</div>
                </div>

                <div class="fl clearfix">
                  <div class="title fl">国籍</div>
                  <div class="index fl">{{popUpDriverLicense.ryjb.nationality}}</div>
                </div>
              </div>

              <!-- 第二行 -->
              <div class="detailsItem fl clearfix">
                <div>住址</div>
                <div>{{popUpDriverLicense.ryjb.address}}</div>
              </div>

              <!-- 第三行 -->
              <div class="detailsItem fl clearfix">
                <div class="fl clearfix">
                  <div class="fl">出生日期</div>
                  <div class="fl">{{formatDate(popUpDriverLicense.ryjb.birth_date)}}</div>
                </div>

                <div class="fl clearfix">
                  <div class="fl">初次领证日期</div>
                  <div class="fl">{{formatDate(popUpDriverLicense.initialcollection_date)}}</div>
                </div>
              </div>

              <!-- 第四行 -->
              <div class="detailsItem fl clearfix">
                <div class="fl clearfix">
                  <div class="fl">准驾车型</div>
                  <div class="fl">{{popUpDriverLicense.allow_driving_type_code}}</div>
                </div>

                <div class="fl clearfix">
                  <div class="fl">有效期限</div>
                  <div class="fl">
                    {{formatDate(popUpDriverLicense.effective_date)}} 至 {{formatDate(popUpDriverLicense.expire_date)}}
                  </div>
                </div>
              </div>

            </div>

          </div>

          <div class="item qualify_detail-rear">
            <div class="titleName">中华人民共和国机动车驾驶证</div>
            <div class="titleNameEnglish">Driving License Of People's Republic Of China</div>
            <div class="qualifyIdCon clearfix">
              <div class="fl">证号</div>
              <div class="fl">{{popUpDriverLicense.license_number}}</div>
            </div>

            <div class="indexDetailsCon clearfix">
              <!-- 第一行 -->
              <div class="detailsItem clearfix">
                <div class="fl clearfix">
                  <div class="title fl">姓名</div>
                  <div class="index fl">{{popUpDriverLicense.ryjb.name}}</div>
                </div>

                <div class="fl clearfix">
                  <div class="title fl">档案编号</div>
                  <div class="index fl">{{popUpDriverLicense.file_no}}</div>
                </div>
              </div>

              <!-- 第二行 -->
              <div class="detailsItem clearfix">
                <div>记录</div>
                <div>实习期至</div>
                <!-- <div>实习期至2018年12月28日</div> -->
              </div>
            </div>
          </div>

        </div>

        <div class='qualify_btn'
             @click='drivePop = true'>驾驶证</div>
      </div>

      <div class='qualify_wrap'
           v-if="popUpWorkQualification">
        <!-- 从业资格证 -->
        <div class='qualify_detail eleScrollBar qualify_detail_right'>
          <div class="item item_front">
            <div class="content">
              <div class="lis_item clearfix">
                <div class="fl">姓名</div>
                <div class="fr">{{ryjb.name}}</div>
              </div>

              <div class="lis_item clearfix">
                <div class="fl">性別</div>
                <div class="fr">{{ryjb.ryxb.gender}}</div>
              </div>
              <div class="lis_item clearfix">
                <div class="fl">出生年月日</div>
                <div class="fr">{{formatDate(ryjb.birth_date)}}</div>
              </div>
              <div class="lis_item clearfix">
                <div class="fl">住址</div>
                <div class="fr">{{ryjb.address}}</div>
              </div>
              <div class="lis_item clearfix">
                <div class="fl">身份证号</div>
                <div class="fr">{{ryjb.idcertificate_number}}</div>
              </div>
              <div class="lis_item clearfix">
                <div class="fl">从业资格证件号</div>
                <div class="fr">{{popUpWorkQualification.certificatenumber}}</div>
              </div>
              <div class="lis_item clearfix">
                <div class="fl">从业资格类别</div>
                <div class="fr">{{popUpWorkQualification.certificate_type_code}}</div>
                <!-- <div class="fr">J-客运/货运</div> -->
              </div>
              <div class="lis_item clearfix">
                <div class="fl">初次发证时间</div>
                <div class="fr">{{formatDate(ryjb.cyzgz.initialcollection_date)}}</div>
              </div>
              <div class="lis_item clearfix">
                <div class="fl">有效期至</div>
                <div class="fr">{{formatDate(ryjb.cyzgz.expiredate)}}</div>
              </div>
            </div>
          </div>

          <div class="item item_rear">
            <div class="content">
              <div class="title">服务单位</div>

              <div class="unitCon clearfix">
                <div class="unitItem">
                  <span>联系电话:</span>
                  <span>13956858569</span>
                </div>
                <div class="unitItem">
                  <span>地址:</span>
                  <span>江苏省苏州市吴中区静凤路229号</span>
                </div>
                <div class="unitItem">
                  <span>2017</span>
                  <span>年</span>
                  <span>12</span>
                  <span>月</span>
                  <span>26</span>
                  <span>日</span>
                </div>
              </div>
              <div class="unitCon clearfix">
                <div class="unitItem">
                  <span>联系电话:</span>
                  <span>13956858569</span>
                </div>
                <div class="unitItem">
                  <span>地址:</span>
                  <span>江苏省苏州市吴中区静凤路229号</span>
                </div>
                <div class="unitItem">
                  <span>2017</span>
                  <span>年</span>
                  <span>12</span>
                  <span>月</span>
                  <span>26</span>
                  <span>日</span>
                </div>
              </div>
              <div class="unitCon clearfix">
                <div class="unitItem">
                  <span>联系电话:</span>
                  <span>13956858569</span>
                </div>
                <div class="unitItem">
                  <span>地址:</span>
                  <span>江苏省苏州市吴中区静凤路229号</span>
                </div>
                <div class="unitItem">
                  <span>2017</span>
                  <span>年</span>
                  <span>12</span>
                  <span>月</span>
                  <span>26</span>
                  <span>日</span>
                </div>
              </div>
              <div class="unitCon clearfix">
                <div class="unitItem">
                  <span>联系电话:</span>
                  <span>13956858569</span>
                </div>
                <div class="unitItem">
                  <span>地址:</span>
                  <span>江苏省苏州市吴中区静凤路229号</span>
                </div>
                <div class="unitItem">
                  <span>2017</span>
                  <span>年</span>
                  <span>12</span>
                  <span>月</span>
                  <span>26</span>
                  <span>日</span>
                </div>
              </div>
              <div class="unitCon clearfix">
                <div class="unitItem">
                  <span>联系电话:</span>
                  <span>13956858569</span>
                </div>
                <div class="unitItem">
                  <span>地址:</span>
                  <span>江苏省苏州市吴中区静凤路229号</span>
                </div>
                <div class="unitItem">
                  <span>2017</span>
                  <span>年</span>
                  <span>12</span>
                  <span>月</span>
                  <span>26</span>
                  <span>日</span>
                </div>
              </div>
              <div class="unitCon clearfix">
                <div class="unitItem">
                  <span>联系电话:</span>
                  <span>13956858569</span>
                </div>
                <div class="unitItem">
                  <span>地址:</span>
                  <span>江苏省苏州市吴中区静凤路229号</span>
                </div>
                <div class="unitItem">
                  <span>2017</span>
                  <span>年</span>
                  <span>12</span>
                  <span>月</span>
                  <span>26</span>
                  <span>日</span>
                </div>
              </div>

            </div>
          </div>
        </div>

        <div class='qualify_btn'
             @click='workPop = true'>从业资格证</div>
      </div>
    </div>

    <!-- 驾驶证弹窗 -->
    <div class="driver_pop"
         :class="[drivePop?'driver_pop-show':'driver_pop-hide']">
      <pop-up-frame @close='drivePop = false'>
        <pop-up-driver-license></pop-up-driver-license>
      </pop-up-frame>
    </div>

    <!-- 从业资格弹窗 -->
    <div class="work_pop"
         :class="[workPop?'work_pop-show':'work_pop-hide']">
      <pop-up-frame @close='workPop = false'>
        <pop-up-work-qualification></pop-up-work-qualification>
      </pop-up-frame>
    </div>

    <!-- 其他弹窗 -->
    <div class="other_pop"
         :class="[otherPop?'other_pop-show':'other_pop-hide']">
      <pop-up-frame @close='otherPop = false'>
        <popup-driver-other-qualification></popup-driver-other-qualification>
      </pop-up-frame>
    </div>

  </div>
</template>
<script>
/*eslint-disable */
import { mapState } from "vuex";
import PopUpWidget from "../../../components/PopUpWidget";
import PopUpFrame from "../../../components/PopUpFrame";
import PopUpDriverLicense from "../popupdriverlicense/PopUpDriverLicense";
import PopUpWorkQualification from "../popupworkqualification/PopUpWorkQualification";
import PopupDriverOtherQualification from "../popupdriverotherqualification/PopupDriverOtherQualification";

export default {
  components: {
    PopUpWidget,
    PopUpFrame,
    PopUpDriverLicense,
    PopUpWorkQualification,
    PopupDriverOtherQualification
  },
  data: () => ({
    drivePop: false,
    workPop: false,
    otherPop: false
  }),
  computed: {
    ...mapState("driverbase", ["ryjb"]),
    ...mapState("popupdriverlicense", ["popUpDriverLicense"]),
    ...mapState("popupworkqualification", ["popUpWorkQualification"])
  },
  methods: {},
  mounted() {
    // console.log('reeeeeeqqqqqeq', this.popUpDriverLicense)
  }
};
</script>
<style lang="scss" scoped>
@mixin size($w, $h) {
  width: $w;
  height: $h;
}
@mixin font_level_4_2 {
  font-size: 14px;
  color: #fff;
}
// 滚动条
.eleScrollBar::-webkit-scrollbar {
  @include size(5px, 5px);
  background: url("../../../assets/driver/scroll.png") no-repeat center center;
  background-size: 100% 100%;
}
.eleScrollBar::-webkit-scrollbar-thumb {
  background: rgba(5, 208, 235, 1);
}
.qualify {
  width: 710px;
  height: 225px;
  padding-left: 20px;
  &_wrap {
    // width: 320px;
    // width: 325px;
    width: 335px;
    height: 205px;
    float: left;
    // background: #004668;
    &:nth-child(2) {
      // margin-left: 50px;
      margin-left: 30px;
    }
  }

  &_detail {
    // width: 320px;
    width: 330px;
    height: 155px;
    float: left;
    margin-bottom: 10px;
    margin-top: 10px;
    overflow-x: hidden;
    overflow-y: auto;

    .item {
      width: 330px;
      height: 155px;
      box-sizing: border-box;
      border: 2px solid #81d9e5;
      background-color: rgba(5, 208, 235, 0.4);
      cursor: pointer;
      text-align: center;
      // 中文标题
      .titleName {
        @include font_level_4_2;
        margin-top: 10px;
        // background:red;
      }
      // 英文标题
      .titleNameEnglish {
        color: #fff;
        font-size: 7px;
      }

      // 证件id包裹
      .qualifyIdCon {
        div {
          color: #fff;
          font-size: 10px;
          text-align: center;
          // line-height: 12px;
          margin-top: 2px;
        }
        div:nth-child(1) {
          width: 30px;
          height: 14px;
          background: #003849;
          text-align: center;
          line-height: 14px;
          margin-left: 80px;
        }
        div:nth-child(2) {
          margin-left: 10px;
        }
      }

      // 驾驶证具体信息
      .indexDetailsCon {
        // @include size();
        width: 290px;
        min-height: 80px;
        margin: 5px 13px;
        // background: pink;
        .detailsItem {
          width: 100%;
          min-height: 10px;
          margin-top: 5px;
          color: #b5b5b5;
          font-size: 8px;
          // background: red;
        }

        // 第一行
        .detailsItem:nth-child(1) {
          > div {
            width: 93px;
            height: 100%;
            // background: pink;
            // .title{
            // background: cyan;
            // }
            .index {
              width: 64px;
              height: 100%;
              box-sizing: border-box;
              border-bottom: 0.5px solid #b5b5b5;
              margin-left: 5px;
              text-align: left;
              text-indent: 10px;
              // background: cyan;
            }
          }

          > div:nth-child(n + 2) {
            margin-left: 5px;
          }
        }

        // 第二行
        .detailsItem:nth-child(2) {
          div {
            // @include size(50px,100%);
            float: left;
          }
          div:nth-child(2) {
            @include size(260px, 100%);
            box-sizing: border-box;
            text-align: left;
            text-indent: 10px;
            border-bottom: 0.5px solid #b5b5b5;
            margin-left: 5px;
          }
        }

        // 第三行
        .detailsItem:nth-child(3) {
          > div:nth-child(1) {
            @include size(130px, 100%);
            // background: red;
            font-size: 8px;
            > div:nth-child(2) {
              @include size(77px, 100%);
              margin-left: 5px;
              box-sizing: border-box;
              border-bottom: 0.5px solid #b5b5b5;
            }
          }

          > div:nth-child(2) {
            @include size(155px, 100%);
            margin-left: 5px;
            // background: cyan;
            > div:nth-child(2) {
              @include size(78px, 100%);
              margin-left: 5px;
              box-sizing: border-box;
              border-bottom: 0.5px solid #b5b5b5;
            }
          }
        }

        // 第四行
        .detailsItem:nth-child(4) {
          > div:nth-child(1) {
            @include size(80px, 100%);
            // background: red;
            > div:nth-child(2) {
              @include size(27px, 100%);
              margin-left: 5px;
              box-sizing: border-box;
              border-bottom: 0.5px solid #b5b5b5;
            }
          }

          > div:nth-child(2) {
            @include size(205px, 100%);
            margin-left: 5px;
            > div:nth-child(2) {
              @include size(157px, 100%);
              // margin-left:5px;
              margin-left: 0px;
              box-sizing: border-box;
              border-bottom: 0.5px solid #b5b5b5;
            }
          }
        }
      }
    }

    .item:nth-child(2) {
      margin-top: 10px;
      // background: red;
      .indexDetailsCon {
        // 第一行
        .detailsItem:nth-child(1) {
          .index {
            margin-left: 5px;
          }
          > div:nth-child(1) {
            @include size(100px, 100%);
          }

          > div:nth-child(2) {
            @include size(185px, 100%);
            div:nth-child(2) {
              @include size(132px, 100%);
            }
          }

          > div:nth-child(n + 2) {
            @include size(185px, 100%);
            margin-left: 5px;
          }
        }
      }
    }
  }
  &_btn {
    float: left;
    height: 40px;
    width: 330px;
    box-sizing: border-box;
    background-color: rgba(5, 208, 235, 0.4);
    border: 1px solid rgba(5, 208, 235, 1);
    font-size: 24px;
    color: white;
    text-align: center;
    line-height: 40px;
  }

  // 右侧从业资格样式
  .qualify_detail_right {
    .item {
      @include size(330px, 190px);
      overflow: hidden;
      border: none;
      // background: red;
      // 内容包裹
      .content {
        @include size(315px, 175px);
        box-sizing: border-box;
        border: 0.5px solid #b5b5b5;
        margin: 5px 5px;
        // background:pink;
        padding: 7px 4px;

        // items
        .lis_item {
          // @include size(100%,14px);
          color: #b5b5b5;
          font-size: 8px;
          // background:green;
          // div:nth-child(1){
          // background:red;
          // }
          div:nth-child(2) {
            @include size(210px, 100%);
            box-sizing: border-box;
            border-bottom: 0.5px solid #b5b5b5;
            text-align: left;
            text-indent: 10px;
            overflow: hidden;
            // background:green;
          }
        }

        .lis_item:nth-child(n + 2) {
          margin-top: 5px;
        }
      }
    }

    //从业资格反面
    .item_rear {
      .content {
        > div {
          color: #b5b5b5;
          box-sizing: border-box;
          border: 0.5px solid #b5b5b5;
        }
        .title {
          @include size(100%, 22px);
          text-align: center;
          line-height: 21px;
          font-size: 10px;
          // background: green;
        }

        // 单位信息包裹
        .unitCon {
          @include size(50%, 36px);
          float: left;
          padding: 0px 4px;
          // background: red;
          .unitItem {
            @include size(100%, 12px);
            font-size: 8px;
            text-align: left;
            line-height: 12px;
            overflow: hidden;
          }

          .unitItem:nth-child(3) {
            text-align: right;
          }
        }
      }
    }
  }
}
// 驾驶员基本信息弹窗
.driver_pop {
  position: absolute;
  top: 200px;
  left: -300px;
  &-show {
    display: block;
  }
  &-hide {
    display: none;
  }
}

// 从业资格弹窗
.work_pop {
  position: absolute;
  top: 200px;
  left: 500px;
  &-show {
    display: block;
  }
  &-hide {
    display: none;
  }
}

// 其他证书弹窗
.other_pop {
  width: 750px;
  // height: 280px;
  // overflow: hidden;
  position: absolute;
  top: 45px;
  left: 250px;
  background: green;
  &-show {
    display: block;
  }
  &-hide {
    display: none;
  }
}
</style>    

