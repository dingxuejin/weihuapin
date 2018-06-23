import * as CompanySecureAPI from '@/api/companysecure'

const state = {
  Irregularities: null,
}
const mutations = {
  setIrregularities(state, data) {
    state.Irregularities = data
  },
}
const actions = {
  async getIrregularities({ commit }, param) {
    commit('setIrregularities', null)
    const irregularities = await CompanySecureAPI.getIrregularities(param)
    commit('setIrregularities', irregularities.data)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
