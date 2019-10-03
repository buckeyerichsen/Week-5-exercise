package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    PotluckRepository potluckRepository;

    @RequestMapping("/")
    public String listPotlucks(Model model){
        model.addAttribute("potlucks", potluckRepository.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String potluckForm(Model model) {
        model.addAttribute("potluck", new Potluck());
        return "potluckform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Potluck potluck,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "potluckform";
        }
        potluckRepository.save(potluck);
        return "redirect:/";
    }

        @RequestMapping("/detail/{id}")
        public String showPotluck(@PathVariable("id") long id, Model model)
        {
            model.addAttribute("potluck", potluckRepository.findById(id).get());
            return "show";
        }

        @RequestMapping("/update/{id}")
        public String updatePotluck(@PathVariable("id") long id,
        Model model){
            model.addAttribute("potluck", potluckRepository.findById(id).get());
            return "potluckform";
        }

        @RequestMapping("/delete/{id}")
        public String delPotluck(@PathVariable("id") long id){
            potluckRepository.deleteById(id);
            return "redirect:/";
        }
    }