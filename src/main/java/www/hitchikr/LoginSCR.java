package www.hitchikr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginSCR extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_scr); //links XML file to src

        Username = (EditText)findViewById(R.id.etUsername);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);

        Login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                validate(Username.getText().toString(), Password.getText().toString());
            }
        });
    }



    private void validate(String userName, String userPW){
        if(userName.equals("Admin") && userPW.equals("1234")){
            Intent intent = new Intent(LoginSCR.this, MainSCR.class);
            startActivity(intent);
        }else{
            counter --;
            Info.setVisibility(View.VISIBLE);
            if(counter == 0){
                Login.setEnabled(false);
            }
        }
    }
}
