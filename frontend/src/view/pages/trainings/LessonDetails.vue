<template>
  <div>
    <b-row>
      <b-col md="8">
        <div class="card card-custom gutter-b card-stretch">
          <div class="card-body pt-2">
            <video-component :options="videoOptions" />
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
            <div v-for="(item, i) in list" :key="i.toString()" class="mb-3">
              <router-link
                :to="'/lessons/' + item.id"
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
      list: [
        {
          id: '084970b3-6be2-4e73-aef7-ba34d483e70f',
          title: 'Yapikredi Mobil Uygulaması iOS/Android Aktarım-Giriş',
          duration: '20 min'
        },
        {
          id: '084970b3-6be2-4e73-aef7-ba34d483370f',
          title: 'iOS Architecture, Custom Components',
          duration: '18 min'
        },
        {
          id: '083450b3-6be2-4e73-aef7-ba34d483e70f',
          title: 'iOS Architecture, Custom Components',
          duration: '18 min'
        },
        {
          id: '084970b3-6be2-4e73-aef7-ba34d483e70f',
          title: 'iOS Architecture, Custom Components',
          duration: '18 min'
        },
        {
          id: '084970b3-6be2-4e73-aef7-ba34d483e70f',
          title: 'iOS Architecture, Custom Components',
          duration: '18 min'
        },
        {
          id: '084970b3-6be2-4e73-aef7-ba34d483e70f',
          title: 'iOS Architecture, Custom Components',
          duration: '18 min'
        },
        {
          id: '084970b3-6be2-4e73-aef7-ba34d483e70f',
          title: 'iOS Architecture, Custom Components',
          duration: '18 min'
        },
        {
          id: '084970b3-6be2-4e73-aef7-ba34d483e70f',
          title: 'iOS Architecture, Custom Components',
          duration: '18 min'
        },
        {
          id: '084970b3-6be2-4e73-aef7-ba34d483e70f',
          title: 'iOS Architecture, Custom Components',
          duration: '18 min'
        },
        {
          id: '084970b3-6be2-4e73-aef7-ba34d483e70f',
          title: 'iOS Architecture, Custom Components',
          duration: '18 min'
        }
      ],
      lesson: {
        title: 'Yapikredi Mobil Uygulaması iOS/Android Aktarım-Giriş',
        videoUrl:
          'https://my-gym-assistant.s3.eu-central-1.amazonaws.com/exercises/videos/arnoldPressDumbbell.mp4',
        description:
        // eslint-disable-next-line max-len
          'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad debitis dignissimos incidunt obcaecati voluptates. Architecto consectetur dolor dolores fugiat in minima nihil numquam, tenetur? Cum quae, qui. Ad alias asperiores, aut consequuntur, cupiditate est exercitationem, maxime possimus provident ratione recusandae repellendus totam veniam. Alias, animi atque consequatur cupiditate dignissimos ducimus esse exercitationem fuga id modi necessitatibus, odio quae quos recusandae rem ullam velit vero. Dolores explicabo fugit illo reiciendis? Alias animi, dolor dolore doloremque expedita explicabo laboriosam nisi odio quo quod, repellat repellendus sed sint sit tenetur ut vel? Beatae doloremque ducimus eos esse eveniet libero minus quos repellat, saepe.'
      }
    };
  },
  computed: {
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
  }
};
</script>
