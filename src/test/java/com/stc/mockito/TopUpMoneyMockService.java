package com.stc.mockito;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stc.db.model.TransactionForm;
import com.stc.db.repo.WalletTransactionRepo;
import com.stc.service.WalletTransactionService;
import com.stc.service.impl.WalletTransactionServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TopUpMoneyMockService {

	private Long customerId = 133L;
	public String trans_type = "withdraw";
	public String trans_from = "Personal Account";
	public String trans_to = "";
	public double trans_amount = 200;
	@SuppressWarnings("deprecation")
	public Date trans_time = new Date(2000, 11, 21);

	@InjectMocks
	private WalletTransactionService WalletTransactionService = new WalletTransactionServiceImpl();

	@Mock
	private WalletTransactionRepo walletTransactionRepo;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private MockMvc mockMvc;
	TransactionForm mockTransactionForm = new TransactionForm(trans_type, trans_from, trans_to, trans_amount,
			customerId, "SAR");
	
	@Before
	public void setup(){
	    MockitoAnnotations.initMocks(this); //without this you will get NPE
	}

	@Test
	public void createTopUpTransaction() throws Exception {
		TransactionForm mockTransactionForm = new TransactionForm(trans_type, trans_from, trans_to, trans_amount,
				customerId, "SAR");

		Mockito.when(WalletTransactionService.topUpMoney(Mockito.any(TransactionForm.class))).thenReturn(mockTransactionForm);

		String json = null;
		try {
			json = mapper.writeValueAsString(mockTransactionForm);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/top_up_tran").accept(MediaType.APPLICATION_JSON)
				.content(json).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		// assertEquals("http://localhost:8080/top_up_tran",response.getHeader(HttpHeaders.LOCATION));
	}

}
