import * as CompanyAPI from '@/api/company'

const state = {
  peopleMsg: null,
}
const mutations = {
  setData(state, data) {
    state.peopleMsg = data
  },
}
const actions = {
  async getPeopleMsg({ commit }, param) {
    commit('setData', null)
    const peopleMsg = await CompanyAPI.getPeopleMsg(param)
    commit('setData', peopleMsg.data)
  },
}

export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
