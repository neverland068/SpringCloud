package com.qf.person.facade;

import com.qf.person.bean.User;
import com.qf.person.request.AddPersonRequest;
import com.qf.person.request.DeletePersonRequest;
import com.qf.person.request.SeletePersonRequest;
import com.qf.person.request.UpdatePersonRequest;
import com.qf.person.response.AddPersonResponse;
import com.qf.person.response.DeletePersonResponse;
import com.qf.person.response.SelectPersonResponse;
import com.qf.person.response.UpdatePersonResponse;

/**
 * @author liuchaogang
 * @date 2017年4月12日
 */
public interface PersonFacade {
    AddPersonResponse addPerson(AddPersonRequest addPersonRequest);
    DeletePersonResponse deletePerson(DeletePersonRequest deletePersonRequest);
    SelectPersonResponse<User> selectPerson(SeletePersonRequest seletePersonRequest);
    UpdatePersonResponse updatePerson(UpdatePersonRequest updatePersonRequest);
}
