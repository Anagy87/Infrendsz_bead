package jjw34g.ire.service;

import jjw34g.ire.dto.BefizetesekDTO;
import jjw34g.ire.entity.BefizetesekEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import static jjw34g.ire.entity.LakokStatusEntity.borrowed;
import static jjw34g.ire.entity.LakokStatusEntity.fizetetlen;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

@Named
@ApplicationScoped
public class BefizetesekService {

    private final int lateDayLimit = 30;
    private BefizetesekDTO befizetes = new BefizetesekDTO();

    public BefizetesekService() {
        System.out.println("BefizetesekService constructed");
    }

    public ArrayList<BefizetesekEntity> getAllBefizetes() {
        ArrayList<BefizetesekEntity> temp = befizetes.getAllBefizetesek();

        for (BefizetesekEntity temp1 : temp) {
            temp1.setDelayed_days(calculateDateDiff(temp1.getWhen_paid(), temp1.getWhen_paid()));
            if (temp1.getDelayed_days() > lateDayLimit) {
                temp1.setLate(true);
                temp1.setLate_payment_days(temp1.getDelayed_days() - lateDayLimit);
            }
        }

        return temp;
    }

    public void createBefizetes(BefizetesekEntity entity) {
        Date date = new Date();
        entity.getWho_paid().setStatus(name);
        entity.setWhen_paid(new Timestamp(date.getTime()));
        befizetes.createNewBefizetes(entity);
    }

    public void deleteBefizetes(int id) {
        Date date = new Date();
        BefizetesekEntity loaning = befizetes.getBefizetesbyId(id);
        loaning.setWhen_paid(new Timestamp(date.getTime()));
        loaning.getWho_paid().setStatus(fizetetlen);
        befizetes.deleteBefizetes(befizetes);
    }

    public int calculateDateDiff(Timestamp date1, Timestamp date2) {
        if (date2 == null) {
            Date date = new Date();
            Timestamp timestamp1 = new Timestamp(date.getTime());
            date2 = timestamp1;
        }
        long difference = date2.getTime() - date1.getTime();
        int seconds = (int) difference / 1000;
        int days = (seconds / 3600) / 24;
        return days;
    }

    public int getNumberOfBefizetes(int id) {
        return befizetes.getBefizetesekSzama(id);
    }

}
