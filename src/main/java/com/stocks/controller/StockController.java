package com.stocks.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stocks.entity.Stock;
import com.stocks.service.StockService;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

	@Autowired
	private StockService stockService;

	@GetMapping("/findAllTickers")
	public List<String> findAllTickers() {
		return stockService.findAllTickers();
	}
	
	@GetMapping("/findByTicker/{ticker}")
	public List<Stock> findByTicker(@PathVariable String ticker,
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

		return stockService.findByTicker(ticker, startDate, endDate);
	}

	@GetMapping("/findMaxCloseByTicker/{ticker}")
	public Stock findMaxCloseByTicker(@PathVariable String ticker,
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

		return stockService.findMaxCloseByTickerBetweenDates(ticker, startDate, endDate);
	}

	@GetMapping("/findMinCloseByTicker/{ticker}")
	public Stock findMinCloseByTicker(@PathVariable String ticker,
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

		return stockService.findMinCloseByTickerBetweenDates(ticker, startDate, endDate);
	}

	@GetMapping("/percentageChange/{ticker}")
	public BigDecimal percentageChange(@PathVariable String ticker,
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

		return stockService.percentageChangeByTickerBetweenDates(ticker, startDate, endDate);
	}
}
