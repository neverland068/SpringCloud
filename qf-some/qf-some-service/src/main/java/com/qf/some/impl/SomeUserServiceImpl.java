package com.qf.some.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.qf.person.bean.User;
import com.qf.person.constants.ResponseCode;
import com.qf.person.request.AddPersonRequest;
import com.qf.person.request.DeletePersonRequest;
import com.qf.person.request.UpdatePersonRequest;
import com.qf.person.response.AddPersonResponse;
import com.qf.person.response.DeleteSomeResponse;
import com.qf.person.response.SelectPersonResponse;
import com.qf.person.response.UpdatePersonResponse;
import com.qf.some.SomeUserService;
import com.qf.some.bean.SomeUser;
import com.qf.some.client.person.PersonClient;

/**
 * @author liuchaogang
 * @date 2017年4月6日
 */
@Service
public class SomeUserServiceImpl implements SomeUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SomeUserServiceImpl.class);

    @Autowired
    private PersonClient personClient;
    @Value("${my.message}") // 1
    private String message;

    @Override
    public int addSomeUser(String userName) {
        LOGGER.info("Add the some user for >>>>>>>>>>>>>>>" + userName);
        AddPersonRequest addPersonRequest = new AddPersonRequest();
        addPersonRequest.setPersonName(message + "-" + userName);
        AddPersonResponse addPersonResponse = personClient.add(addPersonRequest);
        LOGGER.info("The response from person service is>>>>>>>>>>"
                + JSON.toJSONString(addPersonResponse));
        if (addPersonResponse != null && !StringUtils.isEmpty(addPersonResponse.getResponseCode())
                && addPersonResponse.getResponseCode().equals(ResponseCode.RC_SUCCESS.getResponseCode())) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updateSomeUser(SomeUser user) {
        LOGGER.info("Update the some user for >>>>>>>>>>>>>>>" + JSON.toJSONString(user));
        UpdatePersonRequest updatePersonRequest = new UpdatePersonRequest();
        User person = new User();
        person.setId(user.getId());
        person.setDisplayName(message + "-" + user.getDisplayName());
        person.setUserName(message + "-" + user.getUserName());
        updatePersonRequest.setUser(person);
        UpdatePersonResponse updatePersonResponse = personClient.update(updatePersonRequest);
        LOGGER.info("The response from person service is>>>>>>>>>>"
                + JSON.toJSONString(updatePersonResponse));
        if (updatePersonResponse != null
                && !StringUtils.isEmpty(updatePersonResponse.getResponseCode())
                && updatePersonResponse.getResponseCode().equals(ResponseCode.RC_SUCCESS.getResponseCode())) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int deleteSomeUser(Long id) {
        LOGGER.info("Delete the some user for >>>>>>>>>>>>>>>" + id);
        DeletePersonRequest deletePersonRequest = new DeletePersonRequest();
        deletePersonRequest.setPersonId(id);
        DeleteSomeResponse deletePersonResponse = personClient.delete(deletePersonRequest);
        LOGGER.info("The response from person service is>>>>>>>>>>"
                + JSON.toJSONString(deletePersonResponse));
        if (deletePersonResponse != null
                && !StringUtils.isEmpty(deletePersonResponse.getResponseCode())
                && deletePersonResponse.getResponseCode().equals(ResponseCode.RC_SUCCESS.getResponseCode())) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public SomeUser selectSomeUserById(Long id) {
        LOGGER.info("Selete the some user for >>>>>>>>>>>>>>>" + id);
        SelectPersonResponse<User> seletePersonResponse = personClient.selectById(id);
        LOGGER.info("The response from person service is>>>>>>>>>>"
                + JSON.toJSONString(seletePersonResponse));
        if (seletePersonResponse != null
                && !StringUtils.isEmpty(seletePersonResponse.getResponseCode())
                && seletePersonResponse.getResponseCode().equals(ResponseCode.RC_SUCCESS.getResponseCode())
                && seletePersonResponse.getUser() != null) {
            User person = seletePersonResponse.getUser();
            SomeUser user = new SomeUser();
            user.setDisplayName(person.getDisplayName());
            user.setId(person.getId());
            user.setUserName(person.getUserName());
            return user;
        } else {
            return null;
        }

    }


}
