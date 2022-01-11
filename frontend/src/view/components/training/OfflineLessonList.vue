<template>
  <div class="card card-custom gutter-b card-stretch">
    <!--begin::Header-->
    <div class="card-header border-0">
      <h3 class="card-title font-weight-bolder text-dark">Lesson List</h3>
      <div class="card-toolbar">
        <div class="dropdown dropdown-inline">
          <Dropdown2></Dropdown2>
        </div>
      </div>
    </div>
    <!--end::Header-->
    <!--begin::Body-->
    <div class="card-body pt-2">
      <table class="table table-borderless table-vertical-center">
        <thead>
          <tr>
            <th class="p-0" style="width: 50px"></th>
            <th class="p-0" style="min-width: 150px"></th>
            <th class="p-0" style="min-width: 140px"></th>
            <th class="p-0" style="min-width: 40px"></th>
          </tr>
        </thead>
        <tbody>
          <template v-for="(item, i) in lessons">
            <tr v-bind:key="i">
              <td class="pl-0 py-5 font-weight-bolder">
                {{ i + 1 }}
              </td>
              <td class="pl-0">
                <router-link
                  :to="'/lessons/' + item.id"
                  tag="a"
                  class="text-dark text-hover-primary mb-1 font-size-lg"
                >
                  {{ item.title }}
                </router-link>
              </td>
              <td class="text-right">
                <span class="text-muted font-weight-bold">
                  {{ item.completionStatus }}
                </span>
              </td>
              <td class="text-right pr-0">
                <b-button
                  v-if="
                    item.completionStatus === completionStatuses.NOT_STARTED
                  "
                  :to="'/lessons/' + item.id"
                  variant="light-success"
                  size="sm"
                >
                  Start
                </b-button>
                <b-button
                  v-if="item.completionStatus === completionStatuses.STARTED"
                  :to="'/lessons/' + item.id"
                  variant="light-warning"
                  size="sm"
                >
                  Continue
                </b-button>
                <b-button
                  v-if="item.completionStatus === completionStatuses.FINISHED"
                  :to="'/lessons/' + item.id"
                  variant="light-danger"
                  size="sm"
                >
                  Re-Watch
                </b-button>
              </td>
            </tr>
          </template>
        </tbody>
      </table>
    </div>
    <!--end::Body-->
  </div>
</template>

<script>
import Dropdown2 from '@/view/components/dropdown/Dropdown2.vue';
import { mapGetters } from 'vuex';

const completionStatuses = {
  NOT_STARTED: 'not_started',
  STARTED: 'started',
  FINISHED: 'finished'
};

export default {
  props: ['lessons'],
  data() {
    return {
      completionStatuses
    };
  },
  components: {
    Dropdown2
  },
  computed: {
    ...mapGetters(['layoutConfig', 'activeTraining'])
  },
  created() {
    //this.getLessons();
  },
  methods: {
    lastElement(i) {
      if (i === this.list.length - 1) {
        return false;
      } else {
        return true;
      }
    },
    async getLessons() {
      try {
        const trainingId = this.activeTraining.id;
        const { data } = await this.axios.get(
          `/training/offlineLesson/getAllLessons/${trainingId}`
        );
        this.list = data.data;
      } catch (e) {
        console.log(e);
      }
    }
  }
};
</script>
