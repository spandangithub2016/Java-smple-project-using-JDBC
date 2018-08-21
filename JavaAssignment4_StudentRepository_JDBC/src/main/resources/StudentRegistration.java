// default package
// Generated Jul 5, 2018 11:56:26 AM by Hibernate Tools 3.6.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * StudentRegistration generated by hbm2java
 */
@Entity
@Table(name = "STUDENT_REGISTRATION", schema = "dbo", catalog = "BPIGTN_AGN_APP_DEV")
public class StudentRegistration implements java.io.Serializable {

	private String username;
	private String fullname;
	private String pasword;
	private String address;
	private String dob;
	private String gender;
	private String email;
	private String contact;

	public StudentRegistration() {
	}

	public StudentRegistration(String username) {
		this.username = username;
	}

	public StudentRegistration(String username, String fullname, String pasword, String address, String dob,
			String gender, String email, String contact) {
		this.username = username;
		this.fullname = fullname;
		this.pasword = pasword;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.contact = contact;
	}

	@Id

	@Column(name = "USERNAME", unique = true, nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "FULLNAME", length = 50)
	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Column(name = "PASWORD", length = 50)
	public String getPasword() {
		return this.pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	@Column(name = "ADDRESS", length = 500)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "DOB", length = 20)
	public String getDob() {
		return this.dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Column(name = "GENDER", length = 10)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "EMAIL", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "CONTACT", length = 20)
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
