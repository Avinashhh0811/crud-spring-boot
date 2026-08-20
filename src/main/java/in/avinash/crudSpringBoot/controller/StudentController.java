package in.avinash.crudSpringBoot.controller;

import in.avinash.crudSpringBoot.entity.Student;
import in.avinash.crudSpringBoot.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")

public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }


    // Create Student
    @PostMapping("/create")
    public ResponseEntity<Student> createStudents(@RequestBody Student student){
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    //Read one studnet
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
      Student studentResp = studentService.getStudent(id);

      if(studentResp == null){
         // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
          /// OR
          return ResponseEntity.notFound().build();
      }

      return ResponseEntity.ok(studentResp);
    }

    //Get all
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList = studentService.getAllStudent();

        if(studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }
    //Update Student
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                @RequestBody Student studentReq){
        Student studentResp = studentService.updateStudent(id,studentReq);
        if(studentResp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }
    //Delete Student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        Boolean isDeleted = studentService.deleteStudent(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record Deleted.");
    }

}
