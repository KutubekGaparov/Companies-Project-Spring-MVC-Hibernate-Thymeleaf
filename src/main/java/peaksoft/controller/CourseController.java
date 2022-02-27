package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Course;
import peaksoft.service.interfase.CourseService;

@Controller
@RequestMapping("/")
public class CourseController {

    private  CourseService service;

    @Autowired
    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("new",service.getAllCourse());
        return "/course/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("show", service.getById(id));
        return "/course/show";
    }


    @GetMapping("/new")
    public String company(Model model){
        model.addAttribute("course",new Course());
        return "/course/newCourse";
    }

    @PostMapping("/save")
    public String getCompany(@ModelAttribute("course") Course course) {
        service.saveCourse(course);
        return "redirect:/run";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("course", service.getById(id));
        return "/course/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("course")  Course course ,@PathVariable("id") long id) {
        service.updateCourse( course);
        return "redirect:/run";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id" ) int id){
        service.removeCourseById(id);
        return "redirect:/run";
    }

}
