package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Teacher;
import peaksoft.service.interfase.TeacherService;

@Controller
@RequestMapping("/good")
public class TeacherController {

    private final TeacherService service;

    @Autowired
    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("good", service.getAllTeacher());
        return "/teacher/teacher-page";
    }

    @GetMapping("/newTeacher")
    public String company(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "/teacher/newTeacher";
    }

    @PostMapping("/save")
    public String getCompany(@ModelAttribute("teacher") Teacher teacher) {
        service.saveTeacher(teacher);
        return "redirect:/good";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("teacher", service.getById(id));
        return "/teacher/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("teacher") Teacher teacher, @PathVariable("id") long id) {
        service.updateTeacher(id, teacher);
        return "redirect:/good";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        service.removeTeacherById(id);
        return "redirect:/good";
    }
}
