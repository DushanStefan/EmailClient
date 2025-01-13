package company;

public class Official implements Recipient{
    private String name;
    private String email;
    private String company_position;
    private final String birthday = "N"; //official members dont have birthdays


    public Official(String name, String email, String company_position) {
        this.name = name;
        this.email = email;
        this.company_position = company_position;
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
