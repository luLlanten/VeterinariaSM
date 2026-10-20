import './App.css'
import { Route,Routes } from 'react-router-dom'
import Principal from './pages/Principal'
import Noticias from './pages/Noticias'
import Login from './pages/Login'
import Registro from './pages/Registro'
import PrincipalAdmin from './pages/PrincipalAdmin'
import Catalogo from './pages/Catalogo'
import MedVac from './pages/MedVac'
import Modificaciones from './pages/Modificaciones'
function App() {
  return (
    <>
    <Routes>
      <Route
      path='/'
      element={<Principal/>}
      />
      <Route
      path='/noticias'
      element={<Noticias/>}
      />
      <Route
      path='/login'
      element={<Login/>}
      />
      <Route
      path='/registro'
      element={<Registro/>}
      />
      <Route
      path='/admin'
      element={<PrincipalAdmin/>}
      />
      <Route
      path='/servicios'
      element={<Catalogo/>}
      />
      <Route
      path='/medicamentos'
      element={<MedVac/>}
      />
      <Route
      path='/modificaciones'
      element={<Modificaciones/>}
      />
    </Routes>
    </>
  )
}

export default App
