import axios from 'axios'

// const baseURL = 'http://172.30.7.105:3033'
// const baseURL = process.env.NODE_ENV === 'production' ? 'http://172.16.5.51:3033' : 'http://172.30.6.147:3033'
// const baseURL = process.env.NODE_ENV === 'production' ? 'http://www.mobius-vision.com:3033' : 'http://172.30.7.103:3033'
// const baseURL = process.env.NODE_ENV === 'production' ? 'http://www.mobius-vision.com:3033' : 'http://172.30.7.103:3033'
const baseURL = process.env.NODE_ENV === 'production' ? 'http://39.104.89.57:3034' : 'http://172.30.7.103:3033'
const baseURL_java = process.env.NODE_ENV === 'production' ? 'http://39.104.89.57:8081' : 'http://39.104.89.57:8081'
// const baseURL_java = process.env.NODE_ENV === 'production' ? 'http://172.30.7.115:8080' : 'http://172.30.7.115:8080'

// ?成本比例变化趋势
export async function getCompanyManageCostRatio({ entity_id }) {
  return axios.get(`${baseURL}/company_manage_cost_trand`, {
    params: {
      entity_id,
    },
  })
}

// 变动成本
export async function getVariableCost({ entity_id }) {
  return axios.get(`${baseURL}/company_manage_variable_cost`, {
    params: {
      entity_id,
    },
  })
}

// 固定成本
export async function getFixedCost({ entity_id, situation, type }) {
  return axios.get(`${baseURL}/company_manage_fix_cost`, {
    params: {
      entity_id,
      situation,
      type,
    },
  })
}

// 实时运行情况 company_manage_runtime_state
export async function getRunReal({ entity_id }) {
  return axios.get(`${baseURL}/company_manage_runtime_state`, {
    params: { entity_id },
  })
}
// 经营总收入-年排名及趋势
export async function requireYearRanking({ entity_id, year }) {
  return axios.get(`${baseURL_java}/queryRankingByYearAndEntityId`, {
    params: { entity_id, year },
  })
}

// 经营单车收入-年排名及趋势
export async function requireDcYearRanking({ entity_id, year }) {
  return axios.get(`${baseURL_java}/queryDCRankingByEntityId`, {
    params: { entity_id, year },
  })
}

// 经营总收入-月排名及趋势
export async function requireMonthRanking({ entity_id, year, month }) {
  return axios.get(`${baseURL_java}/queryRankingEntityCountByEntityIdAndYearAndMonth`, {
    params: { entity_id, year, month },
  })
}
// 经营单车收入-月排名及趋势
export async function requireDcMonthRanking({ entity_id, year, month }) {
  return axios.get(`${baseURL_java}/queryDCRankingEntityCountByEntityIdAndYearAndMonth`, {
    params: { entity_id, year, month },
  })
}
// 经营总收入-年排名及趋势-弹窗
export async function requireFrameYearRanking({ entity_id }) {
  return axios.get(`${baseURL_java}/queryAllByEntityId`, {
    params: { entity_id },
  })
}
// 经营总收入-月排名及趋势-弹窗
export async function requireFrameMonthRanking({ entity_id, year }) {
  return axios.get(`${baseURL_java}/queryAllByEntityIdAndYear`, {
    params: { entity_id, year },
  })
}
// 经营单车收入-年排名及趋势-弹窗
export async function requireDcFrameYearRanking({ entity_id }) {
  return axios.get(`${baseURL_java}/queryDCAllByEntityId`, {
    params: { entity_id },
  })
}
// 经营单车收入-月排名及趋势-弹窗
export async function requireDcFrameMonthRanking({ entity_id, year }) {
  return axios.get(`${baseURL_java}/queryDCAllByEntityIdAndYear`, {
    params: { entity_id, year },
  })
}
// 运单数和周转量统计
export async function requireTbSubjectQyMYRydAndHwzzl({ entity_id, year, monthlist }) {
  return axios.get(`${baseURL_java}/TbSubjectQyMYRydAndHwzzlYearMonthDayByEId`, {
    params: { entity_id, year, monthlist },
  })
}
// 运输时段运行车辆次数分布
export async function getIntervalVehicleQuantity({ entity_id, year, month }) {
  return axios.get(`${baseURL}/company_manage_vehicle_quantiy_by_interval`, {
    params: {
      entity_id,
      year,
      month,
    },
  })
}

// 线路排名
export async function getRouteOrder({ entity_id, year, month, period }) {
  return axios.get(`${baseURL}/company_manage_route_order`, {
    params: {
      entity_id,
      year,
      month,
      period,
    },
  })
}

// 货物流量流向统计
export async function getCargoFlow({ entity_id, year, cargo_id }) {
  return axios.get(`${baseURL}/company_manage_cargo_flow`, {
    params: {
      entity_id,
      year,
      cargo_id,
    },
  })
}

// 货物流量流向变化趋势
export async function getCargoFlowTrend({ entity_id, year, cargo_type_code }) {
  return axios.get(`${baseURL}/company_manage_cargo_flow`, {
    params: {
      entity_id,
      year,
      cargo_type_code,
    },
  })
}

// 货物流量流向统计
export async function getCargoFlowArea({ entity_id, year, cargo_id }) {
  return axios.get(`${baseURL}/company_manage_cargo_flow_area`, {
    params: {
      entity_id,
      year,
      cargo_id,
    },
  })
}

// cargo_id以及cargo_name
export async function getCargoId_name() {
  return axios.get(`${baseURL}/tb_dictionary_cjhwfl`)
}

// 里程统计
export async function getMileageStatistics({ entity_id, year, month }) {
  return axios.get(`${baseURL}/company_manage_mileage_distribute`, {
    params: {
      entity_id,
      year,
      month,
    },
  })
}

// 里程变化趋势
export async function getMileageTrend({ entity_id, year, month }) {
  return axios.get(`${baseURL}/company_manage_mileage_distribute_by_entity`, {
    params: {
      entity_id,
      year,
      month,
    },
  })
}

// 里程分布比例
export async function getMileageRatio({ entity_id, year, month }) {
  return axios.get(`${baseURL}/company_manage_mileage_distribute_by_interval`, {
    params: {
      entity_id,
      year,
      month,
    },
  })
}
// 最高里程车辆TOP10
export async function getHighestVehicleMileage({ entity_id, year, month }) {
  return axios.get(
    `${baseURL}/company_manage_mileage_distribute_highest_vehicle`,
    {
      params: {
        entity_id,
        year,
        month,
      },
    },
  )
}

// 详情弹出框：
// 年度成本变化趋势（年度固定成本统计）
export async function getYearCostTrendFixed({ entity_id }) {
  return axios.get(`${baseURL}/company_manage_year_cost_trend_fixed`, {
    params: {
      entity_id,
    },
  })
}

export async function getYearCostTrendTurnover({ entity_id }) {
  return axios.get(`${baseURL}/company_manage_year_cost_trend_turnover`, {
    params: {
      entity_id,
    },
  })
}

export async function getYearCostTrendFloat({ entity_id }) {
  return axios.get(`${baseURL}/company_manage_year_cost_trend_float`, {
    params: {
      entity_id,
    },
  })
}

// 总运单数量
export async function getWaybillStatistics({ entity_id, year, month }) {
  return axios.get(`${baseURL}/company_manage_waybill_statistics`, {
    params: {
      entity_id,
      year,
      month,
    },
  })
}
export async function getWaybillTrendRecently({ entity_id, year, month }) {
  return axios.get(`${baseURL}/company_mange_waybill_trend_recently`, {
    params: {
      entity_id,
      year,
      month,
    },
  })
}
export async function getWaybillYearOnYearThisMonth({
  entity_id,
  year,
  month,
}) {
  return axios.get(`${baseURL}/company_manage_waybill_yearonyear_this_month`, {
    params: {
      entity_id,
      year,
      month,
    },
  })
}

// 不同类型货物周转量统计
export async function getTurnoverByCargoType({
  entity_id,
  year,
  month,
  cargo_id,
}) {
  return axios.get(`${baseURL}/company_manage_turnover_by_cargo_type`, {
    params: {
      entity_id,
      year,
      month,
      cargo_id,
    },
  })
}
// 不同类型货物货运量统计
export async function getVolumeByCargoType({
  entity_id,
  year,
  month,
  cargo_id,
}) {
  return axios.get(`${baseURL}/company_manage_volume_by_cargo_type`, {
    params: {
      entity_id,
      year,
      month,
      cargo_id,
    },
  })
}
export async function getRouteInfo({ entity_id }) {
  return axios.get(`${baseURL}/company_manage_route_info`, {
    params: {
      entity_id,
    },
  })
}

export async function getVolumeStatisticDayNight({ entity_id, cargo_id }) {
  return axios.get(`${baseURL}/company_manage_volume_statistics_day_night`, {
    params: {
      entity_id,
      cargo_id,
    },
  })
}

export async function getVolumeStatisticsEntity({
  year,
  region_scope_code,
  cargo_id,
  entity_id,
}) {
  return axios.get(`${baseURL}/company_manage_volume_statistics_entity`, {
    params: {
      year,
      region_scope_code,
      cargo_id,
      entity_id,
    },
  })
}

export async function getVolumeInterstateEntity({
  cargo_id,
  entity_id,
}) {
  return axios.get(`${baseURL}/company_manage_volume_interstate_entity`, {
    params: {
      entity_id,
      cargo_id,
    },
  })
}
// 货物流量流向变化趋势
export async function getManageGoodsBh({
  entity_id,
  cargo_id,
  year,
  route,
}) {
  return axios.get(`${baseURL}/company_manage_cargo_flow_direction_options`, {
    params: { entity_id, cargo_id, year, route },
  })
}

// 日常管理台账
export async function getDailyManageLedger({
  entity_id,
  year,
  month,
  day,
}) {
  return axios.get(`${baseURL}/company_manage_day_accounts`, {
    params: { entity_id, year, month, day },
  })
}


export default {}
