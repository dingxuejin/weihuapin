import * as CompanyManageAPI from '@/api/companymanage'

const state = {
  routeInfo: null,
}
const mutations = {
  setData(state, data) {
    state.routeInfo = data
  },
}
const actions = {
  async getRouteInfo({ commit }, param) {
    commit('setData', null)
    const routeInfo = await CompanyManageAPI.getRouteInfo(
      param,
    )
    commit('setData', routeInfo.data)
  },
}

export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
