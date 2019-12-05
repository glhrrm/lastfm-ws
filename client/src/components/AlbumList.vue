<template>
  <div class="album-list">
    <div v-for="album in topAlbums" :key="album.position">
      <Album
        v-bind:image="album.image"
        v-bind:position="album.position"
        v-bind:artistName="album.artist"
        v-bind:albumName="album.name"
      />
    </div>
  </div>
</template>

<script>
import Album from "./Album";

export default {
  components: {
    Album
  },
  props: {
    topAlbums: Array
  },
};
</script>

<style>
.album-list {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-template-rows: repeat(5, 1fr);
}
</style>