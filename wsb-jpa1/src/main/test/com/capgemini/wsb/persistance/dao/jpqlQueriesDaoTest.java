import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PatientDaoTest {

    private PatientDao patientDao;

    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<PatientEntity> patientTypedQuery;

    @Mock
    private TypedQuery<Object[]> objectArrayTypedQuery;

    @Mock
    private TypedQuery<Long> longTypedQuery;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        patientDao = new PatientDao(entityManager);
    }

    @Test
    public void testFindPatientBySurname() {
        // Given
        String surname = "Smith";
        List<PatientEntity> expectedPatients = Arrays.asList(new PatientEntity(), new PatientEntity());
        when(entityManager.createQuery(anyString(), eq(PatientEntity.class))).thenReturn(patientTypedQuery);
        when(patientTypedQuery.setParameter("surname", surname)).thenReturn(patientTypedQuery);
        when(patientTypedQuery.getResultList()).thenReturn(expectedPatients);

        // When
        List<PatientEntity> actualPatients = patientDao.findPatientBySurname(surname);

        // Then
        assertEquals(expectedPatients, actualPatients);
    }

    @Test
    public void testFindPremiumPatients() {
        // Given
        Boolean isPremium = true;
        List<PatientEntity> expectedPatients = Arrays.asList(new PatientEntity(), new PatientEntity());
        when(entityManager.createQuery(anyString(), eq(PatientEntity.class))).thenReturn(patientTypedQuery);
        when(patientTypedQuery.setParameter("isPremium", isPremium)).thenReturn(patientTypedQuery);
        when(patientTypedQuery.getResultList()).thenReturn(expectedPatients);

        // When
        List<PatientEntity> actualPatients = patientDao.findPremiumPatients(isPremium);

        // Then
        assertEquals(expectedPatients, actualPatients);
    }

    @Test
    public void testFindPatientWhenCountVisitsIs() {
        // Given
        Long visitCount = 2L;
        List<Object[]> expectedResults = Arrays.asList(new Object[]{"John", "Doe", 3L});
        when(entityManager.createQuery(anyString(), eq(Object[].class))).thenReturn(objectArrayTypedQuery);
        when(objectArrayTypedQuery.setParameter("visitCount", visitCount)).thenReturn(objectArrayTypedQuery);
        when(objectArrayTypedQuery.getResultList()).thenReturn(expectedResults);

        // When
        List<Object[]> actualResults = patientDao.findPatientWhenCountVisitsIs(visitCount);

        // Then
        assertEquals(expectedResults, actualResults);
    }

    @Test
    public void testFindPatientIdWhenCountVisitsIs() {
        // Given
        Long visitCount = 2L;
        List<Long> expectedIds = Arrays.asList(1L, 2L);
        when(entityManager.createQuery(anyString(), eq(Long.class))).thenReturn(longTypedQuery);
        when(longTypedQuery.setParameter("visitCount", visitCount)).thenReturn(longTypedQuery);
        when(longTypedQuery.getResultList()).thenReturn(expectedIds);

        // When
        List<Long> actualIds = patientDao.findPatientIdWhenCountVisitsIs(visitCount);

        // Then
        assertEquals(expectedIds, actualIds);
    }
}
