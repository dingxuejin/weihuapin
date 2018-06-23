import * as IndexAPI from '@/api/index'

const state = {
  leftHeaderTitle: '亿顺凯危货运输有限公司',
  carDetailsShow: false, // 展示详情弹窗
  trajectoryShow: false, // 展示轨迹弹窗
  companyInfoShow: false, // 展示企业信息弹窗
  CompanyName: '', // 展示企业信息弹窗获取(获取公司名)
  provinceName: '',
  markers: [
    {
      lng: 115.961632,
      lat: 40.362109,
      status: 1,
      name: '京AAF900',
    }, {
      lng: 115.971632,
      lat: 40.262109,
      status: 0,
      name: '京AAF901',
    }, {
      lng: 115.981632,
      lat: 40.452109,
      status: 1,
      name: '京AAF902',
    }, {
      lng: 116.453261,
      lat: 40.100549,
      status: 0,
      name: '京AAF903',
    }, {
      lng: 115.071632,
      lat: 40.462109,
      status: 0,
      name: '京AAF904',
    },
  ],
  playInfo: {},
  // 企业信息
  companyInfos: [
    {
      name: '北京程盛新泰燃气有限公司',
      position: '北京',
      spName: '北京中航天泰科技有限公司',
      type: 'company',
      RegisteredAdd: '廊坊经济技术开发区华祥路118号',
      RegisteredDate: '1998/1/1 0:00:00',
      BusinessScope: '四唑并-1-乙酸,一氧化碳等',
      AccessDate: '2016-05-01',
      AccessCars: '33',
      adasOnlineRatio: '64.52',
      carOnlineRatio: '61.34',
      alarm_quantity: '3256',
      alarm_doneQuantity: '3012',
    },
    {
      position: '北京',
      name: '北京市今日阳光燃气发展有限公司',
      spName: '北京中航天泰科技有限公司',
      type: 'company',
      RegisteredAdd: '北京市通州区宋庄镇大兴庄村',
      RegisteredDate: '2002/7/22 0:00:00',
      BusinessScope: '丙烷等',
      AccessDate: '2016-04-01',
      AccessCars: '7',
      adasOnlineRatio: '74.12',
      carOnlineRatio: '72.06',
      alarm_quantity: '6742',
      alarm_doneQuantity: '4006',
    },
    {
      position: '北京',
      name: '北京新亚特物流有限公司',
      spName: '北京中航天泰科技有限公司',
      type: 'company',
      RegisteredAdd: '北京市房山区城关街道东街村火车站路5号',
      RegisteredDate: '2008/3/11 0:00:00',
      BusinessScope: '乙硼烷等',
      AccessDate: '2016-02-01',
      AccessCars: '10',
      adasOnlineRatio: '68.62',
      carOnlineRatio: '65.14',
      alarm_quantity: '5247',
      alarm_doneQuantity: '5240',
    },
  ],
  // 首页企业信息弹窗信息
  indexPopupComInfo: [],
  Province: [],
  SpName: [],
  CompanyNameList: [],
}
const mutations = {
  setProvinceName(state, data) {
    state.provinceName = data
  },
  getTrajectoryShow(state, data) {
    state.trajectoryShow = data.state
    state.plateName = data.name
  },

  getCompanyInfoShow(state, data) {
    state.companyInfoShow = data.state
    state.CompanyName = data.name
    state.indexPopupComInfo =
    state.companyInfos && state.companyInfos.filter(o => o.name === data.name)
  },
  getCarDetailsInfoShow(state, data) {
    state.carDetailsShow = data.state
    state.CompanyName = data.name
  },
  startPlayPath(state, data) {
    state.playInfo = {
      startAddress: data.startAddress,
      endAddress: data.endAddress,
      play: data.play,
    }
  },
  setListqueryProvince(state, data) {
    state.Province = data
  },
  setListquerySpName(state, data) {
    state.SpName = data
  },
  setListqueryCompanyName(state, data) {
    state.CompanyNameList = data
  },
}
const actions = {
  // 获取省份
  async getListqueryProvince({ commit }, param) {
    const Province = await IndexAPI.getListqueryProvince(param)
    commit('setListqueryProvince', Province.data)
  },
  // 获取服务商
  async getListquerySpName({ commit }, param) {
    const SpName = await IndexAPI.getListquerySpName(param)
    commit('setListquerySpName', SpName.data)
  },
  // 获取企业列表
  async getListqueryCompanyName({ commit }, param) {
    const CompanyName = await IndexAPI.getListqueryCompanyName(param)
    commit('setListqueryCompanyName', CompanyName.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
