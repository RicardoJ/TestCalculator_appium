package com.accenture.TestCalculatorF;

public class Dato {
	
		private String number1;
		private String operator;
		private String number2;
		public String getNumber1() {
			return number1;
		}
		public void setNumber1(String number1) {
			this.number1 = number1;
		}
		public String getOperator() {
			return operator;
		}
		public void setOperator(String operator) {
			this.operator = operator;
		}
		public String getNumber2() {
			return number2;
		}
		public void setNumber2(String number2) {
			this.number2 = number2;
		}
		public Dato(String number1, String operator, String number2) {
			super();
			this.number1 = number1;
			this.operator = operator;
			this.number2 = number2;
		}
		
		public Dato () {
			number1 = "";
			operator = "";
			number2 = "";
		}
}
