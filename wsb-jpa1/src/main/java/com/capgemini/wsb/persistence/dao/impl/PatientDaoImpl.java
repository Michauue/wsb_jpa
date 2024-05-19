package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {
    @Override
    public List<PatientEntity> findPatientBySurname(String surname) {
        return entityManager.createQuery("select pat from PatientEntity pat " +
                "where pat.LAST_NAME like :surname ", PatientEntity.class).setParameter("surname", surname).getResultList();
    }

    // Dodane przeze mnie pole jset typu BOOLEAN więc nie widzę opcji użycia zapytania typu wieksze/mniejsze/pozniej/wczesniej/zawiera, ze względu, że pole to przyjmuje to tylko wartości true lub false :/
    @Override
    public List<PatientEntity> findPremiumPatients(Boolean isPremium) {
        return entityManager.createQuery("select pat from PatentEntity pat " +
                "where pat.IS_PREMIUM_PATIENT = :isPremium", PatientEntity.class).setParameter("isPremium", isPremium).getResultList();
    }

    @Override
    public List<PatientEntity> findPatientWhenCountVisitsIs(Long visitCount) {
        return entityManager.createQuery("select pat.FIRST_NAME, pat.LAST_NAME, COUNT(visit.ID) from PatientEntity pat " +
                "join pat.visitEntities visit " +
                "GROUP BY pat.id, pat.FIRST_NAME, pat.LAST_NAME " +
                "HAVING COUNT(visit.ID) > :visitCount", PatientEntity.class).setParameter("visitCount", visitCount).getResultList();
    }

    // Pozostale zapytania znajduja sie w VisitDaoImpl

}
