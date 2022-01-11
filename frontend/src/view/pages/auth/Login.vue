<template>
  <div class="login-form login-signin">
    <form-wrapper :validator="$v.form" id="kt_login_signin_form">
      <div class="pb-13 pt-lg-0 pt-5">
        <h3 class="font-weight-bolder text-dark font-size-h4 font-size-h1-lg">
          Welcome to Training Platform
        </h3>
      </div>
      <div class="form-group">
        <label class="font-size-h6 font-weight-bolder text-dark">Username</label>
        <b-row>
          <form-group name="username" xs="12" no-label no-margin>
            <b-input
              slot-scope="{ attrs, listeners }"
              v-bind="attrs"
              v-on="listeners"
              class="
                form-control-lg form-control-solid
                h-auto
                py-7
                px-6
                rounded-lg
              "
              v-model="form.username"
            />
          </form-group>
        </b-row>
      </div>
      <div class="form-group">
        <div class="d-flex justify-content-between mt-n5">
          <label class="font-size-h6 font-weight-bolder text-dark pt-5"
            >Password</label
          >
          <a
            class="
              text-primary
              font-size-h6 font-weight-bolder
              text-hover-primary
              pt-5
              cursor-pointer
            "
            id="kt_login_forgot"
            @click="showForm('forgot')"
            >Forgot Password ?</a
          >
        </div>
        <b-row>
          <form-group name="password" xs="12" no-label no-margin>
            <b-input
              slot-scope="{ attrs, listeners }"
              v-bind="attrs"
              v-on="listeners"
              type="password"
              @keypress.enter="submit"
              class="
                form-control-lg form-control-solid
                h-auto
                py-7
                px-6
                rounded-lg
              "
              v-model="form.password"
            />
          </form-group>
        </b-row>
      </div>
      <div class="pb-lg-0 pb-5">
        <button
          @click="submit"
          :disabled="$v.form.$anyError || submitting"
          class="
            btn btn-primary
            font-weight-bolder font-size-h6
            px-15
            py-4
            my-3
            mr-3
          "
        >
          Sign In <b-spinner small v-if="submitting" />
        </button>
      </div>
    </form-wrapper>
  </div>
</template>

<script>
// import { LOGIN, LOGOUT } from '@/core/store/auth.module';
import { required } from 'vuelidate/lib/validators';

export default {
  props: ['showForm'],
  validations: {
    form: {
      username: { required },
      password: { required }
    }
  },
  data() {
    return {
      // Remove this dummy login info
      form: {
        username: 'test5',
        password: 'test5'
      },
      submitting: false
    };
  },
  computed: {},
  mounted() {},
  methods: {
    async submit() {
      try {
        this.submitting = true;

        this.$store.dispatch('logout');
        await this.$store.dispatch('login', this.form);

        this.$router.push({ name: 'dashboard' });
      } catch (e) {
        this.toast({ type: 'danger', message: 'wrongCredentials' });
        console.log(e);
      } finally {
        this.submitting = false;
      }
    }
  }
};
</script>
