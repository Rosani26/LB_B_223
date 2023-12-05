package ch.zli.m223;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class LocationControllerTest {
    
    @Test
    @Order(1)
    public void testShowBookings() {
        given()
        .when().get("/workspaces/availability")
        .then()
        .statusCode(200);
        
    }
	@Test
	void test() {

	}
  
}
