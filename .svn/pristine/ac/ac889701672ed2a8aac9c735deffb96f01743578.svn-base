import * as CarAPI from '@/api/car'

const state = {
  // 右侧：重车行驶里程占比
  mileageStatisticsRatioData: null,
}
const mutations = {
  setcarMileageStatisticsRatio(state, data) {
    state.mileageStatisticsRatioData = data
  },
}
const actions = {
  async getcarMileageStatisticsRatio({
    commit,
  }, params) {
    const carMileageStatisticsRatio = await CarAPI.getcarMileageStatisticsRatio(params)
    commit('setcarMileageStatisticsRatio', carMileageStatisticsRatio.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
