import React, { Component } from 'react';
import LoginForm from './components/LoginForm/LoginForm'
import NotFound from './components/NotFound/NotFound'
import { Switch, Route, Redirect} from 'react-router-dom'
import './App.css';
import MostrarTodasMensagensDoUsuario from './components/Telas/Mensagem/MostrarTodasMensagensDoUsuario';
import MostrarTodasMensagens from './components/Telas/Mensagem/MostrarTodasMensagens';
import MostrarTodasEnviadas from './components/Telas/Mensagem/MostrarTodasEnviadas';
import MostrarTodasRecebidas from './components/Telas/Mensagem/MostrarTodasRecebidas';
import PesquisarMensagens from './components/Telas/Mensagem/PesquisarMensagens'
import PesquisarUsuarios from './components/Telas/Mensagem/PesquisarUsuarios'
import RegisterForm from './components/RegisterForm/RegisterForm'

class App extends Component {
  render() {
    return (
      <div>
        <Switch>
            <Route path="/404" component={NotFound} />
            <Route path="/registro" component={RegisterForm} />
            <Route path="/" exact component={LoginForm} />
            <Route path="/home" component={MostrarTodasRecebidas} />    
            <Route path="/mensagem/usuario/:username" component={MostrarTodasMensagensDoUsuario} />
            <Route path="/mensagem/todas/:conteudo" component={PesquisarMensagens} />
            <Route path="/mensagem/todas" component={MostrarTodasMensagens} />
            <Route path="/mensagem/enviadas" component={MostrarTodasEnviadas} />
            <Route path="/buscar/usuarios/:username" component={PesquisarUsuarios} />
            <Redirect to="/404"/>
          </Switch>
      </div>
    );
  }
}

export default App;
