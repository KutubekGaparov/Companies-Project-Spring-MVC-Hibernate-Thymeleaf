package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Student;
import peaksoft.service.interfase.StudentService;

@Controller
@RequestMapping("/xaxa")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("xaxa", service.getAllStudent());
        return "/student/index";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("show", service.getById(id));
        return "/student/show";
    }

    @GetMapping("/new")
    public String company(Model model) {
        model.addAttribute("student", new Student());
        return "/student/addStudent";
    }

    @PostMapping("/save")
    public String getCompany(@ModelAttribute("student") Student student) {
        service.saveStudent(student);
        return "redirect:/xaxa";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("student", service.getById(id));
        return "/student/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("student") Student student, @PathVariable("id") long id) {
        service.updateStudent(id, student);
        return "redirect:/xaxa";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        service.removeStudentById(id);
        return "redirect:/xaxa";
    }
}
