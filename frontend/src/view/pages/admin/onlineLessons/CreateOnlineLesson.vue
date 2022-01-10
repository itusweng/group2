<template>
  <div class="card card-custom">
    <div class="card-header py-3">
      <div class="card-title align-items-start flex-column">
        <h3 class="card-label font-weight-bolder text-dark">
          Create a New Online Lesson
        </h3>
        <span class="text-muted font-weight-bold font-size-sm mt-1">
          You can create online lesson in this page.
        </span>
      </div>
      <div class="card-toolbar">
        <button
          type="reset"
          class="btn btn-success mr-2"
          @click="save()"
          ref="kt_save_changes"
        >
          Create
        </button>
        <button type="reset" class="btn btn-secondary" @click="$router.back()">
          Cancel
        </button>
      </div>
    </div>
    <form-wrapper :validator="$v.form" class="form">
      <div class="card-body">
        <div class="row">
          <label class="col-xl-3"></label>
          <div class="col-lg-9 col-xl-6">
            <h5 class="font-weight-bold mb-6">Online Lesson Info:</h5>
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
          <label class="col-xl-3 col-lg-3 col-form-label">Meeting Date</label>
          <form-group name="meetingDate" lg="9" xl="6" no-label no-margin>
            <b-datepicker
              slot-scope="{ attrs, listeners }"
              v-bind="attrs"
              v-on="listeners"
              class="form-control form-control-lg form-control-solid"
              v-model="form.meeting_date"
            />
          </form-group>
        </div>
        <div class="form-group row">
          <label class="col-xl-3 col-lg-3 col-form-label">Zoom Link</label>
          <form-group name="zoomLink" lg="9" xl="6" no-label no-margin>
            <b-input
              slot-scope="{ attrs, listeners }"
              v-bind="attrs"
              v-on="listeners"
              class="form-control form-control-lg form-control-solid"
              v-model="form.zoom_link"
            />
          </form-group>
        </div>
      </div>
    </form-wrapper>
  </div>
</template>

<script>
import { required } from 'vuelidate/lib/validators';
import Swal from 'sweetalert2';
import moment from 'moment';

export default {
  validations: {
    form: {
      title: { required },
      description: {},
      meeting_date: {},
      zoom_link: { required }
    }
  },
  data() {
    return {
      form: {
        title: '',
        description: '',
        meeting_date: new Date(),
        zoom_link: ''
      }
    };
  },
  methods: {
    async save() {
      try {
        await this.axios.post('/training/onlineLesson/', {
          ...this.form,
          meeting_date: moment(this.form.meeting_date).format('DD-MM-YYYY'),
          training_id: this.$route.params.id
        });

        await Swal.fire({
          icon: 'success',
          title: 'Online lesson created successfully!',
          reverseButtons: true,
          confirmButtonText: 'OK'
        });

        this.$router.back();
      } catch (e) {
        await Swal.fire({
          icon: 'error',
          title: 'Online lesson cannot created!',
          reverseButtons: true,
          confirmButtonText: 'OK'
        });
        console.log(e);
      }
    },
    cancel() {
      this.$router.push('/admin/trainings/list');
    }
  }
};
</script>
