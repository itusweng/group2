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
      <b-col md="12" v-if="trainingList.length === 0" class="text-center">
        You have no training.
      </b-col>
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
            <b-button v-if="training.started" href="#" variant="primary">
              Continue
            </b-button>
            <b-button v-else @click="goToDetails(training)" variant="success">
              Start
            </b-button>
          </b-card-body>
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      search: '',
      trainingList: []
    };
  },
  async created() {
    try {
      const userId = this.$store.getters.currentUser.id;
      const { data } = await this.axios.get(
        `/training/byParticipantId/${userId}/getAll`
      );
      this.trainingList = data.data;
    } catch (e) {
      console.log(e);
    }
  },
  methods: {
    goToDetails(item) {
      this.$router.push('/trainings/' + item.id);
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
