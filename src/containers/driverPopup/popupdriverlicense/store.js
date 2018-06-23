import * as DriverAPI from '@/api/driver'

const state = {
  popUpDriverLicense: null,
}
const mutations = {
  setPopUpDriverLicense(state, data) {
    state.popUpDriverLicense = data
  },
}
const actions = {
  async getPopUpDriverLicense({ commit }, param) {
    commit('setPopUpDriverLicense', null)
    const popUpDriverLicense = await DriverAPI.getPopUpDriverLicense(param)
    commit('setPopUpDriverLicense', popUpDriverLicense.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
