package com.github.hieuvv.dp;

// =========================================================================
// Abstract Factory is a creation design pattern that lets you produce
// families of related objects without specifying their concrete classes.
// All variants of the same object must be moved to a single class hierarchy.
// Each concrete factory corresponds to s specific product variant.
// The client shouldn't care about the concrete class of the factory it works with.
// ==========
public class AbstractFactoryMethod {

    public void main() {
//        Client client = new Client(new ConcreteFactory2());
//        client.someOperation();

        System.setProperty("os.name", "MacOS");
        Application app = new Application();
        app.createUI();
        app.paint();

    }

    public static void main(String[] args) {

        AbstractFactoryMethod test = new AbstractFactoryMethod();
        test.main();

    }


// =========================================================================
// ABSTRACT PRODUCTS declare interfaces for a set of distinct
// but related products which make up a product family.
// ==========

    interface ProductA {
        void doStuff();
    }

    interface ProductB {
        void doStuff();
    }

// =========================================================================
// CONCRETE PRODUCTS are various implementations of abstract products, grouped by variants.
// Each abstract product must be implemented in all given variants.
// ==========

    class ConcreteProductA1 implements ProductA {

        @Override
        public void doStuff() {
            System.out.println("Product A1 do stuff");
        }
    }

    class ConcreteProductA2 implements ProductA {

        @Override
        public void doStuff() {
            System.out.println("Product A2 do stuff");
        }
    }

    class ConcreteProductB1 implements ProductB {

        @Override
        public void doStuff() {
            System.out.println("Product B1 do stuff");
        }
    }

    class ConcreteProductB2 implements ProductB {


        @Override
        public void doStuff() {
            System.out.println("Product B2 do stuff");
        }
    }

// =========================================================================
// ABSTRACT FACTORY interface declares a set of methods for creating each of the abstract products.
// ==========

    interface AbstractFactory {

        ProductA createProductA();

        ProductB createProductB();
    }

// =========================================================================
// CONCRETE FACTORIES implement creation methods of the abstract factory.
// Each concrete factory corresponds to a specific variant of products and creates only those product variants.
// ==========

    class ConcreteFactory1 implements AbstractFactory {

        public ProductA createProductA() {
            return new ConcreteProductA1();
        }

        public ProductB createProductB() {
            return new ConcreteProductB1();
        }
    }

    class ConcreteFactory2 implements AbstractFactory {

        public ProductA createProductA() {
            return new ConcreteProductA2();
        }

        public ProductB createProductB() {
            return new ConcreteProductB2();
        }
    }

// =========================================================================
// CLIENT Although concrete factories instantiate concrete products, signatures of their creation methods
// must return corresponding abstract products.
// This way the client code that uses a factory doesn't get couple to the specific variant
// of the product it gets from a factory.
// The client can work with any concrete factory/product variant,
// as long as it communicates with their objects via abstraction interfaces.
// ==========


    class Client {

        private final AbstractFactory factory;

        public Client(AbstractFactory factory) {
            this.factory = factory;
        }

        public void someOperation() {
            ProductA productA = factory.createProductA();
            ProductB productB = factory.createProductB();
            productA.doStuff();
            productB.doStuff();

        }

    }

// =========================================================================
// EXAMPLE 1: The cross-platform UI classes example.
// ==========

    /**
     * The abstract factory interface declares a set of methods that return different abstract products. These products are
     * called a family and are related by a high-level theme or concept.
     * Products of one family are usually able to collaborate among themselves. A family of products may have several variants, but
     * the products of one variant are incompatible with the products of another variant.
     */
    interface GUIFactory {

        Button createButton();

        Checkbox createCheckBox();
    }

    /**
     * Concrete factories' produce a family of products that belong to a single variant.
     * The factory guarantees that the resulting products are compatible Signatures of the concrete factory's methods
     * return an abstract product, while inside the method a concrete product is instantiated.
     */
    class WinFactory implements GUIFactory {

        @Override
        public Button createButton() {
            return new WinButton();
        }

        @Override
        public Checkbox createCheckBox() {
            return new WinCheckbox();
        }
    }

    /**
     * Each concrete factory has a corresponding product variant.
     */
    class MacFactory implements GUIFactory {

        @Override
        public Button createButton() {
            return new MacButton();
        }

        @Override
        public Checkbox createCheckBox() {
            return new MacCheckbox();
        }
    }

    interface Button {
        void paint();
    }

    /**
     * Concrete products are created by corresponding concrete factories
     */
    class WinButton implements Button {

        /**
         * Render a button win Windows style.
         */
        @Override
        public void paint() {
            System.out.println("Render Win button");
        }
    }

    class MacButton implements Button {

        /**
         * Render a button in macOS style.
         */
        @Override
        public void paint() {
            System.out.println("Render Mac button");
        }
    }

    /**
     * Here's the base interface of another product. All products can interact with each other,
     * but proper interaction is possible between products of the same concrete variant.
     */
    interface Checkbox {
        void paint();
    }

    class WinCheckbox implements Checkbox {

        /**
         * Render a checkbox in Windows style.
         */
        @Override
        public void paint() {
            System.out.println("Render Window check box");
        }
    }

    class MacCheckbox implements Checkbox {

        /**
         * Render a checkbox in macOS style.
         */
        @Override
        public void paint() {
            System.out.println("Render MacOS check box");
        }
    }

    /**
     * The client code works with factories and products only through abstract types. GUIFactory, Button and Checkbox.
     * This lets you pass any factory or product subclass to the client code without breaking it.
     */
    class Application {

        private final GUIFactory factory;

        public Application() {
            GUIFactory factory;
            String osName = System.getProperty("os.name");
            if (osName == "Windows") {
                this.factory = new WinFactory();
            } else if (osName == "MacOS") {
                this.factory = new MacFactory();
            } else {
                throw  new RuntimeException("Error! Unknown operating system.");
            }
        }

        private Button button;

        void createUI() {
            this.button = factory.createButton();
        }

        void paint() {
            button.paint();
        }

    }



}