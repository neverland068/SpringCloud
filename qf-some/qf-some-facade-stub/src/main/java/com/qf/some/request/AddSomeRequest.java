package com.qf.some.request;

/**
 * @author liuchaogang
 * @date 2017年4月12日
 */
public class AddSomeRequest extends CommonRequest {

    /**
     * @return
     */
    private static final long serialVersionUID = 4322762951401019282L;
    
    private String personName;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
    
    

}
