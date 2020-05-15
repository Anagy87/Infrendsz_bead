package jjw34g.ire.service;

import jjw34g.ire.dto.LakokDTO;
import jjw34g.ire.entity.LakokEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;

@Named
@ApplicationScoped
public class LakokService {

    private LakokDTO lakok = new LakokDTO();

    public LakokService() {
        System.out.println("LakokService constructed");
    }

    public ArrayList<LakokEntity> getAllLakok() {
        return lakok.getAllLakok();
    }

    public void createLakok(LakokEntity entity) {
        lakok.createNewLako(entity);
    }

    public LakokEntity getLakoById(int id) {
        return lakok.getLakoById(id);
    }
}
