package com.qf.some.client.person;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qf.person.bean.User;
import com.qf.person.request.AddPersonRequest;
import com.qf.person.request.DeletePersonRequest;
import com.qf.person.request.UpdatePersonRequest;
import com.qf.person.response.AddPersonResponse;
import com.qf.person.response.DeleteSomeResponse;
import com.qf.person.response.SelectPersonResponse;
import com.qf.person.response.UpdatePersonResponse;

@Component
@FeignClient(name ="person",fallbackFactory = PersonClientFallbackFactory.class)
public interface PersonClient {
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    AddPersonResponse add(@RequestBody AddPersonRequest addPersonRequest);
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces="application/json",consumes="application/json")
    UpdatePersonResponse update(@RequestBody UpdatePersonRequest updatePersonRequest);
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    DeleteSomeResponse delete(@RequestBody DeletePersonRequest deletePersonRequest);
    
    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    SelectPersonResponse<User> selectById(@PathVariable("id") Long id);
}
