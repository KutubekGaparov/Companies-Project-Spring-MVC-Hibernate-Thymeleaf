package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Course;
import peaksoft.service.interfase.CompanyService;
import peaksoft.service.interfase.CourseService;
import peaksoft.service.interfase.TeacherService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("courses")
public class CourseController {

   private final CompanyService companyService;
    private final CourseService service;


    @Autowired
    public CourseController(CompanyService companyService, CourseService service) {
        this.companyService = companyService;
        this.service = service;
    }

    @GetMapping()
    public String getCourses(@RequestParam("companyId") Long companyId,Model model) {
        List<Course> courses = new ArrayList<>();
        try{
            for(Course i : service.getAllCourse()){
                if(i.getCompany().getId().equals(companyId)){
                    courses.add(i);
                }
            }
        }
        catch(NullPointerException e){
            System.out.println("It is empty!");
        }
        model.addAttribute("course", courses);
        return "/course/course_page";
    }

    @GetMapping("/newCourse")
    public String newCourse(@RequestParam("companyId") Long companyId, Model model) {
        model.addAttribute("course", new Course());
        return "/course/addCourse";
    }

    @PostMapping("/save")
    public String saveCourse( @ModelAttribute("course") Course course,@RequestParam("companyId") Long id) {
        course.setCompany(companyService.getById(id));
        service.saveCourse(course);
        return "redirect:/courses?companyId="+id;
    }

    @GetMapping("/{id}/edit")
    public String getById(Model model, @PathVariable("id") Long id) {
        model.addAttribute("course", service.getById(id));
        return "/course/update";
    }

    @PatchMapping("/{id}")
    public String updateCourse(@ModelAttribute("course") Course course, @PathVariable("id") Long id) {
        service.updateCourse(id, course);
        return "redirect:/courses";
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable("id") Long id) {
        service.removeCourseById(id);
        return "redirect:/courses";
    }

}
