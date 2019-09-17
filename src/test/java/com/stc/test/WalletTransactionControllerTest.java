package com.stc.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stc.db.model.TransactionForm;
import com.stc.db.repo.WalletTransactionRepo;
import com.stc.service.WalletTransactionService;
import com.stc.web.rest.WalletTransactionController;

@RunWith(SpringRunner.class)
@WebMvcTest(WalletTransactionController.class)
@WithMockUser(username = "user",password="pass" , roles = "USER")
public class WalletTransactionControllerTest {

	private TransactionForm tesTransactionForm;

	//private Long id = 12L;
	private Long customerId = 133L;
	public String trans_type = "withdraw";
	public String trans_from = "Personal Account";
	public String trans_to = "";
	public double trans_amount = 200;
	@SuppressWarnings("deprecation")
	public Date trans_time = new Date(2000, 11, 21);

	@Autowired
	private MockMvc mockMvc;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@MockBean
	public WalletTransactionRepo walletTransactionRepo;

	@MockBean
	WalletTransactionService service;

	@Autowired
	private ObjectMapper mapper;

	@Before
	public void setup() {
		tesTransactionForm = new TransactionForm(trans_type, trans_from, trans_to, trans_amount, customerId, "SAR");
	}

	@Test
	public void topUpTest() {
		String json = null;
		try {
			json = mapper.writeValueAsString(tesTransactionForm);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		try {
			mockMvc.perform(put("/api/top_up_tran").contentType(MediaType.APPLICATION_JSON).content(json)
					.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void transferToTest() {
		String json = null;
		try {
			json = mapper.writeValueAsString(tesTransactionForm);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		try {
			mockMvc.perform(put("/api/transfer_to").contentType(MediaType.APPLICATION_JSON).content(json)
					.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}