<template>
  <div class="d-flex align-items-center justify-content-between">
    <div>
      <b>Total:</b>
      {{ totalRows }}
    </div>
    <b-pagination
      size="sm"
      align="center"
      class="m-0"
      :total-rows="totalRows"
      :per-page="perPage"
      :value="currentPage"
      @input="$emit('update:current-page', $event)"
    />
    <b-dropdown
      :text="`${perPage}`"
      variant="outline-primary"
      block
      class="d-inline-block float-right mr-2"
    >
      <b-dropdown-item
        v-for="(size, index) in pageSizes"
        :key="index"
        @click="$emit('update:per-page', size)"
      >
        {{ size }}
      </b-dropdown-item>
    </b-dropdown>
  </div>
</template>

<script>
export default {
  props: {
    totalRows: {
      type: Number
    },
    currentPage: {
      type: Number,
      default: 1
    },
    perPage: {
      type: Number,
      default: 10
    },
    pageSizes: {
      type: Array,
      default: () => [5, 10, 20, 50]
    }
  }
};
</script>
