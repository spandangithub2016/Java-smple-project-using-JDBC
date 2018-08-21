package com.stpl.trainee.assignment4.main;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.stpl.trainee.assignment4.addmarksdetails.AddMarksDetails;
import com.stpl.trainee.assignment4.addstudent.AddStudent;
import com.stpl.trainee.assignment4.deletestudent.DeleteStudent;
import com.stpl.trainee.assignment4.updatestudent.UpdateMarksDetails;
import com.stpl.trainee.assignment4.viewstudentdetails.ViewStudentDetails;

public class Main {

    private static final Logger LOGGER = LogManager.getFormatterLogger(Main.class);
    private static String studentId;
    private static final String MESSAGE = "Enter Student Id: ";
    private static int choice;

    private Main() {
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        AddStudent addStudent = new AddStudent();
        AddMarksDetails addMarksDetails = new AddMarksDetails();
        DeleteStudent deleteStudent = new DeleteStudent();
        ViewStudentDetails viewStudentDetails = new ViewStudentDetails();
        UpdateMarksDetails updateMarksDetails = new UpdateMarksDetails();
        
        try {

            do {

                LOGGER.info("1. Add Student Details");
                LOGGER.info("2. Insert Student Marks Details");
                LOGGER.info("3. View Student Details");
                LOGGER.info("4. Delete Existing Student Details");
                LOGGER.info("5. Update Student Details");
                LOGGER.info("6. Exit");

                LOGGER.info("Enter Your Choice: ");
                choice = scan.nextInt();

                switch (choice) {
                case 1:
                    LOGGER.info("Enter Student Id & Name: ");
                    String id = scan.next().toUpperCase();
                    scan.nextLine();
                    addStudent.addStudent(id, scan.nextLine().toUpperCase());
                    break;
                case 2:
                	LOGGER.info("Enter Student Id: ");
                	id = scan.next().toUpperCase();
                	
                	LOGGER.info("Enter math Mark: ");
    				int math = scan.nextInt();
    				
    				LOGGER.info("Enter English Mark: ");
    				int english = scan.nextInt();
    				
                    addMarksDetails.addMarksDetails(id, math, english);
                    break;
                case 3:
                	LOGGER.info("Enter Student Id: ");
                    id = scan.next().toUpperCase();
                    viewStudentDetails.hasStudentDetails(id);
                    break;
                case 4:
                    LOGGER.info(MESSAGE);
                    studentId = scan.next().toUpperCase();
                    deleteStudent.deleteStudent(studentId);
                    break;
                case 5:
                    LOGGER.info(MESSAGE);
                    id = scan.next().toUpperCase();
                    
                    LOGGER.info("Enter Student Name: ");
                    scan.nextLine();
                    String name = scan.nextLine();
                    
                    LOGGER.info("Enter math Mark: ");
    				math = scan.nextInt();
    				
    				LOGGER.info("Enter English Mark: ");
    				english = scan.nextInt();
    				
                    updateMarksDetails.updateStudentDetails(id, name, math, english);
                    break;
                case 6:
                    LOGGER.info("Bye..!");
                    break;
                default:
                    LOGGER.info("please choice item from menu");

                }

            } while (choice != 6);
            
            scan.close();
        } 
        catch (InputMismatchException | SQLException e) {
            LOGGER.info("Please Enter integer value...! " + e);
        } 
    }

}
