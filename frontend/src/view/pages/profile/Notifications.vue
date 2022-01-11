<template>
  <div>
    <!--end::Row-->
    <Widget2></Widget2>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import { SET_BREADCRUMB } from '@/core/store/breadcrumbs.module';
import Widget2 from '@/view/pages/profile/overview-comp/Widget2';

export default {
  data() {
    return {
      tabIndex: 0
    };
  },
  components: {
    Widget2,
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
