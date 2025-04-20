package com.pranjal.GarageBillingSystem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToInvoice() {
        return "redirect:/index.html";
    }
}