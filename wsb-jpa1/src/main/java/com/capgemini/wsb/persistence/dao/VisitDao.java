package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.List;

public interface VisitDao extends Dao<VisitEntity, Long>
{
    List<VisitEntity> findVisitsByPatientId(Long id);

    List<VisitEntity> findPatientIdWhenCountVisitsIs(Long count);
}