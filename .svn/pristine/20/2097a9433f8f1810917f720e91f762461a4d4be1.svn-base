/*eslint-disable */
import * as CarAPI from "@/api/car";
const state = {
  carOverdueRemindingShow: false,
  carOverdueRemindingData: null
};
const mutations = {
  setcarOverdueRemindingShow(state, data) {
    state.carOverdueRemindingShow = data;
  },
  setcarOverdueRemindingData(state, data) {
    state.carOverdueRemindingData = data;
  }
};
const actions = {
  async getCarOverReminding({ commit }, params) {
    const CarOverdueRemindingData = await CarAPI.getCarOverReminding(params);
    commit("setcarOverdueRemindingData", CarOverdueRemindingData.data);
  }
};
export default {
  namespaced: true,
  state,
  actions,
  mutations
};
