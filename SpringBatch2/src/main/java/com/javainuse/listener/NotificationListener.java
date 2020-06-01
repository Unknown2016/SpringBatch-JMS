package com.javainuse.listener;

import java.util.List;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javainuse.dao.StockDao;
import com.javainuse.entity.Stock;

@Component
public class NotificationListener extends JobExecutionListenerSupport {
//	private final JdbcTemplate jdbcTemplate;

	@Autowired
	StockDao stockDao;
//	public NotificationListener(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("============ JOB FINISHED ============ Verifying the results....\n");

			List<Stock> results = stockDao.getStock();
//			jdbcTemplate.query(
//					"SELECT name, position, office, age, startDate, salary FROM S",
//					new RowMapper<Stock>() {
//						@Override
//						public Stock mapRow(ResultSet rs, int row) throws SQLException {
//							return new Stock(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
//									rs.getString(5), rs.getString(6));
//						}
//					});

			for (Stock stock : results) {
				System.out.println("Discovered <" + stock + "> in the database.");
			}

		}
	}
}
