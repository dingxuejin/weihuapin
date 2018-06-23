import * as CompanySecureAPI from '@/api/companysecure'

const state = {
  driverIllegalTrend: null,
}
const mutations = {
  setData(state, data) {
    state.driverIllegalTrend = data
  },
}
const actions = {
  async getDriverIllegalTrend({ commit }, param) {
    commit('setData', null)
    const driverIllegalTrend = await CompanySecureAPI.getDriverIllegalTrend(param)
    commit('setData', driverIllegalTrend.data)
  },

}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
