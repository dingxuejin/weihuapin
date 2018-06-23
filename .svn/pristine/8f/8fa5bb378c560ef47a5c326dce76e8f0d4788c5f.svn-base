import * as DriverAPI from '@/api/driver'

const state = {
  rewardCountInfo: null,
}
const mutations = {
  setRewardCountInfo(state, data) {
    // console.log(data)
    state.rewardCountInfo = data
  },
}
const actions = {
  async getRewardCountInfo({ commit }, param) {
    // commit('setRewardCountInfo', null)
    const rewardCountInfo = await DriverAPI.getRewardCountInfo(param)
    commit('setRewardCountInfo', rewardCountInfo.data)
    // console.log('sotre.js', JSON.stringify(state.rewardCountInfo))
  },

}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
