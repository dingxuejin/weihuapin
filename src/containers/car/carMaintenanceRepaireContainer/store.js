import * as CarAPI from '@/api/car'

const state = {
  // 中间：车辆保养信息
  clbyxxData: null,
  clwxxxData: null,
  clbxjcData: null,
  ylrqgtjcData: null,
  // 弹出框信息
  maintainInfomationData: null,
  repairRecordData: null,
  repairStatisticsData: null,
  insuranceRecordData: null,
  lossAdviseData: null,
  testInformationData: null,
  lossAdviseCountData: null,
}
const mutations = {
  setClbyxx(state, data) {
    state.clbyxxData = data
  },
  setClwxxx(state, data) {
    state.clwxxxData = data
  },
  setClbxjc(state, data) {
    state.clbxjcData = data
  },
  setYlrqgtjc(state, data) {
    state.ylrqgtjcData = data
  },


  setMaintainInfomation(state, data) {
    state.maintainInfomationData = data
  },
  setRepairRecord(state, data) {
    state.repairRecordData = data
  },

  setRepairStatistics(state, data) {
    state.repairStatisticsData = data
  },

  setInsuranceRecord(state, data) {
    state.insuranceRecordData = data
  },

  setLossAdvise(state, data) {
    state.lossAdviseData = data
  },

  setTestInformation(state, data) {
    state.testInformationData = data
  },
  setLossAdviseCount(state, data) {
    state.lossAdviseCountData = data
  },


}
const actions = {
  async getClbyxx({
    commit,
  }, vehicleId) {
    const clbyxx = await CarAPI.getClbyxx(vehicleId)
    commit('setClbyxx', clbyxx.data[0])
    // console.log('sotre.js---clbyxx', clbyxx.data)
  },
  async getClwxxx({
    commit,
  }, vehicleId) {
    const clwxxx = await CarAPI.getClwxxx(vehicleId)
    commit('setClwxxx', clwxxx.data[0])
  },
  async getClbxjc({
    commit,
  }, vehicleId) {
    const clbxjc = await CarAPI.getClbxjc(vehicleId)
    commit('setClbxjc', clbxjc.data[0])
  },
  async getYlrqgtjc({
    commit,
  }, vehicleId) {
    const ylrqgtjc = await CarAPI.getYlrqgtjc(vehicleId)
    commit('setYlrqgtjc', ylrqgtjc.data[0])
  },


  // 详情弹出框
  // 中下保养及维修等信息弹出框 -- 保养信息
  async getcarMaintainInfomation({
    commit,
  }, vehicleId) {
    const maintain = await CarAPI.getcarMaintainInfomation(vehicleId)
    commit('setMaintainInfomation', maintain.data)
  },
  // 中下保养及维修等信息弹出框 -- 维修信息
  async getcarRepairRecord({
    commit,
  }, vehicleId) {
    const repaireRecord = await CarAPI.getcarRepairRecord(vehicleId)
    commit('setRepairRecord', repaireRecord.data)
  },
  async getcarRepairStatistics({
    commit,
  }, vehicleId) {
    const repairStatistics = await CarAPI.getcarRepairStatistics(vehicleId)
    commit('setRepairStatistics', repairStatistics.data)
  },
  // 中下保养及维修等信息弹出框 -- 保险信息
  async getcarInsuranceRecord({
    commit,
  }, vehicleId) {
    const insuranceRecord = await CarAPI.getcarInsuranceRecord(vehicleId)
    commit('setInsuranceRecord', insuranceRecord.data)
  },
  async getcarLossAdvise({
    commit,
  }, params) {
    const lossAdvise = await CarAPI.getcarLossAdvise(params)
    commit('setLossAdvise', lossAdvise.data)
  },
  async getcarLossAdviseCount({
    commit,
  }, params) {
    const lossAdviseCount = await CarAPI.getcarLossAdviseCount(params)
    commit('setLossAdviseCount', lossAdviseCount.data)
  },

  // 中下保养及维修等信息弹出框 -- 检测信息
  async getcarTestInformation({
    commit,
  }, params) {
    const testInformation = await CarAPI.getcarTestInformation(params)
    commit('setTestInformation', testInformation.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
