import * as CompanyAPI from '@/api/company'

const state = {
  red: [],
  black: [],
  branchCom: {
    bad: null,
    good: null,
  },
  driver: {
    bad: null,
    good: null,
  },
  motorcade: {
    bad: null,
    good: null,
  },
}
const mutations = {
  setDataSafe(state, data) {
    const good = data.data.good
    const bad = data.data.bad
    const red = []
    const black = []
    good.forEach((item) => {
      red.push({ name: item.qy_cdxx.entity_name })
    })

    bad.forEach((item) => {
      black.push({ name: item.qy_cdxx.entity_name })
    })
    state.red = red
    state.black = black
  },
  setDataSafeJ(state, data) {
    const good = data.data.good
    const bad = data.data.bad
    const red = []
    const black = []
    good.forEach((item) => {
      red.push({ name: item.ryjb.name, fleet: item.ryjb.qy_cdxx.entity_name })
    })

    bad.forEach((item) => {
      black.push({ name: item.ryjb.name, fleet: item.ryjb.qy_cdxx.entity_name })
    })
    state.red = red
    state.black = black
  },
  setYearOrMonthMsg(state, data) {
    state.branchCom = data.branchCom
    state.driver = data.driver
    state.motorcade = data.motorcade
  },
}
const actions = {
  async getYear({ commit }) {
    const yearMsg = await CompanyAPI.getYearMsg()
    commit('setDataSafe', yearMsg)
    // console.log('store.js', JSON.stringify(state.red))
    // console.log('store.js', JSON.stringify(state.black))
  },
  async getMonth({ commit }) {
    const monthMsg = await CompanyAPI.getMonthMsg()
    commit('setDataSafe', monthMsg)
    // console.log('store.js', JSON.stringify(state.red))
    // console.log('store.js', JSON.stringify(state.black))
  },
  async getJyear({ commit }) {
    const jyearMsg = await CompanyAPI.getJyearMsg()
    commit('setDataSafeJ', jyearMsg)
    // console.log('store.js', JSON.stringify(state.red))
    // console.log('store.js', JSON.stringify(state.black))
  },
  async getJmonth({ commit }) {
    const jmonthMsg = await CompanyAPI.getJmonthMsg()
    commit('setDataSafeJ', jmonthMsg)
    // console.log('store.js', JSON.stringify(state.red))
    // console.log('store.js', JSON.stringify(state.black))
  },
  async getYearOrMonthMsg({ commit }, params) {
    const ymMsg = await CompanyAPI.getYearOrMonthMsg(params)
    commit('setYearOrMonthMsg', ymMsg.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
