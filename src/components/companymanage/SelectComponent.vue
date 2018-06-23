<template>
  <div class="selectbox"
       @click="open()">
    <div class="nowselect">{{nowselect}}</div>
    <div class="arrowbtn"></div>
    <div class="listbox"
         v-if="openflg">
      <div class="list"
           v-for="(item,i) in data"
           :key="i"
           @click="setdata(item)">{{item}}</div>
    </div>
  </div>
</template>

<script>
export default {
  props: ['data'],
  name: 'SelectComponent',
  data() {
    return {
      openflg: false,
      nowselect: '',
    }
  },
  methods: {
    open() {
      this.openflg = !this.openflg
    },
    setdata(item) {
      this.nowselect = item
    },
  },
}
</script>

<style lang="scss" scoped>
.selectbox {
  width: 100%;
  height: 100%;
  box-sizing: border-box;
  border: 1px solid rgba(129, 217, 229, 0.6);
  float: left;
  position: relative;
  cursor: pointer;
}

.nowselect {
  position: absolute;
  line-height: 23px;
  color: #b5b5b5;
  font-size: 14px;
  text-indent: 20px;
}

.arrowbtn {
  // background: url('../../assets/pull_arrow_off.png');
  background: url("../../assets/companymanage/arrow_down.png");
  transition: background 0.2s;
  position: absolute;
  right: 10px;
  top: 7px;
  width: 14px;
  height: 8px;
  cursor: pointer;
}
// .arrowbtn:hover {
// background: url('../../assets/pull_arrow_on.png');
// }
.listbox {
  overflow: hidden;
  position: absolute;
  top: 30px;
  z-index: 1;
}
.list {
  color: #b5b5b5;
  font-size: 14px;
  text-indent: 20px;
  width: 400px;
  background: rgba(46, 218, 223, 0.3);
  transition: background 0.2s;
  cursor: pointer;
}
.list:hover {
  color: #fff;
  background: rgba(46, 218, 223, 0.1);
}
</style>
