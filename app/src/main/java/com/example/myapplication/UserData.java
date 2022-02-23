package com.example.myapplication;

public class UserData {
        private String userName;
        private String userEmail;
        private String userBirthDate;
        private String userGender;

        public UserData() {

        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public String getUserBirthDate() {
            return userBirthDate;
        }

        public void setUserBirthDate(String userBirthDate) {
            this.userBirthDate = userBirthDate;
        }

        public String getUserGender() {
            return userGender;
        }
        
        public void setUserGender(String userGender){
            this.userGender = userGender;
    }

}
