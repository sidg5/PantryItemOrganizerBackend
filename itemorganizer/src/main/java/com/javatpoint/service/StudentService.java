package com.javatpoint.service;

import com.javatpoint.model.Student;

import com.javatpoint.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


//defining the business logic
@Service public class StudentService {
    @Autowired StudentRepository studentRepository;

//getting all student records
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<Student>();
        studentRepository.findAll().forEach(student -> students.add(student));

        return students;
    }

//getting a specific record
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    public List<Integer> saveOrUpdate(List<Student> students) {
        List<Integer> ids = new ArrayList<Integer>();

        for (Student student : students) {
            Student savedStudent = studentRepository.save(student);

            ids.add(savedStudent.getId());
        }

        return ids;
    }

//deleting a specific record
    public void delete(int id) {
        studentRepository.deleteById(id);
    }
}
