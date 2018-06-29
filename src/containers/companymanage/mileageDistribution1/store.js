import * as CompanyManageAPI from '@/api/companymanage'

const state = {
  mileageStatistics: null,
  mileageTrend: null,
  mileageRatio: null,
  topMileage: null,
}
const mutations = {
  setData(state, { name, data }) {
    state[name] = data
  },
}
const actions = {
  async getMileageStatistics({ commit }, param) {
    commit('setData', { name: 'mileageStatistics', data: null })
    const mileageStatistics = await CompanyManageAPI.getMileageStatistics(param)

    commit('setData', { name: 'mileageStatistics', data: mileageStatistics.data })
  },
  async getMileageTrend({ commit }, param) {
    commit('setData', { name: 'mileageTrend', data: null })
    const mileageTrend = await CompanyManageAPI.getMileageTrend(param)

    commit('setData', { name: 'mileageTrend', data: mileageTrend.data })
  },
  async getMileageRatio({ commit }, param) {
    commit('setData', { name: 'mileageRatio', data: null })
    const mileageRatio = await CompanyManageAPI.getMileageRatio(param)

    commit('setData', { name: 'mileageRatio', data: mileageRatio.data })
  },
  async getHighestVehicleMileage({ commit }, param) {
    commit('setData', { name: 'topMileage', data: null })
    const topMileage = await CompanyManageAPI.getHighestVehicleMileage(param)

    commit('setData', { name: 'topMileage', data: topMileage.data })
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
