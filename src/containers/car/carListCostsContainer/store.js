import * as CarAPI from '@/api/car'

const state = {
  // 中间：累计各项费用占比
  clfytjData: null,
}
const mutations = {
  setMutationData(state, data) {
    state.clfytjData = data
  },
}
const actions = {
  async getClfytj({ commit }, vehicleId) {
    const clfytj = await CarAPI.getClfytj(vehicleId)
    commit('setMutationData', clfytj.data)
  },

}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
