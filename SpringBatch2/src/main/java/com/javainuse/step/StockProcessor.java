package com.javainuse.step;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javainuse.entity.Stock;
import com.javainuse.model.StockModel;
import com.javainuse.util.DateUtil;

@Component
public class StockProcessor implements ItemProcessor<StockModel, Stock> {
	
	@Autowired
	DateUtil dateUtil;
	
	@Override
	public Stock process(final StockModel model) throws Exception {
		final String symbol = model.getSymbol();
		final String series = model.getSeries();
		final Double open = Double.parseDouble(model.getOpen());
		final Double high = Double.parseDouble(model.getHigh());
		final Double low = Double.parseDouble(model.getLow());
		final Double close = Double.parseDouble(model.getClose());
		final Double last = Double.parseDouble(model.getLast());
		final Double prevclose = Double.parseDouble(model.getPrevclose());
		final BigInteger tottrdqty = new BigInteger(model.getTottrdqty());
		final BigDecimal tottrdval = new BigDecimal(model.getTottrdval());
		final Date timestamp = dateUtil.convertFromString(model.getTimestamp());
		final Long totaltrades = Long.parseLong(model.getTotaltrades());
		final String isin = model.getIsin();

		Stock stock = new Stock(symbol, series, open, high, low, close, last, prevclose, tottrdqty, tottrdval,
				timestamp, totaltrades, isin);
		// System.out.println("@@ data===" + stock);
		return stock;
	}
}