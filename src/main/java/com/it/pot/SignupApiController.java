package com.it.pot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v2")
public class SignupApiController {
	
	 @Autowired 
	 private RestTemplate restTemplate;
	
	@GetMapping("/ksignups")
	public SingupWrapperDTO getSignups() {
		    HttpHeaders getHeaders = new HttpHeaders();
	        getHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	        HttpEntity<SignupDTO> entity = new HttpEntity<>(getHeaders);
	        List<SignupDTO> signupDTOs=new ArrayList<>();
	        //Why I have given ->THOTHIT-SERVICE
	        //JSON - >> 
			ResponseEntity<? extends List>  result = restTemplate.exchange("http://THOTHIT-SERVICE"+"/api/signups",HttpMethod.GET,entity,signupDTOs.getClass());
			List<?> signupResponse=result.getBody();
			SingupWrapperDTO singupWrapperDTO=new SingupWrapperDTO();
			singupWrapperDTO.setSignups(signupResponse);
			singupWrapperDTO.setCode("1029");
			singupWrapperDTO.setMessage("Data is fetched from THOTHIT-SERVICE");
			return singupWrapperDTO;
	}

}
