<template>
  <div class="behaviorTitle">
    <div class="behaviorTitleLeft"
         v-if="detailesBoxShow===1">
      <div v-if="tb_subject_qy_qyaqfz">
        <behaviorHeader type="danger"
                        name='高危驾驶行为'
                        :year='tb_subject_qy_qyaqfz.y.danger_drive_score'
                        :month="tb_subject_qy_qyaqfz.m.danger_drive_score"
                        :riseAndFallChangeYear="tb_subject_qy_qyaqfz.y.danger_drive_score_trend"
                        :riseAndFallChangeMonth="tb_subject_qy_qyaqfz.m.danger_drive_score_trend"></behaviorHeader>
      </div>
      <div v-if="tb_subject_qy_qyaqfz">
        <behaviorHeader type="illegal"
                        name='违规行为'
                        :year='tb_subject_qy_qyaqfz.y.irregularity_drive_score'
                        :month="tb_subject_qy_qyaqfz.m.irregularity_drive_score"
                        :riseAndFallChangeYear="tb_subject_qy_qyaqfz.y.irregularity_drive_score_trend"
                        :riseAndFallChangeMonth="tb_subject_qy_qyaqfz.m.irregularity_drive_score_trend"></behaviorHeader>
      </div>
    </div>
    <div class="behaviorTitleRight"
         v-if="detailesBoxShow===2">
      <div v-if="tb_subject_qy_qyaqfz">
        <behaviorHeader type="law"
                        name='违法行为'
                        :year='tb_subject_qy_qyaqfz.y.illegal_drive_score'
                        :month="tb_subject_qy_qyaqfz.m.illegal_drive_score"
                        :riseAndFallChangeYear="tb_subject_qy_qyaqfz.y.illegal_drive_score_trend"
                        :riseAndFallChangeMonth="tb_subject_qy_qyaqfz.m.illegal_drive_score_trend"></behaviorHeader>
      </div>
      <div v-if="tb_subject_qy_qyaqfz">
        <behaviorHeader type="event"
                        name='事故记录'
                        :year='tb_subject_qy_qyaqfz.y.accident_score'
                        :month="tb_subject_qy_qyaqfz.m.accident_score"
                        :riseAndFallChangeYear="tb_subject_qy_qyaqfz.y.accident_score_trend"
                        :riseAndFallChangeMonth="tb_subject_qy_qyaqfz.m.accident_score_trend"></behaviorHeader>
      </div>
    </div>
    <!-- <div v-show="false">{{getBehaviorScore_year}}</div> -->
    <!-- <div v-show="false">{{getBehaviorScore_month}}</div> -->
  </div>
</template>

<script>
/*eslint-disable */
import _ from "lodash";
import { mapState, mapActions } from "vuex";
import behaviorHeader from "../../../components/companysecure/behaviorHeader";

export default {
  components: {
    behaviorHeader
  },
  props: ["detailesBoxShow"],
  computed: {
    ...mapState("behaviorTitle", ["tb_subject_qy_qyaqfz"])
    // getBehaviorScore_year() {
    //   if (this.tb_subject_qy_qyaqfz &&  this.tb_subject_qy_qyaqfz!==undefined  &&  ) {
    //     const danger_drive_score = _.sum(
    //       _.values(year_score.map(o => Number(o.danger_drive_score)))
    //     );
    //     const irregularity_drive_score = _.sum(
    //       _.values(year_score.map(o => Number(o.irregularity_drive_score)))
    //     );
    //     const illegal_drive_score = _.sum(
    //       _.values(year_score.map(o => Number(o.illegal_drive_score)))
    //     );
    //     const accident_score = _.sum(
    //       _.values(year_score.map(o => Number(o.accident_score)))
    //     );
    //     const year = {
    //       danger_drive_score,
    //       irregularity_drive_score,
    //       illegal_drive_score,
    //       accident_score
    //     };
    //     return year;
    //   }
    //   return null;
    // },
    // getBehaviorScore_month() {
    //   if (this.tb_subject_qy_qyaqfz) {
    //     const year_score = this.tb_subject_qy_qyaqfz.filter(
    //       o => o.year === "2017"
    //     );
    //     const month_score = year_score.filter(
    //       o => o.month === new Date().getMonth() + 1
    //     );
    //     const danger_drive_score = _.sum(
    //       _.values(month_score.map(o => Number(o.danger_drive_score)))
    //     );

    //     const irregularity_drive_score = _.sum(
    //       _.values(month_score.map(o => Number(o.irregularity_drive_score)))
    //     );
    //     const illegal_drive_score = _.sum(
    //       _.values(month_score.map(o => Number(o.illegal_drive_score)))
    //     );
    //     const accident_score = _.sum(
    //       _.values(month_score.map(o => Number(o.accident_score)))
    //     );
    //     const month = {
    //       danger_drive_score,
    //       irregularity_drive_score,
    //       illegal_drive_score,
    //       accident_score
    //     };
    //     return month;
    //   }
    //   return null;
    // }
  },
  methods: {
    ...mapActions("behaviorTitle", ["gettb_subject_qy_qyaqfz"])
  }
};
</script>

<style lang="scss" scoped>
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.behaviorTitle {
  // width: 1405px;
  width: 1290px;
  height: 100px;
  background: url("../../../assets/companysecure/safty_bg.png") no-repeat;
  margin-top: 15px;
  padding-top: 7px;
  box-sizing: border-box;
  margin-right: 20px;
  .behaviorTitleLeft {
    @include size(100%, 100%);
    div {
      float: left;
    }
    div:nth-child(1) {
      margin-left: 0px;
    }
    div:nth-child(2) {
      margin-left: 170px;
    }
  }
  .behaviorTitleRight {
    @include size(100%, 100%);
    div {
      float: left;
    }
    div:nth-child(1) {
      margin-left: 0px;
    }
    div:nth-child(2) {
      margin-left: 170px;
    }
  }
}
</style>