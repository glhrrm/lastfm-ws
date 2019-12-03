<template>
  <div class="album-list">
    <div v-for="album in topAlbums" :key="album.position" v-bind:topAlbums="topAlbums">
      <Album
        v-bind:image="album.image"
        v-bind:position="album.position"
        v-bind:artistName="album.artist"
        v-bind:albumName="album.name"
      />
    </div>
    <button v-on:click="this.getAlbums">Show albums</button>
  </div>
</template>

<script>
import Album from "./Album";

export default {
  components: {
    Album
  },
  props: {
    username: String,
    period: String
  },
  data() {
    return {
      topAlbums: ""
    };
  },
  methods: {
    getAlbums() {
      if (this.username != "" && this.period != "") {
        fetch(
          `http://localhost:8080/${this.username}/top-albums/${this.period}`
        )
          .then(response => response.json())
          .then(data => (this.topAlbums = data));
      }
    }
  }
};
</script>

<style>
.album-list {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-template-rows: repeat(5, 1fr);
}
</style>