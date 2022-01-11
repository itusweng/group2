<template>
  <div>
    <!--begin::Dashboard-->
    <div class="card card-custom gutter-b card-stretch">
      <div class="card-header border-0">
        <h3 class="card-title font-weight-bolder text-dark">Training Info</h3>
      </div>
      <div class="card-body pt-2">
        <b-row>
          <b-col md="3">
            <img
              src="https://picsum.photos/600/300/?image=56"
              class="w-100"
              alt=""
            />
          </b-col>
          <b-col md="3">
            <h4>{{ training.title }}</h4>

            <br />
            {{ training.description }}
          </b-col>
          <b-col md="3">
            <h4>Instructor:</h4>
            <span>
              {{ training.instructor.first_name }}
              {{ training.instructor.last_name }}
            </span>
          </b-col>
          <b-col md="3">
            <h4>Progress</h4>
            <Widget13></Widget13>
          </b-col>
        </b-row>
      </div>
    </div>

    <OnlineLessonList v-if="training.is_online" :lessons="lessons" />
    <OfflineLessonList v-else :lessons="lessons" />
  </div>
</template>

<script>
import Widget13 from '@/view/components/training/TrainingProgress';
import OfflineLessonList from '@/view/components/training/OfflineLessonList';
import OnlineLessonList from '@/view/components/training/OnlineLessonList';

export default {
  name: 'dashboard',
  components: {
    Widget13,
    OfflineLessonList,
    OnlineLessonList
  },
  data() {
    return {
      training: {
        instructor: {},
        user_created: {}
      },
      lessons: []
    };
  },
  created() {
    this.getTraining();
  },
  methods: {
    async getTraining() {
      try {
        const { data } = await this.axios.get(
          '/training/getTraining/byId/' + this.$route.params.id
        );

        this.training = data.data;

        this.getLessons();
      } catch (e) {
        console.log(e);
      }
    },
    async getLessons() {
      try {
        const trainingId = this.$route.params.id;

        let url;
        if (this.training.is_online) {
          url = `/training/onlineLesson/getAllLessons/${trainingId}`;
        } else {
          url = `/training/offlineLesson/getAllLessons/${trainingId}`;
        }
        const { data } = await this.axios.get(url);
        this.lessons = data.data;
      } catch (e) {
        console.log(e);
      }
    }
  }
};
</script>
