package com.veterinariasm.catalogo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.veterinariasm.catalogo.model.Medicamento;
import com.veterinariasm.catalogo.model.Servicios;
import com.veterinariasm.catalogo.repo.MedRepo;
import com.veterinariasm.catalogo.repo.ServRepo;

@Configuration 
public class DataLoader {
    @Bean 
    CommandLineRunner initServicioDataBase(ServRepo repo){
        return args->{
            if (repo.count() == 0) {
                Servicios s1 = repo.save(new Servicios(null,"Consultas","Consulta general",15000.0,"/images/consulta-general.jpg"));
                Servicios s2 = repo.save(new Servicios(null,"Consultas","Consulta urgencia",25000.0,"/images/consulta-urgencia.jpg"));
                Servicios s3 = repo.save(new Servicios(null,"Consultas","Control postoperatorio",10000.0,"/images/control-postoperatorio.jpg"));
                Servicios s4 = repo.save(new Servicios(null,"Consultas","Consulta ave/conejo",18000.0,"/images/consulta-ave-conejo.jpg"));
                Servicios s5 = repo.save(new Servicios(null,"Consultas","Segunda opinión médica",20000.0,"/images/segunda-opinion-medica.jpg"));
                Servicios s6 = repo.save(new Servicios(null,"Cirugía","Esterilización hembra canina",80000.0,"/images/esterilizacion-hembra-canina.jpg"));
                Servicios s7 = repo.save(new Servicios(null,"Cirugía","Esterilización macho canino",60000.0,"/images/esterilizacion-macho-canino.jpg"));
                Servicios s8 = repo.save(new Servicios(null,"Cirugía","Esterilización hembra felina",65000.0,"/images/esterilizacion-hembra-felina.jpg"));
                Servicios s9 = repo.save(new Servicios(null,"Cirugía","Esterilización macho felino",50000.0,"/images/esterilizacion-macho-felino.jpg"));
                Servicios s10 = repo.save(new Servicios(null,"Cirugía","Extirpación de tumor cutáneo",120000.0,"/images/extirpacion-de-tumor-cutaneo.jpg"));
                Servicios s11 = repo.save(new Servicios(null,"Cirugía","Cesárea de urgencia",180000.0,"/images/cesarea-de-urgencia.png"));
                Servicios s12 = repo.save(new Servicios(null,"Desparasitación","Desparasitación interna pequeños (<10 kg)",8000.0,"/images/desparasitacion-interna-pequenos-0-kg.jpg"));
                Servicios s13 = repo.save(new Servicios(null,"Desparasitación","Desparasitación interna medianos (10-25 kg)",9500.0,"/images/desparasitacion-interna-medianos.jpg"));
                Servicios s14 = repo.save(new Servicios(null,"Desparasitación","Desparasitación interna grandes (>25 kg)",11000.0,"/images/desparasitacion-interna-grandes.jpg"));
                Servicios s15 = repo.save(new Servicios(null,"Desparasitación","Desparasitación interna felina",8000.0,"/images/desparasitacion-interna-felina.jpg"));
                Servicios s16 = repo.save(new Servicios(null,"Desparasitación","Antiparasitario externo (pipeta)",7500.0,"/images/antiparasitario-externo.jpg"));
                Servicios s17 = repo.save(new Servicios(null,"Exámenes","Hemograma completo",22000.0,"/images/hemograma-completo.jpg"));
                Servicios s18 = repo.save(new Servicios(null,"Exámenes","Perfil bioquímico completo",35000.0,"/images/perfil-bioquimico-completo.jpg"));
                Servicios s19 = repo.save(new Servicios(null,"Exámenes","Radiografía (1 proyección)",28000.0,"/images/radiografia.jpg"));
                Servicios s20 = repo.save(new Servicios(null,"Exámenes","Ecografía abdominal",45000.0,"/images/ecografia-abdominal.jpg"));
                Servicios s21 = repo.save(new Servicios(null,"Exámenes","Test de leishmaniasis",18000.0,"/images/test-de-leishmaniasis.jpg"));
                Servicios s22 = repo.save(new Servicios(null,"Otros","Corte de uñas",5000.0,"/images/corte-de-unas.jpg"));
                Servicios s23 = repo.save(new Servicios(null,"Otros","Limpieza dental",55000.0,"/images/limpieza-dental.jpg"));
                Servicios s24 = repo.save(new Servicios(null,"Otros","Microchip identificación",15000.0,"/images/microchip-identificacion.jpg"));
                Servicios s25 = repo.save(new Servicios(null,"Otros","Hospitalización (por día)",30000.0,"/images/hospitalizacion.jpg"));
            }
        };
    };

    @Bean
    CommandLineRunner initMedicamentoDataBase(MedRepo repo){
        return args->{
            if (repo.count() == 0) {
                Medicamento m1 = repo.save(new Medicamento(null,"Vacunación","Vacuna antirrábica canina",12000.0,20,"/images/vacunaantirrabicacanina.jpg"));
                Medicamento m2 = repo.save(new Medicamento(null,"Vacunación","Vacuna sextuple canina",18000.0,20,"/images/Vacunasextuplecanina.png"));
                Medicamento m3 = repo.save(new Medicamento(null,"Vacunación","Vacuna bivalente felina",15000.0,20,"/images/Vacunabivalentefelina.jpg"));
                Medicamento m4 = repo.save(new Medicamento(null,"Vacunación","Vacuna triple felina",17000.0,20,"/images/Vacunatriplefelina.jpg"));
                Medicamento m5 = repo.save(new Medicamento(null,"Vacunación","Vacuna Bordetella canina",14000.0,20,"/images/VacunaBordetellacanina.jpg"));
                Medicamento m6 = repo.save(new Medicamento(null,"Vacunación","Vacuna antirrábica felina",12000.0,20,"/images/vacuna-antirrabica-felina.jpg"));
                Medicamento m7 = repo.save(new Medicamento(null,"Antibióticos","Amoxibay 250mg",4200.0,20,"/images/amoxibay250mg.jpg"));
                Medicamento m8 = repo.save(new Medicamento(null,"Antibióticos","Enrox 50mg",6800.0,20,"/images/Enrox50mg.jpg"));
                Medicamento m9 = repo.save(new Medicamento(null,"Antibióticos","Metrobay 250mg",3900.0,20,"/images/metrobay-250mg.png"));
                Medicamento m10 = repo.save(new Medicamento(null,"Antiparasitarios","Nexgard",9500.0,20,"/images/Nexgard.jpg"));
                Medicamento m11 = repo.save(new Medicamento(null,"Antiparasitarios","Bravecto",18900.0,20,"/images/Bravecto.png"));
                Medicamento m12 = repo.save(new Medicamento(null,"Antiparasitarios","Revolution Plus",14500.0,20,"/images/revolution-plus.jpg"));
                Medicamento m13 = repo.save(new Medicamento(null,"Antiparasitarios","Drontal Plus",3200.0,20,"/images/drontal-plus.jpg"));
                Medicamento m14 = repo.save(new Medicamento(null,"Antiparasitarios","Milbemax Gato",6800.0,20,"/images/milbemax-gato.jpg"));
                Medicamento m15 = repo.save(new Medicamento(null,"Antiinflamatorios","Meloxicam 1mg",4500.0,20,"/images/meloxicam-1mg.jpeg"));
                Medicamento m16 = repo.save(new Medicamento(null,"Antiinflamatorios","Carprofen 50mg",9800.0,20,"/images/Carprofen50mg.png"));
                Medicamento m17 = repo.save(new Medicamento(null,"Dermatología","Clorhexidina shampoo",8900.0,20,"images/clorhexidina-shampoo.jpg"));
                Medicamento m18 = repo.save(new Medicamento(null,"Dermatología","Malaseb shampoo",12500.0,20,"/images/malaseb-shampoo.jpg"));
                Medicamento m19 = repo.save(new Medicamento(null,"Dermatología","Apoquel 16mg",22000.0,20,"/images/apoquel-16mg.jpg"));
                Medicamento m20 = repo.save(new Medicamento(null,"Dermatología","Probifor",5600.0,20,"/images/Probifor.jpeg"));
                Medicamento m21 = repo.save(new Medicamento(null,"Dermatología","Omeprazol 10mg vet",3800.0,20,"/images/omeprazol-10mg-vet.jpg"));
                Medicamento m22 = repo.save(new Medicamento(null,"Dermatología","Vetmedin 2.5mg",28000.0,20,"/images/vetmedin-2-5mg.jpg"));
                Medicamento m23 = repo.save(new Medicamento(null,"Analgésicos","Tramadol 50mg vet",5200.0,20,"/images/tramadol-50mg-vet.jpg"));
                Medicamento m24 = repo.save(new Medicamento(null,"Vacunas","Nobivac DHPPi",8500.0,20,"/images/nobivac-dhppi.png"));
                Medicamento m25 = repo.save(new Medicamento(null,"Vacunas","Nobivac Rabies",5800.0,20,"/images/nobivac-rabies.jpg"));
                Medicamento m26 = repo.save(new Medicamento(null,"Vacunas","Felocell CVR",7200.0,20,"/images/felocell-cvr.jpg"));
                Medicamento m27 = repo.save(new Medicamento(null,"Suplementos","Omega vet 3-6-9",9900.0,20,"/images/Omega.png"));
                Medicamento m28 = repo.save(new Medicamento(null,"Suplementos","Condrovet forte",14500.0,20,"/images/condrovetforte.jpg"));

            }
        };
    }

}
