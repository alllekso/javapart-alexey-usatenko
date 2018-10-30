package automationPractce;

import automationPractce.model.EntityDress;

public class TestRunner {
    public static void main(String[] args) {
        CartTests cartTests = new CartTests();
        cartTests.init("firefox", "http://automationpractice.com");

        EntityDress entityDress1 = new EntityDress();
        entityDress1.setName("Printed Dress");
        entityDress1.setModel("demo_3");
        entityDress1.setSize("S");
        entityDress1.setColor("Orange");
        entityDress1.setPrice(26.00);

        EntityDress entityDress2 = new EntityDress();
        entityDress2.setName("Printed Dress");
        entityDress2.setModel("demo_3");
        entityDress2.setSize("S");
        entityDress2.setColor("Orange");
        entityDress2.setPrice(26.00);

        Object[][] testData = {
                {entityDress1, 2},
                {entityDress2, 2}
        };

        // TODO
//        for (int i = 0; i < testData.length; i++) {
//            cartTests.testAddDressToCart((EntityDress) testData[i][0], (int) testData[i][1]);
//        }
    }
}