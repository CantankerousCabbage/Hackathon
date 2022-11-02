package app;

/**
 * Class represeting a LGA from the Studio Project database
 * In the template, this only uses the code and name for 2016
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 */
public class Student {
   
   private int studentNumber;

  
   private String studentName;

  
   public Student(int studentNumber, String studentName) {
      this.studentNumber = studentNumber;
      this.studentName = studentName;
   }

   public int getStudentNumber() {
      return studentNumber;
   }

   public String getStudentName() {
      return studentName;
   }
}

