package com.mutesaid.bootdemo.controller;

import com.mutesaid.bootdemo.model.Expert;
import com.mutesaid.bootdemo.model.Response;
import com.mutesaid.bootdemo.service.ExpertService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@EnableCaching
@CacheConfig(cacheNames = "expert")
@Slf4j
public class ExpertController {
    @Resource
    private ExpertService expertService;

    @GetMapping("/a/expert")
    @Cacheable
    public Response findList() {
        List<Expert> expertList = expertService.findList();
        log.info("select expert list size = {}", expertList.size());
        return new Response<>(0, "success", expertList);
    }
}