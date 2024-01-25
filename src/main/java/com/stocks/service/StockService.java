package com.stocks.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocks.entity.Stock;
import com.stocks.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	StockRepository repository;

	public List<Stock> findByTicker(String ticker, Date startDate, Date endDate) {
		return repository.findByTickerAndDateBetween(ticker, startDate, endDate);
	}

	public Stock findMaxCloseByTickerBetweenDates(String ticker, Date startDate, Date endDate) {
		return repository.findTopByTickerAndDateBetweenOrderByCloseDesc(ticker, startDate, endDate);
	}

	public Stock findMinCloseByTickerBetweenDates(String ticker, Date startDate, Date endDate) {
		return repository.findTopByTickerAndDateBetweenOrderByCloseAsc(ticker, startDate, endDate);
	}

	public BigDecimal percentageChangeByTickerBetweenDates(String ticker, Date startDate, Date endDate) {

		Optional<Stock> stockPriceStart = repository.findTopByTickerAndDateGreaterThanEqualOrderByDateAsc(ticker, startDate);
		Optional<Stock> stockPriceEnd = repository.findTopByTickerAndDateLessThanEqualOrderByDateDesc(ticker, endDate);

		if (!stockPriceStart.isPresent() || !stockPriceEnd.isPresent())
			return BigDecimal.ZERO;

		// Calculate the percentage change, from the start date to end date
		BigDecimal percentageChange = stockPriceEnd.get().getClose()
				.subtract(stockPriceStart.get().getClose())
				.divide(stockPriceStart.get().getClose().abs(), 4, RoundingMode.HALF_UP)
				.multiply(new BigDecimal(100));

		return percentageChange;
	}

	public List<String> findAllTickers() {
		return repository.findAllDistinctEntities();
	}

}
