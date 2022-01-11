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
          <template v-for="(item, i) in newLessons">
            <tr v-bind:key="i">
              <td class="pl-0 py-5 font-weight-bolder">
                {{ i + 1 }}
              </td>
              <td class="pl-0">
                {{ item.title }}
              </td>
              <td class="text-right">
                <span class="text-muted font-weight-bold">
                  {{ item.date | formatDate(4) }}
                </span>
              </td>
              <td class="text-right pr-0">
                <b-button
                  v-if="moment(item.date).isAfter(moment())"
                  :href="item.zoom_link"
                  target="_blank"
                  variant="light-success"
                  size="sm"
                >
                  Go to link
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
import moment from 'moment';

export default {
  props: ['lessons', 'training'],
  data() {
    return {};
  },
  components: {
    Dropdown2
  },
  computed: {
    newLessons() {
      return this.lessons.map(lesson => ({
        ...lesson,
        date: moment(
          lesson.meeting_date + ' 18:00',
          'DD-MM-YYYY HH:mm'
        ).toDate()
      }));
    },
    ...mapGetters(['layoutConfig'])
  },
  created() {},
  methods: {
    moment,
    lastElement(i) {
      if (i === this.list.length - 1) {
        return false;
      } else {
        return true;
      }
    }
  }
};
</script>
