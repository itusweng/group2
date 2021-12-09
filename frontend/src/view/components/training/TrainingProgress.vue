<template>
  <!--begin::Mixed Widget 14-->
  <apexchart
    :options="chartOptions"
    :series="series"
    type="radialBar"
  ></apexchart>
  <!--end::Mixed Widget 14-->
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  name: 'widget-7',
  data() {
    return {
      chartOptions: {},
      series: [74]
    };
  },
  components: {
  },
  computed: {
    ...mapGetters(['layoutConfig'])
  },
  mounted() {
    // reference; kt_stats_widget_7_chart
    this.chartOptions = {
      chart: {
        height: 200,
        type: 'radialBar'
      },
      plotOptions: {
        radialBar: {
          hollow: {
            margin: 0,
            size: '65%'
          },
          dataLabels: {
            showOn: 'always',
            name: {
              show: false,
              fontWeight: '700'
            },
            value: {
              color: this.layoutConfig('colors.gray.gray-700'),
              fontSize: '30px',
              fontWeight: '700',
              offsetY: 12,
              show: true
            }
          },
          track: {
            background: this.layoutConfig('colors.theme.light.success'),
            strokeWidth: '100%'
          }
        }
      },
      colors: [this.layoutConfig('colors.theme.base.success')],
      stroke: {
        lineCap: 'round'
      },
      labels: ['Progress']
    };
  }
};
</script>
