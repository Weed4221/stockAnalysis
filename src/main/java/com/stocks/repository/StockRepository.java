package com.stocks.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stocks.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

	// Custom query method to find stocks by ticker symbol
	List<Stock> findByTickerAndDateBetween(String ticker, Date startDate, Date endDate);

	// Custom query method to find max closing price stocks by ticker symbol between dates
	Stock findTopByTickerAndDateBetweenOrderByCloseDesc(String ticker, Date startDate, Date endDate);

	// Custom query method to find min closing price stocks by ticker symbol between dates
	Stock findTopByTickerAndDateBetweenOrderByCloseAsc(String ticker, Date startDate, Date endDate);

	// Find the row with the closest date before or equal to the given date (avoid weekends and holidays)
	Optional<Stock> findTopByTickerAndDateGreaterThanEqualOrderByDateAsc(String ticker, Date startDate);

	// Find the row with the closest date after or equal to the given date (avoid weekends and holidays)
	Optional<Stock> findTopByTickerAndDateLessThanEqualOrderByDateDesc(String ticker, Date targetDate);
	
	//Find all tickers
	@Query("SELECT DISTINCT (e.ticker) FROM Stock e")
	List<String> findAllDistinctEntities();

}
