<template>
  <div>
    <b-row>
      <b-col md="8">
        <div class="card card-custom gutter-b card-stretch">
          <div class="card-body pt-2">
            <video-component :options="videoOptions" @play="videoStarted" @ended="videoFinished" />
            <div class="mt-5">
              <h2>{{ lesson.title }}</h2>
              <p class="mt-5">
                {{ lesson.description }}
              </p>
            </div>
          </div>
        </div>
      </b-col>
      <b-col md="4">
        <div class="card card-custom gutter-b card-stretch">
          <div class="card-header border-0">
            <h3 class="card-title font-weight-bolder text-dark">Lesson List</h3>
          </div>
          <div class="card-body pt-2">
            <div v-for="(item, i) in lessons" :key="i.toString()" class="mb-3">
              <router-link
                :to="
                  '/trainings/' +
                  $route.params.trainingId +
                  '/lessons/' +
                  item.id
                "
                tag="a"
                class="text-dark text-hover-primary mb-1 font-size-lg"
              >
                {{ i + 1 }}. {{ item.title }}
              </router-link>
            </div>
          </div>
        </div>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import VideoComponent from '@/view/components/Video.component';
export default {
  components: {
    VideoComponent
  },
  data() {
    return {
      lesson: {
        videoUrl: ''
      },
      lessons: []
    };
  },
  created() {
    this.getLesson();
    this.getAllLessons();
  },
  methods: {
    async getLesson() {
      try {
        const { data } = await this.axios.get(
          'training/offlineLesson/getLesson/byId/' + this.$route.params.lessonId
        );

        this.lesson = {
          ...data.data,
          videoUrl: `https://swetrainingplatform.s3.eu-central-1.amazonaws.com/video/${this.trainingId}/${this.lessonId}.mp4`
        };
      } catch (e) {
        console.log(e);
      }
    },
    async getAllLessons() {
      try {
        const trainingId = this.$route.params.trainingId;

        const { data } = await this.axios.get(
          `/training/offlineLesson/getAllLessons/${trainingId}`
        );
        this.lessons = data.data;
      } catch (e) {
        console.log(e);
      }
    },
    async videoStarted() {
      try {
        await this.axios.post('training/updateLessonProgress', {
          userId: this.$store.getters.currentUser.id,
          lessonId: this.lessonId,
          isStarted: true
        });
      } catch (e) {
        console.log(e);
      }
    },
    async videoFinished() {
      try {
        await this.axios.post('training/updateLessonProgress', {
          userId: this.$store.getters.currentUser.id,
          lessonId: this.lessonId,
          isCompleted: true
        });
      } catch (e) {
        console.log(e);
      }
    }
  },
  computed: {
    trainingId() {
      return this.$route.params.trainingId;
    },
    lessonId() {
      return this.$route.params.lessonId;
    },
    videoOptions() {
      return {
        autoplay: false,
        controls: true,
        width: 800,
        sources: [
          {
            src: this.lesson.videoUrl,
            type: 'video/mp4'
          }
        ]
      };
    }
  },
  watch: {
    $route() {
      this.getLesson();
    }
  }
};
</script>
