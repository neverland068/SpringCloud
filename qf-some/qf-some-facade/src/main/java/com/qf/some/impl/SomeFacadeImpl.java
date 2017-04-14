package com.qf.some.impl;

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
import com.qf.some.SomeUserService;
import com.qf.some.bean.SomeUser;
import com.qf.some.constants.ResponseCode;
import com.qf.some.facade.SomeFacade;
import com.qf.some.request.AddSomeRequest;
import com.qf.some.request.DeleteSomeRequest;
import com.qf.some.request.UpdateSomeRequest;
import com.qf.some.response.AddSomeResponse;
import com.qf.some.response.DeleteSomeResponse;
import com.qf.some.response.SelectSomeResponse;
import com.qf.some.response.UpdateSomeResponse;

@RestController
public class SomeFacadeImpl implements SomeFacade{
    private static final Logger LOGGER = LoggerFactory.getLogger(SomeFacadeImpl.class);
	@Autowired
	private SomeUserService someUserService;
	
    @RequestMapping(value = "/add", method = RequestMethod.POST)
	 public AddSomeResponse addSome(@RequestBody AddSomeRequest addSomeRequest){
        AddSomeResponse response = new AddSomeResponse();
        if(addSomeRequest==null || StringUtils.isEmpty(addSomeRequest.getPersonName())){
            LOGGER.error("The parameter is invalid>>>>>>>>>>>>>>>>"+JSON.toJSONString(addSomeRequest));
            response.setResponseCode(ResponseCode.RC_PARAMETER_ERROR.getResponseCode());
            response.setResponseMessage(ResponseCode.RC_PARAMETER_ERROR.getResponseMessage());
            return response;
        }
        try{
            Integer result = someUserService.addSomeUser(addSomeRequest.getPersonName());
            if(result==null || result == 0){
                LOGGER.error("Add person failed>>>>>>>>>>>>>>>>>>>>.");
                response.setResponseCode(ResponseCode.RC_SOME_ADD_ERROR.getResponseCode());
                response.setResponseMessage(ResponseCode.RC_SOME_ADD_ERROR.getResponseMessage());
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


    @Override
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public DeleteSomeResponse deleteSome(@RequestBody DeleteSomeRequest deleteSomeRequest) {
        DeleteSomeResponse response = new DeleteSomeResponse();
        if(deleteSomeRequest==null || deleteSomeRequest.getPersonId() == null){
            LOGGER.error("The parameter is invalid>>>>>>>>>>>>>>>>"+JSON.toJSONString(deleteSomeRequest));
            response.setResponseCode(ResponseCode.RC_PARAMETER_ERROR.getResponseCode());
            response.setResponseMessage(ResponseCode.RC_PARAMETER_ERROR.getResponseMessage());
            return response;
        }
        try{
            Integer result = someUserService.deleteSomeUser(deleteSomeRequest.getPersonId());
            if(result==null || result == 0){
                LOGGER.error("Delete person failed>>>>>>>>>>>>>>>>>>>>.");
                response.setResponseCode(ResponseCode.RC_SOME_DELETE_ERROR.getResponseCode());
                response.setResponseMessage(ResponseCode.RC_SOME_DELETE_ERROR.getResponseMessage());
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

    @Override
    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    public SelectSomeResponse<SomeUser> selectSome(@PathVariable Long id) {
        SelectSomeResponse<SomeUser> response = new SelectSomeResponse<SomeUser>();
        if(id==null){
            LOGGER.error("The parameter is invalid>>>>>>>>>>>>>>>>");
            response.setResponseCode(ResponseCode.RC_PARAMETER_ERROR.getResponseCode());
            response.setResponseMessage(ResponseCode.RC_PARAMETER_ERROR.getResponseMessage());
            return response;
        }
        try{
            SomeUser user = someUserService.selectSomeUserById(id);
            if(user != null){
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

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces="application/json",consumes="application/json")
    public UpdateSomeResponse updateSome(@RequestBody UpdateSomeRequest updateSomeRequest) {
        UpdateSomeResponse response = new UpdateSomeResponse();
        if(updateSomeRequest==null || updateSomeRequest.getUser() == null){
            LOGGER.error("The parameter is invalid>>>>>>>>>>>>>>>>"+JSON.toJSONString(updateSomeRequest));
            response.setResponseCode(ResponseCode.RC_PARAMETER_ERROR.getResponseCode());
            response.setResponseMessage(ResponseCode.RC_PARAMETER_ERROR.getResponseMessage());
            return response;
        }
        try{
            Integer result = someUserService.updateSomeUser(updateSomeRequest.getUser());
            if(result==null || result == 0){
                LOGGER.error("Update person failed>>>>>>>>>>>>>>>>>>>>.");
                response.setResponseCode(ResponseCode.RC_SOME_UPDATE_ERROR.getResponseCode());
                response.setResponseMessage(ResponseCode.RC_SOME_UPDATE_ERROR.getResponseMessage());
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
