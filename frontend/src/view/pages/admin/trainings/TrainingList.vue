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
                :to="'/admin/trainings/' + item.id + '/details'"
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
      trainings: [
        {
          id: 'f6b706eb-5e12-4c01-8821-155452239a21',
          title: 'İş Sağlığı ve Güvenliği-UE/001-20',
          trainer: 'Dickerson',
          createdBy: 'Macdonald'
        },
        {
          id: 'b36bd5ad-7dad-48d6-98a8-39db9ea37abc',
          title: 'YAS 117 Bilgi Güvenliği HTML 2021-UE/001-21',
          trainer: 'Larsen',
          createdBy: 'Shaw'
        },
        {
          id: '3d5de70c-0b5b-420b-886e-ebfbf9be41eb',
          title: 'Etik Kurallar ve Çalışma İlkeleri 2020-UE/001-20',
          trainer: 'Geneva',
          createdBy: 'Wilson'
        }
      ],
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
  methods: {
    deleteTraining(training) {
      this.confirmDelete();
      console.log(training);
    }
  }
};
</script>
