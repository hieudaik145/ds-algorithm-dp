package com.github.hieuvv.dp;

// =========================================================================
// The Factory Method pattern suggests that you replace direct object construction calls (using new operator) with calls to a special factory method. Don't worry: the objects
// are still created via the new operator, but it's being called from within the factory method. Objects returned by a factory method are often referred to as "product"
// Subclasses can alter the class of objects being returned factory method
// Note that the factory method doesn't have to create new instances all the time. It can also return existing objects from a cache, an object pool, or another resource.
// ==========
public class FactoryMethod {

    public void main() {
//        Creator creator = new ConcreteCreatorB();
//        creator.someOperation();
//        creator = new ConcreteCreatorA();
//
//        Product productA = creator.createProduct();
//        productA.doStuff();

        System.setProperty("os.name", "Web");
        Application app = new Application();
        app.main();

    }

    public static void main(String[] args) {
        FactoryMethod test = new FactoryMethod();
        test.main();
    }

// =========================================================================
// PRODUCT
// The Product declare the interface, which is common to all objects that can be produced by the creator and its subclasses
// All product must follow the same interface.
// ==========

interface Product {

    void doStuff();
}

// =========================================================================
// CONCRETE PRODUCTS
// Concrete Products are different implements of the product interface
// ==========

class ConcreteProductA implements Product {

    @Override
    public void doStuff() {
        System.out.println("Product A do stuff");
    }
}

class ConcreteProductB implements Product {

    @Override
    public void doStuff() {
        System.out.println("Product B do stuff");
    }
}

// =========================================================================
// CREATOR
// The Creator class declares the factory method that returns new product objects.
// It's important that the return type of this method matches the product interface.
// You can declare the factory method as abstract to force own version of the method. As an alternative, the base factory method can return some default product type.
// Note, despite its name, product creation is not the primary responsibility of the creator. Usually, the creator class already has some core business logic related to products.
// The factory method helps to decouple this logic from concrete product classes. Here is an analogy: a large software development company can have a training department for programmers.
// However, the primary function of the company as a whole is still writing code, not producing programmers.
// ==========

interface Creator {

    default void someOperation() {
        Product p = createProduct();
        p.doStuff();
    }

    Product createProduct();
}

// =========================================================================
// CONCRETE CREATOR
// Concrete Creators override the base factory method, so it returns a different type of product
// ==========

class ConcreteCreatorA implements Creator {

    @Override
    public Product createProduct() {

        return new ConcreteProductA();
    }
}

class ConcreteCreatorB implements Creator {

    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }
}

// =========================================================================
// EXAMPLES
// DIFFERENT TYPE OF BUTTON IN OS
// =============================================================================
// CREATOR
// The creator class declares the factory method that mus return an object of a product class.
// The creator's subclasses usually provide the implementation of this method
// ==============================================================================

// =========================================================================
// PRODUCT
// The product interface declares the operations that all concrete products must implement.
// ==========
interface Button {

    void onClick(boolean closeDialog);

    void render(int a, int b);

}

// =========================================================================
// CONCRETE PRODUCTS
// Concrete products provide various implementations of the product interface
// ==========

class WindowsButton implements Button {

    /**
     * Action click a button Windows.
     *
     * @param closeDialog
     */
    @Override
    public void onClick(boolean closeDialog) {
        System.out.println("Button Windows has clicked");
    }

    /**
     * Render a button in Windows style.
     */
    @Override
    public void render(int a, int b) {
        System.out.println("Button Windows has rendered at position a: " + a + "- b: " + b);
    }
}

class HTMLButton implements Button {

    /**
     * Bind a web browser click event.
     *
     * @param closeDialog
     */
    @Override
    public void onClick(boolean closeDialog) {
        System.out.println("Button Webs has clicked");
    }

    /**
     * Return an HTML representation of a button
     */
    @Override
    public void render(int a, int b) {
        System.out.println("Button Webs has rendered at position a: " + a + "- b: " + b);
    }
}

// =========================================================================
// CREATOR
// The creator class declares the factory method that mus return an object of a product class.
// The creator's subclasses usually provide the implementation of this method
// ==========
interface Dialog {

    // The creator may also provide some default implementation of the factory method
    Button createButton();

    // Note that, despite its name, the creator's primary responsibility isn't creating products. It usually
    // contains some core business logic that relies on product objects return by the factory method indirectly
    // change that business logic by overriding the factory method and returning a different type of product from it
    default void render() {
        // Call the factory method to create a product object.
        Button okButton = createButton();

        // Now use the product.
        okButton.onClick(true);

        okButton.render(1, 5);
    }

}

// =========================================================================
// CONCRETE CREATOR
// Concrete creators override the factory method to change the resulting product's type.
// ==========
class WindowsDialog implements Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

class WebDialog implements Dialog {

    @Override
    public Button createButton() {
        return new HTMLButton();
    }
}

class Application {

    private Dialog dialog;

    /**
     * The application picks a creator's type depending on the current configuration or environment settings.
     */
    void initialize() {
        String os = System.getProperty("os.name");
        if (os == "Windows") {
            dialog = new WindowsDialog();
        } else if (os == "Web") {
            dialog = new WebDialog();
        } else {
            throw new RuntimeException("Error! Unknown operating system.");
        }
    }

    // The client code works with an instance of a concrete creator,
    // albeit through its base interface as long as the client keeps working with the creator
    // via the base interface, you can pass it any creator's subclass.
    public void main() {
        this.initialize();
        dialog.render();
    }
}

}