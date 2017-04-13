package com.qf.person.request;

/**
 * @author liuchaogang
 * @date 2017年4月12日
 */
public class DeletePersonRequest extends CommonRequest {

    /**
     * @return
     */
    private static final long serialVersionUID = -6072993793854706380L;
    
    private Long personId;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
    
    

}
