/*eslint-disable */
import * as CarAPI from "@/api/car";

const state = {
  // 右侧：周转量
  clzzlData: null,
  carPerMileageStatisticsData: null
};
const mutations = {
  setMutationData(state, data) {
    state.clzzlData = data;
  },
  setcarPerMileageStatistics(state, data) {
    state.carPerMileageStatisticsData = data;
  }
};
const actions = {
  async getClzzl({ commit }, vehicleId) {
    const clzzl = await CarAPI.getClzzl(vehicleId);
    commit("setMutationData", clzzl.data[0]);
  },
  async getCarPerMileageStatistics({ commit }, params) {
    const CarPerMileageStatistics = await CarAPI.getCarPerMileageStatistics(
      params
    );
    commit("setcarPerMileageStatistics", CarPerMileageStatistics.data);
  }
};
export default {
  namespaced: true,
  state,
  actions,
  mutations
};
