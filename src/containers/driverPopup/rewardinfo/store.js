import * as DriverAPI from '@/api/driver'

const state = {
  rewardInfo: null,
}
const mutations = {
  setRewardInfo(state, data) {
    state.rewardInfo = data
  },
}
const actions = {
  async getRewardInfo({ commit }, param) {
    commit('setRewardInfo', null)
    const rewardInfo = await DriverAPI.getRewardInfo(param)
    commit('setRewardInfo', rewardInfo.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
