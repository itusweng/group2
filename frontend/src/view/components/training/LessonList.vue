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
            <th class="p-0" style="min-width: 120px"></th>
            <th class="p-0" style="min-width: 40px"></th>
          </tr>
        </thead>
        <tbody>
          <template v-for="(item, i) in list">
            <tr v-bind:key="i">
              <td class="pl-0 py-5">
                {{ i + 1 }}
              </td>
              <td class="pl-0">
                <router-link :to="'/lessons/'+item.id"  tag="a" class="text-dark
                    font-weight-bolder
                    text-hover-primary
                    mb-1
                    font-size-lg">
                  {{ item.title }}
                </router-link>

              </td>
              <td class="text-right">
                <span class="text-muted font-weight-bold">{{
                  item.duration
                }}</span>
              </td>
              <td class="text-right">
                <span class="text-muted font-weight-bold">
                  {{ item.completionStatus }}</span
                >
              </td>
              <td class="text-right pr-0">
                <button
                  type="button"
                  class="btn btn-light-success font-weight-bold btn-sm"
                >
                  Start
                </button>
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
  name: 'widget-2',
  data() {
    return {
      completionStatuses,
      list: [
        {
          id: '084970b3-6be2-4e73-aef7-ba34d483e70f',
          title: 'Yapikredi Mobil Uygulaması iOS/Android Aktarım-Giriş',
          duration: '20 min',
          completionStatus: completionStatuses.NOT_STARTED
        },
        {
          id: '084970b3-6be2-4e73-aef7-ba34d483370f',
          title: 'iOS Architecture, Custom Components',
          duration: '18 min',
          completionStatus: completionStatuses.STARTED
        },
        {
          id: '083450b3-6be2-4e73-aef7-ba34d483e70f',
          title: 'iOS Architecture, Custom Components',
          duration: '18 min',
          completionStatus: completionStatuses.STARTED
        },
        {
          id: '084970b3-6be2-4e73-aef7-ba34d483e70f',
          title: 'iOS Architecture, Custom Components',
          duration: '18 min',
          completionStatus: completionStatuses.STARTED
        },
        {
          id: '084970b3-6be2-4e73-aef7-ba34d483e70f',
          title: 'iOS Architecture, Custom Components',
          duration: '18 min',
          completionStatus: completionStatuses.STARTED
        },
        {
          id: '084970b3-6be2-4e73-aef7-ba34d483e70f',
          title: 'iOS Architecture, Custom Components',
          duration: '18 min',
          completionStatus: completionStatuses.STARTED
        },
        {
          id: '084970b3-6be2-4e73-aef7-ba34d483e70f',
          title: 'iOS Architecture, Custom Components',
          duration: '18 min',
          completionStatus: completionStatuses.STARTED
        },
        {
          id: '084970b3-6be2-4e73-aef7-ba34d483e70f',
          title: 'iOS Architecture, Custom Components',
          duration: '18 min',
          completionStatus: completionStatuses.STARTED
        },
        {
          id: '084970b3-6be2-4e73-aef7-ba34d483e70f',
          title: 'iOS Architecture, Custom Components',
          duration: '18 min',
          completionStatus: completionStatuses.STARTED
        },
        {
          id: '084970b3-6be2-4e73-aef7-ba34d483e70f',
          title: 'iOS Architecture, Custom Components',
          duration: '18 min',
          completionStatus: completionStatuses.STARTED
        }

      ]
    };
  },
  components: {
    Dropdown2
  },
  methods: {
    lastElement(i) {
      if (i === this.list.length - 1) {
        return false;
      } else {
        return true;
      }
    }
  },
  computed: {
    ...mapGetters(['layoutConfig'])
  }
};
</script>
