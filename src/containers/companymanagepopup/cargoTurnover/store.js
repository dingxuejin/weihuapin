import * as CompanyManageAPI from '@/api/companymanage'

const state = {
  cargoTurnover: null,
}
const mutations = {
  setData(state, data) {
    state.cargoTurnover = data
  },
}
const actions = {
  async getTurnoverByCargoType({ commit }, param) {
    commit('setData', null)
    const cargoTurnover = await CompanyManageAPI.getTurnoverByCargoType(param)
    console.log(param)
    commit('setData', cargoTurnover.data)
  },
}

export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
