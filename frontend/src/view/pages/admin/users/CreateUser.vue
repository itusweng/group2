<template>
  <div class="card card-custom">
    <div class="card-header py-3">
      <div class="card-title align-items-start flex-column">
        <h3 class="card-label font-weight-bolder text-dark">
          Create a New User
        </h3>
        <span class="text-muted font-weight-bold font-size-sm mt-1">
          You can create user in this page.
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
          <form-group name="title" lg="9" xl="6" no-label no-margin>
            <b-input
              slot-scope="{ attrs, listeners }"
              v-bind="attrs"
              v-on="listeners"
              class="form-control form-control-lg form-control-solid"
              v-model="form.firstName"
            />
          </form-group>
        </div>
        <div class="form-group row">
          <label class="col-xl-3 col-lg-3 col-form-label">Last Name</label>
          <form-group name="trainer" lg="9" xl="6" no-label no-margin>
            <b-input
              slot-scope="{ attrs, listeners }"
              v-bind="attrs"
              v-on="listeners"
              class="form-control form-control-lg form-control-solid"
              v-model="form.lastName"
            />
          </form-group>
        </div>
        <div class="form-group row">
          <label class="col-xl-3 col-lg-3 col-form-label">Email Address</label>
          <form-group name="description" lg="9" xl="6" no-label no-margin>
            <b-form-textarea
              slot-scope="{ attrs, listeners }"
              v-bind="attrs"
              v-on="listeners"
              class="form-control form-control-lg form-control-solid"
              v-model="form.email"
            />

          </form-group>
        </div>
        <div class="form-group row">
          <label class="col-xl-3 col-lg-3 col-form-label">Role</label>
          <div>
            <b-form-select v-model="role_id" :options="options"></b-form-select>
          </div>
        </div>
      </div>
    </form-wrapper>
  </div>
</template>

<script>
import { required } from 'vuelidate/lib/validators';
import Swal from "sweetalert2";

export default {
  validations: {
    form: {
      firstName: { required },
      lastName: { required },
      email: { required },
      role_id: { required },
      description: {}
    }
  },
  data() {
    return {
      form: {
        firstName: '',
        lastName: '',
        email: '',
        Role: ''
      },
      role_id: null,
      options: [
        { value: null, text: 'Please select a role' },
        { value: '1', text: 'HR' },
        { value: '2', text: 'R&D' },
        { value: '3', text: 'Manager' },
      ]
    };
  },
  methods: {
    save() {
      try {
        Swal.fire({
          icon: 'success',
          title: 'User created successfully!',
          reverseButtons: true,
          confirmButtonText: 'OK'
        }).then(() => {
          this.$router.push('/admin/users/f6b706eb-5e12-4c01-8821-155452239a21/details'); //User Id'si alıp users yerine yazmak lazım

        })
      } catch (e) {
        console.log(e);
      }
    },
    cancel() {
      this.$router.push('/admin/users/list');
    }
  }
};
</script>
