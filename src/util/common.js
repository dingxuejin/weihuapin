/* eslint-disable */
import axios from "axios";

export default {
  isEmpty(val = null) {
    if (val === "" || val === undefined || val === null) return false;
    if (val instanceof Array && val.length === 0) {
      return false;
    } else if (val instanceof Object && Object.keys(val).length === 0) {
      return false;
    }
    return true;
  },
  getLocation(lng = 116.717, lat = 23.4209) {
    return axios
      .get("/geocoder/v2/", {
        params: {
          location: `${lat},${lng}`,
          output: "json",
          pois: 1,
          ak: "W2fd4lgScqD7Wgywl8na9ivlFfcPaGzt"
        }
      })
      .catch(err => {
        console.log(`经纬度获取地址：${err}`);
      });
  }
};
