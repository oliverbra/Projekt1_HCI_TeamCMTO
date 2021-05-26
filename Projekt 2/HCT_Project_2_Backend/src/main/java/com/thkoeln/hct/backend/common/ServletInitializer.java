package com.thkoeln.hct.backend.common;

import com.thkoeln.hct.backend.HctProject2BackendApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HctProject2BackendApplication.class);
    }

}
