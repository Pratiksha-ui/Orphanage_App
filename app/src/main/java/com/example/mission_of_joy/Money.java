package com.example.mission_of_joy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class Money extends AppCompatActivity implements PaymentResultListener {

    Button btPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);

        btPay = findViewById(R.id.bt_pay);
        String sAmount = "100";

        int amount = Math.round(Float.parseFloat(sAmount) * 100);

        btPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Checkout checkout = new Checkout();

                //set key id
                checkout.setKeyID("rzp_test_I8MHW62a3Lf597");

                checkout.setImage(R.drawable.rzp_logo);

                JSONObject object = new JSONObject();

                try {
                    object.put("name", "Pratiksha Patil");
                    object.put("description", "Payment");
                    object.put("theme.color", "#0093DD");
                    object.put("currency", "INR");
                    object.put("amount", amount);
                    object.put("prefill.contact", "8208050109");
                    object.put("prefill.email", "2206pratiksha@gmail.com");
                    checkout.open(Money.this, object);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });

    }



    @Override
    public void onPaymentSuccess(String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Payment ID");
        builder.setMessage(s);
        builder.show();

    }

    @Override
    public void onPaymentError(int i, String s) {

        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();

    }
}
