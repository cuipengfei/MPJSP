package Collector;

import java.io.Serializable;
import javax.persistence.*;
/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/10/12
 * Time: 10:20 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "PersonalInfoTable")
public class PersonalInfo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3555358701038269477L;
	private String name;
    private String hobby;
    private Integer id;

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonalInfo() {
    }
}
