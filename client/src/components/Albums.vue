<template>
  <div>
    <h1 class="name">Albums</h1>
    <h1 class="email">{{userEmail}}</h1>
    <section class="albumapp">
      <div v-if="loading">
        <h1 class="loading">Loading...</h1>
      </div>
      <div v-else>
        <header class="header">
          <input
            class="new-album"
            autofocus
            autocomplete="off"
            :placeholder="this.inputPlaceholder"
            v-model="newAlbum"
            @keyup.enter="addAlbum"
          />
        </header>
        <section class="main" v-show="albums.length" v-cloak>
          <input class="toggle-all" type="checkbox" v-model="allDone" />
          <ul class="album-list">
            <li
              v-for="album in filteredAlbums"
              class="album"
              :key="album.id"
              :class="{ name: album.name, editing: album == editedAlbum }"
            >
              <div class="view">
                <input
                  class="toggle"
                  type="checkbox"
                  v-model="album.name"
                  @change="completeAlbum(album)"
                />
                <label @dblclick="editAlbum(album)">{{ album.name }}</label>
                <button class="destroy" @click="removeAlbum(album)"></button>
              </div>
              <input
                class="edit"
                type="text"
                v-model="album.name"
                v-album-focus="album == editedAlbum"
                @blur="doneEdit(album)"
                @keyup.enter="doneEdit(album)"
                @keyup.esc="cancelEdit(album)"
              />
            </li>
          </ul>
        </section>
        <footer class="footer" v-show="albums.length" v-cloak>
          <span class="album-count">
            <strong>{{ remaining }}</strong>
            {{ remaining | pluralize }} left
          </span>
          <ul class="filters">
            <li>
              <a
                href="#/all"
                @click="setVisibility('all')"
                :class="{ selected: visibility == 'all' }"
              >All</a>
            </li>
            <li>
              <a
                href="#/active"
                @click="setVisibility('active')"
                :class="{ selected: visibility == 'active' }"
              >Active</a>
            </li>
            <li>
              <a
                href="#/name"
                @click="setVisibility('name')"
                :class="{ selected: visibility == 'name' }"
              >name</a>
            </li>
          </ul>
          <button
            class="clear-name"
            @click="removeName"
            v-show="albums.length > remaining"
          >Clear name</button>
        </footer>
      </div>
    </section>
    <div v-if="error" class="error" @click="handleErrorClick">ERROR: {{this.error}}</div>
  </div>
</template>

<script>
import api from "../Api";
// visibility filters
let filters = {
  all: function(albums) {
    return albums;
  },
  active: function(albums) {
    return albums.filter(function(album) {
      return !album.name;
    });
  },
  name: function(albums) {
    return albums.filter(function(album) {
      return album.name;
    });
  }
};

// app Vue instance
const Albums = {
  name: "Albums",
  props: {
    activeUser: Object
  },

  // app initial state
  data: function() {
    return {
      albums: [],
      newAlbum: "",
      editedAlbum: null,
      visibility: "all",
      loading: true,
      error: null
    };
  },

  mounted() {
    api
      .getAll()
      .then(response => {
        this.$log.debug("Data loaded: ", response.data);
        this.todos = response.data;
      })
      .catch(error => {
        this.$log.debug(error);
        this.error = "Failed to load albums";
      })
      .finally(() => (this.loading = false));
  },

  // computed properties
  // http://vuejs.org/guide/computed.html
  computed: {
    filteredAlbums: function() {
      return filters[this.visibility](this.albums);
    },
    remaining: function() {
      return filters.active(this.albums).length;
    },
    allDone: {
      get: function() {
        return this.remaining === 0;
      },
      set: function(value) {
        this.albums.forEach(function(album) {
          album.playcount = value;
        });
      }
    },
    userEmail: function() {
      return this.activeUser ? this.activeUser.email : "";
    },
    inputPlaceholder: function() {
      return this.activeUser
        ? this.activeUser.given_name + ", what needs to be done?"
        : "What needs to be done?";
    }
  },

  filters: {
    pluralize: function(n) {
      return n === 1 ? "item" : "items";
    }
  },

  // methods that implement data logic.
  // note there's no DOM manipulation here at all.
  methods: {
    addAlbum: function() {
      var value = this.newAlbum && this.newAlbum.trim();
      if (!value) {
        return;
      }

      this.albums.push({
        name: value
      });

      this.newAlbum = "";
    },

    setVisibility: function(vis) {
      this.visibility = vis;
    },

    // completeAlbum(album) {},

    removeAlbum: function(album) {
      // notice NOT using "=>" syntax
      this.albums.splice(this.albums.indexOf(album), 1);
    },

    editAlbum: function(album) {
      this.beforeEditCache = album.name;
      this.editedAlbum = album;
    },

    doneEdit: function(album) {
      if (!this.editedAlbum) {
        return;
      }

      this.editedAlbum = null;
      album.name = album.name.trim();

      if (!album.name) {
        this.removeAlbum(album);
      }
    },

    cancelEdit: function(album) {
      this.editedAlbum = null;
      album.name = this.beforeEditCache;
    },

    removeName: function() {
      this.albums = filters.active(this.albums);
    },

    handleErrorClick: function() {
      this.error = null;
    }
  },

  // a custom directive to wait for the DOM to be updated
  // before focusing on the input field.
  // http://vuejs.org/guide/custom-directive.html
  directives: {
    "album-focus": function(el, binding) {
      if (binding.value) {
        el.focus();
      }
    }
  }
};

export default Albums;
</script>

<style>
[v-cloak] {
  display: none;
}
</style>