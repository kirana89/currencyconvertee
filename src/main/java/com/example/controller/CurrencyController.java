package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Currency;
import com.example.repo.CurrencyRepository;

@RestController
public class CurrencyController {
	@Autowired
	private CurrencyRepository currRepo;
	
	@GetMapping(value="/Currencies")
	public List<Currency> getAllCurrencies() {
		return currRepo.findAll();
	}
	
	@PostMapping(value="/addCurrency")
	public Currency createCurrency(@RequestBody Currency currency)
	{
		return currRepo.save(currency);
	}

	
	@PutMapping(value="/updateCurrency/{id}")
	public ResponseEntity<Currency> updateCurrency(@PathVariable(value="id")int  currId, @RequestBody Currency currency)
	{
		Currency curr=null;
		try {
			 curr=currRepo.findById(currId).orElseThrow(()->new ResourceNotFoundException("Currency not found "+currId));
		 } catch (ResourceNotFoundException e) {
			 
			 e.printStackTrace();
		 }
		 curr.setCname(currency.getCname());
		 curr.setCcountry(currency.getCcountry());
		 
		 Currency updatedCurrency=currRepo.save(curr);
		 return ResponseEntity.ok(updatedCurrency);

	}
	@DeleteMapping(value="/deleteCurrency/{id}")
	 public Map<String, Boolean> deleteCurrency(@PathVariable(value="id") int  currId)
	 {
		 Currency curr=null;
		 try {
			 curr=currRepo.findById(currId).orElseThrow(()->new ResourceNotFoundException("Product not found "+currId));
		 } catch (ResourceNotFoundException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
		 currRepo.delete(curr);
		 Map<String,Boolean> res=new HashMap<>();
		 res.put("deleted", Boolean.TRUE);
		 return res;
	 }
}
