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
              :src="
                'https://swetrainingplatform.s3.eu-central-1.amazonaws.com/trainingThumbnails/' +
                training.id +
                '.jpeg'
              "
              onerror="if (this.src != 'error.jpg') this.src = '/media/other/no-img.jpeg';"
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
            <Widget13 :percentage="trainingProgress" />
          </b-col>
        </b-row>
      </div>
    </div>

    <OnlineLessonList
      v-if="training.is_online"
      :lessons="lessons"
      :training="training"
    />
    <OfflineLessonList v-else :lessons="mappedLessons" :training="training" />
  </div>
</template>

<script>
import Widget13 from '@/view/components/training/TrainingProgress';
import OfflineLessonList from '@/view/components/training/OfflineLessonList';
import OnlineLessonList from '@/view/components/training/OnlineLessonList';
import moment from 'moment';

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
      lessons: [],
      mappedLessons: [],
      offlineLessonStatus: []
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

        if (!this.training.is_online) {
          this.getOfflineLessonStatus();
        }
      } catch (e) {
        console.log(e);
      }
    },
    async getOfflineLessonStatus() {
      try {
        const trainingId = this.$route.params.id;
        const userId = this.$store.getters.currentUser.id;

        const { data } = await this.axios.get(
          `/training/${trainingId}/getLessonProgress/byUserId/${userId}`
        );
        this.offlineLessonStatus = data.data;

        this.mappedLessons = this.lessons.map(lesson => {
          const progress = this.offlineLessonStatus.find(
            p => p.lessonId === lesson.id
          );
          if (progress) {
            return {
              ...progress,
              ...lesson
            };
          }
        });
      } catch (e) {
        console.log(e);
      }
    }
  },
  computed: {
    trainingProgress() {
      if (this.training.is_online) {
        let passed = 0;
        this.lessons.map(lesson => {
          if (
            moment(lesson.meeting_date + ' 18:00', 'DD-MM-YYYY HH:mm').isBefore(
              moment()
            )
          ) {
            passed++;
          }
        });
        return Math.floor((passed / this.lessons.length) * 100);
      } else {
        let passed = 0;
        this.offlineLessonStatus.map(lesson => {
          if (lesson.isCompleted) {
            passed++;
          }
        });
        return Math.floor((passed / this.lessons.length) * 100);
      }
    }
  }
};
</script>
