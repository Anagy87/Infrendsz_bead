package jjw34g.ire.view;

import jjw34g.ire.entity.LakasokEntity;
import jjw34g.ire.service.LakasokService;

import org.primefaces.event.RowEditEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

@Named("lakasokview")
@ViewScoped
public class LakasokView implements Serializable {

    @Inject
    private LakasokService service;

    private ArrayList<LakasokEntity> lakasok;
    private ArrayList<LakasokEntity> filteredLakasok;

    private LakasokEntity newLakas = new LakasokEntity();
    private LakasokEntity updateLakas = new LakasokEntity();

    public LakasokView() {
        System.out.println("LakasView constructed");
    }

    @PostConstruct
    public void init() {
        System.out.println("LakasService injected : " + service);
        lakasok = service.getAllLakas();
    }

    public String addNewLakas() {
        newLakas.setDeleted_Lakas(false);
        System.out.println(newLakas.toString());
        service.createLakas(newLakas);
        addMessage("Lakas elmentve");
        newLakas = new LakasokEntity();
        return "lakasok?faces-redirect=true\"";
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onRowEdit(RowEditEvent<LakasokEntity> event) {
        FacesMessage msg = new FacesMessage("Lakas Edited", event.getObject().getalapterulet());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println(event.getObject().toString());
        service.updateLakas(event.getObject());
    }

    public void onRowCancel(RowEditEvent<LakasokEntity> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().getalapterulet());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    //Getters setters
    public ArrayList<LakasokEntity> getfilteredLakasok() {
        return filteredLakasok;
    }

    public void setfilteredLakasok(ArrayList<LakasokEntity> filteredLakasok) {
        this.filteredLakasok = filteredLakasok;
    }

    public LakasokEntity getNewLakas() {
        return newLakas;
    }

    public void setNewLakas(LakasokEntity newLakas) {
        this.newLakas = newLakas;
    }

    public ArrayList<LakasokEntity> getLakasok() {
        if (lakasok == null) {
            lakasok = service.getAllLakas();
        }
        return lakasok;
    }

    public void setUsers(ArrayList<LakasokEntity> lakasok) {
        this.lakasok = lakasok;
    }

    public void setService(LakasokService service) {
        this.service = service;
    }
}
