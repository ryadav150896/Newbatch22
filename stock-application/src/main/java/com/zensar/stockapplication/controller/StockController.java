package com.zensar.stockapplication.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.stockapplication.entity.Stock;
//@Controller
@RestController
@RequestMapping("/stocks")
//@CrossOrigin("*")-to allow the request from other url
public class StockController {

	static List<Stock> stocks = new ArrayList();
	static {
		stocks.add(new Stock(1L, "Rjio", "bse", 321));
		stocks.add(new Stock(2L, "zensar", "bse", 325));

	}

	/*
	 * public StockController() { stocks.add(new Stock(1L,"Rjio","bse",321));
	 * stocks.add(new Stock(2L,"zensar","bse",325)); }
	 */
	// read all stocks
	// @GetMapping("/stocks")
	//@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public List<Stock> getAllStocks() {

		return stocks;

	}
	// handler method
	// read specific stock
	// @GetMapping("/stocks/{stockId}")
	/*
	 * @RequestMapping(value = "/{stockId}", method = RequestMethod.GET) public
	 * Stock getStock(@PathVariable long stockId) {
	 * 
	 * for (Stock stock : stocks) {
	 * 
	 * if (stock.getStockId() == stockId) { return stock; } } return null; }
	 */

	@RequestMapping(value = "/{stockId}", method = RequestMethod.GET)
	public Stock getStock(@PathVariable long stockId) {

		Optional<Stock> stock1=stocks.stream().filter(stock->stock.getStockId()==stockId).findAny();
		
		
		if(stock1.isPresent()) {
			return stock1.get();
		}else {
			return stock1.orElseGet( ()->{ return new Stock();});}}
		

	// create new stock
	// @PostMapping("/stocks")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Stock> createStock(@RequestBody Stock stock, @RequestHeader("auth-token") String token) {
		if (token.equals("ry43099")) {
			stocks.add(stock);
		} else {

			return new ResponseEntity<Stock>(stock, HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<Stock>(stock, HttpStatus.CREATED);
	}

	/*
	 * //@GetMapping("/stocks")
	 * 
	 * @RequestMapping(value="/stocks", method=RequestMethod.GET) public Stock
	 * getStock(@RequestParam(required=false, value="id", defaultValue ="1") long id
	 * ) {
	 * 
	 * for(Stock stock:stocks) {
	 * 
	 * if(stock.getStockId()==id) { return stock; } } return null; }
	 */
	// delete specific stock
	@DeleteMapping("/{stockId}")
	public String deleteStock(@PathVariable long stockId) {

		for (Stock stock : stocks) {

			if (stock.getStockId() == stockId) {
				stocks.remove(stock);

				return "stock id deleted " + stockId;
			}
		}
		return "sorry, stockId is not present";
	}

	@PutMapping("/{stockId}")
	public Stock updateStocks(@PathVariable int stockId, @RequestBody Stock stock) {

		Stock availablestock = getStock(stockId);
		availablestock.setMarketName(stock.getMarketName());
		availablestock.setName(stock.getName());
		availablestock.setPrice(stock.getPrice());

		return availablestock;

	}

	/*
	 * @RequestMapping(value="/test", method=
	 * {RequestMethod.GET,RequestMethod.POST}) public void test() {
	 * System.out.println("inside test"); }
	 */
	// delete all stocks
	@DeleteMapping
	public ResponseEntity<String> deleteAllStocks() {

		stocks.removeAll(stocks);

		return new ResponseEntity<String>("All stcoks deleted successfully", HttpStatus.OK);
	}
}
