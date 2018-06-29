import * as CompanySecureAPI from '@/api/companysecure'

const state = {
  driverAreaDistribute: null,
  driverIntervalDistribute: null,
}
const mutations = {
  setAreaData(state, data) {
    // console.log(data)
    state.driverAreaDistribute = data
  },
  setIntervalData(state, data) {
    state.driverIntervalDistribute = data
  },
}
const actions = {
  async getDriverAreaDistribute({
    commit,
  }, param) {
    commit('setAreaData', null)
    const driverAreaDistribute = await CompanySecureAPI.getDriverAreaDistribute(param)
    commit('setAreaData', driverAreaDistribute.data)
  },
  async getDriverIntervalDistribute({
    commit,
  }, param) {
    commit('setIntervalData', null)
    const driverIntervalDistribute = await CompanySecureAPI.getDriverIntervalDistribute(
      param,
    )
    commit('setIntervalData', driverIntervalDistribute.data)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
