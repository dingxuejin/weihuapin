import * as DriverAPI from '@/api/driver'

const state = {
  // healthyData: null,
  workMileageCountInfo: null,
}
const mutations = {
  // setDriverHealthy(state, data) {
  //   state.healthyData = data
  // },
  setworkMileageCountInfo(state, data) {
    state.workMileageCountInfo = data
  },
}

const actions = {
  // async getDriverHealthy({ commit }, param) {
  //   commit('setDriverHealthy', { healthyData: null })

  //   const Healthy = await DriverAPI.getDriverHealthy(param)
  //   commit('setDriverHealthy', Healthy.data)
  // },
  async getWorkMileageCountInfo({ commit }, param) {
    const workMileageCountInfoWrap = await DriverAPI.getWorkMileageCountInfo(param)
    commit('setworkMileageCountInfo', workMileageCountInfoWrap.data)
  },
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
