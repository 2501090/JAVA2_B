import java.util.ArrayList;

public class PowerOffice {
    private ArrayList<Customer> customers;

    public PowerOffice(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    protected void sortByCharge() {
        for (int i = 0; i < customers.size() - 1; i++) {
            for (int j = 0; j < customers.size() - 1 - i; j++) {
                if (customers.get(j).charge() > customers.get(j + 1).charge()) {
                    Customer temp = customers.get(j);
                    customers.set(j, customers.get(j + 1));
                    customers.set(j + 1, temp);
                }
            }
        }
    }
}
