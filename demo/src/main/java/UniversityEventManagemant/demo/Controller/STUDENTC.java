package UniversityEventManagemant.demo.Controller;


import UniversityEventManagemant.demo.Model.Department;
import UniversityEventManagemant.demo.Model.Student;
import UniversityEventManagemant.demo.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/student")

public class STUDENTC {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public String addStudent(@Valid @RequestBody List<Student> students){
        studentService.addStudentList(students);
        return "Added succesfully";
    }

    @PutMapping("/id/{studentId}/dept/{department}")
    public String updateDept(@PathVariable int studentId, @PathVariable Department department){
        return studentService.updateDepartment(studentId,department);
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudentById(@PathVariable int studentId){
        return studentService.deleteStudentById(studentId);
    }
}

