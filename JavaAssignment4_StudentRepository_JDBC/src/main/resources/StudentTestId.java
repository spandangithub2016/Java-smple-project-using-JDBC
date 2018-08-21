// default package
// Generated Jun 28, 2018 3:46:40 PM by Hibernate Tools 3.6.0.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * StudentTestId generated by hbm2java
 */
@Embeddable
public class StudentTestId implements java.io.Serializable {

	private String id;
	private String name;
	private Integer marks;

	public StudentTestId() {
	}

	public StudentTestId(String id, String name, Integer marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	@Column(name = "id", length = 20)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "marks")
	public Integer getMarks() {
		return this.marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StudentTestId))
			return false;
		StudentTestId castOther = (StudentTestId) other;

		return ((this.getId() == castOther.getId())
				|| (this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null && castOther.getName() != null
						&& this.getName().equals(castOther.getName())))
				&& ((this.getMarks() == castOther.getMarks()) || (this.getMarks() != null
						&& castOther.getMarks() != null && this.getMarks().equals(castOther.getMarks())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result + (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result + (getMarks() == null ? 0 : this.getMarks().hashCode());
		return result;
	}

}