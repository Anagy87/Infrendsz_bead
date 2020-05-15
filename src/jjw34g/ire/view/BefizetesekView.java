package jjw34g.ire.view;

import jjw34g.ire.entity.BefizetesekEntity;
import jjw34g.ire.entity.LakasokEntity;
import jjw34g.ire.entity.LakokEntity;
import jjw34g.ire.entity.LakokStatusEntity;
import jjw34g.ire.service.BefizetesekService;
import jjw34g.ire.service.LakasokService;
import jjw34g.ire.service.LakokService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

@Named("befizetesekView")
@ViewScoped
public class BefizetesekView implements Serializable {

    @Inject
    private BefizetesekService service;

    @Inject
    private LakasokService lakasokService;

    @Inject
    private LakokService lakokService;

    private ArrayList<BefizetesekEntity> befizetesekEntities;
    ArrayList<LakasokEntity> lakasok = new ArrayList<>();
    ArrayList<LakokEntity> lakok = new ArrayList<>();

    private BefizetesekEntity entity = new BefizetesekEntity();

    public BefizetesekView() {
        System.out.println("befizetesekView constructed");
    }

    @PostConstruct
    public void init() {
        System.out.println("BefizetesekService injected : " + service);
        entity.setWho_paid(new LakasokEntity());//Populating it to avoid target unreachable
        entity.setWhat_paid(new LakokEntity());

        befizetesekEntities = service.getAllBefizetes();
        lakasok = lakasokService.getAllLakas();
        lakok = lakokService.getAllLakok();
    }

    public String createBefizetes() {
        System.out.println("Creating : \n " + entity.toString());
        entity.setWho_paid(lakasokService.getLakasById(entity.getWho_Paid().getId()));
        entity.setWhat_paid(lakokService.getLakoById(entity.getWhat_Paid().getId()));
        service.createBefizetes(entity);
        entity = new BefizetesekEntity();
        return "befizetesek?faces-redirect=true\"";
    }

    public String deleteBefizetes(int id) {
        System.out.println("ID is : " + id);
        service.deleteBefizetes(id);
        return "befizetesek?faces-redirect=true\"";
    }

    public ArrayList<LakasokEntity> getLakokAkikFizettek() {
        ArrayList<LakasokEntity> lakokAkikFizettek = new ArrayList<>();
        for (LakasokEntity e : lakasok) {
            if (service.getNumberOfBefizetes(e.getId()) < 7) {
                lakokAkikFizettek.add(e); 
            }
        }
        return lakokAkikFizettek;
    }

  


    public ArrayList<LakasokEntity> getLakasok() {
        return lakasok;
    }

    public void setLakasok(ArrayList<LakasokEntity> users) {
        this.lakasok = users;
    }

    public ArrayList<LakokEntity> getBefizetesek() {
        return lakok;
    }

    public void setBefizetesek(ArrayList<LakokEntity> befizetesek) {
        this.lakok = befizetesek;
    }

    public BefizetesekEntity getEntity() {
        return entity;
    }

    public void setEntity(BefizetesekEntity entity) {
        this.entity = entity;
    }

    public ArrayList<BefizetesekEntity> getBefizetesekEntities() {
        if (befizetesekEntities == null) {
            befizetesekEntities = service.getAllBefizetes();
        }
        return befizetesekEntities;
    }

    public ArrayList<BefizetesekEntity> getFilteredBefizetesekEntities() {
        return FilteredBefizetesekEntities;
    }

    public void setFilteredBefizetesekEntities(ArrayList<BefizetesekEntity> FilteredBefizetesekEntities) {
        FilteredBefizetesekEntities = FilteredBefizetesekEntities;
    }

    public void setBefizetesekEntities(ArrayList<BefizetesekEntity> befizetesekEntities) {
        this.befizetesekEntities = befizetesekEntities;
    }

    public void setService(BefizetesekService service) {
        this.service = service;
    }
}
