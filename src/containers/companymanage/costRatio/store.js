import * as CompanyManageAPI from '@/api/companymanage'

const state = {
  costRatio: null,
}
const mutations = {
  setCostRatio(state, data) {
    state.costRatio = data
  },
}
const actions = {
  async getCostRatio({ commit }, param) {
    const costRatio = await CompanyManageAPI.getCompanyManageCostRatio(param)
    commit('setCostRatio', costRatio.data)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
