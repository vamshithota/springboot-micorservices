package com.company.currencyexchangeservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class CurrencyExchangeServiceApplicationTests {

	@Test
	public void testRatelimiter() {
		/*
		 * EXTERNAL_SERVICE.stubFor(WireMock.get("/api/external") .willReturn(ok()));
		 * Map<Integer, Integer> responseStatusCount = new ConcurrentHashMap()<>();
		 * 
		 * IntStream.rangeClosed(1, 50) .parallel() .forEach(i -> {
		 * ResponseEntity<String> response =
		 * restTemplate.getForEntity("/api/rate-limiter", String.class); int statusCode
		 * = response.getStatusCodeValue(); responseStatusCount.put(statusCode,
		 * responseStatusCount.getOrDefault(statusCode, 0) + 1); });
		 * 
		 * assertEquals(2, responseStatusCount.keySet().size());
		 * assertTrue(responseStatusCount.containsKey(TOO_MANY_REQUESTS.value()));
		 * assertTrue(responseStatusCount.containsKey(OK.value()));
		 * EXTERNAL_SERVICE.verify(5, getRequestedFor(urlEqualTo("/api/external")));
		 */}

}
