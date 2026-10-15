import './App.css'
import { Route,Routes } from 'react-router-dom'
import Principal from './pages/Principal'
import Noticias from './pages/Noticias'
import Login from './pages/Login'
import Registro from './pages/Registro'
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
      path='/'
      element=""
      />
      <Route
      path='/'
      element=""
      />
      <Route
      path='/'
      element=""
      />
      <Route
      path='/'
      element=""
      />
    </Routes>
    </>
  )
}

export default App
