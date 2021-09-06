package stepDefinitions;



import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;

import com.test.studentapp.HttpRequest;
import com.test.studentapp.StringUtil;

import io.cucumber.core.internal.gherkin.ast.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	
HttpHeaders headers;
ResponseEntity<String> response;
public static int id;
String responseMessage ;
String uri;


@Given("^I Set student service api endpoint$")
public void i_Set_POST_student_service_api_endpoint() {
	uri = "http://localhost:8080/student";
    System.out.println("Add URL :"+uri);
}

@When("^I Set request HEADER$")
public void i_Set_request_HEADER() {
	headers = new HttpHeaders();	
    headers.add("Content-Type", "application/json; utf-8");
    headers.add("Accept", "application/json");
    
    //HttpHeaders headers = new HttpHeaders();
    //headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
}

@When("Send a POST HTTP request {string}")
public void send_a_POST_HTTP_request(String requestBody) {
	id = (int) (Math.random() * (999999 - 111111)) + 111111;
	System.out.println("id=="+id);
	requestBody = requestBody.replaceFirst("@id", String.valueOf(id));
		
	HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
	
	RestTemplate restTemplate = new RestTemplate();
	this.response = restTemplate.postForEntity(uri , request,String.class);	
	//this.responseMessage = HttpRequest.request("http://localhost:8080/student", "POST", requestBody.toString());
	assertThat(response.getStatusCode(), is(HttpStatus.OK));
	
}

@Then("^I receive valid Response$")
public void i_receive_valid_Response() {
    String responseBody = response.getBody().toString();
    System.out.println("responseBody --->" + responseBody);
    // Get ID from the Response object
    String studentId =  getStudentIdFromResponse(responseBody);
    System.out.println("studentId is :" + studentId);
    // Check if the added studentId is present in the response body.
    Assert.hasText(responseBody,studentId);
     
    // Check if the status code is 201
    Assert.isTrue(response.getStatusCode()==HttpStatus.OK);
    System.out.println("Action done successfully. StudentId:"+studentId);    
}

private String getStudentIdFromResponse(String responseBody) {
	List<String> val = StringUtil.getMatches(responseBody, "(ID=.*)");
	return (val.size()> 0)?val.get(0):"";
}


@When("^Send a PUT HTTP request$")
public void send_a_PUT_HTTP_request() {
	System.out.println(uri);
	String requestBody = "{\"id\":"+id+ ",\"className\":\"5A\",\"nationality\": \"France\"}";
	
	HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
	RestTemplate restTemplate = new RestTemplate();
	this.response = restTemplate.exchange(uri ,HttpMethod.PUT, request,String.class);	
	assertThat(response.getStatusCode(), is(HttpStatus.OK));
}

@When("^Send a DELETE HTTP request$")
public void send_a_DELETE_HTTP_request() {
	String requestBody = "{\"id\":"+id+ "}";
	
	HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
	RestTemplate restTemplate = new RestTemplate();
	this.response = restTemplate.exchange(uri ,HttpMethod.DELETE, request,String.class);	
	assertThat(response.getStatusCode(), is(HttpStatus.OK));
}
	

@Given("I Set GET student service api endpoint")
public void i_Set_GET_student_service_api_endpoint() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Send a GET HTTP request")
public void send_a_GET_HTTP_request() {
	String requestBody = "";
	
	HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
	RestTemplate restTemplate = new RestTemplate();
	this.response = restTemplate.exchange(uri ,HttpMethod.GET, request,String.class);	
	assertThat(response.getStatusCode(), is(HttpStatus.OK));
}

@When("^Send a GET HTTP request by ID$")
public void send_a_GET_HTTP_request_by_ID() {
	String uri = "http://localhost:8080/fetchStudents?Id="+ id;
	
	HttpEntity<String> request = new HttpEntity<>("", headers);
	RestTemplate restTemplate = new RestTemplate();
	this.response = restTemplate.exchange(uri ,HttpMethod.GET, request,String.class);		
	assertThat(response.getStatusCode(), is(HttpStatus.OK));
}

@Then("^I receive invalid Response$")
public void i_receive_invalid_Response() {
	String responseBody = response.getBody().toString();
    System.out.println("responseBody --->" + responseBody);
    Assert.hasText(responseBody,"Error");
     
    // Check if the status code is 201
    Assert.isTrue(response.getStatusCode()==HttpStatus.OK);
}

@When("Send a GET HTTP request by Class {string}")
public void send_a_GET_HTTP_request_by_Class(String className) {
	String uri = "http://localhost:8080/fetchStudents?class="+className;

	HttpEntity<String> request = new HttpEntity<>("", headers);
	RestTemplate restTemplate = new RestTemplate();
	this.response = restTemplate.exchange(uri ,HttpMethod.GET, request,String.class);		
	assertThat(response.getStatusCode(), is(HttpStatus.OK));
}

@Then("^I receive ininvalid Response$")
public void i_receive_ininvalid_Response() {
	  String responseBody = response.getBody().toString();
	    System.out.println("responseBody --->" + responseBody);
	    Assert.hasText(responseBody,"Error");
	     
	    // Check if the status code is 201
	    Assert.isTrue(response.getStatusCode()==HttpStatus.OK);
	 }


  
}
