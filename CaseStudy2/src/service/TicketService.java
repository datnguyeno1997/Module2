package service;

import config.Config;
import model.Ticket;

import utils.FileUtils;


import java.util.ArrayList;
import java.util.List;

public class TicketService implements ITicketService{
    private final String pathTicket = "D:\\moduel2\\CaseStudy2\\src\\data\\ticket.txt";

    public List<Ticket> getAllTicket() {
        return FileUtils.readFile(pathTicket, Config.TYPE_TICKET);
    }

    public Ticket findTicketById(long idStaff) {
        List<Ticket> tickets = FileUtils.readFile(pathTicket, Config.TYPE_TICKET);
        for (Ticket c : tickets) {
            if (c.getId() == idStaff) {
                return c;
            }
        }
        return null;
    }

    public void updateTicketById(long idStaff, Ticket ticket) {
        List<Ticket> tickets = FileUtils.readFile(pathTicket, Config.TYPE_TICKET);
        for (Ticket c : tickets) {
            if (c.getId() == idStaff) {
                c.setDateStart(ticket.getDateStart());
                c.setDateEnd(ticket.getDateEnd());
                c.setTimeStart(ticket.getTimeStart());
                c.setTime(ticket.getTime());
            }
        }
        FileUtils.writeFile(pathTicket, tickets);
    }

    public void deleteTicketById(long idTicket) {
        List<Ticket> tickets = FileUtils.readFile(pathTicket, Config.TYPE_TICKET);
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId() == idTicket) {
                tickets.remove(i);
                break;
            }
        }
        FileUtils.writeFile(pathTicket, tickets);
    }

    public void addTicket(Ticket staff) {
        List<Ticket> tickets = FileUtils.readFile(pathTicket, Config.TYPE_TICKET);
        tickets.add(staff);
        FileUtils.writeFile(pathTicket, tickets);
    }

    @Override
    public List<Ticket> searchTicketByName(String keyName) {
        List<Ticket> tickets = getAllTicket();
        List<Ticket> results = new ArrayList<>();
        return results;
    }


}
