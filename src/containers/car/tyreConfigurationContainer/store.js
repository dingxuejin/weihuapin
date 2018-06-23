import * as CarAPI from '@/api/car'

const state = {
  // 左侧：轮胎配置信息
  ltsyxxData: null,
  ltghxxData: null,
}
const mutations = {
  setLtsyxxData(state, data) {
    state.ltsyxxData = data
  },
  setLtghxxData(state, data) {
    state.ltghxxData = data
  },
}
const actions = {
  async getLtsyxx({ commit }, vehicleId) {
    const ltsyxx = await CarAPI.getLtsyxx(vehicleId)
    commit('setLtsyxxData', ltsyxx.data)
  },
  async getLtghxx({ commit }, vehicleId) {
    const ltghxx = await CarAPI.getLtghxx(vehicleId)
    commit('setLtghxxData', ltghxx.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
