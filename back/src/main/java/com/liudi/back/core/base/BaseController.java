package com.liudi.back.core.base;

import cn.hutool.core.date.DateUtil;
import java.beans.PropertyEditorSupport;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

    public BaseController() {
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            public void setAsText(String text) {
                this.setValue(DateUtil.parseDate(text));
            }
        });
    }

    public HttpServletRequest getRequest() {
        return ServletUtil.getRequest();
    }

    public HttpServletResponse getResponse() {
        return ServletUtil.getResponse();
    }
}
