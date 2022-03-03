package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Course;
import peaksoft.service.interfase.CompanyService;
import peaksoft.service.interfase.CourseService;

@Controller
@RequestMapping("/api")
public class CourseController {

   private final CompanyService companyService;
    private final CourseService service;

    @Autowired
    public CourseController(CompanyService companyService, CourseService service) {
        this.companyService = companyService;
        this.service = service;
    }

    @GetMapping()
    public String getAllCourse(Model model) {
        model.addAttribute("courses", service.getAllCourse());
        return "/course/course_page";
    }

    @GetMapping("/newCourse")
    public String newCourse(Model model) {
        model.addAttribute("course", new Course());
        return "/course/addCourse";
    }

    @PostMapping("/save")
    public String saveCourse( @ModelAttribute("course") Course course/*,@RequestParam("companyId") Long id*/) {
//        course.setCompany(companyService.getById(id));
        service.saveCourse(course);
        return "redirect:/api"/*+id*/;
    }

    @GetMapping("/{id}/edit")
    public String getById(Model model, @PathVariable("id") long id) {
        model.addAttribute("course", service.getById(id));
        return "/course/update";
    }

    @PatchMapping("/{id}")
    public String updateCourse(@ModelAttribute("course") Course course, @PathVariable("id") long id) {
        service.updateCourse(id, course);
        return "redirect:/api";
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable("id") long id) {
        service.removeCourseById(id);
        return "redirect:/api";
    }

}
