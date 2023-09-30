package pe.edu.cibertec.DAWI_CL1_GRUPO_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_GRUPO_1.model.BirthYearModel;
@Controller
public class DniController {
    @GetMapping("/verificarDni")
    public String index(Model model){
        model.addAttribute("birthyearmodel", new BirthYearModel());
        model.addAttribute("verresultado", false);
        return "formDni";
    }
    @PostMapping("/verificarDni")
    public String verificarDni(@ModelAttribute("birthyearmodel") BirthYearModel birthyearmodel, Model model){
        int currentYear = java.time.Year.now().getValue();
        String resultado = (currentYear - birthyearmodel.getBirthYear() >= 18) ? "Debe sacar su DNI." : "No necesita sacar su DNI aún.";
        model.addAttribute("verresultado", true);
        model.addAttribute("resultado", resultado);
        return "formDni";
    }
}
