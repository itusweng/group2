<template>
  <!--begin::Card-->
  <div class="card card-custom">
    <!--begin::Header-->
    <div class="card-header py-3">
      <div class="card-title align-items-start flex-column">
        <h3 class="card-label font-weight-bolder text-dark">
          Personal Information
        </h3>
        <span class="text-muted font-weight-bold font-size-sm mt-1">
          Update your personal information
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
      </div>
    </div>
    <!--end::Header-->
    <!--begin::Form-->
    <form class="form">
      <!--begin::Body-->
      <div class="card-body">
        <div class="row">
          <label class="col-xl-3"></label>
          <div class="col-lg-9 col-xl-6">
            <h5 class="font-weight-bold mb-6">Customer Info</h5>
          </div>
        </div>
        <div class="form-group row">
          <label class="col-xl-3 col-lg-3 col-form-label text-right">
            Avatar
          </label>
          <div class="col-lg-9 col-xl-6">
            <div class="image-input image-input-outline" id="kt_profile_avatar">
              <div
                class="image-input-wrapper"
                :style="{ backgroundImage: `url(${photo})` }"
              ></div>
              <label
                class="
                  btn
                  btn-xs
                  btn-icon
                  btn-circle
                  btn-white
                  btn-hover-text-primary
                  btn-shadow
                "
                data-action="change"
                data-toggle="tooltip"
                title=""
                data-original-title="Change avatar"
              >
                <i class="fa fa-pen icon-sm text-muted"></i>
                <input
                  type="file"
                  name="profile_avatar"
                  accept=".png, .jpg, .jpeg"
                  @change="onFileChange($event)"
                />
                <input type="hidden" name="profile_avatar_remove" />
              </label>
              <span
                class="
                  btn
                  btn-xs
                  btn-icon
                  btn-circle
                  btn-white
                  btn-hover-text-primary
                  btn-shadow
                "
                data-action="cancel"
                data-toggle="tooltip"
                title="Cancel avatar"
              >
                <i class="ki ki-bold-close icon-xs text-muted"></i>
              </span>
              <span
                class="
                  btn
                  btn-xs
                  btn-icon
                  btn-circle
                  btn-white
                  btn-hover-text-primary
                  btn-shadow
                "
                data-action="remove"
                data-toggle="tooltip"
                title="Remove avatar"
                @click="current_photo = null"
              >
                <i class="ki ki-bold-close icon-xs text-muted"></i>
              </span>
            </div>
            <span class="form-text text-muted">
              Allowed file types: png, jpg, jpeg.
            </span>
          </div>
        </div>
        <div class="form-group row">
          <label class="col-xl-3 col-lg-3 col-form-label text-right">
            First Name
          </label>
          <div class="col-lg-9 col-xl-6">
            <input
              ref="name"
              class="form-control form-control-lg form-control-solid"
              type="text"
              v-model="form.first_name"
            />
          </div>
        </div>
        <div class="form-group row">
          <label class="col-xl-3 col-lg-3 col-form-label text-right">
            Last Name
          </label>
          <div class="col-lg-9 col-xl-6">
            <input
              ref="surname"
              class="form-control form-control-lg form-control-solid"
              type="text"
              v-model="form.last_name"
            />
          </div>
        </div>
        <div class="form-group row">
          <label class="col-xl-3 col-lg-3 col-form-label text-right">
            Email Address
          </label>
          <div class="col-lg-9 col-xl-6">
            <div class="input-group input-group-lg input-group-solid">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="la la-at"></i>
                </span>
              </div>
              <input
                ref="email"
                type="text"
                class="form-control form-control-lg form-control-solid"
                placeholder="Email"
                v-model="form.email"
              />
            </div>
          </div>
        </div>
      </div>
      <!--end::Body-->
    </form>
    <!--end::Form-->
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import Swal from 'sweetalert2';

export default {
  name: 'PersonalInformation',
  data() {
    return {
      form: {
        id: '',
        first_name: '',
        last_name: '',
        email: ''
      },
      default_photo: 'media/users/blank.png',
      current_photo: null
    };
  },
  created() {
    this.getUser();
  },
  mounted() {
    this.current_photo = this.currentUserPersonalInfo.photo;
  },
  methods: {
    async getUser() {
      try {
        const { data } = await this.axios.get(
          '/user/byId/' + this.$store.getters.currentUser.id
        );

        this.form = {
          ...this.form,
          ...data.data
        };
      } catch (e) {
        console.log(e);
      }
    },
    async save() {
      try {
        await this.axios.post('/user/update', {
          ...this.form
        });

        await Swal.fire({
          icon: 'success',
          title: 'Profile updated successfully!',
          reverseButtons: true,
          confirmButtonText: 'OK'
        });

      } catch (e) {
        Swal.fire({
          icon: 'error',
          title: 'Profile cannot updated!',
          reverseButtons: true,
          confirmButtonText: 'OK'
        });
        console.log(e);
      }
    },
    onFileChange(e) {
      const file = e.target.files[0];

      if (typeof FileReader === 'function') {
        const reader = new FileReader();

        reader.onload = event => {
          this.current_photo = event.target.result;
        };

        reader.readAsDataURL(file);
      } else {
        alert('Sorry, FileReader API not supported');
      }
    }
  },
  computed: {
    ...mapGetters(['currentUserPersonalInfo']),
    photo() {
      return this.current_photo == null
        ? this.default_photo
        : this.current_photo;
    }
  }
};
</script>
