import axios from 'axios'

export default axios.create({
    baseURL: 'http://39.96.72.22:7350',
    timeout: 10000
})