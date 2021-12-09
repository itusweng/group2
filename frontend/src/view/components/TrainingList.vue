<template>
  <div>
    <b-row class="mb-4">
      <b-col xs="12">
        <h2>Required Trainings</h2>
      </b-col>
    </b-row>
    <b-row>
      <b-col md="4" v-for="(training, index) in trainingList" :key="index">
        <b-card
          :title="training.title"
          :img-src="'https://picsum.photos/600/300/?image=' + (index + 35)"
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
      trainingList: [
        {
          id: 'f6b706eb-5e12-4c01-8821-155452239a21',
          title: 'İş Sağlığı ve Güvenliği-UE/001-20',
          startDate: '9 NİS 2020 00:00',
          endDate: '31 ARA 2021 00:00',
          started: false
        },
        {
          id: 'b36bd5ad-7dad-48d6-98a8-39db9ea37abc',
          title: 'YAS 117 Bilgi Güvenliği HTML 2021-UE/001-21',
          startDate: '24 ŞUB 2021 00:00',
          endDate: '31 ARA 2021 00:00',
          started: true
        },
        {
          id: '3d5de70c-0b5b-420b-886e-ebfbf9be41eb',
          title: 'Etik Kurallar ve Çalışma İlkeleri 2020-UE/001-20',
          startDate: '29 EYL 2020 00:00',
          endDate: '31 ARA 2021 00:00',
          started: true
        }
      ]
    };
  }
};
</script>
