package com.qf.person.bean;

/**
 * @author liuchaogang
 * @date 2017年4月12日
 */
public class User extends CommonBean{
    
    /**
     * @return
     */
    private static final long serialVersionUID = -7716620497613564367L;
    
    private String userName;
    private String displayName;
    private Long id;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    

}
