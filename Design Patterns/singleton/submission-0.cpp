class Singleton {
private:
    static Singleton *instance;
    string value_;
    Singleton() {}
public:

    static Singleton *getInstance() {
        if(instance == nullptr) {
            instance = new Singleton();
        }
        return instance;
    }

    string getValue() {
        return value_;
    }

    void setValue(string &value) {
        value_ = value;
    }
};

Singleton* Singleton::instance = nullptr;
