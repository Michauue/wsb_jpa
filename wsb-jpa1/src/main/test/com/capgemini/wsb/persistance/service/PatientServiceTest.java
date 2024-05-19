import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PatientDaoTest {

    @Mock
    private PatientDao patientDao;

    @Mock
    private VisitDao visitDao;

    @Mock
    private DoctorDao doctorDao;

    @InjectMocks
    private PatientServiceImpl patientService;

    @Test
    public void testShouldDeletePatientCascade() {
        // given
        Long patientId = 1L;
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientId);

        VisitEntity visit1 = new VisitEntity();
        visit1.setId(101L);
        visit1.setPatient(patientEntity);

        VisitEntity visit2 = new VisitEntity();
        visit2.setId(102L);
        visit2.setPatient(patientEntity);

        List<VisitEntity> visits = new ArrayList<>();
        visits.add(visit1);
        visits.add(visit2);

        DoctorEntity doctor1 = new DoctorEntity();
        doctor1.setId(201L);
        doctor1.setFirstName("John");
        doctor1.setLastName("Doe");
        doctor1.getVisitEntities().add(visit1);

        DoctorEntity doctor2 = new DoctorEntity();
        doctor2.setId(202L);
        doctor2.setFirstName("Jane");
        doctor2.setLastName("Smith");
        doctor2.getVisitEntities().add(visit2);

        List<DoctorEntity> doctors = new ArrayList<>();
        doctors.add(doctor1);
        doctors.add(doctor2);

        when(patientDao.findOne(patientId)).thenReturn(patientEntity);
        when(visitDao.findVisitsByPatientId(patientId)).thenReturn(visits);
        when(doctorDao.findDoctorsByVisitEntities(visits)).thenReturn(doctors);

        // when
        patientService.deletePatient(patientId);

        // then
        verify(visitDao).delete(visit1);
        verify(visitDao).delete(visit2);
        verify(doctorDao, never()).delete(any());
    }
}
