package uai629.springsec.service;

import org.springframework.stereotype.Service;

@Service
public class ManagementServiceImpl implements ManagementService {

    private String info = "DEFAULT";
    
    @Override
    public String readInfo() {
        return info;
    }

    @Override
    public void setInfo(String info) {
        this.info = info;
    }

}
