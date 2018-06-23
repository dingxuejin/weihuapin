import * as CompanyAPI from '@/api/company'

const state = {
  companyRegisterInfo: null,
  companySecureAbility: null,
  companyCargoFlow: null,
  companyCargoFlowMap: null,
  cargoHistoryFlow: null,
  cargoHistoryFlowMap: null,
  vehicleState: null,
  vehicleStateMap: null,
  safeProductDay: null,
  CompanyMsg: {},
  companyCarInfo: [],
  CarGroupInfo: {},
}
const mutations = {
  setRegisterData(state, data) {
    state.companyRegisterInfo = data
  },
  setCompanyMsg(state, data) {
    state.CompanyMsg = data
  },
  setSecureData(state, data) {
    state.companySecureAbility = data
  },
  setCargoFlowData(state, data) {
    state.companyCargoFlow = data
  },
  setCargoFlowDataMap(state, data) {
    state.companyCargoFlowMap = data
  },
  setHistoryCargoData(state, data) {
    state.cargoHistoryFlow = data
  },
  setHistoryCargoDataMap(state, data) {
    state.cargoHistoryFlowMap = data
  },
  setVehicleState(state, data) {
    state.vehicleState = data
  },
  setVehicleStateMap(state, data) {
    state.vehicleStateMap = data
  },
  setSafeDay(state, data) {
    state.safeProductDay = data
  },
  setCompanyCarInfo(state, data) {
    state.companyCarInfo = data
  },
  setCarGroupInfo(state, data) {
    state.CarGroupInfo = data
  },
}
const actions = {
  async getCompanyRegisterInfo({ commit }) {
    commit('setRegisterData', null)
    const companyRegisterInfo = await CompanyAPI.getCompanyRegisterInfo()
    commit('setRegisterData', companyRegisterInfo.data)
  },
  async getCompanyMsg({ commit }, params) {
    const CompanyMsg = await CompanyAPI.getCompanyInfo(params)
    commit('setCompanyMsg', CompanyMsg.data)
  },
  async getCompanySecureAbility({ commit }) {
    commit('setSecureData', null)
    const companySecureAbility = await CompanyAPI.getCompanySecureAbility()
    commit('setSecureData', companySecureAbility.data)
  },
  async getCompanyCargoFlow({ commit }, params) {
    commit('setCargoFlowData', null)
    const companyCargoFlow = await CompanyAPI.getCompanyCargoFlow(params)
    commit('setCargoFlowData', companyCargoFlow.data)
    // console.log('companyCargoFlow', JSON.stringify(state.companyCargoFlow))
  },
  async getCompanyCargoFlowMap({ commit }, params) {
    commit('setCargoFlowDataMap', [])
    const companyCargoFlow = await CompanyAPI.getCompanyCargoFlowMap(params)
    commit('setCargoFlowDataMap', companyCargoFlow.data)
    // console.log('companyCargoFlow', JSON.stringify(companyCargoFlow.data))
  },
  async getCargoHistoryFlow({ commit }, param) {
    commit('setHistoryCargoData', null)
    const cargoHistoryFlow = await CompanyAPI.getCargoHistoryFlow(param)
    commit('setHistoryCargoData', cargoHistoryFlow.data)
  },
  async getCargoHistoryFlowMap({ commit }, param) {
    commit('setHistoryCargoDataMap', null)
    const cargoHistoryFlow = await CompanyAPI.getCargoHistoryFlowMap(param)
    commit('setHistoryCargoDataMap', cargoHistoryFlow.data)
  },
  async getVehicleState({ commit }, param) {
    commit('setVehicleState', null)
    const vehicleState = await CompanyAPI.getVehicleState(param)
    commit('setVehicleState', vehicleState.data)
  },
  async getVehicleStateMap({ commit }, param) {
    commit('setVehicleStateMap', null)
    const vehicleState = await CompanyAPI.getVehicleStateMap(param)
    commit('setVehicleStateMap', vehicleState.data)
  },
  async getSafeProductDay({ commit }, param) {
    commit('setSafeDay', null)
    const safeProductDay = await CompanyAPI.getSafeProductDay(param)
    commit('setSafeDay', safeProductDay.data)
  },
  async getCompanyCarInfo({ commit }, param) {
    const res = await CompanyAPI.getCompanyCarInfo(param)
    commit('setCompanyCarInfo', res.data)
  },
  async getCarGroupInfo({ commit }, param) {
    const res = await CompanyAPI.getCarGroupInfo(param)
    commit('setCarGroupInfo', res.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
