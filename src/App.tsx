import './App.css'
import { Route,Routes } from 'react-router-dom'
import Principal from './pages/Principal'
import Noticias from './pages/Noticias'
import Login from './pages/Login'
import Registro from './pages/Registro'
import PrincipalAdmin from './pages/PrincipalAdmin'
import Catalogo from './pages/Catalogo'
import Detalle from './pages/Detalle'
import MedVac from './pages/MedVac'
import Modificaciones from './pages/Modificaciones'
import DetalleMed from './pages/DetalleMed'
import Ficha from './pages/Ficha'
import DetalleMod from './pages/DetalleMod'
import Agregar from './pages/Agregar'
import FichaReal from './pages/FichaReal'

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
      path='/servicio/:id'
      element={<Detalle/>}
      />
      <Route
      path='/medicamentos'
      element={<MedVac/>}
      />
      <Route
      path='/modificaciones'
      element={<Modificaciones/>}
      />
      <Route
      path='/modificacion/:id'
      element={<DetalleMod/>}
      />
      <Route
      path='/ficha'
      element={<Ficha/>}
      /> 
      <Route 
      path='/medicamentos' 
      element={<MedVac/>} 
      />
      <Route 
      path='/medicamento/:id' 
      element={<DetalleMed/>} 
      />
      <Route
      path='/agregar'
      element={<Agregar/>}
      />
      <Route
      path='/ficha-real'
      element={<FichaReal/>}
      />
    </Routes>
    
    </>
  )
}

export default App