/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apirest;

import javax.persistence.EntityManager;

/**
 *
 * @author Ivan
 */
public class JPAExample {
    private EntityManager entityManager;
    
    public JPAExample () {
        entityManager = EntityManagerUtil.getEntityManager();
    }
    
    public Student saveStudent(String studentName) {
    Student student = new Student();
    try {
      entityManager.getTransaction().begin();
      student.setStudentName(studentName);
      student = entityManager.merge(student);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
    }
    return student;
  }
    
}
