package pe.edu.cibertec.DAWI_CL1_GRUPO_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_GRUPO_1.model.NumbersModel;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NumbersController {
    @GetMapping("/calcularPares")
    public String index(Model model){
        model.addAttribute("numbersmodel", new NumbersModel(20, 10));
        model.addAttribute("verresultado", false);
        return "formNumbers";
    }

    @PostMapping("/calcularPares")
    public String calcularPares(@ModelAttribute("numbersmodel") NumbersModel numbersmodel, Model model){
        List<Integer> pares = new ArrayList<>();
        for (int i = numbersmodel.getStart(); i >= numbersmodel.getEnd(); i--) {
            if (i % 2 == 0) {
                pares.add(i);
            }
        }
        model.addAttribute("verresultado", true);
        model.addAttribute("resultado", "Los números pares son: " + pares.toString());
        return "formNumbers";
    }


}
