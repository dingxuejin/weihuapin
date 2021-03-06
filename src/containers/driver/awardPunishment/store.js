import * as DriverAPI from '@/api/driver'

const state = {
  jc: null,
  reward: null,
  punishment: null,
  safetyIntegral: null,
}
const mutations = {
  setJc(state, data) {
    // console.log(data)
    state.reward = data.reward
    state.punishment = data.punishment
  },
  setSafetyIntegral(state, data) {
    state.safetyIntegral = data
  },
}

const actions = {
  async getJc({ commit }, param) {
    commit('setJc', {
      reward: null,
      punishment: null,
    })

    const jc = await DriverAPI.getJc(param)
    commit('setJc', jc.data)
  },
  async getSafetyIntegral({ commit }, param) {
    commit('setSafetyIntegral', {
      safetyIntegral: null,
    })

    const Safe = await DriverAPI.getSafetyIntegral(param)
    commit('setSafetyIntegral', Safe.data)
  },
}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
