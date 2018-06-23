import * as CompanyManageAPI from '@/api/companymanage'

const state = {
  waybillStatistics: null,
}
const mutations = {
  setData(state, data) {
    state.waybillStatistics = data
  },
}
const actions = {
  async getWaybillStatistics({ commit }, param) {
    commit('setData', null)
    const waybillStatistics = await CompanyManageAPI.getWaybillStatistics(
      param,
    )
    // console.log('运单数据', waybillStatistics)
    commit('setData', waybillStatistics.data)
  },
}

export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
