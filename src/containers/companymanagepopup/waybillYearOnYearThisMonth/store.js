import * as CompanyManageAPI from '@/api/companymanage'

const state = {
  waybillYearOnYearThisMonth: null,
}
const mutations = {
  setData(state, data) {
    state.waybillYearOnYearThisMonth = data
  },
}
const actions = {
  async getWaybillYearOnYearThisMonth({ commit }, param) {
    commit('setData', null)
    const waybillYearOnYearThisMonth = await CompanyManageAPI.getWaybillYearOnYearThisMonth(
      param,
    )
    commit('setData', waybillYearOnYearThisMonth.data)
  },
}

export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
