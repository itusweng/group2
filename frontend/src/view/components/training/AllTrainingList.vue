<template>
  <div>
    <b-row>
      <b-col md="4" v-for="(training, index) in trainingList" :key="index">
        <b-card
          :title="training.title"
          :img-src="'https://picsum.photos/600/300/?image=' + (index + 75)"
          img-alt="Image"
          img-top
          tag="article"
          class="mb-2 mt-2"
        >
          <p>{{ training.description }}</p>
          <b-button @click="register(training)" variant="primary">
            Register
          </b-button>
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import Swal from 'sweetalert2';

export default {
  data() {
    return {
      trainingList: []
    };
  },
  async created() {
    try {
      const { data } = await this.axios.get('/training/getAllTrainings');
      this.trainingList = data.data;
    } catch (e) {
      console.log(e);
    }
  },
  methods: {
    async register(training) {
      try {
        const result = await Swal.fire({
          text: 'The participation request will be sent to the administrator!',
          title: 'Are you sure?',
          icon: 'info',
          confirmButtonColor: 'red',
          confirmButtonText: 'Register',
          cancelButtonText: this.$t('common.cancel'),
          showCancelButton: true,
          reverseButtons: true,
          heightAuto: false
        });

        if (!result.isConfirmed) return;

        await this.axios.post('/training/participation/request', {
          trainingId: training.id,
          userId: this.$store.getters.currentUser.id
        });

        await Swal.fire({
          icon: 'success',
          title: 'The participation request sent successfully!',
          reverseButtons: true,
          confirmButtonText: 'OK'
        });
      } catch (e) {
        console.log(e);
      }
    }
  }
};
</script>
