package pe.edu.cibertec.DAWI_CL1_GRUPO_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_GRUPO_1.model.ProductModel;

@Controller
public class ProductController {
    @GetMapping("/calcularTotal")
    public String index(Model model){
        model.addAttribute("productmodel", new ProductModel());
        model.addAttribute("verresultado", false);
        return "formProduct";
    }
    @PostMapping("/calcularTotal")
    public String calcularTotal(@ModelAttribute("productmodel") ProductModel productmodel, Model model){
        Double total = productmodel.getCantidad() * productmodel.getPrecio();
        if (total > 200) {
            total = total * 0.8;  // Aplicar descuento del 20%
        }
        model.addAttribute("verresultado", true);
        model.addAttribute("resultado", "El total a pagar es: $" + String.format("%.2f", total));
        return "formProduct";
    }
}
