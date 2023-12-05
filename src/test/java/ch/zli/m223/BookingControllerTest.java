package ch.zli.m223;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class BookingControllerTest {
     @Test
    @Order(1)
    public void testShowBookings() {
        given()
        .when().get("/bookings")
        .then()
        .statusCode(200);
        
    }
	@Test
	void testCreate() {

	}

	@Test
	void testCreateSerialBooking() {

	}

	@Test
	void testDelete() {

	}

	@Test
	void testIndex() {

	}

	@Test
	void testUpdate() {

	}
    
}
