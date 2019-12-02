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
import Album from './Album'

export default {
    components: {
        Album
    },
    props: {
        username: String,
        period: String,
        position: Number,
        artistName: String,
        albumName: String,
        image: String
    },
    data() {
        return {
            topAlbums: []
        }
    },
    methods: {
        // getAlbums() {
        //     fetch("http://localhost:8080/since93/top-albums/7day")
        //     // fetch("http://localhost:8080/" + this.username + "/top-albums/" + this.period)
        //         .then(response => response.json())
        //         .then(data => (this.topAlbums = data))
        // }
    },
}
</script>

<style>
.album-list {
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    grid-template-rows: repeat(5, 1fr);
}
</style>