<template>
  <div class="card card-custom">
    <div class="card-header py-3">
      <div class="card-title align-items-start flex-column">
        <h3 class="card-label font-weight-bolder text-dark">
          Update Offline Lesson
        </h3>
        <span class="text-muted font-weight-bold font-size-sm mt-1">
          You can update offline lesson in this page.
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
            <h5 class="font-weight-bold mb-6">Offline Lesson Info:</h5>
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
          <label class="col-xl-3 col-lg-3 col-form-label">Video File</label>
          <form-group name="videoFile" lg="9" xl="6" no-label no-margin>
            <b-form-file
              slot-scope="{ attrs, listeners }"
              v-bind="attrs"
              v-on="listeners"
              class="form-control form-control-lg form-control-solid"
              v-model="form.videoFile"
            />
          </form-group>
        </div>
        <div class="row">
          <label class="col-xl-3"></label>
          <div class="col-lg-9 col-xl-6 mb-6 mt-6">
            <h5 class="font-weight-bold">Lesson Files:</h5>
            <span>
              You can add additional class files such as source code or lecture
              note.
            </span>
            <div class="mt-6 mb-6">
              <b-button @click="addFile">Add File</b-button>
            </div>
          </div>
        </div>

        <div
          class="form-group row"
          v-for="(file, i) in form.lessonFiles"
          :key="i"
        >
          <label class="col-xl-3 col-lg-3 col-form-label"></label>
          <form-group name="videoFile" lg="7" xl="5" no-label no-margin>
            <b-form-file
              slot-scope="{ attrs, listeners }"
              v-bind="attrs"
              v-on="listeners"
              class="form-control form-control-lg form-control-solid"
              v-model="form.videoFile"
            />
          </form-group>
          <div class="col-xl-1 col-lg-2">
            <b-button
              @click="deleteFile(i)"
              variant="danger"
              class="font-weight-bold"
            >
              X
            </b-button>
          </div>
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
      description: {},
      videoFile: {},
      lessonFiles: { required }
    }
  },
  data() {
    return {
      form: {
        title: '',
        description: '',
        videoFile: '',
        lessonFiles: []
      }
    };
  },
  methods: {
    save() {
      try {
        Swal.fire({
          icon: 'success',
          title: 'Offline lesson updated successfully!',
          reverseButtons: true,
          confirmButtonText: 'OK'
        });
      } catch (e) {
        console.log(e);
      }
    },
    addFile() {
      this.form.lessonFiles.push('file');
    },
    deleteFile(i) {
      this.form.lessonFiles = this.form.lessonFiles.filter(
        (file, index) => index !== i
      );
    }
  }
};
</script>
