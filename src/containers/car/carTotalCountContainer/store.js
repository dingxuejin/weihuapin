import * as CarAPI from '@/api/car'

const state = {
  // 右侧：运单数
  clydslData: null,
  mileageWaybillStatistics: null,
}
const mutations = {
  setMutationData(state, data) {
    state.clydslData = data
  },
  setcarMileageWaybillStatistics(state, data) {
    state.mileageWaybillStatistics = data
  },
}
const actions = {
  async getClydsl({ commit }, vehicleId) {
    const clydsl = await CarAPI.getClydsl(vehicleId)
    commit('setMutationData', clydsl.data[0])
  },
  async getcarMileageWaybillStatistics({ commit }, params) {
    const carMileageWaybillStatistics = await CarAPI.getcarMileageWaybillStatistics(
      params,
    )
    commit('setcarMileageWaybillStatistics', carMileageWaybillStatistics.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
