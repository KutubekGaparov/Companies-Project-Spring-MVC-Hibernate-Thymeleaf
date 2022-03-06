package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Student;
import peaksoft.model.Teacher;
import peaksoft.service.interfase.GroupService;
import peaksoft.service.interfase.StudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;
    private final GroupService groupService;

    @Autowired
    public StudentController(StudentService service, GroupService groupService) {
        this.service = service;
        this.groupService = groupService;
    }

    @GetMapping()
    public String index(@RequestParam("groupId") Long groupId ,Model model) {
        List<Student> students = new ArrayList<>();
        try{
            for(Student i : service.getAllStudent()){
                if(i.getGroups().getId().equals(groupId)){
                    students.add(i);
                }
            }
        }
        catch(NullPointerException e){
            System.out.println("It is empty!");
        }

        model.addAttribute("students", students);
        return "/student/student-page";
    }

    @GetMapping("/new")
    public String saveStudent(@RequestParam("groupId") Long groupId,Model model) {
        model.addAttribute("student", new Student());
        return "/student/newStudent";
    }

    @PostMapping("/save")
    public String createStudent(@ModelAttribute("student") Student student, @RequestParam("groupId") Long id) {
        student.setGroups(groupService.getById(id));
        service.saveStudent(student);
        return "redirect:/students?groupId"+id;
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("student", service.getById(id));
        return "/student/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("student") Student student, @PathVariable("id") Long id) {
        service.updateStudent(id, student);
        return "redirect:/students";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.removeStudentById(id);
        return "redirect:/students";
    }
}
