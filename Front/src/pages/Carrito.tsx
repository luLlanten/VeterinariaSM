import Navbar from "../components/organisms/Navbar"
import Footer from "../components/organisms/Footer"
import ListaCarrito from "../components/organisms/ListaCarrito"

function Carrito(){
    return(
        <div className="d-flex flex-column min-vh-100">
            <Navbar/>
            <div className="container my-5 flex-grow-1">
                <h1 className="text-center mb-4">Mi carrito</h1>
                <ListaCarrito/>
            </div>
            <Footer/>
        </div>
    )
}
export default Carrito