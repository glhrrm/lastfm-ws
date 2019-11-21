import axios from "axios";

const username = "since93";
const album_api_url = "http://localhost:8080";
const user_api_url = `${album_api_url}/${username}`;

class AlbumDataService {
  retrieveAllAlbums() {
    return axios.get(`${user_api_url}`);
  }
}

export default new AlbumDataService();