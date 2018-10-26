import axios from 'axios';

const API = {
    getEvents : async () => await axios({
        method : 'get',
        url : 'http://localhost:8080/events'
      }).then(response => response.data),
    createEvent : async event => await axios({
        method : 'post',
        url : 'http://localhost:8080/events',
        data : event
      }).then(response => response.data)
};

export default API;
