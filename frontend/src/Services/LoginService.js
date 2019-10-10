import CONFIG from '../config'
import axios from 'axios'

const LOGGED_USER = 'LOGGED_USER'
const USER_NAME = 'USER_NAME'

export default class LoginService {

	static setLoggedUser(token, username) {
		localStorage.setItem(LOGGED_USER, token)
		localStorage.setItem(USER_NAME, username)
	}

	static login(username, senha) {
		return axios.post(`${CONFIG.API_URL_BASE}/public/login`, {
			username,
			senha
		}).then((result) => {
			console.info(result);
			this.setLoggedUser(result.data.token, result.data.username)
			return result
		})
	}

	static getLoggedUser() {
		return localStorage.getItem(LOGGED_USER)
	}

	static getUserName(){
		return localStorage.getItem(USER_NAME)
	}

	static logout() {
		localStorage.removeItem(LOGGED_USER);
		localStorage.removeItem(USER_NAME);
	}
}