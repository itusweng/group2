<template>
  <div class="card card-custom">
    <div class="card-header py-3">
      <div class="card-title align-items-start flex-column">
        <h3 class="card-label font-weight-bolder text-dark">
          Update a New User
        </h3>
        <span class="text-muted font-weight-bold font-size-sm mt-1">
          You can update user in this page.
        </span>
      </div>
      <div class="card-toolbar">
        <button
          type="reset"
          class="btn btn-success mr-2"
          @click="save()"
          ref="kt_save_changes"
        >
          Save Changes
        </button>
        <button type="reset" class="btn btn-secondary" @click="cancel()">
          Cancel
        </button>
      </div>
    </div>
    <form-wrapper :validator="$v.form" class="form">
      <div class="card-body">
        <div class="row">
          <label class="col-xl-3"></label>
          <div class="col-lg-9 col-xl-6">
            <h5 class="font-weight-bold mb-6">User Info:</h5>
          </div>
        </div>
        <div class="form-group row">
          <label class="col-xl-3 col-lg-3 col-form-label">First Name</label>
          <form-group name="first_name" lg="9" xl="6" no-label no-margin>
            <b-input
              slot-scope="{ attrs, listeners }"
              v-bind="attrs"
              v-on="listeners"
              class="form-control form-control-lg form-control-solid"
              v-model="form.first_name"
            />
          </form-group>
        </div>
        <div class="form-group row">
          <label class="col-xl-3 col-lg-3 col-form-label">Last Name</label>
          <form-group name="last_name" lg="9" xl="6" no-label no-margin>
            <b-input
              slot-scope="{ attrs, listeners }"
              v-bind="attrs"
              v-on="listeners"
              class="form-control form-control-lg form-control-solid"
              v-model="form.last_name"
            />
          </form-group>
        </div>
        <div class="form-group row">
          <label class="col-xl-3 col-lg-3 col-form-label">Email Address</label>
          <form-group name="email" lg="9" xl="6" no-label no-margin>
            <b-form-input
              slot-scope="{ attrs, listeners }"
              v-bind="attrs"
              v-on="listeners"
              class="form-control form-control-lg form-control-solid"
              v-model="form.email"
            />
          </form-group>
        </div>
        <div class="form-group row">
          <label class="col-xl-3 col-lg-3 col-form-label">Profile Photo</label>
          <form-group name="profile_photo" lg="9" xl="6" no-label no-margin>
            <b-form-input
              slot-scope="{ attrs, listeners }"
              v-bind="attrs"
              v-on="listeners"
              class="form-control form-control-lg form-control-solid"
              v-model="form.profile_photo"
            />
          </form-group>
        </div>
        <div class="form-group row">
          <label class="col-xl-3 col-lg-3 col-form-label">Role</label>

          <b-col name="role_id" lg="9" xl="6">
            <b-form-select
              v-model="form.role_id"
              :options="roles"
              value-field="id"
              text-field="roleName"
            ></b-form-select>
          </b-col>
        </div>
      </div>
    </form-wrapper>
  </div>
</template>

<script>
import { required, email, minLength } from 'vuelidate/lib/validators';
import Swal from 'sweetalert2';

export default {
  validations: {
    form: {
      first_name: { required, minLength: minLength(3) },
      last_name: { required },
      username: {},
      password: {},
      email: { required, email },
      profile_photo: {},
      role_id: { required },
      description: {}
    }
  },
  data() {
    return {
      form: {
        first_name: '',
        last_name: '',
        email: '',
        profile_photo: '',
        role_id: ''
      },
      roles: []
    };
  },
  created() {
    this.getUser();
    this.getRoles();
  },
  methods: {
    async getUser() {
      try {
        const { data } = await this.axios.get(
          '/user/byId/' + this.$route.params.id
        );

        this.form = {
          ...this.form,
          ...data.data
        };
      } catch (e) {
        console.log(e);
      }
    },
    async getRoles() {
      try {
        const { data } = await this.axios.get(
          '/user/getAllUserRoles/byManagerGroupId/' +
            this.$store.getters.currentUser.manager_group_id
        );
        this.roles = data.data;
      } catch (e) {
        console.log(e);
      }
    },
    async save() {
      try {
        this.$v.$touch();

        if (this.$v.$anyError) return;

        await this.axios.post('/user/update', {
          ...this.form,
          manager_group_id: this.$store.getters.currentUser.manager_group_id
        });

        await Swal.fire({
          icon: 'success',
          title: 'User updated successfully!',
          reverseButtons: true,
          confirmButtonText: 'OK'
        });

        this.$router.back();
      } catch (e) {
        Swal.fire({
          icon: 'error',
          title: 'User cannot updated!',
          reverseButtons: true,
          confirmButtonText: 'OK'
        });
        console.log(e);
      }
    },
    cancel() {
      this.$router.back();
    }
  }
};
</script>
