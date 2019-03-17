package pl.mati.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ProductController {

    private List<Product> productsList;

    public ProductController() {
        productsList = new ArrayList<>();
    }

    public double sumPrice(List<Product> productsList) {
        double sum = 0;
        for (Product product : productsList) {
            sum = sum + product.getPrice();
        }
        return sum;
    }

    public String printSum() {
        String sum = String.valueOf(sumPrice(productsList));
        return sum;
    }

    @GetMapping("/")
    public String formPage(Model model) {
        model.addAttribute("productsList", productsList);
        model.addAttribute("newProduct", new Product());
        return "homepage";
    }

    @PostMapping("/")
    public String add(Product product) {
        productsList.add(product);
        return "redirect:/";
    }

    @GetMapping("/listpage")
    public String listPage(Model model) {
        model.addAttribute("productsList", productsList);
        model.addAttribute("newProduct", new Product());
        model.addAttribute("suma", printSum());
        return "listpage";
    }

    @GetMapping("/tablepage")
    public String tablePage(Model model) {
        model.addAttribute("productsList", productsList);
        model.addAttribute("newProduct", new Product());
        model.addAttribute("suma", printSum());
        return "tablepage";
    }
}
