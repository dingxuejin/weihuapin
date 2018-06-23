<template>
  <div class="dcertificate">
    <div class="dcertificate_info dcertificate_btn"
         :class='[otherinfo?"dcertificate_btn-off":"dcertificate_btn-on"]'
         @click='nav'>证件信息</div>
    <div class="dcertificate_otherinfo dcertificate_btn"
         :class='[otherinfo?"dcertificate_btn-on":"dcertificate_btn-off"]'
         @click='nav'>其他证件</div>

     
    <ul class="dcertificate_list">
      <li class="dcertificate_item">
        <div class="dcertificate_imgwrap">
          <div class="dcertificate_img"></div>
        </div>
        <div class="dcertificate_name">驾驶证</div>
      </li>
      <li class="dcertificate_item">
        <div class="dcertificate_imgwrap">
          <div class="dcertificate_img"></div>
        </div>
        <div class="dcertificate_name">危化品从业资格证</div>
      </li>
    </ul>

    <!-- <div class="dcertificate_list fl">
      <div class="dcertificate_item fl">
        <div class="dcertificate_imgwrap">
          <div class="dcertificate_img">

          </div>
        </div>
        <div class="dcertificate_name">
          驾驶证
        </div>
      </div>
      <div class="dcertificate_item fl">
        <div class="dcertificate_imgwrap">
          <div class="dcertificate_img">

          </div>
        </div>
        <div class="dcertificate_name">
          危化品从业资格证
        </div>
      </div>
    </div> -->

  
  </div>
</template>
<script>
export default {
  data: () => ({
    otherinfo: false,
  }),
  methods: {
    nav() {
      this.otherinfo = !this.otherinfo
    },
  },
}
</script>
<style lang="scss" scoped>




.dcertificate {
  width: 750px;
  &_info {
    display: inline-block;
    height: 30px;
    width: 166px;
  }
  &_otherinfo {
    display: inline-block;
    height: 30px;
    width: 200px;

    margin-left: 20px;
  }
  &_btn {
    
    text-align: center;
    vertical-align: middle;
    &-on {
      line-height: 30px;
      font-size: 18px;
      font-weight: bold;
      background-color: rgba(129, 217, 229, 0.3);
      color: #89dddf;
    }
    &-off {
      line-height: 28px;
      font-size: 16px;
      box-sizing: border-box;
      background-color: rgba(5, 208, 235, 0.2);
      border: 1px solid;
      border-color: rgba(5, 208, 235, 0.4);
      color: #b5b5b5;
    }
  }
  &_list {
    margin-top: 20px;
    margin-right: -130px;
  }
  &_item {
    float: left;
    width: 310px;
    margin-right: 130px;
  }
  &_imgwrap {
    width: 310px;
    height: 155px;
    box-sizing: border-box;
    border: 2px solid #81d9e5;
  }
  &_img {
    margin-left: 10px;
    margin-top: 10px;
    width: 286px;
    height: 131px;
    background-color: #007ace;
  }
  &_name {
    text-align: center;
    vertical-align: middle;
    line-height: 40px;
    margin-top: 10px;
    color: #ffffff;
    font-size: 24px;
    height: 40px;
    border: 1px solid #05d0eb;
    background-color: rgba(5, 208, 235, 0.4);
  }
}
</style>
