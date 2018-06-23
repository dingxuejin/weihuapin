import * as CompanySecureAPI from '@/api/companysecure'

const state = {
  entityScoreTrend: null,
}
const mutations = {
  setData(state, data) {
    state.entityScoreTrend = data
  },
}
const actions = {
  async getEntityScoreTrend({ commit }, param) {
    commit('setData', null)
    const entityScoreTrend = await CompanySecureAPI.getEntityScoreTrend(param)
    commit('setData', entityScoreTrend.data)
  },

}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
