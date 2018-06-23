import * as CarAPI from '@/api/car'

const state = {
  // 右侧：车辆运量
  clylData: null,
  mileageVolumeStatisticsData: null,
}
const mutations = {
  setMutationData(state, data) {
    state.clylData = data
  },
  setcarMileageVolumeStatistics(state, data) {
    state.mileageVolumeStatisticsData = data
  },
}
const actions = {
  async getClyl({ commit }, vehicleId) {
    const clyl = await CarAPI.getClyl(vehicleId)
    commit('setMutationData', clyl.data[0])
  },
  async getcarMileageVolumeStatistics({ commit }, params) {
    const carMileageVolumeStatistics = await CarAPI.getcarMileageVolumeStatistics(params)
    commit('setcarMileageVolumeStatistics', carMileageVolumeStatistics.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
