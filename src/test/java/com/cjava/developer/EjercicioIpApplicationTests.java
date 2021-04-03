package com.cjava.developer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.demo.ip.EjercicioIpApplication;
import com.java.demo.ip.controller.IPController;
import com.java.demo.ip.dto.Response;
import com.java.demo.ip.service.IPService;
import com.java.demo.ip.utils.Constant;
import com.java.demo.ip.utils.Utils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EjercicioIpApplication.class)
class EjercicioIpApplicationTests {

	@Autowired
	private IPService ipService;
	@Autowired
	private IPController ipController;

	@Test
	public void testIpBanned() {
		assertTrue(ipService.isBanned(Constant.IP_BANNED));
		}

	@Test
	public void testIpTrue() {
		assertTrue(Utils.validateFormatIp(Constant.IP_VALID));
		}

	@Test
	public void testIpFalse() {
		assertFalse(Utils.validateFormatIp(Constant.IP_NO_VALID));
		}
	
	@Test
	public void testGetCountryInfoValid() {
		Response response = ipController.getCountryInfo(Constant.IP_VALID);
		assertThat(response.getBody()).isNotNull();
		}
	
	@Test
	public void testGetCountryInfoInValid() {
		Response response = ipController.getCountryInfo(Constant.IP_NO_VALID);
		assertThat(response.getBody()).isNull();
		}

}
