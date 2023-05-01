package UniversityEventManagemant.demo.Service;


import UniversityEventManagemant.demo.Model.Student;
import UniversityEventManagemant.demo.Repository.IStudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudentRepo studentDao;
    public List<Student> getAllStudent() {
        return (List<Student>) studentDao.findAll();
    }

    public void addStudentList(List<Student> students) {
        studentDao.saveAll(students);
    }

    @Transactional
    public String updateDepartment(int studentId, Department department) {
        String departmentString = department.name();
        studentDao.updateDepartment(studentId,departmentString);
        return "Updated successfully";

    }

    public String deleteStudentById(int studentId) {
        studentDao.deleteById(studentId);
        return "Deleted Successfully";
    }

    public Student getStudentById(int studentId) {
        Optional<Student> stud= studentDao.findById(studentId);
        return stud.isPresent()? stud.get():null;
    }
}

