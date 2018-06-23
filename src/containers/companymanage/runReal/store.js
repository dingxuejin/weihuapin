import * as CompanyAPI from '@/api/companymanage'

const state = {
  costData: null,
}
const mutations = {
  setData(state, data) {
    if (data && data.length > 0) {
      state.costData = data[0]
    } else if (data) {
      state.costData = data
    } else {
      state.costData = null
    }
  },
}
const actions = {
  async getCost({ commit }, param) {
    const costRatio = await CompanyAPI.getRunReal(param)
    commit('setData', costRatio.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
