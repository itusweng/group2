<template>
  <div class="d-flex flex-row">
    <!--begin::Aside-->
    <div
      class="flex-row-auto offcanvas-mobile w-300px w-xl-350px"
      id="kt_profile_aside"
    >
      <!--begin::Card-->
      <div class="card card-custom">
        <!--begin::Body-->
        <div class="card-body pt-15">
          <!--begin::User-->
          <div class="text-center mb-10">
            <div class="symbol symbol-60 symbol-circle symbol-xl-90">
              <div
                class="symbol-label"
                :style="{
                  backgroundImage: `url(${currentUserPhoto})`
                }"
              ></div>
              <i class="symbol-badge symbol-badge-bottom bg-success"></i>
            </div>

            <h4 class="font-weight-bold my-2">
              {{ currentUser.first_name }} {{ currentUser.last_name }}
            </h4>
            <div class="text-muted mb-2">{{ currentUser.role_name }}</div>
            <span
              class="
                label label-light-warning label-inline
                font-weight-bold
                label-lg
              "
            >
              Active
            </span>
          </div>
          <!--end::User-->

          <!--begin::Contact-->
          <div class="mb-10 text-center">
            <a href="#" class="btn btn-icon btn-circle btn-light-facebook mr-2">
              <i class="socicon-facebook"></i>
            </a>
            <a href="#" class="btn btn-icon btn-circle btn-light-twitter mr-2">
              <i class="socicon-twitter"></i>
            </a>
            <a href="#" class="btn btn-icon btn-circle btn-light-google">
              <i class="socicon-google"></i>
            </a>
          </div>
          <!--end::Contact-->

          <!--begin::Nav-->
          <div
            class="navi navi-bold navi-hover navi-active navi-link-rounded"
            role="tablist"
          >
            <div class="navi-item mb-2">
              <router-link
                class="
                  btn btn-hover-light-primary
                  font-weight-bold
                  py-3
                  px-6
                  mb-2
                  text-center
                  btn-block
                "
                exact-active-class="active"
                to="/profile/personal-information"
              >
                Personal info
              </router-link>
              <router-link
                class="
                  btn btn-hover-light-primary
                  font-weight-bold
                  py-3
                  px-6
                  mb-2
                  text-center
                  btn-block
                "
                exact-active-class="active"
                to="/profile/notifications"
              >
                Notifications
              </router-link>
              <router-link
                class="
                  btn btn-hover-light-primary
                  font-weight-bold
                  py-3
                  px-6
                  mb-2
                  text-center
                  btn-block
                "
                exact-active-class="active"
                to="/profile/change-password"
              >
                Change Password
              </router-link>
            </div>
          </div>
          <!--end::Nav-->
        </div>
        <!--end::Body-->
      </div>
      <!--end::Card-->
    </div>
    <!--end::Aside-->

    <!--begin::Content-->
    <div class="flex-row-fluid ml-lg-8">
      <transition name="fade-in-up">
        <router-view></router-view>
      </transition>
    </div>
    <!--end::Content-->
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import { SET_BREADCRUMB } from '@/core/store/breadcrumbs.module';

export default {
  name: 'Profile-2',
  data() {
    return {
      tabIndex: 0
    };
  },

  mounted() {
    this.$store.dispatch(SET_BREADCRUMB, [{ title: 'Profile 2' }]);
  },
  computed: {
    ...mapGetters(['currentUserPhoto', 'currentUser'])
  }
};
</script>
