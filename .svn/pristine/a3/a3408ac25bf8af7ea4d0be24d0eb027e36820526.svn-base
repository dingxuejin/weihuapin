import * as comAPI from '../../../api/company'

const state = {
  vehicleTermailRatio: null,
}
const mutations = {
  setData(state, data) {
    state.vehicleTermailRatio = data
  },
}
const actions = {
  async getVehicleTerminal({ commit }, param) {
    commit('setData', null)

    const vehicleTermailRatio = await comAPI.getVehicleTerminal(param)
    commit('setData', vehicleTermailRatio.data)
  },
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
