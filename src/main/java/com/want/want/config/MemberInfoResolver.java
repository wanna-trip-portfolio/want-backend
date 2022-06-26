package com.want.want.config;

import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

@Component
@RequiredArgsConstructor
public class MemberInfoResolver implements HandlerMethodArgumentResolver {

    private final HttpServletRequest request;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean isMemberSessionClass = com.want.want.common.MemberInfo.class.equals(parameter.getParameterType());

        return isMemberSessionClass;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return new com.want.want.common.MemberInfo(request);
    }
}
