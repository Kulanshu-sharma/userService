package com.voteroid.userService.dtos;

public interface Messages {
	
	interface Exceptions{
		public static final String NO_API_ID_RECIEVED = "No API ID Recieved!!!" ;
		public static final String NO_USER_information_RECIEVED = "No API USER DATA Recieved !!!";
		public static final String NO_API_FOUND = "OOPS :( No API Found for this API ID !!";
		public static final String NO_API_URI_RECIEVED = "No API URI Recieved!!!";
		public static final String METHOD_CHANGE_NOT_ALLOWED = "Method Name Change is Not Allowed !!";
		public static final String PATH_CHANGE_NOT_ALLOWED = "Path Change is Not Allowed !!";
		public static final String URI_CHANGE_NOT_ALLOWED = "URI Change is Not Allowed !!";
		public static final String INVALID_TOKEN = "Invalid Token, Company Id Fetching failed!!!";
		public static final String NO_USER_NAME_RECIEVED = "No Client Name Recieved!!!";
		public static final String NO_USER_PHONE_NO_RECIEVED = "No User Phone Number Recieved!!!";
		public static final String NO_USER_EMAIL_ID_RECIEVED = "No User Email Id Recieved!!!";
		public static final String NO_USER_PASSWORD_RECIEVED = "No User Password Recieved!!!";
		public static final String PHONE_EMAIL_ALREADY_EXIST = "User Email Id or Phone No Already Exist !!!";
	}
	
	interface Responses{
		public static final String API_SAVED_SUCCESSFULLY = "API Saved Successfully !!!";
		public static final Object API_UPDATED_SUCCESSFULLY = "API Updated Successfully !!!";
	}
	
	interface loginErrors{
		public static final String INVALID_USER_ID_PASSWORD = "Invalid User Id or Password!!!";
	}
	
}
