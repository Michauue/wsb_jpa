import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PatientServiceTest {

    private PatientService patientService;

    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<PatientEntity> patientTypedQuery;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        patientService = new PatientService(entityManager);
    }

    @Test
    public void testFindAllVisitsByPatientId() {
        // Given
        Long patientId = 1L;
        PatientEntity expectedPatient = new PatientEntity();
        when(entityManager.createQuery(anyString(), eq(PatientEntity.class))).thenReturn(patientTypedQuery);
        when(patientTypedQuery.setParameter("id", patientId)).thenReturn(patientTypedQuery);
        when(patientTypedQuery.getSingleResult()).thenReturn(expectedPatient);

        // When
        PatientEntity actualPatient = patientService.findAllVisitsByPatientId(patientId);

        // Then
        assertEquals(expectedPatient, actualPatient);
        verify(entityManager).createQuery("select pat from PatientEntity pat join fetch pat.visits visit where pat.id = :id", PatientEntity.class);
        verify(patientTypedQuery).setParameter("id", patientId);
        verify(patientTypedQuery).getSingleResult();
    }

    @Test
    public void testFindAllVisitsByPatientIdNoResult() {
        // Given
        Long patientId = 1L;
        when(entityManager.createQuery(anyString(), eq(PatientEntity.class))).thenReturn(patientTypedQuery);
        when(patientTypedQuery.setParameter("id", patientId)).thenReturn(patientTypedQuery);
        when(patientTypedQuery.getSingleResult()).thenThrow(new NoResultException());

        // When
        PatientEntity actualPatient = patientService.findAllVisitsByPatientId(patientId);

        // Then
        assertNull(actualPatient);
        verify(entityManager).createQuery("select pat from PatientEntity pat join fetch pat.visits visit where pat.id = :id", PatientEntity.class);
        verify(patientTypedQuery).setParameter("id", patientId);
        verify(patientTypedQuery).getSingleResult();
    }
}
