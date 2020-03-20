package com.tianhy.study.dubbo.api;

import javax.ws.rs.*;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2020/1/15 15:12
 **/
@Path("/hello")
public interface HelloService {

    @GET
    @Path("/{msg}")
    String sayHello(@PathParam("msg") String msg);
}
