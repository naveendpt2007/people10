package com.people.hotel;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.people.hotel.dto.Customer;
import com.people.hotel.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelBookingApplicationTests.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HotelBookingApplicationTests {

//	@Autowired
//	private MockMvc mockMvc;
	
//	@LocalServerPort
//	private int port;

//	@MockBean
//	private CustomerService customerService;
	
//	TestRestTemplate restTemplate = new TestRestTemplate();

//	HttpHeaders headers = new HttpHeaders();

//	@Before
//	public void before() {
//		headers.add("Authorization", createHttpAuthenticationHeaderValue(
//				"user1", "secret1"));
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	}
	
//	@Test
//	public void testCustomerCreation() throws Exception {
//		Customer mockCustomer = new Customer();
//		mockCustomer.setFirstName("Naveen");
//		mockCustomer.setLastName("Kumar");
//		mockCustomer.setEmail("naveen.dpt2020@gmail.com");
//		mockCustomer.setPassword("abc1234");
//		mockCustomer.setDateOfBirth(new Date());
//		mockCustomer.setId(10013);
//		
//		Mockito.when(customerService.addCustomer(Mockito.any(Customer.class))).thenReturn(mockCustomer);
		
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
//				"api/createCustomer")
//				.accept(MediaType.APPLICATION_JSON).content("{\"firstName\":\"Naveen\",\"lastName\":\"Kumar\",\"dateOfBirth\":\"1988-11-20\",\"email\":\"naveen.dpt2020@gmail.com\",\"password\":\"abc1234\"}")
//				.contentType(MediaType.APPLICATION_JSON);
//		
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

//		MockHttpServletResponse response = result.getResponse();

//		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

//		assertEquals("http://localhost/students/Student1/courses/1", response
//				.getHeader(HttpHeaders.LOCATION));

		
//	}
	
//	private String createURLWithPort(String uri) {
//		return "http://localhost:" + port + uri;
//	}
//	
//	private String createHttpAuthenticationHeaderValue(String userId,
//			String password) {
//
//		String auth = userId + ":" + password;
//
//		byte[] encodedAuth = Base64.encode(auth.getBytes(Charset
//				.forName("US-ASCII")));
//
//		String headerValue = "Basic " + new String(encodedAuth);
//
//		return headerValue;
//	}

}
