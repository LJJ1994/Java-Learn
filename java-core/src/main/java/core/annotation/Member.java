package main.java.core.annotation;

@DBTable(name = "test")
public class Member {
    @SQLString(30)
    private String firstName;

    @SQLString(50)
    private String lastName;

    @SQLInteger
    private Integer age;

    @SQLString(value = 20, constrains = @Constraints(primaryKey = true))
    private String handle;

    static int memberCount;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }
}
