import * as CompanyManageAPI from '@/api/companymanage'

const state = {
  variableCost: null,
}
const mutations = {
  setData(state, data) {
    state.variableCost = data
  },
}
const actions = {
  async getVariableCost({ commit }, param) {
    const variableCost = await CompanyManageAPI.getVariableCost(param)
    commit('setData', variableCost.data)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
