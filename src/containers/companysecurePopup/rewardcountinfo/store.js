/*eslint-disable */
import * as DriverAPI from "@/api/driver";

const state = {
  rewardCountInfo: null
};
const mutations = {
  setRewardCountInfo(state, data) {
    state.rewardCountInfo = data;
  }
};
const actions = {
  async getRewardCountInfo({ commit }, param) {
    // commit('setRewardCountInfo', null)
    const rewardCountInfo = await DriverAPI.getRewardCountInfo(param);
    commit("setRewardCountInfo", rewardCountInfo.data);
  }
};
export default {
  namespaced: true,
  state,
  actions,
  mutations
};
