<template>
  <div>
    <div class='car-item'>
    </div>
    <!-- <img class='item' src="./assets/危货运输企业安全管理画像系统1226-企业货物流向-01" alt=""> -->
    <div class='car-man'>
      <div v-for="item in series" :key="item">{{item}}</div>
    </div>

  </div>

</template>
<script>
import _ from 'lodash'

export default {
  name: 'my-first-container',
  data: () => ({
    series: _.times(10, num => num),
  }),
}
</script>
<style lang="scss" scoped>
.item {
  height: 300px;
  width: 400px;
}
.car-item {
  border: 1px solid red;
  height: 300px;
  width: 400px;
}
.car-man {
  border: 1px solid red;
  height: 300px;
  width: 400px;
}
</style>
