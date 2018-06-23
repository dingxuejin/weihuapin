import * as CarAPI from '@/api/car'

const state = {
  // 中间：累计各项费用占比
  showCostStatisticsDetails: false,
  carCostStatisticsData: null,
  carFuelvsMileageData: null,
}
const mutations = {
  setCarCostStatistics(state, data) {
    state.carCostStatisticsData = data
  },
  costStatisticsDetailsBtn(state) {
    state.showCostStatisticsDetails = !state.showCostStatisticsDetails
  },
  closeDetailsShow(state) {
    state.showCostStatisticsDetails = false
  },
  setcarFuelvsMileage(state, data) {
    state.carFuelvsMileageData = data
  },
}

const actions = {
  async getcarCostStatistics({
    commit,
  }, vehicleId) {
    const carCostStatistics = await CarAPI.getcarCostStatistics(vehicleId)
    commit('setCarCostStatistics', carCostStatistics.data)
  },
  async getcarFuelvsMileage({
    commit,
  }, vehicleId) {
    const carFuelvsMileage = await CarAPI.getcarFuelvsMileage(vehicleId)
    commit('setcarFuelvsMileage', carFuelvsMileage.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
