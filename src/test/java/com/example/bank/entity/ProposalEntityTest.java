package com.example.bank.entity;

import com.example.bank.enums.State;
import com.example.bank.enums.Status;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ProposalEntityTest {
    @Test
    public void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new ProposalEntity()).canEqual("other"));
    }

    @Test
    public void testConstructor() {
        // Arrange and Act
        ProposalEntity actualProposalEntity = new ProposalEntity();

        // Assert
        assertNull(actualProposalEntity.getProposal());
        assertNull(actualProposalEntity.getComplement());
        assertNull(actualProposalEntity.getNeighborhood());
        assertNull(actualProposalEntity.getCity());
        assertNull(actualProposalEntity.getDocument());
        assertNull(actualProposalEntity.getZip());
        assertNull(actualProposalEntity.getId());
        assertNull(actualProposalEntity.getState());
        assertEquals(
                "ProposalEntity(id=null, zip=null, street=null, neighborhood=null, complement=null, city=null, state=null,"
                        + " proposal=null, document=null)",
                actualProposalEntity.toString());
        assertNull(actualProposalEntity.getStreet());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertFalse((new ProposalEntity()).equals("o"));
    }

    @Test
    public void testEquals2() {
        // Arrange
        ProposalEntity proposalEntity = new ProposalEntity();
        proposalEntity.setNeighborhood("Neighborhood");
        proposalEntity.setComplement("Complement");
        proposalEntity.setId(UUID.randomUUID());
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");
        proposalEntity.setProposal(preRegistrationEntity);
        proposalEntity.setZip("21654");
        proposalEntity.setCity("Oxford");
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setImageAddress("42 Main St");
        documentEntity.setId(UUID.randomUUID());
        proposalEntity.setDocument(documentEntity);
        proposalEntity.setStreet("Street");
        proposalEntity.setState(State.AC);

        // Act and Assert
        assertFalse((new ProposalEntity()).equals(proposalEntity));
    }

    @Test
    public void testEquals3() {
        // Arrange
        ProposalEntity proposalEntity = new ProposalEntity();
        proposalEntity.setNeighborhood("Neighborhood");
        proposalEntity.setComplement("Complement");
        proposalEntity.setId(null);
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");
        proposalEntity.setProposal(preRegistrationEntity);
        proposalEntity.setZip("21654");
        proposalEntity.setCity("Oxford");
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setImageAddress("42 Main St");
        documentEntity.setId(UUID.randomUUID());
        proposalEntity.setDocument(documentEntity);
        proposalEntity.setStreet("Street");
        proposalEntity.setState(State.AC);

        // Act and Assert
        assertFalse((new ProposalEntity()).equals(proposalEntity));
    }

    @Test
    public void testEquals4() {
        // Arrange
        ProposalEntity proposalEntity = new ProposalEntity();
        proposalEntity.setNeighborhood("Neighborhood");
        proposalEntity.setComplement("Complement");
        proposalEntity.setId(null);
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");
        proposalEntity.setProposal(preRegistrationEntity);
        proposalEntity.setZip(null);
        proposalEntity.setCity("Oxford");
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setImageAddress("42 Main St");
        documentEntity.setId(UUID.randomUUID());
        proposalEntity.setDocument(documentEntity);
        proposalEntity.setStreet("Street");
        proposalEntity.setState(State.AC);

        // Act and Assert
        assertFalse((new ProposalEntity()).equals(proposalEntity));
    }

    @Test
    public void testEquals5() {
        // Arrange
        ProposalEntity proposalEntity = new ProposalEntity();
        proposalEntity.setZip("21654");
        ProposalEntity proposalEntity1 = new ProposalEntity();
        proposalEntity1.setNeighborhood("Neighborhood");
        proposalEntity1.setComplement("Complement");
        proposalEntity1.setId(null);
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(Status.UNDER_PRE_ANALYSIS);
        preRegistrationEntity.setBirthDate(LocalDate.ofEpochDay(1L));
        preRegistrationEntity.setEmail("Email");
        preRegistrationEntity.setId(UUID.randomUUID());
        preRegistrationEntity.setCpf("Cpf");
        preRegistrationEntity.setFirstName("Jane");
        proposalEntity1.setProposal(preRegistrationEntity);
        proposalEntity1.setZip("21654");
        proposalEntity1.setCity("Oxford");
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setImageAddress("42 Main St");
        documentEntity.setId(UUID.randomUUID());
        proposalEntity1.setDocument(documentEntity);
        proposalEntity1.setStreet("Street");
        proposalEntity1.setState(State.AC);

        // Act and Assert
        assertFalse(proposalEntity.equals(proposalEntity1));
    }

    @Test
    public void testGetCity() {
        // Arrange, Act and Assert
        assertNull((new ProposalEntity()).getCity());
    }

    @Test
    public void testGetComplement() {
        // Arrange, Act and Assert
        assertNull((new ProposalEntity()).getComplement());
    }

    @Test
    public void testGetDocument() {
        // Arrange, Act and Assert
        assertNull((new ProposalEntity()).getDocument());
    }

    @Test
    public void testGetId() {
        // Arrange, Act and Assert
        assertNull((new ProposalEntity()).getId());
    }

    @Test
    public void testGetNeighborhood() {
        // Arrange, Act and Assert
        assertNull((new ProposalEntity()).getNeighborhood());
    }

    @Test
    public void testGetProposal() {
        // Arrange, Act and Assert
        assertNull((new ProposalEntity()).getProposal());
    }

    @Test
    public void testGetState() {
        // Arrange, Act and Assert
        assertNull((new ProposalEntity()).getState());
    }

    @Test
    public void testGetStreet() {
        // Arrange, Act and Assert
        assertNull((new ProposalEntity()).getStreet());
    }

    @Test
    public void testGetZip() {
        // Arrange, Act and Assert
        assertNull((new ProposalEntity()).getZip());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(158117686, (new ProposalEntity()).hashCode());
    }

    @Test
    public void testHashCode2() {
        // Arrange
        PreRegistrationEntity preRegistrationEntity = new PreRegistrationEntity();
        preRegistrationEntity.setLastName("Doe");
        preRegistrationEntity.setStatus(null);
        preRegistrationEntity.setBirthDate(null);
        preRegistrationEntity.setEmail(null);
        preRegistrationEntity.setId(null);
        preRegistrationEntity.setCpf(null);
        preRegistrationEntity.setFirstName("Jane");
        ProposalEntity proposalEntity = new ProposalEntity();
        proposalEntity.setProposal(preRegistrationEntity);

        // Act and Assert
        assertEquals(2022342803, proposalEntity.hashCode());
    }

    @Test
    public void testHashCode3() {
        // Arrange
        ProposalEntity proposalEntity = new ProposalEntity();
        proposalEntity.setZip("21654");

        // Act and Assert
        assertEquals(1977713415, proposalEntity.hashCode());
    }

    @Test
    public void testHashCode4() {
        // Arrange
        ProposalEntity proposalEntity = new ProposalEntity();
        proposalEntity.setCity("Oxford");

        // Act and Assert
        assertEquals(1209484737, proposalEntity.hashCode());
    }

    @Test
    public void testHashCode5() {
        // Arrange
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setImageAddress("42 Main St");
        documentEntity.setId(null);
        ProposalEntity proposalEntity = new ProposalEntity();
        proposalEntity.setDocument(documentEntity);

        // Act and Assert
        assertEquals(781916435, proposalEntity.hashCode());
    }

    @Test
    public void testHashCode6() {
        // Arrange
        ProposalEntity proposalEntity = new ProposalEntity();
        proposalEntity.setNeighborhood("Neighborhood");

        // Act and Assert
        assertEquals(-995370153, proposalEntity.hashCode());
    }

    @Test
    public void testHashCode7() {
        // Arrange
        ProposalEntity proposalEntity = new ProposalEntity();
        proposalEntity.setComplement("Complement");

        // Act and Assert
        assertEquals(1899775009, proposalEntity.hashCode());
    }

    @Test
    public void testHashCode8() {
        // Arrange
        ProposalEntity proposalEntity = new ProposalEntity();
        proposalEntity.setStreet("Street");

        // Act and Assert
        assertEquals(891543278, proposalEntity.hashCode());
    }

    @Test
    public void testHashCode9() {
        // Arrange
        ProposalEntity proposalEntity = new ProposalEntity();
        proposalEntity.setState(State.AC);
        ProposalEntity proposalEntity1 = new ProposalEntity();
        proposalEntity1.setState(State.AC);

        // Act and Assert
        assertEquals(proposalEntity1.hashCode(), proposalEntity.hashCode());
    }

    @Test
    public void testSetCity() {
        // Arrange
        ProposalEntity proposalEntity = new ProposalEntity();

        // Act
        proposalEntity.setCity("Oxford");

        // Assert
        assertEquals("Oxford", proposalEntity.getCity());
    }

    @Test
    public void testSetComplement() {
        // Arrange
        ProposalEntity proposalEntity = new ProposalEntity();

        // Act
        proposalEntity.setComplement("Complement");

        // Assert
        assertEquals("Complement", proposalEntity.getComplement());
    }

    @Test
    public void testSetDocument() {
        // Arrange
        ProposalEntity proposalEntity = new ProposalEntity();

        // Act
        proposalEntity.setDocument(new DocumentEntity());

        // Assert
        assertEquals(
                "ProposalEntity(id=null, zip=null, street=null, neighborhood=null, complement=null, city=null, state=null,"
                        + " proposal=null, document=DocumentEntity(id=null, imageAddress=null))",
                proposalEntity.toString());
    }

    @Test
    public void testSetId() {
        // Arrange
        ProposalEntity proposalEntity = new ProposalEntity();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        proposalEntity.setId(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, proposalEntity.getId());
    }

    @Test
    public void testSetNeighborhood() {
        // Arrange
        ProposalEntity proposalEntity = new ProposalEntity();

        // Act
        proposalEntity.setNeighborhood("Neighborhood");

        // Assert
        assertEquals("Neighborhood", proposalEntity.getNeighborhood());
    }

    @Test
    public void testSetProposal() {
        // Arrange
        ProposalEntity proposalEntity = new ProposalEntity();

        // Act
        proposalEntity.setProposal(new PreRegistrationEntity());

        // Assert
        assertEquals(
                "ProposalEntity(id=null, zip=null, street=null, neighborhood=null, complement=null, city=null, state=null,"
                        + " proposal=PreRegistrationEntity(id=null, firstName=null, lastName=null, email=null, birthDate=null,"
                        + " cpf=null, status=null), document=null)",
                proposalEntity.toString());
    }

    @Test
    public void testSetState() {
        // Arrange
        ProposalEntity proposalEntity = new ProposalEntity();

        // Act
        proposalEntity.setState(State.AC);

        // Assert
        assertEquals(State.AC, proposalEntity.getState());
    }

    @Test
    public void testSetStreet() {
        // Arrange
        ProposalEntity proposalEntity = new ProposalEntity();

        // Act
        proposalEntity.setStreet("Street");

        // Assert
        assertEquals("Street", proposalEntity.getStreet());
    }

    @Test
    public void testSetZip() {
        // Arrange
        ProposalEntity proposalEntity = new ProposalEntity();

        // Act
        proposalEntity.setZip("21654");

        // Assert
        assertEquals("21654", proposalEntity.getZip());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals(
                "ProposalEntity(id=null, zip=null, street=null, neighborhood=null, complement=null, city=null, state=null,"
                        + " proposal=null, document=null)",
                (new ProposalEntity()).toString());
    }
}

