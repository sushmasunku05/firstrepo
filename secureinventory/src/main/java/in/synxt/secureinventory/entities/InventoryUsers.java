package in.synxt.secureinventory.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name="inventoryusers")
@SequenceGenerator(name= "user_gen", sequenceName = "seq_inventoryusers", initialValue=1, allocationSize = 1)
public class InventoryUsers {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_gen")
	private int id;
	@Column(name="emailid")
	private String emailId;
	private String password;
	private String verified;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="useraccesses",joinColumns= {@JoinColumn(name="userid")},inverseJoinColumns= {@JoinColumn(name="accessid")})
	private List<Accesses> access;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVerified() {
		return verified;
	}
	public void setVerified(String verified) {
		this.verified = verified;
	}
	public List<Accesses> getAccess() {
		return access;
	}
	public void setAccess(List<Accesses> access) {
		this.access = access;
	}
	@Override
	public String toString() {
		return "InventoryUsers [id=" + id + ", emailId=" + emailId + ", password=" + password + ", verified=" + verified
				+ "]";
	}
}
