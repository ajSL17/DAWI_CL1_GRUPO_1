package pe.edu.cibertec.DAWI_CL1_GRUPO_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_GRUPO_1.model.GradesModel;

import java.util.Arrays;
@Controller
public class GradesController {
    @GetMapping("/calcularPromedio")
    public String index(Model model){
        model.addAttribute("gradesmodel", new GradesModel());
        model.addAttribute("verresultado", false);
        return "formGrades";
    }
    @PostMapping("/calcularPromedio")
    public String calcularPromedio(@ModelAttribute("gradesmodel") GradesModel gradesmodel, Model model){
        Double[] notas = {gradesmodel.getNota1(), gradesmodel.getNota2(), gradesmodel.getNota3(), gradesmodel.getNota4()};
        Arrays.sort(notas);
        Double promedio = notas[1]*0.2 + notas[2]*0.3 + notas[3]*0.5;
        model.addAttribute("verresultado", true);
        model.addAttribute("resultado", "El promedio es: " + String.format("%.2f", promedio));
        return "formGrades";
    }
}
