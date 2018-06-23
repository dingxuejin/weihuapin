import * as CompanySecureAPI from '@/api/companysecure'

const state = {
  accidentList: null,
}
const mutations = {
  setData(state, data) {
    state.accidentList = data
  },
}
const actions = {
  async getAccidentList({ commit }, param) {
    commit('setData', null)
    const accidentList = await CompanySecureAPI.getAccidentList(param)
    commit('setData', accidentList.data)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
