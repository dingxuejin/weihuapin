<template>
        <div>
            <variationTrend name='违法行为数量变化趋势'>
                <!-- 图表 -->
            </variationTrend>
        </div>
    </template>
    <script>
        import variationTrend from '../../../components/companysecure/variationTrend'

        export default{
          components: {
            variationTrend,
          },
        }
    </script>
    <style lang="scss" scoped>
        div{
            height: 100%;
            width: 100%;
        }
    </style>