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
          <b-table :fields="tableFields" :items="users">
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
      users: [
        {
          id: 'f6b706eb-5e12-4c01-8821-155452239a21',
          firstName: 'Umut',
          lastName: 'Oğuz',
          email: 'umutoguz@sirket.com'
        },
        {
          id: 'b36bd5ad-7dad-48d6-98a8-39db9ea37abc',
          firstName: 'Sena',
          lastName: 'Yıldırım',
          email: 'senayildirim@sirket.com'
        },
        {
          id: '3d5de70c-0b5b-420b-886e-ebfbf9be41eb',
          firstName: 'Ertuğrul',
          lastName: 'Yılmaz',
          emailAddress: 'ertugrulyilmaz@sirket.com'
        }
      ],
      tableFields: [
        {
          key: 'firstName',
          sortable: true
        },{
          key: 'lastName',
          sortable: true
        },
        {
          key: 'emailAddress',
          sortable: true
        },
        {
          key: 'actions'
        }
      ]
    };
  },
  methods: {
    deleteUser(user) {
      this.confirmDelete();
      console.log(user);
    }
  }
};
</script>
