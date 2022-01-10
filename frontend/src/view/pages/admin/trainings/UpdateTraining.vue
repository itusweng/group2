<template>
  <div class="card card-custom">
    <div class="card-header py-3">
      <div class="card-title align-items-start flex-column">
        <h3 class="card-label font-weight-bolder text-dark">Update Training</h3>
        <span class="text-muted font-weight-bold font-size-sm mt-1">
          You can update trainings in this page.
        </span>
      </div>
      <div class="card-toolbar">
        <button
          type="reset"
          class="btn btn-success mr-2"
          @click="save"
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
            <h5 class="font-weight-bold mb-6">Training Info:</h5>
          </div>
        </div>
        <div class="form-group row">
          <label class="col-xl-3 col-lg-3 col-form-label">Title</label>
          <form-group name="title" lg="9" xl="6" no-label no-margin>
            <b-input
              slot-scope="{ attrs, listeners }"
              v-bind="attrs"
              v-on="listeners"
              class="form-control form-control-lg form-control-solid"
              v-model="form.title"
            />
          </form-group>
        </div>
        <div class="form-group row">
          <label class="col-xl-3 col-lg-3 col-form-label">Description</label>
          <form-group name="description" lg="9" xl="6" no-label no-margin>
            <b-form-textarea
              slot-scope="{ attrs, listeners }"
              v-bind="attrs"
              v-on="listeners"
              class="form-control form-control-lg form-control-solid"
              v-model="form.description"
            />
          </form-group>
        </div>
        <div class="form-group row">
          <label class="col-xl-3 col-lg-3 col-form-label">Image URL</label>
          <form-group name="thumbnail" lg="9" xl="6" no-label no-margin>
            <b-input
              slot-scope="{ attrs, listeners }"
              v-bind="attrs"
              v-on="listeners"
              class="form-control form-control-lg form-control-solid"
              v-model="form.thumbnail"
            />
          </form-group>
        </div>
        <div class="form-group row">
          <label class="col-xl-3 col-lg-3 col-form-label">Capacity</label>
          <form-group name="thumbnail" lg="9" xl="6" no-label no-margin>
            <b-input
              slot-scope="{ attrs, listeners }"
              v-bind="attrs"
              v-on="listeners"
              class="form-control form-control-lg form-control-solid"
              v-model="form.capacity"
            />
          </form-group>
        </div>
        <div class="form-group row">
          <label class="col-xl-3 col-lg-3 col-form-label">Is Online</label>
          <form-group name="is_online" lg="9" xl="6" no-label no-margin>
            <span slot-scope="{ attrs, listeners }" class="switch switch-sm">
              <label>
                <input
                  type="checkbox"
                  v-bind="attrs"
                  v-on="listeners"
                  v-model="form.is_online"
                />
                <span></span>
              </label>
            </span>
          </form-group>
        </div>
      </div>
    </form-wrapper>
  </div>
</template>

<script>
import { required } from 'vuelidate/lib/validators';
import Swal from 'sweetalert2';

export default {
  validations: {
    form: {
      title: { required },
      trainer: { required },
      description: {}
    }
  },
  data() {
    return {
      form: {
        title: '',
        description: '',
        capacity: '',
        is_online: false,
        instructor_id: 2,
        thumbnail: ''
      }
    };
  },
  created() {
    this.getTraining();
  },
  methods: {
    async getTraining() {
      try {
        const { data } = await this.axios.get(
          '/training/getTraining/byId/' + this.$route.params.id
        );

        this.form = data.data;
      } catch (e) {
        console.log(e);
      }
    },
    async save() {
      try {
        await this.axios.post('/training/update', {
          ...this.form,
          id: this.$route.params.id
        });

        await Swal.fire({
          icon: 'success',
          title: 'Training updated successfully!',
          reverseButtons: true,
          confirmButtonText: 'OK'
        });
      } catch (e) {
        await Swal.fire({
          icon: 'error',
          title: 'Training cannot updated!',
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
