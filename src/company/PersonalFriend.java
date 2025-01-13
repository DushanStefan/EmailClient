package company;

public class PersonalFriend implements Recipient  {

    private String name;
    private String email;
    private String nickname;
    private String birthday;

    public PersonalFriend(String name, String nickname, String email, String birthday) {
        this.name = name;
        this.email = email;
        this.nickname = nickname;
        this.birthday = birthday;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String getBirthday() {
        return birthday;
    }
}
