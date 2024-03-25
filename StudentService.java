package com.example.admissionportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admissionportal.entity.Admission;
import com.example.admissionportal.entity.Payment;
import com.example.admissionportal.entity.Student;
import com.example.admissionportal.repository.AdmissionRepositorty;
import com.example.admissionportal.repository.PaymentRepository;
import com.example.admissionportal.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private AdmissionRepositorty arepo;
	
//	@Autowired
//	private StudentRepository srepo;
	
	@Autowired
	private PaymentRepository prepo;
	

	public boolean addAdmission(Admission admission) {
		// TODO Auto-generated method stub
		arepo.save(admission);
		return true;	
	}


	public boolean editAdmission(Admission admission, long admissionId) {
		// TODO Auto-generated method stub
		Optional<Admission> ad=arepo.findById(admissionId);
		if(ad!= null) {
			Admission a=ad.get();
			admission.setAdmissionId(a.getAdmissionId());
			arepo.save(admission);
			return true;
		}
		return false;
	}


	public List<Admission> viewAdmission(long studentId) {
		// TODO Auto-generated method stub\
		
		return arepo.findAllByStudentStudentId(studentId);
		
	}

//
//	public boolean addStudent(Student student) {
//		// TODO Auto-generated method stub
//		srepo.save(student);
//		return true;
//	}


	public boolean deleteAdmission(long admissionId) {
		// TODO Auto-generated method stub
		Optional<Admission> ad=arepo.findById(admissionId);
		if(ad!= null) {
		arepo.deleteById(admissionId);
		return true;
		}
		return false;
	}


	public boolean studentPayment(Payment payment) {
		// TODO Auto-generated method stub		
			prepo.save(payment);
			return true;
	
	}


	public Payment getStudentPayment(String status) {
		// TODO Auto-generated method stub
		Payment pay=prepo.getByStatus(status);
		return pay;
	}
	
	// student
	
	@Autowired
	private StudentRepository studentRepository;
	
//	public List<Student> getAllStudents() {
//		// TODO Auto-generated method stub
//		return studentRepository.findAll();
//	}

	public boolean addStudent(Student s) {
		if(s!=null)
		{
			studentRepository.save(s);
			return true;
		}
		return false;
	}

	public boolean updateStudent(Long studentId, Student s) {
		Student s1=studentRepository.findById(studentId).get();
		
		if(s1!=null)
		{
			s1.setAddress(s.getAddress());
			s1.setAge(s.getAge());
			return true;
		}
		return false;
	}

	public boolean deleteStudent(Long studentId) {
		if(studentRepository.findById(studentId)!=null)
		{
			studentRepository.deleteById(studentId);
			return true;
		}
		return false;
	}
	

}
