<template>
  <div>
    <b-alert
      show
      variant="light"
      class="alert alert-custom alert-white alert-shadow fade show gutter-b"
    >
      <div class="alert-icon">
        <span class="svg-icon svg-icon-lg">
          <inline-svg src="/media/svg/icons/Tools/Compass.svg" />
        </span>
      </div>
      <div class="alert-text">
        You can create a new user or update and delete existing users.
      </div>
    </b-alert>

    <card>
      <b-row>
        <b-col md="12" class="d-flex justify-content-end">
          <b-button variant="light-success" to="/admin/users/create">
            Create New User
          </b-button>
        </b-col>
      </b-row>
      <b-row class="mt-5">
        <b-col md="12">
          <b-table :fields="tableFields" :items="users" :busy="loading">
            <template v-slot:cell(actions)="{ item }">
              <b-button
                :to="'/admin/users/' + item.id + '/details'"
                class="btn btn-icon btn-light btn-hover-primary btn-sm"
                v-b-tooltip="'Details'"
              >
                <span class="svg-icon svg-icon-md svg-icon-primary">
                  <inline-svg src="/media/svg/icons/General/Settings-1.svg" />
                </span>
              </b-button>
              <b-button
                :to="'/admin/users/' + item.id + '/update'"
                class="btn btn-icon btn-light btn-hover-primary btn-sm mx-3"
                v-b-tooltip="'Edit'"
              >
                <span class="svg-icon svg-icon-md svg-icon-primary">
                  <inline-svg src="/media/svg/icons/Communication/Write.svg" />
                </span>
              </b-button>
              <b-button
                class="btn btn-icon btn-light btn-hover-primary btn-sm"
                v-b-tooltip="'Delete'"
                @click="deleteUser(item)"
              >
                <span class="svg-icon svg-icon-md svg-icon-primary">
                  <inline-svg src="/media/svg/icons/General/Trash.svg" />
                </span>
              </b-button>
            </template>
            <template v-slot:table-busy>
              <div class="text-center">
                <b-spinner variant="primary" />
              </div>
            </template>
          </b-table>
          <pagination
            :total-rows="total"
            :per-page.sync="pagination.size"
            :current-page.sync="pagination.page"
          />
        </b-col>
      </b-row>
    </card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      users: [],
      tableFields: [
        {
          key: 'first_name'
        },
        {
          key: 'last_name'
        },
        {
          key: 'email'
        },
        {
          key: 'role_name'
        },
        {
          key: 'actions'
        }
      ],
      loading: false,
      total: 0,
      pagination: {
        page: 1,
        size: 20
      }
    };
  },

  created() {
    this.getUsers();
  },
  methods: {
    async getUsers() {
      try {
        this.loading = true;
        const { data } = await this.axios.get('/user/getAllUsers', {
          params: {
            page: this.pagination.page - 1,
            size: this.pagination.size
          }
        });
        this.users = data.data.users;
        this.total = data.data.total;
      } catch (e) {
        console.log(e);
      } finally {
        this.loading = false;
      }
    },
    deleteUser(user) {
      this.confirmDelete();
      console.log(user);
    }
  },
  watch: {
    pagination: {
      handler: 'getUsers',
      deep: true
    }
  }
};
</script>
