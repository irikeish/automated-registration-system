package com.automated_student_registration.bean;

public class UserBean {
		private String userName;
		private String password;
		private String mno;
		public UserBean(String string, String string2, String string3) {
			this.userName = string;
			this.password=string2;
			this.mno=string3;
			// TODO Auto-generated constructor stub
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getMno() {
			return mno;
		}
		public void setMno(String mno) {
			this.mno = mno;
		}
		


}
