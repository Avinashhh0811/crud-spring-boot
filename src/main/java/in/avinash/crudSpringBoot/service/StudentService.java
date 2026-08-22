package in.avinash.crudSpringBoot.service;
import in.avinash.crudSpringBoot.entity.Student;
import in.avinash.crudSpringBoot.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }
    //Creating student logic
    public Student createStudent(Student studentReq){
      Student studentResp = studentRepository.save(studentReq);
      return studentResp;
    }

    //Get one student

    public  Student getStudent(Long id){
        Optional<Student> studentResp = studentRepository.findById(id);
        if(studentResp.isPresent()){
            return studentResp.get();
        }
        return null;
    }

    public List<Student> getAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }


public Student updateStudent(Long id,Student studentReq){
        Optional<Student> existingStud = studentRepository.findById(id);
        if(existingStud.isEmpty()){
            return null;
        }
        Student studentToSave = existingStud.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setMobileNo(studentReq.getMobileNo());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setRollNo(studentReq.getRollNo());

       return studentRepository.save(studentToSave);
}
public Boolean deleteStudent(Long id){
       Boolean isStudent = studentRepository.existsById(id);
        if(!isStudent) return false;
        studentRepository.deleteById(id);
        return true;
}

}
