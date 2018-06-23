import * as CarAPI from '@/api/car'

const state = {
  clzzzjxxData: null,
}
const mutations = {
  setClzzzjxx(state, data) {
    state.clzzzjxxData = data
  },
}
const actions = {
  async getClzzzjxx({ commit }, vehicleId) {
    const clzzzjxx = await CarAPI.getClzzzjxx(vehicleId)
    commit('setClzzzjxx', clzzzjxx.data)
  },

}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
