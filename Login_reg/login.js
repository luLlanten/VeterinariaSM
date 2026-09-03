
function ingreso(){
    let formatoadmin = /^[^\s@]+@+$/+"sanmarcosadmin"+/^\.[^\s@]+$/;
    let formatomedico= /^[^\s@]+@+$/+"sanmarcos"+/^\.[^\s@]+$/;
    let formatocliente=/^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    let correo = document.getElementById("correo").value;
    let clave = document.getElementById("clave").value;
    if (clave ==="" || correo===""){
        alert("Complete todos los campos")
        return;
    }
    if(formatoadmin.test(correo)){
        window.location.href="../Us_admin/principal_admin.html";
    }else if(formatomedico.test(correo)){
        window.location.href="#";//falta un html de los veterinarios
    }else if(formatocliente.test(correo)){
        window.location.href="../Pag_principal/principal.html";
    }else{
        alert("Correo invalido")
    }
};