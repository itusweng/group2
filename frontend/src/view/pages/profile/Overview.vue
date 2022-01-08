<template>
  <div>
    <!--begin::Row-->
    <div class="row">
      <div class="col-lg-6">
        <Widget14></Widget14>
      </div>
      <div class="col-lg-6">
        <Widget1></Widget1>
      </div>
    </div>
    <!--end::Row-->
    <Widget2></Widget2>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import { SET_BREADCRUMB } from '@/core/store/breadcrumbs.module';
import Widget1 from '@/view/pages/profile-old/profile-comp-2/Widget1';
import Widget2 from '@/view/pages/profile-old/profile-comp-2/Widget2';
import Widget14 from '@/view/pages/profile-old/profile-comp-2/Widget14';

export default {
  data() {
    return {
      tabIndex: 0
    };
  },
  components: {
    Widget1,
    Widget2,
    Widget14
  },
  mounted() {
    this.$store.dispatch(SET_BREADCRUMB, [{ title: 'Profile 2' }]);
  },
  methods: {

  },
  computed: {
    ...mapGetters(['currentUserPhoto'])
  }
};
</script>
