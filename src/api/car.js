/*eslint-disable */
import axios from "axios";

// const baseURL = 'http://172.30.7.105:3033'
// const baseURL = process.env.NODE_ENV === 'production' ? 'http://172.16.5.51:3033' : 'http://172.30.6.147:3033'
// const baseURL = process.env.NODE_ENV === 'production' ? 'http://www.mobius-vision.com:3033' : 'http://172.30.7.103:3033'
const baseURL =
  process.env.NODE_ENV === "production"
    ? "http://39.104.89.57:3034"
    : "http://172.30.7.103:3033";

// //费用信息统计弹窗

// export async function getCostInformationStatistics({ vehicle_id }) {
//   return axios.get(`${baseURL}/car_cost_statistics_all`, {
//     params: {
//       vehicle_id
//     }
//   });
// }

//到期预警提醒

export async function getAlertInfo(vehicleId) {
  return axios.get(`${baseURL}/tb_basic_clzzzjxx_warning_alert`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}

//  过期提醒
export async function getCarOverReminding(vehicleId) {
  return axios.get(`${baseURL}/tb_basic_clzzzjxx_expiration_reminders`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}

// 右侧：年月下拉框之后的信息
export async function getrightPartData({ vehicle_id, month, year }) {
  return axios.get(`${baseURL}/tb_subject_clxslc_yl_zzl_yd`, {
    params: {
      vehicle_id,
      month,
      year
    }
  });
}

// 左侧：终端配置信息
export async function getCzzdxx(vehicleId) {
  return axios.get(`${baseURL}/tb_basic_czzdxx_zdpzxx`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}

//  左侧：轮胎配置信息
export async function getLtsyxx(vehicleId) {
  return axios.get(`${baseURL}/tb_basic_cllt_info`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}

// 左侧：轮胎配置详细信息:轮胎轮换记录
export async function getLtghxx(vehicleId) {
  return axios.get(`${baseURL}/tb_business_ltghxx`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}
// 左侧：防护及警告装备配置信息
export async function getCzzbxx(vehicleId) {
  return axios.get(`${baseURL}/tb_basic_czzbxx`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}
// 中间：车辆基础信息弹出框
export async function getClzzzjxx(vehicleId) {
  return axios.get(`${baseURL}/tb_basic_clzzzjxx`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}

//  中间：警告信息提示汇总信息
export async function getJgxxsl() {
  return axios.get(`${baseURL}/companyregisterinfo`);
}

//  中间：获取车辆根据车牌---车辆基础信息左侧车车按钮弹出框的车辆基本信息
export async function getCljcxx(plate_number) {
  return axios.get(`${baseURL}/tb_basic_cljcxx`, {
    params: {
      plate_number
    }
  });
}
// 右侧：行驶里程, 重车行驶里程，空车行驶里程，占比
export async function getClxslc(vehicleId) {
  return axios.get(`${baseURL}/tb_subject_clxslc`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}
// 右侧：行驶里程弹出框
export async function getCarMileageStatistics({ vehicleId, year, month, day }) {
  return axios.get(`${baseURL}/car_mileage_statistics`, {
    params: {
      vehicle_id: vehicleId,
      year,
      month,
      day
    }
  });
}

// 右侧：重车行驶里程占比弹出框
export async function getcarMileageStatisticsRatio({
  vehicleId,
  year,
  month,
  day
}) {
  return axios.get(`${baseURL}/car_mileage_statistics_ratio`, {
    params: {
      vehicle_id: vehicleId,
      year,
      month,
      day
    }
  });
}

// 右侧：运单数弹出框
export async function getcarMileageWaybillStatistics({
  vehicleId,
  year,
  month,
  day
}) {
  return axios.get(`${baseURL}/car_mileage_waybill_statistics`, {
    params: {
      vehicle_id: vehicleId,
      year,
      month,
      day
    }
  });
}
// 右侧：车辆运量弹出框
export async function getcarMileageVolumeStatistics({
  vehicleId,
  year,
  month,
  day,
  cargoTypeCode
}) {
  return axios.get(`${baseURL}/car_mileage_volume_statistics`, {
    params: {
      vehicle_id: vehicleId,
      cargo_type_code: cargoTypeCode,
      year,
      month,
      day
    }
  });
}

// 右侧：车辆周转量弹出框
export async function getCarPerMileageStatistics({
  vehicleId,
  year,
  month,
  day,
  cargoTypeCode
}) {
  return axios.get(`${baseURL}/tb_subject_clzzl_all`, {
    params: {
      vehicle_id: vehicleId,
      cargo_type_code: cargoTypeCode,
      year,
      month,
      day
    }
  });
}

// 右侧：车辆运量
export async function getClyl(vehicleId) {
  return axios.get(`${baseURL}/tb_subject_clyl`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}
// 右侧：周转量
export async function getClzzl(vehicleId) {
  return axios.get(`${baseURL}/tb_subject_clzzl`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}
// 右侧：运单数量
export async function getClydsl(vehicleId) {
  return axios.get(`${baseURL}/tb_subject_clydsl`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}
// 中间：保养信息
export async function getClbyxx(vehicleId) {
  return axios.get(`${baseURL}/tb_business_clbyxx`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}
// 中间：维修信息
export async function getClwxxx(vehicleId) {
  return axios.get(`${baseURL}/tb_business_clwxxx`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}
// 中间：保险信息
export async function getClbxjc(vehicleId) {
  return axios.get(`${baseURL}/tb_business_clbxjc`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}

// 中间：检测信息
export async function getYlrqgtjc(vehicleId) {
  return axios.get(`${baseURL}/tb_business_ylrqgtjc`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}
// 中间：累计各项费用占比
export async function getClfytj(vehicleId) {
  return axios.get(`${baseURL}/tb_subject_clfytj`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}

// 中间：累计各项费用占比模块弹出信息

export async function getcarCostStatistics(vehicleId) {
  return axios.get(`${baseURL}/car_cost_statistics_all`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}

// 中间：累计各项费用占比模块弹出信息--二级弹出框
export async function getcarFuelvsMileage(vehicleId) {
  return axios.get(`${baseURL}/car_fuel_vs_mileage`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}

// 中下保养及维修等信息弹出框 -- 保养信息
export async function getcarMaintainInfomation(vehicleId) {
  return axios.get(`${baseURL}/car_maintain_infomation`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}
// 中下保养及维修等信息弹出框 -- 维修信息
export async function getcarRepairRecord(vehicleId) {
  return axios.get(`${baseURL}/car_repair_record`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}
export async function getcarRepairStatistics(vehicleId) {
  return axios.get(`${baseURL}/car_repair_statistics`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}
// 中下保养及维修等信息弹出框 -- 保险信息
export async function getcarInsuranceRecord(vehicleId) {
  return axios.get(`${baseURL}/car_insurance_record`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}
export async function getcarLossAdvise({ vehicleId, year }) {
  return axios.get(`${baseURL}/car_loss_advise`, {
    params: {
      vehicle_id: vehicleId,
      year
    }
  });
}
export async function getcarLossAdviseCount(vehicleId) {
  return axios.get(`${baseURL}/car_loss_advise_count`, {
    params: {
      vehicle_id: vehicleId
    }
  });
}
// 中下保养及维修等信息弹出框 -- 检测信息
export async function getcarTestInformation({ vehicleId, testDate }) {
  return axios.get(`${baseURL}/car_test_information`, {
    params: {
      vehicle_id: vehicleId,
      test_date: testDate
    }
  });
}

// 计算油耗：

export async function getfuel() {
  return axios.get(`${baseURL}/car_fuel_vs_mileage_id`);
}
// 获取车辆定位信息
export async function getCarLocationInfo({ vehicle_id }) {
  return axios.get(`${baseURL}/car_home_hawkeye_map`, {
    params: {
      vehicle_id
    }
  });
}
