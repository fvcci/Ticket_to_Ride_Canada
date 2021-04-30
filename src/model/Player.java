package model;

import util.EventType;
import util.Observable;

import java.util.*;

/**
 * @author Nathan Wong
 */
public class Player extends Observable {

    private final String name;
    private final PlayerColour playerColour;
    private final ArrayList<Ticket> tickets;
    private final ArrayList<Route> claimedRoutes;
    
    private int totalCards;
    private final int[] numCardsOfColour;
    private int numTrains;
    private int score;
    
    public Player (String name, PlayerColour playerColour) {
        
        this.name = name;
        this.playerColour = playerColour;
        this.tickets = new ArrayList<>();
        this.claimedRoutes = new ArrayList<>();
        this.numCardsOfColour = new int[CardColour.values().length];
        this.numTrains = 45;
        this.totalCards = this.score = 0;
        
    }
    
    public void addTicket (Ticket ticket) {
        tickets.add(ticket);
        notifyObservers(EventType.UPDATE_TICKETS);
    }
    
    public ArrayList<Route> getClaimedRoutes () {
        return claimedRoutes;
    }

    public String getName() {
        return name;
    }
    
    public int getScore () {
        return score;
    }
    
    public void addTrainCard (TrainCard card) {
        ++totalCards;
        ++numCardsOfColour[card.getColour().getValue()];
        notifyObservers(EventType.UPDATE_TRAINS);
    }
    
    public void removeTrainCards (int cardColour, int numberRemoved) {
        totalCards -= totalCards;
        numCardsOfColour[cardColour] -= numberRemoved;
    }
    
    public int getTotalCards () {
        return totalCards;
    }
    
    public ArrayList<Ticket> getTickets(){
        return tickets;
    }
    
    public void setScore (int score) {
        this.score = score;
        notifyObservers(EventType.UPDATE_SCORES);
    }
    
    public int getNumTrains () {
        return numTrains;
    }
    
    public void setNumTrains (int numTrains) {
        this.numTrains = numTrains;
    }
    
    public int getNumCardsOfColour (int index) {
        return numCardsOfColour[index];
    }
    
    public PlayerColour getPlayerColour () {
        return playerColour;
    }
    
    @Override
    public String toString () {
        return "Player{"+
                "name='"+name+'\''+
                ", playerColour="+playerColour+
                ", tickets="+tickets+
                ", claimedRoutes="+claimedRoutes+
                ", cards="+Arrays.toString(numCardsOfColour)+
                ", numTrains="+numTrains+
                ", score="+score+
                '}';
    }
    
}
