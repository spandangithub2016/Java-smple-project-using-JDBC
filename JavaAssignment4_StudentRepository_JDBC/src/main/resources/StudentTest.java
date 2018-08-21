// default package
// Generated Jun 28, 2018 3:46:40 PM by Hibernate Tools 3.6.0.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * StudentTest generated by hbm2java
 */
@Entity
@Table(name = "studentTest", schema = "dbo", catalog = "BPIGTN_AGN_APP_DEV")
public class StudentTest implements java.io.Serializable {

	private StudentTestId id;

	public StudentTest() {
	}

	public StudentTest(StudentTestId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id", length = 20)),
			@AttributeOverride(name = "name", column = @Column(name = "name", length = 50)),
			@AttributeOverride(name = "marks", column = @Column(name = "marks")) })
	public StudentTestId getId() {
		return this.id;
	}

	public void setId(StudentTestId id) {
		this.id = id;
	}

}