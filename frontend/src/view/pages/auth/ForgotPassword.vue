<template>
  <div class="login-form login-forgot">
    <form-wrapper :validator="$v.form" id="kt_login_forgot_form">
      <div class="pb-13 pt-lg-0 pt-5">
        <h3 class="font-weight-bolder text-dark font-size-h4 font-size-h1-lg">
          Forgotten Password ?
        </h3>
        <p class="text-muted font-weight-bold font-size-h4">
          Enter your email to reset your password
        </p>
      </div>
      <b-row class="form-group">
        <form-group name="email" xs="12" no-label no-margin>
          <b-input
            slot-scope="{ attrs, listeners }"
            v-bind="attrs"
            v-on="listeners"
            :placeholder="$t('common.email')"
            class="
              form-control-lg form-control-solid
              h-auto
              py-7
              px-6
              rounded-lg
            "
            v-model="form.email"
          />
        </form-group>
      </b-row>
      <div class="form-group d-flex flex-wrap pb-lg-0">
        <b-button
          size="lg"
          variant="primary"
          :disabled="$v.form.$anyError || submitting"
          class="font-weight-bolder font-size-h6 px-15 py-4 my-3 mr-3"
        >
          {{ $t('common.send') }} <b-spinner small v-if="submitting" />
        </b-button>
        <b-button
          size="lg"
          variant="primary"
          @click="showForm('signin')"
          class="
            btn-light-primary
            font-weight-bolder font-size-h6
            px-15
            py-4
            my-3
            mr-3
          "
        >
          {{ $t('common.cancel') }}
        </b-button>
      </div>
    </form-wrapper>
  </div>
</template>

<script>
import { required, email } from 'vuelidate/lib/validators';

export default {
  props: ['showForm'],
  validations: {
    form: {
      email: { required, email },
      password: { required }
    }
  },
  data() {
    return {
      // Remove this dummy login info
      form: {
        email: ''
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
        //sd
      } catch (e) {
        console.log(e);
      }
    }
  }
};
</script>
