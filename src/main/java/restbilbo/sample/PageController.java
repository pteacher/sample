package restbilbo.sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {
    private final EmployeeRepository repository;

    public PageController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping ("/")
    public String main(){
        return "index"; // you should have thymeleaf dependency installed
    }

    @GetMapping ("/add")
    public String addForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add";
    }

    @PostMapping ("/add")
    public String postForm(@ModelAttribute Employee employee, Model model) {
        model.addAttribute("employee", employee);
        repository.save(employee);
        return "result";
    }
}
