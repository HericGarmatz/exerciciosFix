package entities;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entities.enumm.OrderStatus;

public class Order {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrdemItem> items = new ArrayList<OrdemItem>();


    public Order() {
    }
    
    public Order(Date moment, OrderStatus orderStatus, Client client) {
        this.moment = moment;
        this.status = orderStatus;
        this.client = client;
    }

    public void addItem(OrdemItem item){
        items.add(item);
    }
    public void removeItem(OrdemItem item){
        items.remove(item);
    }
    
    public Date getMoment() {
        return moment;
    }
    public OrderStatus getStatus() {
        return status;
    }

    public void setMoment(Date date) {
        this.moment =date;
    }

    public void setStatus(OrderStatus orderStatus) {
        this.status = orderStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public double total(){        
        double sum = 0;
        for (OrdemItem it: items) {
            sum += it.subTotal();
        }
        return sum;
    }

    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (OrdemItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}
