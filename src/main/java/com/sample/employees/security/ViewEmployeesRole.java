package com.sample.employees.security;

import com.sample.employees.entity.Employee;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityui.role.annotation.MenuPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;

@ResourceRole(name = "ViewEmployees", code = "view-employees")
public interface ViewEmployeesRole {

    @MenuPolicy(menuIds = "Employee.browse")
    @ScreenPolicy(screenIds = "Employee.browse")
    void screens();

    @EntityPolicy(entityClass = Employee.class, actions = EntityPolicyAction.READ)
    @EntityAttributePolicy(entityClass = Employee.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    void employee();
}