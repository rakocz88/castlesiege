package com.pilaf.cs.card;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.test.context.junit4.SpringRunner;

import com.pilaf.cs.card.service.CardCreatorFeignClient;
import com.pilaf.cs.card.service.ExternalUserService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SomeTest {
//	
	
	@Autowired
	private CardCreatorFeignClient cardCreatorClient;
	
	@Autowired
	private ExternalUserService externalUserService;
	
	@Autowired
	private EurekaDiscoveryClient eurekaDiscoveryClient;
	
	@Test
	public void someTest(){
		eurekaDiscoveryClient.getServices();
		cardCreatorClient.create();
		externalUserService.getAllUsers();
//		externalUserService.getAllUsers();
//		System.out.println(this.externalUserService.getAllUsers());
	}

}
