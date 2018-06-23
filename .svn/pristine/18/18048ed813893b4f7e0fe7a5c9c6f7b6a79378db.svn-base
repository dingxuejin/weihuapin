<template>
  <div>
    <amessage>
      <aheader slot='header'
               name='从业人员信息'
               @click='$router.push("/driver")'></aheader>
      <aCarPeople slot='content'
                  :data='apeople'
                  :data1='peopleMsg'
                  @up='selectTitle'>
        <!-- 图表 -->
        <div class="echarts">
          <sunburst chartTheme="dark"
                    :data="peopleMsg"
                    :color="sunburstColor"
                    v-if="peopleMsg"></sunburst>
        </div>
      </aCarPeople>
    </amessage>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import amessage from '../../../components/company/amessage'
import aheader from '../../../components/company/aheader'
import aCarPeople from '../../../components/company/aCarPeople'
import sunburst from '../../../components/charts/sunburst'

export default {
  components: {
    amessage,
    aheader,
    aCarPeople,
    sunburst,
  },
  computed: {
    ...mapState('peopleMsgStore', ['peopleMsg']),
    ...mapState('headerMsgStore', ['selectedEntity', 'entities']),
  },
  methods: {
    ...mapActions('peopleMsgStore', ['getPeopleMsg']),
    selectTitle(i) {
      // console.log('peopleMsg', JSON.stringify(this.peopleMsg))
      this.title = ['人员类型', '性别', '年龄', '从业年限', '学历', '证件比例'][
        i
      ]
      // console.log('selectedEntity', this.selectedEntity)
      this.entity_id = this.selectedEntity
      this.fetchData()
    },
    fetchData() {
      this.getPeopleMsg({
        entity_id: this.selectedEntity,
        type: this.title,
      })
    },
  },
  data() {
    return {
      apeople: ['人员类型', '性别', '年龄', '从业年限', '学历', '证件比例'],
      peopledata1: ['18-30岁', '31-50岁', '51-60岁'],
      peopledata2: [678, 435, 230],
      sunburstColor: [
        'rgb(5, 208, 235)',
        'rgb(129, 180, 223)',
        'rgb(255, 203, 246)',
        'rgb(231, 80, 41)',
        'rgb(0, 252, 155)',
        'rgb(88, 0, 106)',
        'rgb(78, 106, 0)',
      ],
      title: '人员类型',
      entity_id: this.selectedEntity,
    }
  },
}
</script>

<style lang="scss" scoped>
.echarts {
  width: 100%;
  height: 100%;
}
</style>
