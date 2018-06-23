<template>
  <div class="linkbtn">
    <!-- <header>
      <div class='log'></div>
      <button @click="nav('company')">Company</button>
      <button @click="nav('driver')">Driver</button>
      <button @click="nav('car')">Car</button>
    </header> -->
    <!-- <router-view></router-view> -->
    <div @click="nav('car')" class="car_link details_link">车辆</div>
    <div @click="nav('driver')" class="details_link">人员</div>
    <div @click="nav('company')" class="details_link">企业</div>
    <div @click="nav('company/manage')" class="details_link">企业经营</div>
    <div @click="nav('company/secure')" class="details_link">企业安全</div>
    <!-- <div @click="nav('api')">api</div> -->
  </div>
</template>
<script>
export default {
  name: 'application',
  methods: {
    nav(name) {
      this.$router.push(name)
    },
  },
}
</script>
<style lang="scss" scoped>
.linkbtn {
  width: 133%;
  height: 100px;
  line-height: 200px;
  cursor: pointer;
  font-size: 24px;
  margin:0 auto;
  margin-top:400px;
  
  .details_link {
    width: 200px;
    height: 100px;
    line-height: 100px;
    text-align: center;
    background: rgba(5, 208, 235, 0.3);
    color: #b5b5b5;
    float:left; 
    margin-left:50px;
  }
  .details_link:hover {
    color: #ffffff;
    background: rgba(5, 208, 235, 0.6);
    box-shadow: 0px 0px 1px rgba(5, 208, 235, 0.6);
  }
  .car_link{
    margin-left:25%;
  }
}
</style>








