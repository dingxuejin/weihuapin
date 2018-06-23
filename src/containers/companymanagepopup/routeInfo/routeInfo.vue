<template>
  <div class="route_info_table_wrap">
    <list-component :titlesData='titlesData' :listData='routeInfo' v-if="routeInfo"></list-component>
    <loading :data='routeInfo'></loading>
  </div>
</template>
<script>
import { mapState } from 'vuex'
import ListComponent from '../../../components/ListComponent'


export default {
  components: {
    ListComponent,
  },
  computed: {
    ...mapState('routeInfo', ['routeInfo']),
  },

  data: () => ({
    titlesData: [{
      name: '线路',
      key: 'route_name',
      width: 400,
    }, {
      name: '货源地',
      key: 'qy_dbxx_source_db_id.name',
      width: 250,
    }, {
      name: '目的地',
      key: 'qy_dbxx_destination_db_id.name',
      width: 250,
    }, {
      name: '场站',
      key: 'qy_dbxx_station_name.name',
      width: 250,
    }, {
      name: '线路类型',
      key: 'xllx_route_type_code.route_type',
      width: 250,
    }],
  }),
}
</script>
<style lang="scss" scoped>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.route_info_table_wrap {
  width: 100%;
  height: 275px;
  margin-top:10px;
  //   background: pink;
}
</style>
