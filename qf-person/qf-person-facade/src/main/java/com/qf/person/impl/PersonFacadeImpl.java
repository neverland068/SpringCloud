package com.qf.person.impl;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.qf.person.bean.User;
import com.qf.person.constants.ResponseCode;
import com.qf.person.domain.TUser;
import com.qf.person.facade.PersonFacade;
import com.qf.person.request.AddPersonRequest;
import com.qf.person.request.DeletePersonRequest;
import com.qf.person.request.UpdatePersonRequest;
import com.qf.person.response.AddPersonResponse;
import com.qf.person.response.DeletePersonResponse;
import com.qf.person.response.SelectPersonResponse;
import com.qf.person.response.UpdatePersonResponse;
import com.qf.person.user.UserService;


@RestController
public class PersonFacadeImpl implements PersonFacade{
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonFacadeImpl.class);
    @Autowired
    UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public AddPersonResponse addPerson(@RequestBody AddPersonRequest addPersonRequest) {
        AddPersonResponse response = new AddPersonResponse();
        if(addPersonRequest==null || StringUtils.isEmpty(addPersonRequest.getPersonName())){
            LOGGER.error("The parameter is invalid>>>>>>>>>>>>>>>>"+JSON.toJSONString(addPersonRequest));
            response.setResponseCode(ResponseCode.RC_PARAMETER_ERROR.getResponseCode());
            response.setResponseMessage(ResponseCode.RC_PARAMETER_ERROR.getResponseMessage());
            return response;
        }
        try{
            Integer result = userService.addUser(addPersonRequest.getPersonName());
            if(result==null || result == 0){
                LOGGER.error("Add person failed>>>>>>>>>>>>>>>>>>>>.");
                response.setResponseCode(ResponseCode.RC_PERSON_ADD_ERROR.getResponseCode());
                response.setResponseMessage(ResponseCode.RC_PERSON_ADD_ERROR.getResponseMessage());
                return response;
            }
            response.setResponseCode(ResponseCode.RC_SUCCESS.getResponseCode());
            response.setResponseMessage(ResponseCode.RC_SUCCESS.getResponseMessage());
            return response;
        }catch(Exception e){
            LOGGER.error("There is exception happening>>>>>>>>>>>>>>>.",e);
            response.setResponseCode(ResponseCode.RC_EXCEPTION_ERROR.getResponseCode());
            response.setResponseMessage(ResponseCode.RC_EXCEPTION_ERROR.getResponseMessage());
            return response;
        }

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public DeletePersonResponse deletePerson(@RequestBody DeletePersonRequest deletePersonRequest) {
        DeletePersonResponse response = new DeletePersonResponse();
        if(deletePersonRequest==null || deletePersonRequest.getPersonId() == null){
            LOGGER.error("The parameter is invalid>>>>>>>>>>>>>>>>"+JSON.toJSONString(deletePersonRequest));
            response.setResponseCode(ResponseCode.RC_PARAMETER_ERROR.getResponseCode());
            response.setResponseMessage(ResponseCode.RC_PARAMETER_ERROR.getResponseMessage());
            return response;
        }
        try{
            Integer result = userService.deleteUser(deletePersonRequest.getPersonId());
            if(result==null || result == 0){
                LOGGER.error("Delete person failed>>>>>>>>>>>>>>>>>>>>.");
                response.setResponseCode(ResponseCode.RC_PERSON_DELETE_ERROR.getResponseCode());
                response.setResponseMessage(ResponseCode.RC_PERSON_DELETE_ERROR.getResponseMessage());
                return response;
            }
            response.setResponseCode(ResponseCode.RC_SUCCESS.getResponseCode());
            response.setResponseMessage(ResponseCode.RC_SUCCESS.getResponseMessage());
            return response;
        }catch(Exception e){
            LOGGER.error("There is exception happening>>>>>>>>>>>>>>>.",e);
            response.setResponseCode(ResponseCode.RC_EXCEPTION_ERROR.getResponseCode());
            response.setResponseMessage(ResponseCode.RC_EXCEPTION_ERROR.getResponseMessage());
            return response;
        }

    }

    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    public SelectPersonResponse<User> selectPerson(@PathVariable Long id) {
        SelectPersonResponse<User> response = new SelectPersonResponse<User>();
        if(id==null){
            LOGGER.error("The parameter is invalid>>>>>>>>>>>>>>>>");
            response.setResponseCode(ResponseCode.RC_PARAMETER_ERROR.getResponseCode());
            response.setResponseMessage(ResponseCode.RC_PARAMETER_ERROR.getResponseMessage());
            return response;
        }
        try{
            TUser userDB = userService.selectUserById(id);
            if(userDB != null){
                User user = new User();
                user.setUserName(userDB.getName());
                user.setDisplayName(userDB.getDisplayName());
                response.setUser(user);
            }
            response.setResponseCode(ResponseCode.RC_SUCCESS.getResponseCode());
            response.setResponseMessage(ResponseCode.RC_SUCCESS.getResponseMessage());
            return response;
        }catch(Exception e){
            LOGGER.error("There is exception happening>>>>>>>>>>>>>>>.",e);
            response.setResponseCode(ResponseCode.RC_EXCEPTION_ERROR.getResponseCode());
            response.setResponseMessage(ResponseCode.RC_EXCEPTION_ERROR.getResponseMessage());
            return response;
        }

    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces="application/json",consumes="application/json")
    public UpdatePersonResponse updatePerson(@RequestBody UpdatePersonRequest updatePersonRequest)  {
        UpdatePersonResponse response = new UpdatePersonResponse();
        if(updatePersonRequest==null || updatePersonRequest.getUser() == null){
            LOGGER.error("The parameter is invalid>>>>>>>>>>>>>>>>"+JSON.toJSONString(updatePersonRequest));
            response.setResponseCode(ResponseCode.RC_PARAMETER_ERROR.getResponseCode());
            response.setResponseMessage(ResponseCode.RC_PARAMETER_ERROR.getResponseMessage());
            return response;
        }
        try{
            TUser userDB = userService.selectUserById(updatePersonRequest.getUser().getId());
            User user = updatePersonRequest.getUser();
            userDB.setId(user.getId());
            userDB.setName(user.getUserName());
            userDB.setDisplayName(user.getDisplayName());
            Integer result = userService.updateUser(userDB);
            if(result==null || result == 0){
                LOGGER.error("Update person failed>>>>>>>>>>>>>>>>>>>>.");
                response.setResponseCode(ResponseCode.RC_PERSON_DELETE_ERROR.getResponseCode());
                response.setResponseMessage(ResponseCode.RC_PERSON_DELETE_ERROR.getResponseMessage());
                return response;
            }
            response.setResponseCode(ResponseCode.RC_SUCCESS.getResponseCode());
            response.setResponseMessage(ResponseCode.RC_SUCCESS.getResponseMessage());
            return response;
        }catch(Exception e){
            LOGGER.error("There is exception happening>>>>>>>>>>>>>>>.",e);
            response.setResponseCode(ResponseCode.RC_EXCEPTION_ERROR.getResponseCode());
            response.setResponseMessage(ResponseCode.RC_EXCEPTION_ERROR.getResponseMessage());
            return response;
        }

    }


}
