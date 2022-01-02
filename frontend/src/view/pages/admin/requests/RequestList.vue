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
        You can create a new request or update and delete existing requests.
      </div>
    </b-alert>

    <card>
      <b-row class="mt-5">
        <b-col md="12">
          <b-table :fields="tableFields" :items="requests">
            <template v-slot:cell(actions)="{ item }">
              <b-button
                :to="'/admin/requests/' + item.id + '/details'"
                class="btn btn-icon btn-light btn-hover-primary btn-sm"
                v-b-tooltip="'Details'"
              >
                <span class="svg-icon svg-icon-md svg-icon-primary">
                  <inline-svg src="media/svg/icons/General/Settings-1.svg" />
                </span>
              </b-button>
              <b-button
                :to="'/admin/requests/' + item.id + '/update'"
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
                @click="deleteRequest(item)"
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
      requests: [],
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
    this.getRequests();
  },
  methods: {
    async getRequests() {
      try {
        const { data } = await this.axios.get(
          '/training/participation/listAll'
        );
        this.requests = data.data;
      } catch (e) {
        console.log(e);
      }
    },
    async deleteRequest(request) {
      try {
        const result = await this.confirmDelete();
        if (!result.isConfirmed) return;

        await this.axios.delete('/request/' + request.id);

        this.getRequests();
      } catch (e) {
        console.log(e);
      }
    }
  }
};
</script>
