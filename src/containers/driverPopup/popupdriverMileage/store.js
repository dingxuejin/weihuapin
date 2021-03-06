import * as DriverAPI from '@/api/driver'

const state = {
  // healthyData: null,
  businessQyDzydData: null,
}
const mutations = {
  // setDriverHealthy(state, data) {
  //   state.healthyData = data
  // },
  setbusinessQyDzydData(state, data) {
    state.businessQyDzydData = data
  },
}

const actions = {
  // async getDriverHealthy({ commit }, param) {
  //   commit('setDriverHealthy', { healthyData: null })

  //   const Healthy = await DriverAPI.getDriverHealthy(param)
  //   commit('setDriverHealthy', Healthy.data)
  // },
  async getTbBusinessQyDzydLcTj({ commit }, param) {
    const businessQyDzyd = await DriverAPI.getTbBusinessQyDzydLcTj(param)
    commit('setbusinessQyDzydData', businessQyDzyd.data)
  },
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
