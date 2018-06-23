import * as CarAPI from '@/api/car'

const state = {
  // 右侧：行使里程
  clxslcData: null,
  carMileageStatisticsData: null,
}
const mutations = {
  setMutationData(state, data) {
    state.clxslcData = data
  },
  setMileageStatistics(state, data) {
    state.carMileageStatisticsData = data
  },
}
const actions = {
  async getClxslc({
    commit,
  }, vehicleId) {
    const clxslc = await CarAPI.getClxslc(vehicleId)
    commit('setMutationData', clxslc.data[0])
  },
  async getCarMileageStatistics({
    commit,
  }, param) {
    const carMileageStatistics = await CarAPI.getCarMileageStatistics(param)
    commit('setMileageStatistics', carMileageStatistics.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
