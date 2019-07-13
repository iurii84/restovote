package restovoteApp.model;

import javax.persistence.*;
@Entity
@Table(name = "testtable")
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "mydata")
    String myData;

    public TestEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMyData() {
        return myData;
    }

    public void setMyData(String myData) {
        this.myData = myData;
    }
}
