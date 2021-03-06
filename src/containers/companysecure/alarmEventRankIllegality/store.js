import * as CompanySecureAPI from '@/api/companysecure'

const state = {
  Illegality: null,
}
const mutations = {
  setIllegality(state, data) {
    state.Illegality = data
  },
}
const actions = {
  async getIllegality({ commit }, param) {
    commit('setIllegality', null)
    const illegality = await CompanySecureAPI.getIllegality(param)
    commit('setIllegality', illegality.data)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
