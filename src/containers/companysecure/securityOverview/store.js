import * as CompanySecureAPI from '@/api/companysecure'

const state = {
  overview: null,
}
const mutations = {
  setData(state, data) {
    state.overview = data
  },
}
const actions = {
  async getSecureStatusOverview({ commit }, param) {
    commit('setData', null)
    const overview = await CompanySecureAPI.getSecureStatusOverview(param)
    commit('setData', overview.data)
  },

}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
