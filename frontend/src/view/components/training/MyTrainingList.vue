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
          <b-card-text>Start Date: {{ training.startDate }}</b-card-text>
          <b-card-text>End Date: {{ training.endDate }}</b-card-text>

          <b-button v-if="training.started" href="#" variant="primary">
            Continue
          </b-button>
          <b-button v-else :to="'/trainings/' + training.id" variant="success">
            Start
          </b-button>
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>

<script>
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
  }
};
</script>
