package uai629.springsec.service;

import org.springframework.security.access.annotation.Secured;

public interface ManagementService {

    @Secured("ROLE_USER")
    String readInfo();
    
    @Secured("ROLE_ADMIN")
    void setInfo(String info);
    
}
