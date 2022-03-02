package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Company;
import peaksoft.model.Course;
import peaksoft.service.interfase.CourseService;

@Controller
@RequestMapping("/api")
public class CourseController {

    private final CourseService service;

    @Autowired
    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("axa", service.getAllCourse());
        return "/course/index";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("show", service.getById(id));
        return "/course/show";
    }

    @GetMapping("/news")
    public String company(Model model) {
        model.addAttribute("course", new Course());
        return "/course/newCourse";
    }

    @PostMapping("/save")
    public String getCompany(@ModelAttribute("course") Course course, @RequestParam("idCompany") Company company ) {

        course.setCompany(company);
        service.saveCourse(course);
        return "redirect:/api";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("course", service.getById(id));
        return "/course/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("course") Course course, @PathVariable("id") long id) {
        service.updateCourse(id, course);
        return "redirect:/api";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        service.removeCourseById(id);
        return "redirect:/api";
    }

}
