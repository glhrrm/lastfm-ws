<template>
  <div class="container">
    <h3>All Albums</h3>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Description</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>Learn Full stack with Spring Boot and Vue</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import AlbumDataService from '../service/AlbumDataService';
export default {
  name: "AlbumsList",
  data() {
    return {
      username: "since93"
    };
  },
  methods: {
    refreshAlbums() {
      AlbumDataService.retrieveAllAlbums(this.username) //HARDCODED
        .then(response => {
          console.log(response.data);
        });
    }
  },
  created() {
    this.refreshAlbums();
  }
};
</script>

<style>
</style>