package company;

public class OfficialFriend implements Recipient {
    private String name;
    private String email;
    private String company_position;
    private String birthday;


    public OfficialFriend(String name,String email,String company_position,String birthday){
        this.name=name;
        this.email=email;
        this.company_position=company_position;
        this.birthday=birthday;

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public String getCompany_position() {
        return company_position;
    }

    @Override
    public String getBirthday() {
        return birthday;
    }
}
