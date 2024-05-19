package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VisitDaoImpl extends AbstractDao<VisitEntity, Long> implements VisitDao {
    @Override
    public List<VisitEntity> findVisitsByPatientId(Long id) {
        return entityManager.createQuery("select visit from VisitEntity visit " +
                "where visit.PATIENT_ID = :id ", VisitEntity.class).setParameter("id", id).getResultList();
    }

    @Override
    public List<VisitEntity> findPatientIdWhenCountVisitsIs(Long visitCount) {
        return entityManager.createQuery("select visit.PATIENT_ID from VisitEntity visit " +
                "GROUP BY PATIENT_ID " +
                "HAVING COUNT(visit.ID) > :visitCount", VisitEntity.class).setParameter("visitCount", visitCount).getResultList();
    }


}
