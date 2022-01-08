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
            <template v-slot:cell(user)="{ item }">
              {{ item.requested_user.first_name }}
              {{ item.requested_user.last_name }}
            </template>
            <template v-slot:cell(actions)="{ item }">
              <b-button
                @click="approve(item)"
                class="btn btn-icon btn-light btn-hover-primary btn-sm"
                v-b-tooltip="'Approve'"
              >
                <span class="svg-icon svg-icon-md svg-icon-primary">
                  <inline-svg src="media/svg/icons/General/Check.svg" />
                </span>
              </b-button>
              <b-button
                @click="reject(item)"
                class="btn btn-icon btn-light btn-hover-primary btn-sm mx-3"
                v-b-tooltip="'Reject'"
              >
                <span class="svg-icon svg-icon-md svg-icon-primary">
                  <inline-svg src="media/svg/icons/Navigation/Close.svg" />
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
import Swal from "sweetalert2";

export default {
  data() {
    return {
      requests: [],
      tableFields: [
        {
          key: 'requested_training.title',
          label: 'Training Name'
        },
        {
          key: 'user',
          label: 'User'
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
        const { data } = await this.axios.post(
          '/training/participation/listAll',
          {
            managerGroupId: this.$store.getters.currentUser.manager_group_id,
            page: 0,
            size: 10
          }
        );
        this.requests = data.data;
      } catch (e) {
        console.log(e);
      }
    },
    async approve(request) {
      try {
        const result = await Swal.fire({
          text: 'The participation request will be approved!',
          title: 'Are you sure?',
          icon: 'warning',
          confirmButtonColor: 'red',
          confirmButtonText: 'Approve',
          cancelButtonText: this.$t('common.cancel'),
          showCancelButton: true,
          reverseButtons: true,
          heightAuto: false
        });
        if (!result.isConfirmed) return;

        await this.axios.post('/training/participation/approve', [
          {
            userId: request.requested_user.id,
            trainingId: request.requested_training.id
          }
        ]);

        await Swal.fire({
          icon: 'success',
          title: 'The participation request approved successfully!',
          reverseButtons: true,
          confirmButtonText: 'OK'
        });

        this.getRequests();
      } catch (e) {
        console.log(e);
      }
    },
    async reject(request) {
      try {
        const result = await Swal.fire({
          text: 'The participation request will be rejected!',
          title: 'Are you sure?',
          icon: 'warning',
          confirmButtonColor: 'red',
          confirmButtonText: 'Reject',
          cancelButtonText: this.$t('common.cancel'),
          showCancelButton: true,
          reverseButtons: true,
          heightAuto: false
        });
        if (!result.isConfirmed) return;

        await this.axios.post('/training/participation/reject', [
          {
            userId: request.requested_user.id,
            trainingId: request.requested_training.id
          }
        ]);

        await Swal.fire({
          icon: 'success',
          title: 'The participation request rejected successfully!',
          reverseButtons: true,
          confirmButtonText: 'OK'
        });

        this.getRequests();
      } catch (e) {
        console.log(e);
      }
    }
  }
};
</script>
