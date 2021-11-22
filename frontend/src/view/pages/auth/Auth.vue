<template>
  <div class="d-flex flex-column flex-root">
    <div
      class="
        login login-1
        d-flex
        flex-column flex-lg-row flex-column-fluid
        bg-white
      "
      :class="{
        'login-signin-on': this.state == 'signin',
        'login-signup-on': this.state == 'signup',
        'login-forgot-on': this.state == 'forgot'
      }"
      id="kt_login"
    >
      <!--begin::Aside-->
      <div
        class="login-aside d-flex flex-column flex-row-auto"
        style="background-color: #f2c98a"
      >
        <div class="d-flex flex-column-auto flex-column pt-lg-40 pt-15">
          <a href="#" class="text-center mb-10">
            <img
              src="media/logos/logo-letter-1.png"
              class="max-h-70px"
              alt=""
            />
          </a>
          <h3
            class="font-weight-bolder text-center font-size-h4 font-size-h1-lg"
            style="color: #986923"
          >
            Enhance Your Skills with <br />Training Platform
          </h3>
        </div>
        <div
          class="
            aside-img
            d-flex
            flex-row-fluid
            bgi-no-repeat bgi-position-y-bottom bgi-position-x-center
          "
          style="background-size: contain"
          :style="{ backgroundImage: `url(${backgroundImage})` }"
        ></div>
      </div>
      <!--begin::Aside-->
      <!--begin::Content-->
      <div
        class="
          login-content
          flex-row-fluid
          d-flex
          flex-column
          justify-content-center
          position-relative
          overflow-hidden
          p-7
          mx-auto
        "
      >
        <div class="d-flex flex-column-fluid flex-center">
          <!--begin::Signin-->
          <login :show-form="showForm" />
          <!--end::Signin-->
          <!--begin::Forgot-->
          <forgot-password :show-form="showForm" />
          <!--end::Forgot-->
        </div>
        <!--begin::Content footer-->
        <div
          class="
            d-flex
            justify-content-lg-start justify-content-center
            align-items-end
            py-7 py-lg-0
          "
        >
          <a href="#" class="text-primary font-weight-bolder font-size-h5"
            >Terms</a
          >
          <a href="#" class="text-primary ml-10 font-weight-bolder font-size-h5"
            >Plans</a
          >
          <a href="#" class="text-primary ml-10 font-weight-bolder font-size-h5"
            >Contact Us</a
          >
        </div>
        <!--end::Content footer-->
      </div>
      <!--end::Content-->
    </div>
  </div>
</template>

<!-- Load login custom page styles -->
<style lang="scss">
@import '@/assets/sass/pages/login/login-1.scss';
</style>

<script>
import KTUtil from '@/assets/js/components/util';
import { mapGetters, mapState } from 'vuex';
import Login from './Login';
import ForgotPassword from './ForgotPassword';

export default {
  components: { Login, ForgotPassword },
  data() {
    return {
      state: 'signin',
      // Remove this dummy login info
      form: {
        email: 'admin@demo.com',
        password: 'demo'
      }
    };
  },
  computed: {
    ...mapState({
      errors: (state) => state.auth.errors
    }),
    ...mapGetters(['currentUser']),

    backgroundImage() {
      return process.env.BASE_URL + 'media/svg/illustrations/working.svg';
    }
  },
  mounted() {},
  methods: {
    showForm(form) {
      this.state = form;
      var form_name = 'kt_login_' + form + '_form';
      KTUtil.animateClass(
        KTUtil.getById(form_name),
        'animate__animated animate__backInUp'
      );
    }
  }
};
</script>
