<template>
  <div>
    <b-row>
      <b-col md="12">
        <b-input-group class="mb-2">
          <b-input-group-prepend is-text>
            <span class="svg-icon svg-icon-primary">
              <inline-svg src="media/svg/icons/General/Search.svg" />
            </span>
          </b-input-group-prepend>
          <b-input placeholder="Search" v-model="search" />
        </b-input-group>
      </b-col>
    </b-row>
    <b-row>
      <b-col md="4" v-for="(training, index) in filteredList" :key="index">
        <b-card class="mb-2 mt-2" no-body>
          <b-card-img
            :src="
              'https://swetrainingplatform.s3.eu-central-1.amazonaws.com/trainingThumbnails/' +
              training.id +
              '.jpeg'
            "
            onerror="if (this.src != 'error.jpg') this.src = '/media/other/no-img.jpeg';"
            top
          />
          <b-card-body>
            <b-card-title>{{ training.title }}</b-card-title>
            <b-card-text>{{ training.description }}</b-card-text>
            <b-button @click="register(training)" variant="primary">
              Register
            </b-button>
          </b-card-body>
        </b-card>
      </b-col>

      <b-col md="12" class="text-center" v-if="filteredList.length === 0">
        There are no trainings.
      </b-col>
    </b-row>
  </div>
</template>

<script>
import Swal from 'sweetalert2';

export default {
  data() {
    return {
      search: '',
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
  },
  computed: {
    filteredList() {
      if (!this.search) return this.trainingList;
      return this.trainingList.filter(
        training =>
          training.title.toLowerCase().indexOf(this.search.toLowerCase()) !== -1
      );
    }
  }
};
</script>
