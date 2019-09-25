package design.factory;

/**
 * 工厂模式
 */
interface IProduct {
    void productMethod();
}

class Product implements IProduct {
    public void productMethod() {
        System.out.println("产品");
    }
}

interface IFactory {
    IProduct createProduct();
}

class Factory implements IFactory {
    public IProduct createProduct() {
        return new Product();
    }
}

public class Client {
    public static void main(String[] args) {
        IFactory factory = new Factory();
        IProduct prodect = factory.createProduct();
        prodect.productMethod();
    }
}
