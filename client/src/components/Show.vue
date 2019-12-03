<template>
  <button id="button" v-on:click="this.getAlbums">
    <i class="fa fa-eye"></i>
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
      }
    }
  }
};
</script>

<style>
#button {
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
#button a {
  color: #ccc;
}
#button:hover {
  background-color: darkred;
}
</style>