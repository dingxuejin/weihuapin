import * as DriverAPI from '@/api/driver'

const state = {
  rewardDetailsInfo: null,
}
const mutations = {
  setRewardDetailsInfo(state, data) {
    state.rewardDetailsInfo = data
  },
}
const actions = {
  async getRewardDetailsInfo({ commit }, param) {
    commit('setRewardDetailsInfo', null)
    const rewardDetailsInfo = await DriverAPI.getRewardDetailsInfo(param)
    commit('setRewardDetailsInfo', rewardDetailsInfo.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
