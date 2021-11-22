import Vue from 'vue';
import VuelidateErrorExtractor, { templates } from 'vuelidate-error-extractor';
import FormGroup from '@/view/components/form/FormGroup';

Vue.use(VuelidateErrorExtractor, {
  i18n: 'validation'
});

Vue.component('FormGroup', FormGroup);
Vue.component('FormWrapper', templates.FormWrapper);
