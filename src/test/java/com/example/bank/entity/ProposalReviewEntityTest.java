package com.example.bank.entity;

import com.example.bank.enums.Accepted;
import com.example.bank.enums.State;
import com.example.bank.enums.Status;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ProposalReviewEntityTest {
    @Test
    public void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new ProposalReviewEntity()).canEqual("other"));
    }

    @Test
    public void testConstructor() {
        // Arrange and Act
        ProposalReviewEntity actualProposalReviewEntity = new ProposalReviewEntity();

        // Assert
        assertNull(actualProposalReviewEntity.getStreet());
        assertNull(actualProposalReviewEntity.getStatus());
        assertNull(actualProposalReviewEntity.getNeighborhood());
        assertNull(actualProposalReviewEntity.getBirtDate());
        assertNull(actualProposalReviewEntity.getPreRegistrationEntity());
        assertNull(actualProposalReviewEntity.getAccepted());
        assertNull(actualProposalReviewEntity.getCity());
        assertNull(actualProposalReviewEntity.getZip());
        assertNull(actualProposalReviewEntity.getLastName());
        assertNull(actualProposalReviewEntity.getComplement());
        assertNull(actualProposalReviewEntity.getEmail());
        assertNull(actualProposalReviewEntity.getDocumentEntity());
        assertNull(actualProposalReviewEntity.getId());
        assertNull(actualProposalReviewEntity.getFirstName());
        assertNull(actualProposalReviewEntity.getState());
        assertNull(actualProposalReviewEntity.getCpf());
        assertEquals(
                "ProposalReviewEntity(id=null, firstName=null, lastName=null, email=null, birtDate=null, cpf=null,"
                        + " status=null, zip=null, street=null, complement=null, neighborhood=null, city=null, state=null,"
                        + " accepted=null, preRegistrationEntity=null, proposalEntity=null, documentEntity=null)",
                actualProposalReviewEntity.toString());
        assertNull(actualProposalReviewEntity.getProposalEntity());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertFalse((new ProposalReviewEntity()).equals("o"));
    }

    @Test
    public void testEquals2() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();
        proposalReviewEntity.setLastName("Doe");
        proposalReviewEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        proposalReviewEntity.setNeighborhood("Neighborhood");
        proposalReviewEntity.setEmail("Email");
        proposalReviewEntity.setBirtDate(LocalDate.ofEpochDay(1L));
        proposalReviewEntity.setId(UUID.randomUUID());
        proposalReviewEntity.setZip("21654");
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");
        proposalReviewEntity.setPreRegistrationEntity(preRegistrationEntity);
        proposalReviewEntity.setFirstName("Jane");
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setImageAddress("42 Main St");
        documentEntity.setId(UUID.randomUUID());
        proposalReviewEntity.setDocumentEntity(documentEntity);
        proposalReviewEntity.setComplement("Complement");
        proposalReviewEntity.setAccepted(Accepted.YES);
        ProposalEntity proposalEntity = new ProposalEntity();
        proposalEntity.setNeighborhood("Neighborhood");
        proposalEntity.setComplement("Complement");
        proposalEntity.setId(UUID.randomUUID());
        PreRegistrationEntity preRegistrationEntity1 = new PreRegistrationEntity();
        preRegistrationEntity1.setLastName("Doe");
        preRegistrationEntity1.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity1.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity1.setEmail("Email");
        preRegistrationEntity1.setId(UUID.randomUUID());
        preRegistrationEntity1.setCpf("Cpf");
        preRegistrationEntity1.setFirstName("Jane");
        proposalEntity.setProposal(preRegistrationEntity1);
        proposalEntity.setZip("21654");
        proposalEntity.setCity("Oxford");
        DocumentEntity documentEntity1 = new DocumentEntity();
        documentEntity1.setImageAddress("42 Main St");
        documentEntity1.setId(UUID.randomUUID());
        proposalEntity.setDocument(documentEntity1);
        proposalEntity.setStreet("Street");
        proposalEntity.setState(State.AC);
        proposalReviewEntity.setProposalEntity(proposalEntity);
        proposalReviewEntity.setCpf("Cpf");
        proposalReviewEntity.setCity("Oxford");
        proposalReviewEntity.setStreet("Street");
        proposalReviewEntity.setState(State.AC);

        // Act and Assert
        assertFalse((new ProposalReviewEntity()).equals(proposalReviewEntity));
    }

    @Test
    public void testEquals3() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();
        proposalReviewEntity.setLastName("Doe");
        proposalReviewEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        proposalReviewEntity.setNeighborhood("Neighborhood");
        proposalReviewEntity.setEmail("Email");
        proposalReviewEntity.setBirtDate(LocalDate.ofEpochDay(1L));
        proposalReviewEntity.setId(null);
        proposalReviewEntity.setZip("21654");
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");
        proposalReviewEntity.setPreRegistrationEntity(preRegistrationEntity);
        proposalReviewEntity.setFirstName("Jane");
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setImageAddress("42 Main St");
        documentEntity.setId(UUID.randomUUID());
        proposalReviewEntity.setDocumentEntity(documentEntity);
        proposalReviewEntity.setComplement("Complement");
        proposalReviewEntity.setAccepted(Accepted.YES);
        ProposalEntity proposalEntity = new ProposalEntity();
        proposalEntity.setNeighborhood("Neighborhood");
        proposalEntity.setComplement("Complement");
        proposalEntity.setId(UUID.randomUUID());
        PreRegistrationEntity preRegistrationEntity1 = new PreRegistrationEntity();
        preRegistrationEntity1.setLastName("Doe");
        preRegistrationEntity1.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity1.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity1.setEmail("Email");
        preRegistrationEntity1.setId(UUID.randomUUID());
        preRegistrationEntity1.setCpf("Cpf");
        preRegistrationEntity1.setFirstName("Jane");
        proposalEntity.setProposal(preRegistrationEntity1);
        proposalEntity.setZip("21654");
        proposalEntity.setCity("Oxford");
        DocumentEntity documentEntity1 = new DocumentEntity();
        documentEntity1.setImageAddress("42 Main St");
        documentEntity1.setId(UUID.randomUUID());
        proposalEntity.setDocument(documentEntity1);
        proposalEntity.setStreet("Street");
        proposalEntity.setState(State.AC);
        proposalReviewEntity.setProposalEntity(proposalEntity);
        proposalReviewEntity.setCpf("Cpf");
        proposalReviewEntity.setCity("Oxford");
        proposalReviewEntity.setStreet("Street");
        proposalReviewEntity.setState(State.AC);

        // Act and Assert
        assertFalse((new ProposalReviewEntity()).equals(proposalReviewEntity));
    }

    @Test
    public void testGetAccepted() {
        // Arrange, Act and Assert
        assertNull((new ProposalReviewEntity()).getAccepted());
    }

    @Test
    public void testGetBirtDate() {
        // Arrange, Act and Assert
        assertNull((new ProposalReviewEntity()).getBirtDate());
    }

    @Test
    public void testGetCity() {
        // Arrange, Act and Assert
        assertNull((new ProposalReviewEntity()).getCity());
    }

    @Test
    public void testGetComplement() {
        // Arrange, Act and Assert
        assertNull((new ProposalReviewEntity()).getComplement());
    }

    @Test
    public void testGetCpf() {
        // Arrange, Act and Assert
        assertNull((new ProposalReviewEntity()).getCpf());
    }

    @Test
    public void testGetDocumentEntity() {
        // Arrange, Act and Assert
        assertNull((new ProposalReviewEntity()).getDocumentEntity());
    }

    @Test
    public void testGetEmail() {
        // Arrange, Act and Assert
        assertNull((new ProposalReviewEntity()).getEmail());
    }

    @Test
    public void testGetFirstName() {
        // Arrange, Act and Assert
        assertNull((new ProposalReviewEntity()).getFirstName());
    }

    @Test
    public void testGetId() {
        // Arrange, Act and Assert
        assertNull((new ProposalReviewEntity()).getId());
    }

    @Test
    public void testGetLastName() {
        // Arrange, Act and Assert
        assertNull((new ProposalReviewEntity()).getLastName());
    }

    @Test
    public void testGetNeighborhood() {
        // Arrange, Act and Assert
        assertNull((new ProposalReviewEntity()).getNeighborhood());
    }

    @Test
    public void testGetPreRegistrationEntity() {
        // Arrange, Act and Assert
        assertNull((new ProposalReviewEntity()).getPreRegistrationEntity());
    }

    @Test
    public void testGetProposalEntity() {
        // Arrange, Act and Assert
        assertNull((new ProposalReviewEntity()).getProposalEntity());
    }

    @Test
    public void testGetState() {
        // Arrange, Act and Assert
        assertNull((new ProposalReviewEntity()).getState());
    }

    @Test
    public void testGetStatus() {
        // Arrange, Act and Assert
        assertNull((new ProposalReviewEntity()).getStatus());
    }

    @Test
    public void testGetStreet() {
        // Arrange, Act and Assert
        assertNull((new ProposalReviewEntity()).getStreet());
    }

    @Test
    public void testGetZip() {
        // Arrange, Act and Assert
        assertNull((new ProposalReviewEntity()).getZip());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(-309967866, (new ProposalReviewEntity()).hashCode());
    }

    @Test
    public void testHashCode2() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();
        proposalReviewEntity.setLastName("Doe");

        // Act and Assert
        assertEquals(-1375622643, proposalReviewEntity.hashCode());
    }

    @Test
    public void testHashCode3() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();
        proposalReviewEntity.setZip("21654");

        // Act and Assert
        assertEquals(-1373996817, proposalReviewEntity.hashCode());
    }

    @Test
    public void testHashCode4() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(null);
        preRegistrationEntity.setBirthDate(null);
        preRegistrationEntity.setEmail(null);
        preRegistrationEntity.setId(null);
        preRegistrationEntity.setCpf(null);
        preRegistrationEntity.setFirstName("Jane");
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();
        proposalReviewEntity.setPreRegistrationEntity(preRegistrationEntity);

        // Act and Assert
        assertEquals(-1989835659, proposalReviewEntity.hashCode());
    }

    @Test
    public void testHashCode5() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();
        proposalReviewEntity.setFirstName("Jane");

        // Act and Assert
        assertEquals(1590903295, proposalReviewEntity.hashCode());
    }

    @Test
    public void testHashCode6() {
        // Arrange
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setImageAddress("42 Main St");
        documentEntity.setId(null);
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();
        proposalReviewEntity.setDocumentEntity(documentEntity);

        // Act and Assert
        assertEquals(313830883, proposalReviewEntity.hashCode());
    }

    @Test
    public void testHashCode7() {
        // Arrange
        ProposalEntity proposalEntity = new ProposalEntity();
        proposalEntity.setNeighborhood(null);
        proposalEntity.setComplement(null);
        proposalEntity.setId(null);
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(null);
        preRegistrationEntity.setBirthDate(null);
        preRegistrationEntity.setEmail(null);
        preRegistrationEntity.setId(null);
        preRegistrationEntity.setCpf(null);
        preRegistrationEntity.setFirstName("Jane");
        proposalEntity.setProposal(preRegistrationEntity);
        proposalEntity.setZip("21654");
        proposalEntity.setCity("Oxford");
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setImageAddress("42 Main St");
        documentEntity.setId(null);
        proposalEntity.setDocument(documentEntity);
        proposalEntity.setStreet(null);
        proposalEntity.setState(null);
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();
        proposalReviewEntity.setProposalEntity(proposalEntity);

        // Act and Assert
        assertEquals(-1218329311, proposalReviewEntity.hashCode());
    }

    @Test
    public void testHashCode8() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();
        proposalReviewEntity.setCity("Oxford");

        // Act and Assert
        assertEquals(186600473, proposalReviewEntity.hashCode());
    }

    @Test
    public void testSetAccepted() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();

        // Act
        proposalReviewEntity.setAccepted(Accepted.YES);

        // Assert
        assertEquals(Accepted.YES, proposalReviewEntity.getAccepted());
    }

    @Test
    public void testSetBirtDate() {
        // Arrange
        LocalDate birtDate = LocalDate.ofEpochDay(1L);
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();

        // Act
        proposalReviewEntity.setBirtDate(birtDate);

        // Assert
        assertEquals(
                "ProposalReviewEntity(id=null, firstName=null, lastName=null, email=null, birtDate=1970-01-02, cpf=null,"
                        + " status=null, zip=null, street=null, complement=null, neighborhood=null, city=null, state=null,"
                        + " accepted=null, preRegistrationEntity=null, proposalEntity=null, documentEntity=null)",
                proposalReviewEntity.toString());
    }

    @Test
    public void testSetCity() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();

        // Act
        proposalReviewEntity.setCity("Oxford");

        // Assert
        assertEquals("Oxford", proposalReviewEntity.getCity());
    }

    @Test
    public void testSetComplement() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();

        // Act
        proposalReviewEntity.setComplement("Complement");

        // Assert
        assertEquals("Complement", proposalReviewEntity.getComplement());
    }

    @Test
    public void testSetCpf() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();

        // Act
        proposalReviewEntity.setCpf("Cpf");

        // Assert
        assertEquals("Cpf", proposalReviewEntity.getCpf());
    }

    @Test
    public void testSetDocumentEntity() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();

        // Act
        proposalReviewEntity.setDocumentEntity(new DocumentEntity());

        // Assert
        assertEquals("ProposalReviewEntity(id=null, firstName=null, lastName=null, email=null, birtDate=null, cpf=null,"
                + " status=null, zip=null, street=null, complement=null, neighborhood=null, city=null, state=null,"
                + " accepted=null, preRegistrationEntity=null, proposalEntity=null, documentEntity=DocumentEntity(id=null,"
                + " imageAddress=null))", proposalReviewEntity.toString());
    }

    @Test
    public void testSetEmail() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();

        // Act
        proposalReviewEntity.setEmail("Email");

        // Assert
        assertEquals("Email", proposalReviewEntity.getEmail());
    }

    @Test
    public void testSetFirstName() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();

        // Act
        proposalReviewEntity.setFirstName("Jane");

        // Assert
        assertEquals("Jane", proposalReviewEntity.getFirstName());
    }

    @Test
    public void testSetId() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        proposalReviewEntity.setId(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, proposalReviewEntity.getId());
    }

    @Test
    public void testSetLastName() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();

        // Act
        proposalReviewEntity.setLastName("Doe");

        // Assert
        assertEquals("Doe", proposalReviewEntity.getLastName());
    }

    @Test
    public void testSetNeighborhood() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();

        // Act
        proposalReviewEntity.setNeighborhood("Neighborhood");

        // Assert
        assertEquals("Neighborhood", proposalReviewEntity.getNeighborhood());
    }

    @Test
    public void testSetPreRegistrationEntity() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();

        // Act
        proposalReviewEntity.setPreRegistrationEntity(new PreRegistrationEntity());

        // Assert
        assertEquals(
                "ProposalReviewEntity(id=null, firstName=null, lastName=null, email=null, birtDate=null, cpf=null,"
                        + " status=null, zip=null, street=null, complement=null, neighborhood=null, city=null, state=null,"
                        + " accepted=null, preRegistrationEntity=PreRegistrationEntity(id=null, firstName=null, lastName=null,"
                        + " email=null, birthDate=null, cpf=null, status=null), proposalEntity=null, documentEntity=null)",
                proposalReviewEntity.toString());
    }

    @Test
    public void testSetProposalEntity() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();

        // Act
        proposalReviewEntity.setProposalEntity(new ProposalEntity());

        // Assert
        assertEquals("ProposalReviewEntity(id=null, firstName=null, lastName=null, email=null, birtDate=null, cpf=null,"
                + " status=null, zip=null, street=null, complement=null, neighborhood=null, city=null, state=null,"
                + " accepted=null, preRegistrationEntity=null, proposalEntity=ProposalEntity(id=null, zip=null, street=null,"
                + " neighborhood=null, complement=null, city=null, state=null, proposal=null, document=null),"
                + " documentEntity=null)", proposalReviewEntity.toString());
    }

    @Test
    public void testSetState() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();

        // Act
        proposalReviewEntity.setState(State.AC);

        // Assert
        assertEquals(State.AC, proposalReviewEntity.getState());
    }

    @Test
    public void testSetStatus() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();

        // Act
        proposalReviewEntity.setStatus(Status.UNDER_PRE_ANALYSIS);

        // Assert
        assertEquals(Status.UNDER_PRE_ANALYSIS, proposalReviewEntity.getStatus());
    }

    @Test
    public void testSetStreet() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();

        // Act
        proposalReviewEntity.setStreet("Street");

        // Assert
        assertEquals("Street", proposalReviewEntity.getStreet());
    }

    @Test
    public void testSetZip() {
        // Arrange
        ProposalReviewEntity proposalReviewEntity = new ProposalReviewEntity();

        // Act
        proposalReviewEntity.setZip("21654");

        // Assert
        assertEquals("21654", proposalReviewEntity.getZip());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals(
                "ProposalReviewEntity(id=null, firstName=null, lastName=null, email=null, birtDate=null, cpf=null,"
                        + " status=null, zip=null, street=null, complement=null, neighborhood=null, city=null, state=null,"
                        + " accepted=null, preRegistrationEntity=null, proposalEntity=null, documentEntity=null)",
                (new ProposalReviewEntity()).toString());
    }
}

