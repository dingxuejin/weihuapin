<template>
  <div class="top_name">
    <select v-if="entities"
            @change='select'>
      <option :value="item.entity_id"
              v-for='(item,index) in entities'
              :key='index'>{{item.entity_name}}</option>
    </select>
    <div class="title">企业安全管理</div>
    <div class="top_btn"></div>
  </div>
</template>

<script>
/*eslint-disable */
import { mapActions, mapState } from "vuex";

export default {
  data() {
    return {
      data: ["华北配送中心", "华南配送中心", "西北配送中心", "东南配送中心"]
    };
  },
  computed: {
    ...mapState("secureMain", ["entities"])
  },
  methods: {
    ...mapActions("secureMain", [
      "getEntity",
      "fetchOtherBlock",
      "selectEntity"
    ]),
    select(e) {
      this.selectEntity({
        entity_id: e.target.value
      });
    }
  },
  mounted() {
    this.getEntity();
    // this.fetchOtherBlock({
    //   entity_id: 1310000010010000,
    // })
  }
};
</script>

<style lang="scss" scoped>
.top_name {
  margin-top: 15px;
  width: 100%;
  height: 100px;
  // margin: 15px 0px 10px;
  // background: url('../../assets/companymanage/select_bg.png') no-repeat;
  background: url("../../../assets/companymanage/select_bg.png") no-repeat;
  text-indent: 50px;
  font-size: 24px;
  font-weight: bold;
  color: #89dddf;
  position: relative;
  select {
    width: 370px;
    color: #89dddf;
    background: rgba(0, 0, 0, 0);
    list-style: none;
    border: 0;
    outline: none;
    cursor: pointer;
    font-weight: bold;
    margin-top: 24px;
  }
  .title {
    font-size: 16px;
    margin-top: 5px;
  }
  .top_btn {
    width: 29px;
    height: 20px;
    position: absolute;
    top: 32px;
    right: 10px;
    // background: url('../../assets/companymanage/selecet.png') no-repeat;
    background: url("../../../assets/companymanage/selecet.png") no-repeat;
    pointer-events: none;
  }
}
</style>
