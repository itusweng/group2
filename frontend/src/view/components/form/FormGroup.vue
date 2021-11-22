<template>
  <b-col :cols="cols" :xs="xs" :sm="sm" :md="md" :lg="lg" :xl="xl">
    <b-form-group
      :invalid-feedback="firstErrorMessage"
      :state="isValid"
      :label-sr-only="noLabel"
      :class="{ 'm-0': noMargin }"
    >
      <template v-slot:label>
        <span v-if="!label && !noLabel"> &nbsp;</span>
        <span v-if="!info">{{ label }}</span>
        <span v-else
          >{{ label }}
          <i
            class="fas fa-info-circle text-primary"
            v-b-tooltip.hover
            :title="info"
          ></i
        ></span>
      </template>
      <slot :attrs="{ state: isValid }" :listeners="listeners" />
    </b-form-group>
  </b-col>
</template>
<script>
import { singleErrorExtractorMixin } from "vuelidate-error-extractor";
export default {
  props: {
    cols: String,
    xs: String,
    sm: String,
    md: String,
    lg: String,
    xl: String,
    label: String,
    info: String,
    noLabel: Boolean,
    noMargin: Boolean,
    quickValidate: Boolean
  },
  computed: {
    listeners() {
      if (this.quickValidate) {
        return {
          input: () => this.preferredValidator.$touch()
        };
      } else {
        return {
          blur: () => this.preferredValidator.$touch()
        };
      }
    }
  },
  extends: singleErrorExtractorMixin
};
</script>
