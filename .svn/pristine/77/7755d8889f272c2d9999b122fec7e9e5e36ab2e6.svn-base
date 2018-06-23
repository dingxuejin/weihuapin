/* eslint-disable */
/*

 1.行驶里程
 totalMileageDetailsShow

2.重车/空车行驶里程
heavyEmptyMileageDetailsShow

 3.运输量
carWeightDetailsShow

4. 周转量
carPerDetailsShow

5.运单数
totalCountDetailsShow

6.右侧所有信息
rightPartData
*/

import * as CarAPI from "@/api/car";
const state = {
  totalMileageDetailsShow: false,
  heavyEmptyMileageDetailsShow: false,
  carWeightDetailsShow: false,
  carPerDetailsShow: false,
  totalCountDetailsShow: false,
  rightPartData: ""
};
const mutations = {
  settotalMileageDetailsShow(state, data) {
    state.totalMileageDetailsShow = data;
  },
  setheavyEmptyMileageDetailsShow(state, data) {
    state.heavyEmptyMileageDetailsShow = data;
  },
  setcarWeightDetailsShow(state, data) {
    state.carWeightDetailsShow = data;
  },
  setcarPerDetailsShow(state, data) {
    state.carPerDetailsShow = data;
  },
  settotalCountDetailsShow(state, data) {
    state.totalCountDetailsShow = data;
  },
  setrightPartDataa(state, data) {
    state.rightPartData = data;
  }
};
const actions = {
  async getrightPartData({ commit }, params) {
    // const params = {
    //   vehicle_id: 20170652,
    //   year: "",
    //   month: ""
    // };
    const rightPartData = await CarAPI.getrightPartData(params);
    // console.log("store.js--params", params);
    // console.log("rightPartData", rightPartData.data);
    commit("setrightPartDataa", rightPartData.data);
    // console.log("右边的信息-------", rightPartData.data);
  }
};

export default {
  namespaced: true,
  state,
  actions,
  mutations
};
