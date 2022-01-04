<template>
  <div>
    <b-alert
      show
      variant="light"
      class="alert alert-custom alert-white alert-shadow fade show gutter-b"
    >
      <div class="alert-icon">
        <span class="svg-icon svg-icon-lg">
          <inline-svg src="media/svg/icons/Tools/Compass.svg" />
        </span>
      </div>
      <div class="alert-text">
        You can create a new training or update and delete existing trainings.
      </div>
    </b-alert>

    <card>
      <b-row>
        <b-col md="12" class="d-flex justify-content-end">
          <b-button variant="light-success" to="/admin/trainings/create">
            Create New Training
          </b-button>
        </b-col>
      </b-row>
      <b-row class="mt-5">
        <b-col md="12">
          <b-table :fields="tableFields" :items="trainings">
            <template v-slot:cell(actions)="{ item }">
              <b-button
                @click="goToDetails(item)"
                class="btn btn-icon btn-light btn-hover-primary btn-sm"
                v-b-tooltip="'Details'"
              >
                <span class="svg-icon svg-icon-md svg-icon-primary">
                  <inline-svg src="media/svg/icons/General/Settings-1.svg" />
                </span>
              </b-button>
              <b-button
                :to="'/admin/trainings/' + item.id + '/update'"
                class="btn btn-icon btn-light btn-hover-primary btn-sm mx-3"
                v-b-tooltip="'Edit'"
              >
                <span class="svg-icon svg-icon-md svg-icon-primary">
                  <inline-svg src="media/svg/icons/Communication/Write.svg" />
                </span>
              </b-button>
              <b-button
                class="btn btn-icon btn-light btn-hover-primary btn-sm"
                v-b-tooltip="'Delete'"
                @click="deleteTraining(item)"
              >
                <span class="svg-icon svg-icon-md svg-icon-primary">
                  <inline-svg src="media/svg/icons/General/Trash.svg" />
                </span>
              </b-button>
            </template>
          </b-table>
        </b-col>
      </b-row>
    </card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      trainings: [],
      tableFields: [
        {
          key: 'title',
          sortable: true
        },
        {
          key: 'trainer'
        },
        {
          key: 'createdBy'
        },
        {
          key: 'actions'
        }
      ]
    };
  },
  async created() {
    this.getTrainings();
  },
  methods: {
    goToDetails(item) {
      this.$store.commit('setTraining', item)
      this.$router.push('/admin/trainings/' + item.id + '/details');
    },
    async getTrainings() {
      try {
        const { data } = await this.axios.get('/training/getAllTrainings');
        this.trainings = data.data;
      } catch (e) {
        console.log(e);
      }
    },
    async deleteTraining(training) {
      try {
        const result = await this.confirmDelete();
        if (!result.isConfirmed) return;

        await this.axios.delete('/training/' + training.id);

        this.getTrainings();
      } catch (e) {
        console.log(e);
      }
    }
  }
};
</script>
