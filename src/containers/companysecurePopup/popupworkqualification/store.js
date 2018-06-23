import * as DriverAPI from '@/api/driver'

const state = {
  popUpWorkQualification: null,
}
const mutations = {
  setPopUpWorkQualification(state, data) {
    state.popUpWorkQualification = data
  },
}
const actions = {
  async getPopUpWorkQualification({ commit }, param) {
    commit('setPopUpWorkQualification', null)
    const popUpWorkQualification = await DriverAPI.getPopUpWorkQualification(
      param,
    )
    commit('setPopUpWorkQualification', popUpWorkQualification.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
