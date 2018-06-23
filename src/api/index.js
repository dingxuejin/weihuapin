import axios from 'axios'

// const baseURL = 'http://172.30.7.105:3033'
// const baseURL = process.env.NODE_ENV === 'production' ? 'http://172.16.5.51:3033' : 'http://172.30.6.147:3033'
// const baseURL = process.env.NODE_ENV === 'production' ? 'http://www.mobius-vision.com:3033' : 'http://172.30.7.103:3033'
const baseURL = process.env.NODE_ENV === 'production' ? 'http://39.104.89.57:3034' : 'http://172.30.7.103:3033'


// 企业列表查询:省份
export async function getListqueryProvince() {
  return axios.get(`${baseURL}/tb_basic_qy_fwsxx_listquery_province`)
}
// 企业列表查询:服务商
export async function getListquerySpName({ province_code }) {
  console.log(province_code)
  return axios.get(`${baseURL}/tb_basic_qy_fwsxx_listquery_spName`, {
    params: {
      province_code,
    },
  })
}
// 企业列表查询:企业
export async function getListqueryCompanyName({ sp_id }) {
  return axios.get(`${baseURL}/tb_basic_qy_fwsxx_listquery_companyName`, {
    params: {
      sp_id,
    },
  })
}
// 企业列表查询:车辆
export async function getListqueryCarName({ sp_id }) {
  return axios.get(`${baseURL}/tb_basic_qy_fwsxx_listquery_carName`, {
    params: {
      sp_id,
    },
  })
}
export default {}
