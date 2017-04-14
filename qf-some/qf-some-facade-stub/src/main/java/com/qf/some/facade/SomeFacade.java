package com.qf.some.facade;

import com.qf.some.bean.SomeUser;
import com.qf.some.request.AddSomeRequest;
import com.qf.some.request.DeleteSomeRequest;
import com.qf.some.request.UpdateSomeRequest;
import com.qf.some.response.AddSomeResponse;
import com.qf.some.response.DeleteSomeResponse;
import com.qf.some.response.SelectSomeResponse;
import com.qf.some.response.UpdateSomeResponse;

/**
 * @author liuchaogang
 * @date 2017年4月12日
 */
public interface SomeFacade {
    AddSomeResponse addSome(AddSomeRequest addSomeRequest);

    DeleteSomeResponse deleteSome(DeleteSomeRequest deleteSomeRequest);

    SelectSomeResponse<SomeUser> selectSome(Long id);

    UpdateSomeResponse updateSome(UpdateSomeRequest updateSomeRequest);
}
