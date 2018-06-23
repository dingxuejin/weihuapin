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
    // console.log('奖励信息', rewardInfo.data)
    commit('setRewardInfo', rewardInfo.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
