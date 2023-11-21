package model;


import java.time.LocalDateTime;

public class Measures {
	//ATRIBUTOS
		private int id;
		private Double temperature;
		private Double times;
		private LocalDateTime date_time;
		
		public Measures(Double temperature, Double times, LocalDateTime date_time) {
			
			this.temperature = temperature;
			this.times = times;
			this.date_time = date_time;
			
		}
		
		public Measures() {
			
			temperature = 0.0;
			times = 0.0;
			date_time = LocalDateTime.now();
			
		}

		//GETTERS AND SETTERS
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		public Double getTemperature() {
			return temperature;
		}


		public void setTemperature(Double temperature) {
			this.temperature = temperature ;
		}


		public Double getTimes() {
			return times;
		}


		public void setTimes(Double times) {
			this.times = times;
		}


		public LocalDateTime getDate_time() {
			return date_time;
		}


		public void setDate_time(LocalDateTime date_time) {
			this.date_time = date_time;
		}

		@Override
		public String toString() {
			return "Measures [id=" + id + ", temperature=" + temperature + ", times=" + times + ", date_time=" + date_time
					+ "]";
		}
}
