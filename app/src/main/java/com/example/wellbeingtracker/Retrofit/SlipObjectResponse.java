package com.example.wellbeingtracker.Retrofit;

import com.example.wellbeingtracker.Model.Advice;

public class SlipObjectResponse {

    private Slip slip;

    public Advice getAdvice(){
        return new Advice(slip.advice);
    }

    private class Slip {
        private int slip_id;
        private String advice;

        public Slip(String advice) {
            this.advice=advice;
        }

        public int getSlip_id() {
            return slip_id;
        }

        public void setSlip_id(int slip_id) {
            this.slip_id = slip_id;
        }

        public String getAdvice() {
            return advice;
        }

        public void setAdvice(String advice) {
            this.advice = advice;
        }
    }
}
