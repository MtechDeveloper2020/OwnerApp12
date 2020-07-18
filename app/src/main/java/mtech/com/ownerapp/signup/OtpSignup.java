package mtech.com.ownerapp.signup;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.util.Random;

import mtech.com.ownerapp.R;
import mtech.com.ownerapp.VisitorsFragment;
import mtech.com.ownerapp.network.ConnectionDetector;
import mtech.com.ownerapp.sms.JSONParser_Post;
import mtech.com.ownerapp.sms.Model_URIs;

public class OtpSignup extends AppCompatActivity {
    EditText mobileNo;
    Button requestOtp;
    String str_mob = null, pin=null;;
    Boolean isInternetPresent = false;
    ConnectionDetector cd;
    String TransactionLog_GetJSON;
    Model_URIs URLs = new Model_URIs();
    JSONParser_Post jsnp_post = new JSONParser_Post();
    boolean msg_sent = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_signup);
        cd = new ConnectionDetector(OtpSignup.this);
        isInternetPresent = cd.isConnectingToInternet();
        if (isInternetPresent == true) {

        } else {
            Toast.makeText(OtpSignup.this, "Internet Connection error", Toast.LENGTH_SHORT).show();
        }
        mobileNo = findViewById(R.id.mobileNo);
        requestOtp = findViewById(R.id.requestOtp);
        requestOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             str_mob = mobileNo.getText().toString();
             if (!str_mob.isEmpty()){
                 isInternetPresent = cd.isConnectingToInternet();
                 if (isInternetPresent == true){
                     Random r = new Random();
                     pin = String.format("%04d", (Object) Integer.valueOf(r.nextInt(1001)));


                     JSONObject jsonObj = new JSONObject();

                     try {
                         jsonObj.put("msg", pin+" is your Owner one time pass code. ");
                         jsonObj.put("mobile", str_mob);
                         jsonObj.put("Respose", "TRUE");

                         TransactionLog_GetJSON = jsonObj.toString();

                         new Perform_log(URLs.getPerform_URI(), TransactionLog_GetJSON).execute();
                         //  new Perform_log("", TransactionLog_GetJSON).execute();

                     }
                     catch (final Exception e)
                     {
                         e.printStackTrace();
                     }
                 }

             }
            }
        });

    }
    //======================================== Perform_log Task ==================================
    public class Perform_log extends AsyncTask<Void, Integer, Void> {
        //        ProgressDialog progressDialog;
        String final_out1 = "";
        String URL = "";
        String jsonString = "";

        public Perform_log(String url, String json){
            this.URL = url;
            this.jsonString = json;
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // TODO Auto-generated method stub
            try {
                final_out1 = jsnp_post.makeHttpRequest(URL, "POST", jsonString);

            } catch (Exception e) {
                // TODO: handle exception
                Toast.makeText(OtpSignup.this, "An unexpected error occurred", Toast.LENGTH_LONG).show();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result){

//            progressDialog.dismiss();
            try {
                if (final_out1.equalsIgnoreCase("")) {
                    Toast.makeText(OtpSignup.this, "OTP not Sent", Toast.LENGTH_SHORT).show();
                    msg_sent = false;
                }
                else {

                    //attribute success then save else error message
//                    Toast.makeText( OtpSignup.this, ""+final_out1, Toast.LENGTH_SHORT).show();
                    msg_sent = true;

                }

                if(msg_sent){
                    Intent i = new Intent(OtpSignup.this, VerifyOtpActivity.class);
                    i.putExtra("pin", pin);
                    i.putExtra("mobile", str_mob);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(OtpSignup.this, "Request Otp Again!", Toast.LENGTH_SHORT).show();
                }
//                    Toast.makeText(getApplicationContext(), "msg"+ msg_sent, Toast.LENGTH_LONG).show();

            } catch (Exception e){
                Toast.makeText(OtpSignup.this, "Error occurred", Toast.LENGTH_LONG).show();
            }
            super.onPostExecute(result);
        }
        @Override
        protected void onPreExecute(){
            // TODO Auto-generated method stub
//            progressDialog = new ProgressDialog( SavedScreen.this);
//            progressDialog.setMessage("Please wait...");
//            progressDialog.show();
            //super.onPreExecute();
        }
    }

//================   4-Digit Pin Code  =============================================================


}