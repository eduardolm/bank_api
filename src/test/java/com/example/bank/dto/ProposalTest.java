package com.example.bank.dto;

import com.example.bank.enums.State;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ProposalTest {
    @Test
    public void testCanEqual() {
        // Arrange, Act and Assert
        assertFalse((new Proposal()).canEqual("other"));
    }

    @Test
    public void testConstructor() {
        // Arrange and Act
        Proposal actualProposal = new Proposal();

        // Assert
        assertNull(actualProposal.getStreet());
        assertNull(actualProposal.getComplement());
        assertNull(actualProposal.getNeighborhood());
        assertNull(actualProposal.getCity());
        assertNull(actualProposal.getZip());
        assertNull(actualProposal.getId());
        assertNull(actualProposal.getState());
        assertEquals("Proposal(id=null, zip=null, street=null, neighborhood=null, complement=null, city=null, state=null)",
                actualProposal.toString());
    }

    @Test
    public void testEquals() {
        // Arrange, Act and Assert
        assertFalse((new Proposal()).equals("o"));
    }

    @Test
    public void testEquals2() {
        // Arrange
        Proposal proposal = new Proposal();

        // Act and Assert
        assertTrue(proposal.equals(new Proposal()));
    }

    @Test
    public void testEquals3() {
        // Arrange
        Proposal proposal = new Proposal();
        proposal.setZip("21654");

        // Act and Assert
        assertFalse(proposal.equals(new Proposal()));
    }

    @Test
    public void testEquals4() {
        // Arrange
        Proposal proposal = new Proposal();
        proposal.setCity("Oxford");

        // Act and Assert
        assertFalse(proposal.equals(new Proposal()));
    }

    @Test
    public void testEquals5() {
        // Arrange
        Proposal proposal = new Proposal();
        proposal.setZip("21654");

        // Act and Assert
        assertFalse((new Proposal()).equals(proposal));
    }

    @Test
    public void testEquals6() {
        // Arrange
        Proposal proposal = new Proposal();
        proposal.setCity("Oxford");

        // Act and Assert
        assertFalse((new Proposal()).equals(proposal));
    }

    @Test
    public void testEquals7() {
        // Arrange
        Proposal proposal = new Proposal();
        proposal.setNeighborhood("Neighborhood");

        // Act and Assert
        assertFalse(proposal.equals(new Proposal()));
    }

    @Test
    public void testEquals8() {
        // Arrange
        Proposal proposal = new Proposal();
        proposal.setComplement("Complement");

        // Act and Assert
        assertFalse(proposal.equals(new Proposal()));
    }

    @Test
    public void testEquals9() {
        // Arrange
        Proposal proposal = new Proposal();
        proposal.setId(UUID.randomUUID());

        // Act and Assert
        assertFalse(proposal.equals(new Proposal()));
    }

    @Test
    public void testGetCity() {
        // Arrange, Act and Assert
        assertNull((new Proposal()).getCity());
    }

    @Test
    public void testGetComplement() {
        // Arrange, Act and Assert
        assertNull((new Proposal()).getComplement());
    }

    @Test
    public void testGetId() {
        // Arrange, Act and Assert
        assertNull((new Proposal()).getId());
    }

    @Test
    public void testGetNeighborhood() {
        // Arrange, Act and Assert
        assertNull((new Proposal()).getNeighborhood());
    }

    @Test
    public void testGetState() {
        // Arrange, Act and Assert
        assertNull((new Proposal()).getState());
    }

    @Test
    public void testGetStreet() {
        // Arrange, Act and Assert
        assertNull((new Proposal()).getStreet());
    }

    @Test
    public void testGetZip() {
        // Arrange, Act and Assert
        assertNull((new Proposal()).getZip());
    }

    @Test
    public void testHashCode() {
        // Arrange, Act and Assert
        assertEquals(64204658, (new Proposal()).hashCode());
    }

    @Test
    public void testHashCode2() {
        // Arrange
        Proposal proposal = new Proposal();
        proposal.setZip("21654");

        // Act and Assert
        assertEquals(-566994325, proposal.hashCode());
    }

    @Test
    public void testHashCode3() {
        // Arrange
        Proposal proposal = new Proposal();
        proposal.setCity("Oxford");

        // Act and Assert
        assertEquals(-1504926923, proposal.hashCode());
    }

    @Test
    public void testHashCode4() {
        // Arrange
        Proposal proposal = new Proposal();
        proposal.setNeighborhood("Neighborhood");

        // Act and Assert
        assertEquals(897943355, proposal.hashCode());
    }

    @Test
    public void testHashCode5() {
        // Arrange
        Proposal proposal = new Proposal();
        proposal.setComplement("Complement");

        // Act and Assert
        assertEquals(-530001771, proposal.hashCode());
    }

    @Test
    public void testHashCode6() {
        // Arrange
        Proposal proposal = new Proposal();
        proposal.setStreet("Street");

        // Act and Assert
        assertEquals(-1553137686, proposal.hashCode());
    }

    @Test
    public void testHashCode7() {
        // Arrange
        Proposal proposal = new Proposal();
        proposal.setState(State.AC);
        Proposal proposal1 = new Proposal();
        proposal1.setState(State.AC);

        // Act and Assert
        assertEquals(proposal1.hashCode(), proposal.hashCode());
    }

    @Test
    public void testSetCity() {
        // Arrange
        Proposal proposal = new Proposal();

        // Act
        proposal.setCity("Oxford");

        // Assert
        assertEquals("Oxford", proposal.getCity());
    }

    @Test
    public void testSetComplement() {
        // Arrange
        Proposal proposal = new Proposal();

        // Act
        proposal.setComplement("Complement");

        // Assert
        assertEquals("Complement", proposal.getComplement());
    }

    @Test
    public void testSetId() {
        // Arrange
        Proposal proposal = new Proposal();
        UUID randomUUIDResult = UUID.randomUUID();

        // Act
        proposal.setId(randomUUIDResult);

        // Assert
        assertSame(randomUUIDResult, proposal.getId());
    }

    @Test
    public void testSetNeighborhood() {
        // Arrange
        Proposal proposal = new Proposal();

        // Act
        proposal.setNeighborhood("Neighborhood");

        // Assert
        assertEquals("Neighborhood", proposal.getNeighborhood());
    }

    @Test
    public void testSetState() {
        // Arrange
        Proposal proposal = new Proposal();

        // Act
        proposal.setState(State.AC);

        // Assert
        assertEquals(State.AC, proposal.getState());
    }

    @Test
    public void testSetStreet() {
        // Arrange
        Proposal proposal = new Proposal();

        // Act
        proposal.setStreet("Street");

        // Assert
        assertEquals("Street", proposal.getStreet());
    }

    @Test
    public void testSetZip() {
        // Arrange
        Proposal proposal = new Proposal();

        // Act
        proposal.setZip("21654");

        // Assert
        assertEquals("21654", proposal.getZip());
    }

    @Test
    public void testToString() {
        // Arrange, Act and Assert
        assertEquals("Proposal(id=null, zip=null, street=null, neighborhood=null, complement=null, city=null, state=null)",
                (new Proposal()).toString());
    }
}

