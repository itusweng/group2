<template>
  <div>
    <!--begin::Dashboard-->
    <div class="row">
      <div class="col-xl-9">
        <b-tabs content-class="mt-3">
          <b-tab title="My Trainings" active>
            <MyTrainingList />
          </b-tab>
          <b-tab title="All Trainings">
            <AllTrainingList />
          </b-tab>
        </b-tabs>
      </div>
      <div class="col-xl-3">
        <profile></profile>
      </div>
    </div>
  </div>
</template>

<script>
import { SET_BREADCRUMB } from '@/core/store/breadcrumbs.module';
import Profile from '@/view/components/widgets/Profile.vue';
import MyTrainingList from '@/view/components/training/MyTrainingList';
import AllTrainingList from '@/view/components/training/AllTrainingList';

export default {
  name: 'dashboard',
  components: {
    Profile,
    MyTrainingList,
    AllTrainingList
  },
  data() {
    return {};
  },
  mounted() {
    this.$store.dispatch(SET_BREADCRUMB, [{ title: 'Dashboard' }]);
  },
  methods: {
    setActiveTab1(event) {
      this.tabIndex = this.setActiveTab(event);
    },
    setActiveTab2(event) {
      this.tabIndex2 = this.setActiveTab(event);
    },
    /**
     * Set current active on click
     * @param event
     */
    setActiveTab(event) {
      // get all tab links
      const tab = event.target.closest('[role="tablist"]');
      const links = tab.querySelectorAll('.nav-link');
      // remove active tab links
      for (let i = 0; i < links.length; i++) {
        links[i].classList.remove('active');
      }

      // set current active tab
      event.target.classList.add('active');

      // set clicked tab index to bootstrap tab
      return parseInt(event.target.getAttribute('data-tab'));
    }
  }
};
</script>
