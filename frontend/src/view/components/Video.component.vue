<template>
  <div>
    <video
      ref="videoPlayer"
      class="video-js"
      @play="$emit('play')"
      @ended="$emit('ended')"
    ></video>
  </div>
</template>

<script>
import videojs from 'video.js';
import 'video.js/dist/video-js.css';

export default {
  props: {
    options: {
      type: Object,
      default() {
        return {};
      }
    }
  },
  data() {
    return {
      player: null
    };
  },
  mounted() {
    this.player = videojs(
      this.$refs.videoPlayer,
      this.options
    );
  },
  beforeDestroy() {
    if (this.player) {
      this.player.dispose();
    }
  },
  watch: {
    options() {
      this.player.src(this.options.sources);
    }
  }
};
</script>

<style></style>
