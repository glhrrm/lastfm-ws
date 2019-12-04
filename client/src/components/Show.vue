<template>
  <button id="show-button" v-on:click="getAlbums">
    <i class="fa fa-search"></i>
  </button>
</template>

<script>
export default {
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
        this.$emit("inputAlbums", this.topAlbums);
      }
    }
  }
};
</script>

<style>
#show-button {
  border: none;
  padding: 10px;
  margin: 10px;
  text-align: center;
  border-radius: 10px;
  display: unset;
  border: 1.5px solid #aaa;
  color: #ccc;
  background-color: transparent;
}
#show-button a {
  color: #ccc;
}
#show-button:hover {
  background-color: darkred;
}
</style>