<template>
  <div>
    Eymen in yaşı {{ eymenYaşi }}

    <div>
      <b-button @click="eymenYaşi++">Increase</b-button>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    age: {
      type: Number,
      default: 10
    },
    name: String
  },
  data() {
    return {
      eymenYaşi: 21
    };
  },
  watch: {
    eymenYaşi(nv){
      this.$emit('yasDegisti', nv)
    }
  }
};
</script>
