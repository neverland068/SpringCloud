package com.qf.some.client.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.qf.person.bean.User;
import com.qf.person.request.AddPersonRequest;
import com.qf.person.request.DeletePersonRequest;
import com.qf.person.request.UpdatePersonRequest;
import com.qf.person.response.AddPersonResponse;
import com.qf.person.response.DeleteSomeResponse;
import com.qf.person.response.SelectPersonResponse;
import com.qf.person.response.UpdatePersonResponse;
import com.qf.some.constants.ResponseCode;

import feign.hystrix.FallbackFactory;

/**
 * @author liuchaogang
 * @date 2017年4月13日
 */
@Component
public class PersonClientFallbackFactory implements FallbackFactory<PersonClient> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonClientFallbackFactory.class);

    @Override
    public PersonClient create(Throwable cause) {
        LOGGER.error(ResponseCode.RC_CALL_PERSON_ERROR.getResponseMessage(), cause);
        return new PersonClient() {
            @Override
            public AddPersonResponse add(AddPersonRequest addPersonRequest) {
                AddPersonResponse resp = new AddPersonResponse();
                resp.setResponseCode(ResponseCode.RC_CALL_PERSON_ERROR.getResponseCode());
                resp.setResponseCode(ResponseCode.RC_CALL_PERSON_ERROR.getResponseMessage());
                return resp;
            }

            @Override
            public UpdatePersonResponse update(UpdatePersonRequest updatePersonRequest) {
                UpdatePersonResponse resp = new UpdatePersonResponse();
                resp.setResponseCode(ResponseCode.RC_CALL_PERSON_ERROR.getResponseCode());
                resp.setResponseCode(ResponseCode.RC_CALL_PERSON_ERROR.getResponseMessage());
                return resp;
            }

            @Override
            public DeleteSomeResponse delete(DeletePersonRequest deletePersonRequest) {
                DeleteSomeResponse resp = new DeleteSomeResponse();
                resp.setResponseCode(ResponseCode.RC_CALL_PERSON_ERROR.getResponseCode());
                resp.setResponseCode(ResponseCode.RC_CALL_PERSON_ERROR.getResponseMessage());
                return resp;
            }

            @Override
            public SelectPersonResponse<User> selectById(Long id) {
                SelectPersonResponse<User> resp = new SelectPersonResponse<User>();
                resp.setResponseCode(ResponseCode.RC_CALL_PERSON_ERROR.getResponseCode());
                resp.setResponseCode(ResponseCode.RC_CALL_PERSON_ERROR.getResponseMessage());
                return resp;
            }

        };
    }

}
