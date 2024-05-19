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

public class VisitServiceTest {

    private VisitService visitService;

    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<VisitEntity> visitTypedQuery;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        visitService = new VisitService(entityManager);
    }

    @Test
    public void testFindVisitsByPatientId() {
        // Given
        Long patientId = 1L;
        List<VisitEntity> expectedVisits = Arrays.asList(new VisitEntity(), new VisitEntity());
        when(entityManager.createQuery(anyString(), eq(VisitEntity.class))).thenReturn(visitTypedQuery);
        when(visitTypedQuery.setParameter("id", patientId)).thenReturn(visitTypedQuery);
        when(visitTypedQuery.getResultList()).thenReturn(expectedVisits);

        // When
        List<VisitEntity> actualVisits = visitService.findVisitsByPatientId(patientId);

        // Then
        assertEquals(expectedVisits, actualVisits);
        verify(entityManager).createQuery("select visit from VisitEntity visit where visit.patient.id = :id", VisitEntity.class);
        verify(visitTypedQuery).setParameter("id", patientId);
        verify(visitTypedQuery).getResultList();
    }
}
