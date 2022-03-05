package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Course;
import peaksoft.model.Teacher;
import peaksoft.service.interfase.CourseService;
import peaksoft.service.interfase.TeacherService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService service;
    private final CourseService courseService;

    @Autowired
    public TeacherController(TeacherService service, CourseService courseService) {
        this.service = service;
        this.courseService = courseService;
    }

    @GetMapping()
    public String index(@RequestParam("courseId") Long courseId,Model model) {
        List<Teacher> teachers = new ArrayList<>();
        try{
            for(Teacher i : service.getAllTeacher()){
                if(i.getCourse().getId().equals(courseId)){
                    teachers.add(i);
                }
            }
        }
        catch(NullPointerException e){
            System.out.println("It is empty!");
        }
        model.addAttribute("teachers", teachers);
        return "/teacher/teacher-page";
    }

    @GetMapping("/newTeacher")
    public String company(@RequestParam("courseId") Long courseId,Model model) {
        model.addAttribute("teacher", new Teacher());
        return "/teacher/newTeacher";
    }

    @PostMapping("/save")
    public String getCompany(@ModelAttribute("teacher") Teacher teacher,@RequestParam("courseId") Long id) {
        teacher.setCourse(courseService.getById(id));
        service.saveTeacher(teacher);
        return "redirect:/teachers?courseId="+id;
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id ) {
        model.addAttribute("teacher", service.getById(id));
        return "/teacher/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("teacher") Teacher teacher, @PathVariable("id") Long id) {
        service.updateTeacher(id, teacher);
        return "redirect:/teachers";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.removeTeacherById(id);
        return "redirect:/teachers";
    }
}
