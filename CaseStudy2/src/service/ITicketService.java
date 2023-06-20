package service;

import model.Ticket;

import java.util.List;

public interface ITicketService {
    List<Ticket> getAllTicket();
    Ticket findTicketById(long idTicket);
    void updateTicketById(long idTicket, Ticket staff);
    void deleteTicketById(long idTicket);
    void addTicket(Ticket user);

    List<Ticket> searchTicketByName(String keyName);
}
