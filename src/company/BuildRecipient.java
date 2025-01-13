package company;

public class BuildRecipient {
    public static int recipientCount=0;

    public Recipient make(String[] dataList){
        String recipient_type = dataList[0];
        recipientCount++;
        if (recipient_type.equals("Personal") ){
            return new PersonalFriend(dataList[1],dataList[2],dataList[3],dataList[4]);

        }
        else if (recipient_type.equals("Office_friend") ){
            return new OfficialFriend(dataList[1],dataList[2],dataList[3],dataList[4]);

        }
        else{
        return new Official(dataList[1],dataList[2],dataList[3]);}

    }
}
