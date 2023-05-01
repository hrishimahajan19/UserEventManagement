package UniversityEventManagemant.demo.Repository;


import UniversityEventManagemant.demo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends CrudRepository<Student,Integer> {


    @Modifying
    @Query(value = "Update Student set Department = :departmentString where Student_Id =:studentId",nativeQuery = true)
    void updateDepartment(int studentId, String departmentString);
}


