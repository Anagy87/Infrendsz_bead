package jjw34g.ire.service;

import jjw34g.ire.dto.LakasokDTO;
import jjw34g.ire.entity.LakasokEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;

@Named
@ApplicationScoped
public class LakasokService {

    private LakasokDTO lakasokDto = new LakasokDTO();

    public LakasokService() {
        System.out.println("LakasokService constructed");
    }

    public ArrayList<LakasokEntity> getAllLakas() {
        return lakasokDto.getAllLakas();
    }

    public void createLakas(LakasokEntity entity) {
        lakasokDto.createNewLakas(entity);
    }

    public void updateLakas(LakasokEntity entity) {
        lakasokDto.updateLakas(entity);
    }

    public void deleteLakas(LakasokEntity entity) {
        lakasokDto.deleteLakas(entity);
    }

    public LakasokEntity getLakasById(int id) {
        return lakasokDto.getLakasById(id);
    }

}