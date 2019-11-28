<template>
  <div id="app">
     <section class="hero is-primary is-bold is-fullheight">
      <!-- Hero content: will be in the middle -->
      <div class="hero-body">
        <div class="container has-text-centered">
          <div class="row">
            <div class="columns">
              <div class="column is-half is-offset-one-quarter">
                <search></search>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import Search from "./components/Search";

export default {
  name: "app",
  components: {
    Search
  },
};
</script>

<style>
</style>