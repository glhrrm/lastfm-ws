<template>
  <div id="app">
    <div class="inline">
      <Logo />
    </div>
    <div class="inline">
      <Username v-on:inputData="updateUsername" />
    </div>
    <div class="inline">
      <Period v-on:inputData="updatePeriod" />
    </div>
    <div class="inline">
      <ListButton v-on:click.native="getAlbums" />
      <GetJsonButton v-bind:username="username" v-bind:period="period" />
    </div>
    <div class="inline">
      <AlbumList v-bind:topAlbums="topAlbums" />
    </div>
  </div>
</template>

<script>
import Logo from "./components/Logo";
import Username from "./components/Username";
import Period from "./components/Period";
import GetJsonButton from "./components/GetJsonButton";
import ListButton from "./components/ListButton";
import AlbumList from "./components/AlbumList";

export default {
  components: {
    Logo,
    Username,
    Period,
    AlbumList,
    GetJsonButton,
    ListButton
  },
  data() {
    return {
      username: "",
      period: "",
      topAlbums: []
    };
  },
  methods: {
    updateUsername(variable) {
      this.username = variable;
    },
    updatePeriod(variable) {
      this.period = variable;
    },
    getAlbums() {
      if (this.username != "" && this.period != "") {
        fetch(
          `http://localhost:8080/${this.username}/top-albums/${this.period}`
        )
          .then(response => response.json())
          .then(data => (this.topAlbums = data));
      } else {
        alert("Fill in all fields")
      }
    }
  }
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css?family=IBM+Plex+Sans:400,700&display=swap");

* {
  box-sizing: border-box;
  font-family: "IBM Plex Sans", sans-serif;
}

#app {
  background-color: #111;
  background-image: url("./assets/background.png");
  height: 100%;
  overflow: auto;
  padding: 50px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;
}

.inline {
  display: inline-block;
}
</style>