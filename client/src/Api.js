import axios from 'axios'

const SERVER_URL = 'http://localhost:9000';

const instance = axios.create({
    baseURL: SERVER_URL,
    timeout: 1000
});

export default {
    // (C)reate  
    createNew: (name, artist, playcount) => instance.post('albums', { name: name, artist: artist, playcount: playcount }),
    // (R)ead  
    getAll: () => instance.get('albums', {
        transformResponse: [function (data) {
            return data ? JSON.parse(data)._embedded.albums : data;
        }]
    }),
    // (U)pdate  
    updateForId: (id, name, artist, playcount) => instance.put('albums/' + id, { name, artist, playcount }),
    // (D)elete  
    removeForId: (id) => instance.delete('albums/' + id)
}