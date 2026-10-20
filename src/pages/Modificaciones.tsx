import AdminNavbar from "../components/organisms/AdminNavbar"

function Modificaciones(){
    return(
        <>
    <header>
        <AdminNavbar/>
    </header>
    <main>
        <div style={{backgroundColor:"rgb(61, 61, 61)",marginTop:"0%"}}>
            <button>Agregar</button>/*Tenia un onclick*/ 
            <a href="../Us_admin/ficha_real.html"><button>Crear Ficha</button></a>
        </div>
        <h2>Vista catalogo</h2>
        <hr/>
        <div style={{display:"flex",flexWrap:"wrap",gap:"25px",maxWidth:"90%",marginLeft:"5%"}} id="mod"></div>    
    </main>
        </>
    )
}
export default Modificaciones