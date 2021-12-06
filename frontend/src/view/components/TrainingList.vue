<template>
  <div>
    <b-row class="mb-4">
      <b-col xs="12">
        <h2>Kurs Listesi</h2>

      </b-col>
    </b-row>
    <b-row>
      <b-col md="4" v-for="(training, index) in trainingList" :key="index">
        <b-card
          :title="training.name"
          img-src="https://picsum.photos/600/300/?image=25"
          img-alt="Image"
          img-top
          tag="article"
          class="mb-2 mt-2"
        >
          <b-card-text> Başlangıç: {{ training.startDate }} </b-card-text>
          <b-card-text> Bitiş: {{ training.endDate }} </b-card-text>

          <b-button v-if="training.started" href="#" variant="primary"
            >Devam Et</b-button
          >
          <b-button v-else href="#" variant="success">Başla</b-button>
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
          name: 'İş Sağlığı ve Güvenliği-UE/001-20',
          startDate: '9 NİS 2020 00:00',
          endDate: '31 ARA 2021 00:00',
          started: false
        },
        {
          name: 'YAS 117 Bilgi Güvenliği HTML 2021-UE/001-21',
          startDate: '24 ŞUB 2021 00:00',
          endDate: '31 ARA 2021 00:00',
          started: true
        },
        {
          name: 'Etik Kurallar ve Çalışma İlkeleri 2020-UE/001-20',
          startDate: '29 EYL 2020 00:00',
          endDate: '31 ARA 2021 00:00',
          started: true
        }
      ]
    };
  }
};
</script>
