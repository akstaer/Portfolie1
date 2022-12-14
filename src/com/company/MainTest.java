package com.company;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testLoadingCargoContainer(){
        ContainerVessel c = new ContainerVessel("Danmark", 3, 50, 230);

        c.loadingCargo(10,5);

        assertEquals(5, c.numbersOfContainer);

    }
    @Test
    void testLoadingCargoContainer2(){
        ContainerVessel c = new ContainerVessel("Danmark", 3, 50, 230);

        c.loadingCargo(10,5);

        assertEquals(10,c.containerCapacity);
    }

    @Test
    void testUtilityContainer(){
        ContainerVessel c = new ContainerVessel("Danmark", 3, 50, 230);
        c.loadingCargo(10,5);

        assertEquals(50.0, c.utilityLevelOfCapacity());
    }

    @Test

    void testLoadingCargoTanker(){
        TankerVessel t = new TankerVessel("Tyskland",3,50,270);
        t.loadingCargo(10);
        assertEquals(10, t.cargo);
    }

    @Test
    void testLoadingCargoTanker2(){
        TankerVessel t = new TankerVessel("Tyskland",3,50,270);

        assertTrue(t.tal>=1 && t.tal<=10); // tester om vores random tal er mellem 1 og 10
    }

    @Test
    void TestUtilityTanker (){
        TankerVessel t = new TankerVessel("Tyskland",3,50,270);
        t.loadingCargo(8);
        //initaliserer tal til 8, da det ellers er random mellem 1-10.
        t.tal=8;
        assertTrue(t.tal == t.cargo);
    }

    @Test
    void TestUtilityTanker2 (){
        TankerVessel t = new TankerVessel("Tyskland",3,50,270);
        t.loadingCargo(8);
        t.tal=7;
        assertFalse(t.tal == t.cargo);
    }

    @Test
    void testLoadingCargoRoRo(){
        RoRoVessel r = new RoRoVessel("Kroatien",10,500,2000,1000);
        r.loadingCargo(4,7);
        assertEquals(4,r.cars);
    }

    @Test
    void testLoadingCargoRoRo2(){
        RoRoVessel r = new RoRoVessel("Kroatien",10,500,2000,1000);
        r.loadingCargo(4,7);
        assertEquals(7,r.trucks);
    }

    @Test
    void TestUtilityRoRo(){
        RoRoVessel r = new RoRoVessel("Kroatien",10,500,2000,1000);
        r.loadingCargo(4,7);
        assertEquals(24.2,r.utilityLevelOfCapacity());
    }

    //dummy tests
    @Test
    void TestTrackingOfContainer(){
        ContainerVessel c = new ContainerVessel("Danmark", 3, 50, 230);
        c.trackingContainer(40.0, 50.6);
        assertEquals(40.0, c.positionX);
    }
    @Test
    void TestDestination(){
        ContainerVessel c = new ContainerVessel("Indien",4,60,240);
        c.futureDestination("Congo");
        assertEquals("Congo",c.destination);
    }

}
