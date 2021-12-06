<template>
  <div class="card card-custom gutter-b card-stretch card-shadowless">
    <div class="card-body p-0 d-flex">
      <div
        class="
          d-flex
          align-items-start
          justify-content-center
          flex-grow-1
          bg-light-warning
          p-8
          card-rounded
          flex-grow-1
          position-relative
        "
      >
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

          <h4 class="font-weight-bold my-2">James Jones</h4>
          <div class="text-muted mb-2">Application Developer</div>
          <span
              class="
                label label-light-warning label-inline
                font-weight-bold
                label-lg
              "
          >Active</span
          >
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {mapGetters} from "vuex";

export default {
  name: 'widget-1',
  computed: {
    ...mapGetters(['currentUserPhoto'])
  }
};
</script>
