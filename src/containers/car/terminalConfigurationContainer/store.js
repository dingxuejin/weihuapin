import * as CarAPI from '@/api/car'

const state = {
  // 左侧：终端配置信息
  czzdxxData: null,
}
const mutations = {
  setMutationData(state, data) {
    state.czzdxxData = data
  },
  // getTermialSelectedInfo(state, item) {
  //   if (state.czzdxxData) {
  //     state.terminalInfo = state.czzdxxData.filter(
  //       o => o.zdlx.terminal_type === item)[0]
  //   }
  //   return true
  // },
}
const actions = {
  async getCzzdxx({ commit }, vehicleId) {
    const czzdxx = await CarAPI.getCzzdxx(vehicleId)
    commit('setMutationData', czzdxx.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
