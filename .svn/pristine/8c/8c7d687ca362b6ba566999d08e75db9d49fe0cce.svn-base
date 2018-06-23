import axios from 'axios'

// const baseURL = 'http://172.30.7.105:3033'
// const baseURL = process.env.NODE_ENV === 'production' ? 'http://172.16.5.51:3033' : 'http://172.30.6.147:3033'
// const baseURL = process.env.NODE_ENV === 'production' ? 'http://www.mobius-vision.com:3033' : 'http://172.30.7.103:3033'
const baseURL = process.env.NODE_ENV === 'production' ? 'http://39.104.89.57:3034' : 'http://172.30.7.103:3033'


// 企业信息API 测试
export async function getCompanyMsg() {
  return axios.get(`${baseURL}/TB_BASIC_QY_QYXX`)
}
// 经营许可信息
export async function getCompanyInfo({ entity_id }) {
  return axios.get(`${baseURL}/tb_basic_qy_qyxx_baseInfo`, {
    params: {
      id: entity_id,
    },
  })
}
// 所有人员 http://172.30.6.147:3033/tb_basic_qy_cdxx
export async function getHeaderMsg() {
  return axios.get(`${baseURL}/tb_basic_qy_cdxx`)
}

// 人员信息
export async function getPeopleMsg({ entity_id, type }) {
  return axios.get(`${baseURL}/tb_subject_qy_rysl`, {
    params: { entity_id, type },
  })
}

// 车辆信息
export async function getCarMsg({ entity_id, type }) {
  return axios.get(`${baseURL}/tb_subject_qy_clsl`, {
    params: { entity_id, type },
  })
}

// 线路信息
export async function getLineMsg({ entity_id }) {
  return axios.get(`${baseURL}/tb_subject_qy_xltj`, {
    params: { entity_id },
  })
}

// 线路详细信息
export async function getLineDetail({ entity_id }) {
  return axios.get(`${baseURL}/company_manage_route_info`, {
    params: { entity_id },
  })
}

// 车辆终端信息
export async function getVehicleTerminal({ entity_id }) {
  return axios.get(`${baseURL}/company_home_vehicle_termial_install`, {
    params: { entity_id },
  })
}

// 工商注册信息
export async function getCompanyRegisterInfo() {
  return axios.get(`${baseURL}/company_home_register_info`)
}

// 企业安全能力
export async function getCompanySecureAbility() {
  return axios.get(`${baseURL}/company_home_secure_ability`)
}

// 实时货物流向
export async function getCompanyCargoFlow({ entity_id }) {
  return axios.get(`${baseURL}/company_home_cargo_runtime_flow`, {
    params: {
      entity_id,
    },
  })
}
// 实时货物流向地图
export async function getCompanyCargoFlowMap({ entity_id }) {
  return axios.get(`${baseURL}/company_home_cargo_runtime_flow_map`, {
    params: {
      entity_id,
    },
  })
}

// 历史货物流向
export async function getCargoHistoryFlow({ entity_id }) {
  return axios.get(`${baseURL}/company_home_cargo_history_flow`, {
    params: {
      entity_id,
    },
  })
}
// 历史货物流向地图
export async function getCargoHistoryFlowMap({ entity_id }) {
  return axios.get(`${baseURL}/company_home_cargo_history_flow_map`, {
    params: {
      entity_id,
    },
  })
}
// 车辆状态
export async function getVehicleState({ entity_id }) {
  return axios.get(`${baseURL}/company_home_vehicle_state`, {
    params: {
      entity_id,
    },
  })
}
// 车辆状态地图
export async function getVehicleStateMap({ entity_id }) {
  return axios.get(`${baseURL}/company_home_vehicle_state_map`, {
    params: {
      entity_id,
    },
  })
}
// 车辆基本信息

export async function getCarBaseInfoMap({ vehicle_id }) {
  return axios.get(`${baseURL}/tb_basic_cljcxx_com_map`, {
    params: {
      vehicle_id,
    },
  })
}
// 最近一次事故信息
export async function getRecentlyAccident() {
  return axios.get(`${baseURL}/tb_business_yzsg`)
}

// 安全生产天数
export async function getSafeProductDay({ entity_id }) {
  return axios.get(`${baseURL}/tb_subject_qy_aqys`, {
    params: {
      entity_id,
    },
  })
}

// 企业经营情况(运单量)
export async function getManageStateWaybill({ entity_id, year }) {
  return axios.get(`${baseURL}/company_home_manage_state_waybill`, {
    params: {
      entity_id,
      year,
      // month,
    },
  })
}
// 企业经营情况(周转量)
export async function getMangeStateTurnover({ entity_id, year }) {
  return axios.get(`${baseURL}/company_home_manage_state_turnover`, {
    params: {
      entity_id,
      year,
      // month,
    },
  })
}

// 安全情况
// ?机构
export async function getYearMsg() {
  return axios.get(`${baseURL}/tb_subject_qy_qyaqnpx`, {
    params: {
      year: 2017,
    },
  })
}

export async function getMonthMsg() {
  return axios.get(`${baseURL}/tb_subject_qy_qyaqypx`, {
    params: {
      year: 2017,
      month: 10,
    },
  })
}

// 驾驶员
export async function getJyearMsg() {
  return axios.get(`${baseURL}/tb_subject_qy_aqjsnpx`, {
    params: {
      year: 2017,
    },
  })
}
export async function getYearOrMonthMsg({ year, month }) {
  return axios.get(`${baseURL}/tb_subject_qy_rankingsAndStatistics`, {
    params: {
      year, month,
    },
  })
}
export async function getJmonthMsg() {
  return axios.get(`${baseURL}/tb_subject_qy_aqjsypx`, {
    params: {
      year: 2017,
      month: 11,
    },
  })
}

// 中间部分 地图
export async function getCenterMsg() {
  return axios.get(`${baseURL}/tb_subject_qy_hwsslllx`)
}
// 公司,分公司车队信息
export async function getCompanyCarInfo() {
  return axios.get(`${baseURL}/tb_basic_qy_cdxx_branch_fleet_info`)
}
// 获取车队信息
export async function getCarGroupInfo({ entity_id }) {
  return axios.get(`${baseURL}/tb_basic_qy_cdxx_details_info`, {
    params: {
      entity_id,
    },
  })
}
// 过期提醒
export async function getCompanyExpireTip({ entity_id }) {
  return axios.get(`${baseURL}/company_expiration_reminders`, {
    params: {
      entity_id,
    },
  })
}
// 运单进度列表
export async function getWaybillProgressList({ entity_id }) {
  return axios.get(`${baseURL}/waybill_progress_list`, {
    params: {
      entity_id,
    },
  })
}

export default {}
