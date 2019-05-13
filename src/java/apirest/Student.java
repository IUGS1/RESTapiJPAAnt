/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apirest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ivan
 */

@Entity
@Table(name = "STUDENT")
public class Student {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "STUDENTID")
  private long studentId;
  @Column(name = "STUDENTNAME")
  private String studentName;

  public void setStudentId(long studentId) {
    this.studentId = studentId;
  }

  public long getStudentId() {
    return studentId;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getStudentName() {
    return studentName;
  }
}
