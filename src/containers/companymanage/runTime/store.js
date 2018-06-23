import * as CompanyManageAPI from '@/api/companymanage'

const state = {
  vehicleQuantity: null,
}
const mutations = {
  setData(state, data) {
    state.vehicleQuantity = data
  },
}
const actions = {
  async getVehicleQuantity({ commit }, param) {
    commit('setData', null)
    const vehicleQuantity = await CompanyManageAPI.getIntervalVehicleQuantity(param)
    // console.log('运输时段 - 数据', vehicleQuantity.data)
    commit('setData', vehicleQuantity.data)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
