<template>
  <div class="otherQualificationInfoCon">
    <pop-up-widget title="其他证书"></pop-up-widget>

    <!-- 证书包裹 -->
    <div class="content">
        <div class="prev"></div>
        <div class="next"></div>

        <!-- 证书包裹 -->
        <div class="qualificationWrap clearfix">
          <div class="qualificationItem fl">
            <!-- 证书内容 -->
            <div class="qualificationContent">
              <div class="qualificationBg"></div>
              <div class="title">学士学位证书</div>

              <!-- 证件具体信息 -->
              <div class="details">
                <span>王明</span>
                <span> ,</span>
                <span>男</span>
                <span> ,</span>
                <span>1989</span>
                <span>年</span>
                <span>12</span>
                <span>月</span>
                <span>26</span>
                <span>日生. 在 </span>
                <span>车辆工程</span>
                <span> 专业完成了 </span>
                <span>本科</span>
                <span> 学习计划,业已毕业.经审核符合《中华人民共和国学位条例》的规定.授予 </span>
                <span> 学士学位</span>
                <span>.</span>
              </div>

              <!-- 签名 -->
              <div class="confirm">
                <span>机械工程院</span>
                <span>院(校)长</span>
                <span>王春桥</span>
              </div>

              <!-- 证书编号 -->
              <div class="numberCon">
                <span>证书编号: </span>
                <span>6549862538514</span>
                <span>二零零八</span>
                <span>年</span>
                <span>六</span>
                <span>月</span>
                <span>十二</span>
                <span>日</span>
              </div>

              <!-- 证书类别 -->
              <div class="typeCon">
                ( 普通高等教育本科毕业生 )
              </div>

            </div>
            <div class="qualificationTitle">
              学历证
            </div>
          </div>
        </div>
    </div>
  </div>
</template>

<script type="text/javascript">
import PopUpWidget from '../../../components/PopUpWidget'

export default {
  name: 'otherQualificationInfo',
  components: {
    PopUpWidget,
  },
  data() {
    return {}
  },
}
</script>

<style lang="scss" coped>
@mixin size($w,$h) {
  width: $w;
  height: $h;
}
.otherQualificationInfoCon {
  // @include size(100%,100%);
  width: 100%;
  min-height: 200px;
  // background:red;

  // 内容部分
  .content {
    width: 100%;
    height: 250px;
    overflow: visible;
    position: relative;
    // background: green;
    
    // 左箭头
    .prev{
        @include size(15px,24px);
        transform: translate(-50%,-50%);
        position: absolute;
        top:50%;
        left:10px;
        background:url('../../../assets/car/css_sprite_car-01.png') no-repeat -280px -40px;
        cursor:pointer;
    }
    .prev:hover{
      background: url('../../../assets/car/css_sprite_car-01.png') no-repeat -340px -40px;
    }

    // 右箭头
    .next{
        @include size(15px,24px);
        transform: translate(-50%,-50%);
        position: absolute;
        top:50%;
        right:10px;
        background:url('../../../assets/car/css_sprite_car-01.png') no-repeat -280px -40px; 
        transform: rotate(180deg);
        cursor:pointer;
    }
    .next:hover{
      background: url('../../../assets/car/css_sprite_car-01.png') no-repeat -340px -40px;
      transform: rotate(180deg);
    }

    // 证书包裹
    .qualificationWrap{
        @include size(320px,260px);
        transform: translate(-50%,-50%);
        overflow: visible;
        position: absolute;
        top:50%;
        left:50%;

        // 每张证书包裹
        .qualificationItem{
          width:100%;
          height:100%;
          // background:pink;

          // 证书内容
          .qualificationContent{
            @include size(100%,200px);
            box-sizing: border-box;
            border: 2px solid #81d9e5;
            background-color: rgba(5, 208, 235, 0.4);
            padding:8px;
            color:#fff;
            font-size: 8px;

            // bg
            .qualificationBg{
              @include size(100%,40px);
              margin-top:5px;
              background: url('../../../assets/driver/icon_badge.png') center center no-repeat;
              background-size:40px 40px;
            }
            
            // 标题
            .title{
              @include size(100%,16px);
              margin-top:3px;
              text-align:center;
              line-height: 16px;
              font-size:14px;
              color:#fff;
              border:none;
              // background: red;
            }

            // 证书具体信息
            .details{
              width:100%;
              // min-height:20px;
              margin-top:3px;
              box-sizing: border-box;
              padding:0px 20px;
            }

            // 确认信息
            .confirm{
              width:100%;
              min-height: 10px;
              color:#fff;
              font-size: 8px;
              margin-top:5px;
              span:nth-child(1),span:nth-child(2){
                margin-left:50px;
              }
              span:nth-child(3){
                margin-left:15px;
              }
              
            }

            // 证书编号
            .numberCon{
              width:100%;
              min-height:10px;
              color:#fff;
              font-size: 8px;
              box-sizing: border-box;
              padding:0px 20px;
              margin-top:3px;
              span:nth-child(3){
                margin-left:50px;
              }
            }

            // 毕业类型
            .typeCon{
              @include size(100%,10px);
              text-align:center;
              margin-top:3px;
            }
            
          }

          // 证书名称
          .qualificationTitle{
            @include size(100%,40px);
                box-sizing: border-box;
                margin-top:10px;
                background-color: rgba(5, 208, 235, 0.4);
                border: 1px solid #05d0eb;
                font-size: 24px;
                color: white;
                text-align: center;
                line-height: 38px;
          }
        }
    
    }
  }
}
</style>