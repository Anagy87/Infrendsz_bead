package jjw34g.ire.view;

import jjw34g.ire.entity.LakokEntity;
import jjw34g.ire.entity.LakokStatusEntity;
import jjw34g.ire.entity.LakokTypeEntity;
import jjw34g.ire.service.LakokService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;

@Named("lakokView")
@ViewScoped
public class LakokView implements Serializable {

    @Inject
    private LakokService service;

    private ArrayList<LakokEntity> lakok;
    private ArrayList<LakokEntity> filteredlakok;

    private LakokEntity newLako = new LakokEntity();

    public LakokView() {
        System.out.println("lakokView constructed");
    }

    @PostConstruct
    public void init() {
        System.out.println("lakokService injected : " + service);
        lakok = service.getAllLakok();
    }


    public String createNewLako() {
        System.out.println(newLako.toString());
        Date date = new Date();
        service.createLakok(newLako);
        NewLako = new LakokEntity();
        addMessage("Lako elmentve");
        return "lakok?faces-redirect=true\"";
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

   
    public ArrayList<LakokEntity> getlakok() {
        if (lakok == null) {
            lakok = service.getAllLakok();
        }
        return lakok;
    }

    public void setlakok(ArrayList<LakokEntity> lakok) {
        this.lakok = lakok;
    }

    public ArrayList<LakokEntity> getFilteredlakok() {
        return filteredlakok;
    }

    public void setFilteredlakok(ArrayList<LakokEntity> filteredlakok) {
        this.filteredlakok = filteredlakok;
    }


    public ArrayList<LakokTypeEntity> getLakokTypeEntityList() {
        ArrayList<LakokTypeEntity> values = new ArrayList<LakokTypeEntity>(EnumSet.allOf(LakokTypeEntity.class));
        return values;
    }

    public ArrayList<LakokStatusEntity> getlakoktatusEntityList() {
        ArrayList<LakokStatusEntity> values = new ArrayList<LakokStatusEntity>(EnumSet.allOf(LakokStatusEntity.class));
        return values;
    }

    public LakokEntity getNewLako() {
        return newLako;
    }

    public void setNewLako(LakokEntity NewLako) {
        this.NewLako = NewLako;
    }

    public void setService(LakokService service) {
        this.service = service;
    }
}
