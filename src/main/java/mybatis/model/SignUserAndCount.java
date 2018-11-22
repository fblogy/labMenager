package mybatis.model;

public class SignUserAndCount {

    /**
     * 签到人账号
     */
    private String userAccount;

    /**
     * 签到人姓名
     */
    private String userName;

    /**
     * 签到次数
     */
    private Integer signCount;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSignCount() {
        return signCount;
    }

    public void setSignCount(Integer signCount) {
        this.signCount = signCount;
    }
}
