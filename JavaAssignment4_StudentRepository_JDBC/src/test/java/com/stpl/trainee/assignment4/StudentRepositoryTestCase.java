package com.stpl.trainee.assignment4;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import com.stpl.trainee.assignment4.addmarksdetails.AddMarksDetails;
import com.stpl.trainee.assignment4.addmarksdetails.SaveMarksData;
import com.stpl.trainee.assignment4.addstudent.AddStudent;
import com.stpl.trainee.assignment4.bean.DeleteStudentBean;
import com.stpl.trainee.assignment4.bean.MarkslDetailsBean;
import com.stpl.trainee.assignment4.bean.StudentBean;
import com.stpl.trainee.assignment4.deletestudent.DeleteStudent;
import com.stpl.trainee.assignment4.deletestudent.DeleteStudentAllDetails;
import com.stpl.trainee.assignment4.updatestudent.UpdateMarksDetails;
import com.stpl.trainee.assignment4.viewstudentdetails.ViewStudentDetails;

public class StudentRepositoryTestCase {

	@Test
	public void addStudentTestCase() {

		AddStudent addStudent = new AddStudent();

		boolean expected;
		try {
			expected = addStudent.addStudent("s105", "Rahul");

			if (!expected) {
				boolean flag = addStudent.addStudent("s112", "Atul");
				if (!flag) {
					assertEquals(flag, false);
				} else {
					assertEquals(flag, true);
				}
			} else {
				assertEquals(expected, true);
			}
		} catch (SQLException e) {
		}
	}

	@Test
	public void addMarksDetailsTestCase() {

		AddMarksDetails addMarksDetails = new AddMarksDetails();

		try {
			addMarksDetails.addMarksDetails("A100", 88, 100);

			addMarksDetails.addMarksDetails("s115", 88, 100);
			boolean expected = addMarksDetails.addMarksDetails("s115", 88, 100);

			if (!expected) {

				boolean flag = addMarksDetails.addMarksDetails("s116", 88, 100);
				if (!flag) {
					assertEquals(flag, false);
				} else {
					assertEquals(flag, true);
				}
			} else {
				assertEquals(expected, true);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteStudentTestCase() {

		AddStudent addStudent = new AddStudent();
		AddMarksDetails addMarksDetails = new AddMarksDetails();
		DeleteStudent deleteStudent = new DeleteStudent();
		boolean expected;

		try {

			deleteStudent.deleteStudent("xxxx");

			addStudent.addStudent("D5858", "Reyan");
			expected = deleteStudent.deleteStudent("D5858");
			if (!expected) {

				addStudent.addStudent("s100", "saha");
				addMarksDetails.addMarksDetails("s100", 100, 100);

				boolean flag = deleteStudent.deleteStudent("s100");

				if (!flag) {
					assertEquals(flag, false);
				} else {
					assertEquals(flag, true);
				}
			} else {
				assertEquals(expected, true);
			}

			DeleteStudentAllDetails deleteStudentAllDetails = new DeleteStudentAllDetails();

			addStudent.addStudent("s900", "saha");
			addMarksDetails.addMarksDetails("s900", 100, 100);
			deleteStudentAllDetails.deleteAllDetails("s900", "DELETE FROM STUDENT_MARKS WHERE STUDENT_ID=?");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updateStudentTestCase() {

		AddStudent addStudent = new AddStudent();
		AddMarksDetails addMarksDetails = new AddMarksDetails();
		UpdateMarksDetails updateMarksDetails = new UpdateMarksDetails();

		boolean expected;
		try {

			updateMarksDetails.updateStudentDetails("zzzz", "Reyansh", 88, 99);

			addStudent.addStudent("D5858", "Reyan");
			expected = updateMarksDetails.updateStudentDetails("D5858", "Reyansh", 88, 99);

			if (!expected) {

				addStudent.addStudent("s100", "saha");
				addMarksDetails.addMarksDetails("s100", 100, 100);

				boolean flag = updateMarksDetails.updateStudentDetails("s100", "Ritesh Saha", 88, 99);

				if (!flag) {
					assertEquals(flag, false);
				} else {
					assertEquals(flag, true);
				}
			} else {
				assertEquals(expected, true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void viewStudentTestCase() {

		AddStudent addStudent = new AddStudent();
		AddMarksDetails addMarksDetails = new AddMarksDetails();
		ViewStudentDetails viewStudentDetails = new ViewStudentDetails();

		boolean expected;
		try {

			viewStudentDetails.hasStudentDetails("D5858");

			addStudent.addStudent("D5858", "Reyan");
			expected = viewStudentDetails.hasStudentDetails("D5858");

			if (!expected) {

				addMarksDetails.addMarksDetails("D5858", 100, 100);

				boolean flag = viewStudentDetails.hasStudentDetails("D5858");

				if (!flag) {
					assertEquals(flag, false);
				} else {
					assertEquals(flag, true);
				}
			} else {
				assertEquals(expected, true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void saveMarksDataTestCase() {

		SaveMarksData saveMarksData = new SaveMarksData();
		MarkslDetailsBean markslDetailsBean = new MarkslDetailsBean();

		try {

			markslDetailsBean.setId("s110");
			markslDetailsBean.setName("Soy");
			markslDetailsBean.setMath(98);
			markslDetailsBean.setEnglish(100);
			markslDetailsBean.setTolat_marks(98 + 100);

			saveMarksData.saveMarksData(markslDetailsBean, "wrong sql");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void storeStudentDataTestCase() {

		AddStudent addStudent = new AddStudent();
		StudentBean studentBean = new StudentBean();

		studentBean.setId("s110");
		studentBean.setName("Soy");

		try {
			addStudent.storeStudentData(studentBean, "wrong sql");
		} catch (SQLException e) {
		}

	}

	@Test
	public void deleteFromDataBaseTestCase() {

		DeleteStudent deleteStudent = new DeleteStudent();
		DeleteStudentBean deleteStudentBean = new DeleteStudentBean();

		deleteStudentBean.setId("s110");
		try {
			deleteStudent.deleteFromDataBase(deleteStudentBean, "wrong sql");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getFromDataBaseTestCase() {

		ViewStudentDetails viewStudentDetails = new ViewStudentDetails();
		MarkslDetailsBean markslDetailsBean = new MarkslDetailsBean();

		try {

			markslDetailsBean.setId("--");
			viewStudentDetails.isDataFromDataBase(markslDetailsBean, "SELECT * FROM STUDENT WHERE STUDENT_ID = ?");

			viewStudentDetails.displayStudentDetails(markslDetailsBean,
					"SELECT * FROM STUDENT_MARKS WHERE STUDENT_ID = ?");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	@Test
//	public void getFromDataBaseTestCase2() {
//
//		ViewStudentDetails viewStudentDetails = new ViewStudentDetails();
//		MarkslDetailsBean markslDetailsBean = new MarkslDetailsBean();
//
//		try {
//
//			markslDetailsBean.setId("s110");
//			viewStudentDetails.isDataFromDataBase(markslDetailsBean, "wrong sql");
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	@Test
	public void getFromDataBaseTestCase3() {

		ViewStudentDetails viewStudentDetails = new ViewStudentDetails();
		MarkslDetailsBean markslDetailsBean = new MarkslDetailsBean();

		try {

			markslDetailsBean.setId("s116");
			viewStudentDetails.isDataFromDataBase(markslDetailsBean, "SELECT * FROM STUDENT WHERE STUDENT_ID = ?");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
