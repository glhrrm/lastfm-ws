<template>
  <p class="control">
    <a class="button" v-bind:href="send">
      <span class="icon is-small">
        <i class="fa fa-search"></i>
      </span>
    </a>
  </p>
</template>

<script>
import { serverBus } from "../main";

export default {
  name: "fetch",
  data() {
    server: null;
  },
  created() {
    serverBus.$on("serverSelected", server => {
      this.server = server;
    });
  },
  computed: {
    send() {
      if (this.username != "") {
        return (
          "http://localhost:8080/" + this.username + "/top-albums/" + "overall"
        );
      }
    }
    // http://andreybleme.com/2018-01-07/sharing-data-across-vuejs-components/
  }
};
</script>
<style scoped>
</style>