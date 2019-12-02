<template>
    <div class="album">
        <div class="cover">
            <img :src="image" alt="Album cover" />
        </div>
        <div class="album-info">
            <p class="position">{{ position }}</p>
            <p class="album-name">{{ albumName }}</p>
            <p class="artist-name">{{ artistName }}</p>
        </div>
    </div>
</template>

<script>
export default {
    props: {
        position: Number,
        artistName: String,
        albumName: String,
        image: String
    },
}
</script>

<style>
* {
    color: #ccc;
}

.cover {
    height: 100px;
}

.cover img {
    height: 100%;
}

.album {
    display: flex;
    flex-direction: row;
    margin: 10px;
}

.album-info {
    margin-left: 20px;
    display: flex;
    flex-direction: column;
    justify-content: center;
}

.album-info p {
    margin: 0;
}

.position {
    font-weight: 700;
}

.artist-name {
    font-weight: 400;
}

.album-name {
    font-weight: 400;
    font-style: italic;
}
</style>