import * as CompanySecureAPI from '@/api/companysecure'

const state = {
  irregaularityTrend: null,
}
const mutations = {
  setData(state, data) {
    state.irregaularityTrend = data
  },
}
const actions = {
  async getDriverIrregularityTrend({ commit }, param) {
    commit('setData', null)
    const irregaularityTrend = await CompanySecureAPI.getDriverIrregularityTrend(param)
    commit('setData', irregaularityTrend.data)
  },

}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
