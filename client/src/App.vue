<template>
  <div class="container">
    <AlbumApp />
  </div>
</template>

<script>
import AlbumApp from "./components/AlbumApp.vue";

export default {
  name: "app",
  components: {
    AlbumApp
  }
};
</script>

<style>
@import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css);
</style>