package com.example.bank.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ProposalReviewTest {
    @Test
    public void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new ProposalReview()).canEqual("other"));
    }

    @Test
    public void testConstructor() {
        // Arrange and Act
        ProposalReview actualProposalReview = new ProposalReview();

        // Assert
        assertNull(actualProposalReview.getStreet());
        assertNull(actualProposalReview.getNeighborhood());
        assertNull(actualProposalReview.getBirtDate());
        assertNull(actualProposalReview.getCity());
        assertNull(actualProposalReview.getZip());
        assertNull(actualProposalReview.getLastName());
        assertNull(actualProposalReview.getComplement());
        assertNull(actualProposalReview.getAccepted());
        assertNull(actualProposalReview.getStatus());
        assertNull(actualProposalReview.getEmail());
        assertNull(actualProposalReview.getId());
        assertNull(actualProposalReview.getState());
        assertNull(actualProposalReview.getFirstName());
        assertNull(actualProposalReview.getCpf());
        assertEquals("ProposalReview(id=null, firstName=null, lastName=null, email=null, birtDate=null, cpf=null,"
                + " status=null, zip=null, street=null, complement=null, neighborhood=null, city=null, state=null,"
                + " accepted=null)", actualProposalReview.toString());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertFalse((new ProposalReview()).equals("o"));
    }

    @Test
    public void testEquals10() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setLastName("Doe");

        // Act and Assert
        assertFalse((new ProposalReview()).equals(proposalReview));
    }

    @Test
    public void testEquals11() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setZip("21654");

        // Act and Assert
        assertFalse((new ProposalReview()).equals(proposalReview));
    }

    @Test
    public void testEquals12() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setFirstName("Jane");

        // Act and Assert
        assertFalse((new ProposalReview()).equals(proposalReview));
    }

    @Test
    public void testEquals2() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();

        // Act and Assert
        assertTrue(proposalReview.equals(new ProposalReview()));
    }

    @Test
    public void testEquals3() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setCity("Oxford");

        // Act and Assert
        assertFalse((new ProposalReview()).equals(proposalReview));
    }

    @Test
    public void testEquals4() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setState("MD");

        // Act and Assert
        assertFalse((new ProposalReview()).equals(proposalReview));
    }

    @Test
    public void testEquals5() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setLastName("Doe");

        // Act and Assert
        assertFalse(proposalReview.equals(new ProposalReview()));
    }

    @Test
    public void testEquals6() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setZip("21654");

        // Act and Assert
        assertFalse(proposalReview.equals(new ProposalReview()));
    }

    @Test
    public void testEquals7() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setFirstName("Jane");

        // Act and Assert
        assertFalse(proposalReview.equals(new ProposalReview()));
    }

    @Test
    public void testEquals8() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setCity("Oxford");

        // Act and Assert
        assertFalse(proposalReview.equals(new ProposalReview()));
    }

    @Test
    public void testEquals9() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setState("MD");

        // Act and Assert
        assertFalse(proposalReview.equals(new ProposalReview()));
    }

    @Test
    public void testGetAccepted() {
        // Arrange, Act and Assert
        assertNull((new ProposalReview()).getAccepted());
    }

    @Test
    public void testGetBirtDate() {
        // Arrange, Act and Assert
        assertNull((new ProposalReview()).getBirtDate());
    }

    @Test
    public void testGetCity() {
        // Arrange, Act and Assert
        assertNull((new ProposalReview()).getCity());
    }

    @Test
    public void testGetComplement() {
        // Arrange, Act and Assert
        assertNull((new ProposalReview()).getComplement());
    }

    @Test
    public void testGetCpf() {
        // Arrange, Act and Assert
        assertNull((new ProposalReview()).getCpf());
    }

    @Test
    public void testGetEmail() {
        // Arrange, Act and Assert
        assertNull((new ProposalReview()).getEmail());
    }

    @Test
    public void testGetFirstName() {
        // Arrange, Act and Assert
        assertNull((new ProposalReview()).getFirstName());
    }

    @Test
    public void testGetId() {
        // Arrange, Act and Assert
        assertNull((new ProposalReview()).getId());
    }

    @Test
    public void testGetLastName() {
        // Arrange, Act and Assert
        assertNull((new ProposalReview()).getLastName());
    }

    @Test
    public void testGetNeighborhood() {
        // Arrange, Act and Assert
        assertNull((new ProposalReview()).getNeighborhood());
    }

    @Test
    public void testGetState() {
        // Arrange, Act and Assert
        assertNull((new ProposalReview()).getState());
    }

    @Test
    public void testGetStatus() {
        // Arrange, Act and Assert
        assertNull((new ProposalReview()).getStatus());
    }

    @Test
    public void testGetStreet() {
        // Arrange, Act and Assert
        assertNull((new ProposalReview()).getStreet());
    }

    @Test
    public void testGetZip() {
        // Arrange, Act and Assert
        assertNull((new ProposalReview()).getZip());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(-1373004971, (new ProposalReview()).hashCode());
    }

    @Test
    public void testHashCode10() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setState("MD");

        // Act and Assert
        assertEquals(-1372862663, proposalReview.hashCode());
    }

    @Test
    public void testHashCode11() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setNeighborhood("Neighborhood");

        // Act and Assert
        assertEquals(-539266274, proposalReview.hashCode());
    }

    @Test
    public void testHashCode12() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setEmail("Email");

        // Act and Assert
        assertEquals(-1736115554, proposalReview.hashCode());
    }

    @Test
    public void testHashCode13() {
        // Arrange
        LocalDate birtDate = LocalDate.ofEpochDay(1L);
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setBirtDate(birtDate);

        // Act and Assert
        assertEquals(1580323586, proposalReview.hashCode());
    }

    @Test
    public void testHashCode14() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setAccepted("Accepted");

        // Act and Assert
        assertEquals(840081137, proposalReview.hashCode());
    }

    @Test
    public void testHashCode2() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setLastName("Doe");

        // Act and Assert
        assertEquals(700077634, proposalReview.hashCode());
    }

    @Test
    public void testHashCode3() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setComplement("Complement");

        // Act and Assert
        assertEquals(368652352, proposalReview.hashCode());
    }

    @Test
    public void testHashCode4() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setStatus("Status");

        // Act and Assert
        assertEquals(-236838150, proposalReview.hashCode());
    }

    @Test
    public void testHashCode5() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setCpf("Cpf");

        // Act and Assert
        assertEquals(2116780771, proposalReview.hashCode());
    }

    @Test
    public void testHashCode6() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setStreet("Street");

        // Act and Assert
        assertEquals(1988044541, proposalReview.hashCode());
    }

    @Test
    public void testHashCode7() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setZip("21654");

        // Act and Assert
        assertEquals(40960696, proposalReview.hashCode());
    }

    @Test
    public void testHashCode8() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setFirstName("Jane");

        // Act and Assert
        assertEquals(704818280, proposalReview.hashCode());
    }

    @Test
    public void testHashCode9() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        proposalReview.setCity("Oxford");

        // Act and Assert
        assertEquals(537512262, proposalReview.hashCode());
    }

    @Test
    public void testSetAccepted() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();

        // Act
        proposalReview.setAccepted("Accepted");

        // Assert
        assertEquals("Accepted", proposalReview.getAccepted());
    }

    @Test
    public void testSetBirtDate() {
        // Arrange
        LocalDate birtDate = LocalDate.ofEpochDay(1L);
        ProposalReview proposalReview = new ProposalReview();

        // Act
        proposalReview.setBirtDate(birtDate);

        // Assert
        assertEquals("ProposalReview(id=null, firstName=null, lastName=null, email=null, birtDate=1970-01-02, cpf=null,"
                + " status=null, zip=null, street=null, complement=null, neighborhood=null, city=null, state=null,"
                + " accepted=null)", proposalReview.toString());
    }

    @Test
    public void testSetCity() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();

        // Act
        proposalReview.setCity("Oxford");

        // Assert
        assertEquals("Oxford", proposalReview.getCity());
    }

    @Test
    public void testSetComplement() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();

        // Act
        proposalReview.setComplement("Complement");

        // Assert
        assertEquals("Complement", proposalReview.getComplement());
    }

    @Test
    public void testSetCpf() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();

        // Act
        proposalReview.setCpf("Cpf");

        // Assert
        assertEquals("Cpf", proposalReview.getCpf());
    }

    @Test
    public void testSetEmail() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();

        // Act
        proposalReview.setEmail("Email");

        // Assert
        assertEquals("Email", proposalReview.getEmail());
    }

    @Test
    public void testSetFirstName() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();

        // Act
        proposalReview.setFirstName("Jane");

        // Assert
        assertEquals("Jane", proposalReview.getFirstName());
    }

    @Test
    public void testSetId() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        proposalReview.setId(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, proposalReview.getId());
    }

    @Test
    public void testSetLastName() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();

        // Act
        proposalReview.setLastName("Doe");

        // Assert
        assertEquals("Doe", proposalReview.getLastName());
    }

    @Test
    public void testSetNeighborhood() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();

        // Act
        proposalReview.setNeighborhood("Neighborhood");

        // Assert
        assertEquals("Neighborhood", proposalReview.getNeighborhood());
    }

    @Test
    public void testSetState() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();

        // Act
        proposalReview.setState("MD");

        // Assert
        assertEquals("MD", proposalReview.getState());
    }

    @Test
    public void testSetStatus() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();

        // Act
        proposalReview.setStatus("Status");

        // Assert
        assertEquals("Status", proposalReview.getStatus());
    }

    @Test
    public void testSetStreet() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();

        // Act
        proposalReview.setStreet("Street");

        // Assert
        assertEquals("Street", proposalReview.getStreet());
    }

    @Test
    public void testSetZip() {
        // Arrange
        ProposalReview proposalReview = new ProposalReview();

        // Act
        proposalReview.setZip("21654");

        // Assert
        assertEquals("21654", proposalReview.getZip());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("ProposalReview(id=null, firstName=null, lastName=null, email=null, birtDate=null, cpf=null,"
                + " status=null, zip=null, street=null, complement=null, neighborhood=null, city=null, state=null,"
                + " accepted=null)", (new ProposalReview()).toString());
    }
}

