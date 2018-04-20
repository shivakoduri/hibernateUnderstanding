package com.myprojects.examples.hibernate.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "author", schema = "mytestdb")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private Long id;

    @Version
	private int version;

    @Column(name="firstname")
	private String firstName;

    @Column(name="lastname")
	private String lastName;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    @Override
    public boolean equals(Object obj) {
      if(this == obj){
          return true;
      }
      if(!(obj instanceof Author)){
          return false;
      }
      Author other = (Author)obj;
      if(id != null){
          if(!id.equals(other.id)){
              return false;
          }
      }
      return true;
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
	    String result = getClass().getSimpleName()+ " ";
	    if(firstName != null && !firstName.trim().isEmpty())
	        result += "firstName:"+ firstName;
	    if(lastName != null && !lastName.trim().isEmpty())
            result += ", lastName:" + lastName;

	    return result;
	}
}
