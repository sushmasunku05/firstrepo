package in.synxt.secureinventory.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="accesses")
@SequenceGenerator(name= "access_gen", sequenceName = "seq_accesses", initialValue=1, allocationSize = 1)
public class Accesses {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="access_gen")
	private int id;
	@Column(name="accessname")
	private String accessName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccessName() {
		return accessName;
	}
	public void setAccessName(String accessName) {
		this.accessName = accessName;
	}
	@Override
	public String toString() {
		return "Accesses [id=" + id + ", accessName=" + accessName + "]";
	}
	
	
}
