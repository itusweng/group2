<template>
  <div class="card card-custom gutter-b card-stretch card-shadowless">
    <div class="card-body p-0 d-flex">
      <div
        class="
          d-flex
          align-items-start
          justify-content-center
          flex-grow-1
          border
          p-8
          card-rounded
          flex-grow-1
          position-relative
        "
      >
        <div class="text-center mb-10">
          <div class="symbol symbol-90 symbol-circle symbol-xl-150">
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
          <div class="text-muted mb-2">
            {{ currentUser.role_name }}
          </div>
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
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  name: 'widget-1',
  created() {
    console.log(this.currentUser);
  },
  computed: {
    ...mapGetters(['currentUserPhoto', 'currentUser'])
  }
};
</script>
