import axios from 'axios'
import CONFIG from '../config'
export default class RegisterService {
    static register(username, nome, senha, confirmarSenha) {
        return axios.post(`${CONFIG.API_URL_BASE}/public/registro/salvar`, {
            username,
            nome,
            senha,
            confirmarSenha
        })
    }
}