import * as CompanyManageAPI from '@/api/companymanage'

const state = {
  waybillTrendRecently: null,
}
const mutations = {
  setData(state, data) {
    state.waybillTrendRecently = data
  },
}
const actions = {
  async getWaybillTrendRecently({ commit }, param) {
    commit('setData', null)
    const waybillTrendRecently = await CompanyManageAPI.getWaybillTrendRecently(
      param,
    )
    commit('setData', waybillTrendRecently.data)
  },
}

export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
