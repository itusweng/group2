import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from '@/core/store';
import ApiService from '@/core/services/api.service';
import { VERIFY_AUTH } from '@/core/store/auth.module';
import { RESET_LAYOUT_CONFIG } from '@/core/store/config.module';

Vue.config.productionTip = false;

// Global 3rd party plugins
import 'popper.js';
import 'tooltip.js';
import PerfectScrollbar from 'perfect-scrollbar';
window.PerfectScrollbar = PerfectScrollbar;
import ClipboardJS from 'clipboard';
window.ClipboardJS = ClipboardJS;

// Vue 3rd party plugins
import i18n from '@/core/plugins/vue-i18n';
import '@/core/plugins/portal-vue';
import '@/core/plugins/bootstrap-vue';
import '@/core/plugins/perfect-scrollbar';
import '@/core/plugins/highlight-js';
import '@/core/plugins/inline-svg';
import '@/core/plugins/apexcharts';
import '@/core/plugins/metronic';
import '@/core/plugins/treeselect';
import '@mdi/font/css/materialdesignicons.css';
import '@/core/plugins/vuelidate-error-extractor';
import { validationMixin } from 'vuelidate';
import { toolMixin } from '@/core/utils/mixins/tool';

// Global Components
import Card from '@/view/components/Card';

Vue.component('card', Card);

Vue.mixin(validationMixin);
Vue.mixin(toolMixin);

// API service init
ApiService.init();

router.beforeEach((to, from, next) => {
  // Ensure we checked auth before each page load.
  Promise.all([store.dispatch(VERIFY_AUTH)]).then(next);

  // reset config to initial state
  store.dispatch(RESET_LAYOUT_CONFIG);

  // Scroll page to top on every route change
  setTimeout(() => {
    window.scrollTo(0, 0);
  }, 100);
});

new Vue({
  router,
  store,
  i18n,
  render: (h) => h(App)
}).$mount('#app');
