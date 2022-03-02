package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Group;
import peaksoft.service.interfase.GroupService;

@Controller
@RequestMapping("/groups")
public class GroupController {

    private final GroupService service;

    @Autowired
    public GroupController(GroupService service) {
        this.service = service;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("addGroup", service.getAllGroup());
        return "/group1/index";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("newGr", service.getById(id));
        return "/group1/show";
    }

    @GetMapping("/newGroups")
    public String company(Model model) {
        model.addAttribute("groups", new Group());
        return "/group1/newGroup";
    }

    @PostMapping("/saveGr")
    public String getCompany(@ModelAttribute("groups") Group group) {
        service.saveGroup(group);
        return "redirect:/groups";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("groups", service.getById(id));
        return "/group1/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("groups") Group group, @PathVariable("id") long id) {
        service.updateGroup(id, group);
        return "redirect:/groups";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        service.removeGroupById(id);
        return "redirect:/groups";
    }

}
