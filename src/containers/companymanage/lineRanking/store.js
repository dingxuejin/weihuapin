import * as CompanyManageAPI from '@/api/companymanage'

const state = {
  routeOrder: null,
}
const mutations = {
  setData(state, data) {
    state.routeOrder = data.filter(o => o.qy_xlxx && o.qy_xlxx.route_name)
  },
}
const actions = {
  async getRouteOrder({ commit }, param) {
    const routeOrder = await CompanyManageAPI.getRouteOrder(param)
    commit('setData', routeOrder.data)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
