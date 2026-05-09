class Observer {
public:
    virtual void notify(string& itemName) = 0;
};

class Customer : public Observer {
private:
    string name;
    int notifications;

public:
    Customer(string& name) : name(name), notifications(0) {}

    void notify(string& itemName) override {
        notifications += 1;
    }

    int countNotifications() {
        return notifications;
    }
};

class OnlineStoreItem {
private:
    string itemName;
    int stock;
    vector<Observer*>observers;
public:
    OnlineStoreItem(string& itemName, int stock) : itemName(itemName), stock(stock) {}

    void subscribe(Observer* observer) {
        observers.push_back(observer);
    }

    void unsubscribe(Observer* observer) {
        observers.erase(find(observers.begin(), observers.end(), observer));
    }

    void updateStock(int newStock) {
        if(newStock == 0 || stock !=0) {
            stock = newStock;
            return;
        }
        stock = newStock;
        for(int i = 0; i < observers.size(); i++) {
            observers[i]->notify(itemName);
        }
    }
};
