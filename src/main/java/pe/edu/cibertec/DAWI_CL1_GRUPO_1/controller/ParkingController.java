package pe.edu.cibertec.DAWI_CL1_GRUPO_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_GRUPO_1.model.ParkingModel;

@Controller
public class ParkingController {

    @GetMapping("/calcularTarifa")
    public String index(Model model){
        model.addAttribute("parkingmodel", new ParkingModel());
        model.addAttribute("verresultado", false);
        return "formParking";
    }

    @PostMapping("/calcularTarifa")
    public String calcularTarifa(@ModelAttribute("parkingmodel") ParkingModel parkingmodel, Model model){
        Double tarifa = 1500.0;
        Integer horas = (parkingmodel.getHoras() != null) ? parkingmodel.getHoras() : 0;
        Integer minutos = (parkingmodel.getMinutos() != null) ? parkingmodel.getMinutos() : 0;
        Double total = (horas + (minutos > 0 ? 1 : 0)) * tarifa;
        model.addAttribute("verresultado", true);
        model.addAttribute("resultado", "Debe pagar: S/." + String.format("%.2f", total));
        return "formParking";
    }
}
