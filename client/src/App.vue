<template>
  <div id="app">
     <section class="hero is-primary is-bold is-fullheight">
      <!-- Hero content: will be in the middle -->
      <div class="hero-body">
        <div class="container has-text-centered">
          <div class="row">
            <div class="columns">
              <div class="column is-half is-offset-one-quarter">
                <username></username>
                <fetch></fetch>
                <period></period>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import Username from "./components/Username";
import Period from "./components/Period";
import Fetch from "./components/Fetch";

export default {
  name: "app",
  components: {
    Username,
    Period,
    Fetch
  },
};
</script>

<style>
</style>