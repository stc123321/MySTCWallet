package com.stc.mockito;

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
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stc.db.model.TransactionForm;
import com.stc.db.repo.WalletTransactionRepo;
import com.stc.service.WalletTransactionService;
import com.stc.service.impl.WalletTransactionServiceImpl;
import com.stc.web.rest.WalletTransactionController;

@RunWith(MockitoJUnitRunner.class)
public class TopUpMoneyMockService {

	//private Long customerId = 32311L;
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
	
	@Mock 
	WalletTransactionController walletTransactionController;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private MockMvc mockMvc;
	TransactionForm mockTransactionForm;
	
	@Before
	public void setup(){
	    MockitoAnnotations.initMocks(this); 
	    mockTransactionForm = new TransactionForm(trans_type, trans_from, trans_to, trans_amount,
				32311L, "SAR");
	}

	@Test
	public void createTopUpTransaction() throws Exception {

		//Mockito.when(walletTransactionController.topUpMoney(mockTransactionForm)).thenReturn(1);

		/*String json = null;
		try {
			json = mapper.writeValueAsString(new TransactionForm(trans_type, trans_from, trans_to, trans_amount,
					32311L, "SAR"));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/top_up_tran").accept(MediaType.APPLICATION_JSON)
				.content(json).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());*/

		// assertEquals("http://localhost:8080/top_up_tran",response.getHeader(HttpHeaders.LOCATION));
	}

}
