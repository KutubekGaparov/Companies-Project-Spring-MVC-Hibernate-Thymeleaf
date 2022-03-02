package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Company;
import peaksoft.service.interfase.CompanyService;

@Controller
@RequestMapping("/run")
public class CompanyController {

    private final CompanyService service;

    @Autowired
    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("run", service.getAllCompany());
        return "/company/index";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("show", service.getById(id));
        return "/company/show";
    }

    @GetMapping("/new")
    public String company(Model model) {
        model.addAttribute("company", new Company());
        return "/company/addCompany";
    }

    @PostMapping("/save")
    public String getCompany(@ModelAttribute("company") Company company) {
        service.saveCompany(company);
        return "redirect:/run";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("company", service.getById(id));
        return "/company/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("company") Company company, @PathVariable("id") long id) {
        service.update(id, company);
        return "redirect:/run";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        service.removeCompanyById(id);
        return "redirect:/run";
    }

}
