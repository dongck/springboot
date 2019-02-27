package com.dongck.pojo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/**
 * 测试bean在ioc中的scope
 * @author dongck
 *
 */
import org.springframework.web.context.WebApplicationContext;
@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ScopeClass {

}
