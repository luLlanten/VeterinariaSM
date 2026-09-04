
function ingreso(){
    let formatoadmin = /^[^\s@]+@+sanmarcosadmin\.[^\s@]+$/;
    let formatocliente=/^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    let correo = document.getElementById("correo").value;
    let clave = document.getElementById("clave").value;
    if (clave ==="" || correo===""){
        alert("Complete todos los campos")
        return;
    }
    if(formatoadmin.test(correo)){
        window.location.href="../Us_admin/principal_admin.html";
    }else {if(formatocliente.test(correo)){
        window.location.href="../Pag_principal/principal.html";
    }else{
        alert("Correo invalido")
        return;
    }}
};
function registro(){
    let formatocliente=/^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    let correo = document.getElementById("correo").value;
    let clave = document.getElementById("clave").value;
    let clave2 = document.getElementById("clave2").value;
    
    if (clave ==="" || correo==="" || clave2===""){
        alert("Complete todos los campos")
        return;
    }
    if(formatocliente.test(correo)){
        if(clave!==clave2){
        alert("Contraseñas no coinciden")
        return;
        }else{
             
            window.location.href="../Pag_principal/principal.html";}
    }else{
        alert("Correo invalido")
        return;
    }


}